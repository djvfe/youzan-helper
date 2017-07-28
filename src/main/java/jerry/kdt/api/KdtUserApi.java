package jerry.kdt.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.result.CrmWeixinFans;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.Result;

/**
 * @author dj
 *
 */
public class KdtUserApi {
	/**
	 * 根据微信粉丝用户的 openid 或 user_id 获取用户信息
	 * @param fields	需要返回的微信粉丝对象字段，如nick,avatar等。可选值：CrmWeixinFans微信粉丝结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @param weixin_openid	微信粉丝用户的openid
	 * @param user_id	微信粉丝用户ID。调用时，参数 weixin_openid 和 user_id 选其一即可
	 * @return	
	 */
	public static Result<CrmWeixinFans> usersWeixinFollowerGet(String fields,String weixin_openid,Integer user_id) {
		String method = "kdt.users.weixin.follower.get";
		HashMap<String, String> params = new HashMap<String, String>();
		if(fields!=null) params.put("fields", fields);
		if(weixin_openid!=null) params.put("weixin_openid", weixin_openid);
		if(user_id!=null) params.put("user_id", user_id.toString());
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
			if(errorResult!=null) return new Result<CrmWeixinFans>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectUser = jsonObjectResponse.getJSONObject("user");
			CrmWeixinFans crmWeixinFans = KdtApiUtility.jsonToCrmWeixinFans(jsonObjectUser);
			return new Result<CrmWeixinFans>(errorResult,crmWeixinFans);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
