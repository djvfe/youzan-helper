package jerry.kdt.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.result.Basic;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.Result;
/**
 * 基础信息接口
 * @author dj
 *
 */
public class KdtBasicApi {
	public static void main(String[] args) {
		basicGet();
	}
	/**
	 * 获取店铺基本信息
	 */
	public static Result<Basic> basicGet() {
		String method = "kdt.shop.basic.get";
		System.out.println("kdt.shop.basic.get");
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			response = kdtApiClient.get(method, null);
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
			if(errorResult!=null) return new Result<Basic>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			return new Result<Basic>(errorResult,KdtApiUtility.jsonToBasic(jsonObjectResponse));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
