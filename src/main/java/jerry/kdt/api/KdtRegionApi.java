package jerry.kdt.api;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.RegionGetLevel;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.result.CommonRegion;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.Result;
/**
 * 区域数据接口
 * @author dj
 *
 */
public class KdtRegionApi {
	public static void main(String[] args) {
		regionsGet(RegionGetLevel.ALL_REGION, null, null, null);
	}
	/**
	 * 获取区域地名列表信息
	 * 区域等级从大到小依次分省、市、县
	 * @param level	要获取的区域等级，0 获取所有区域列表，1 获取省份列表，2 获取城市列表，3 获取县区列表，4 获取指定ID区域及其上级区域信息
	 * @param parent_id	区域父级ID
	 * 当level为0或1时，parent_id可以为空；
	 * 当level为2时，parent_id须为某省份ID；
	 * 当level为3时，parent_id须为某城市ID
	 * @param id	区域ID	当level为4时，id参数生效且不能为空
	 * @param fields	需要返回的区域地名对象字段，如id,name等。可选值：区域数据结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<List<CommonRegion>> regionsGet(RegionGetLevel level,Integer parent_id,Integer id,String fields) {
		if(level==null) return null;
		if(RegionGetLevel.ASSIGN_AND_PARENT.equals(level) && id==null) return null;
		String method = "kdt.regions.get";
		System.out.println("kdt.regions.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(level!=null) params.put("level", level.getId().toString());
		if(parent_id!=null) params.put("parent_id", parent_id.toString());
		if(id!=null) params.put("id", id.toString());
		if(fields!=null) params.put("fields", fields);
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			response = kdtApiClient.get(method, params);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				result.append(line);
			}
			
			System.out.println(result.toString());

			//以下为使用json数据为自定义java bean类赋值
			JSONObject jsonObject = JSONObject.parseObject(result.toString());
			ErrorResult errorResult = KdtApiUtility.jsonToErrorResponse(jsonObject);
			if(errorResult!=null) return new Result<List<CommonRegion>>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONArray jsonArrayRegions = jsonObjectResponse.getJSONArray("regions");
			if(jsonArrayRegions!=null && jsonArrayRegions.size()>0) {
				List<CommonRegion> list = new ArrayList<CommonRegion>();
				for(int i=0;i<jsonArrayRegions.size();i++) {
					CommonRegion cr = KdtApiUtility.jsonToCommonRegion(jsonArrayRegions.getJSONObject(i));
					if(cr!=null) list.add(cr);
				}
				return new Result<List<CommonRegion>>(errorResult,list);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
