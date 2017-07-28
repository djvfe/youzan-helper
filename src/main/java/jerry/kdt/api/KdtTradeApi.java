package jerry.kdt.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.Constant;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.requirement.TradeSoldGetRequirement;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.Result;
import jerry.kdt.result.TradeDetail;
import jerry.kdt.result.TradeDetailWithPage;
import jerry.kdt.utils.Util;

/**
 * 交易接口
 * @author dj
 *
 */
public class KdtTradeApi {
	public static void main(String[] args) {
		TradeSoldGetRequirement requirement = new TradeSoldGetRequirement();
		TradeDetailWithPage tdwp = tradesSoldGet(requirement).getContent();
		System.out.println(tdwp.getTotal_results());
	}
	/**
	 * 卖家关闭一笔交易
	 * 当买家已经付款，卖家不能通过该接口关闭交易
	 * @param tid	交易编号
	 * @param close_reason	关闭交易的原因
	 * @param fields	需要返回的交易对象字段，如tid,title,receiver_city等。可选值：TradeDetail交易结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<TradeDetail> tradeClose(String tid,String close_reason,String fields) {
		if(tid==null) return null;
		String method = "kdt.trade.close";
		System.out.println("kdt.trade.close");
		HashMap<String, String> params = new HashMap<String, String>();
		if(tid!=null) params.put("tid", tid);
		if(close_reason!=null) params.put("close_reason", close_reason);
		if(fields!=null) params.put("fields", fields);
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			response = kdtApiClient.post(method, params);
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
			if(errorResult!=null) return new Result<TradeDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			return new Result<TradeDetail>(errorResult,KdtApiUtility.jsonToTradeDetail(jsonObjectResponse.getJSONObject("trade")));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取单笔交易的信息
	 * @param tid	交易编号
	 * @param fields	需要返回的交易对象字段，如tid,title,receiver_city等。可选值：TradeDetail交易结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @param sub_trade_page_no	指定获取子交易的第几页，不传则获取全部
	 * @param sub_trade_page_size	指定获取子交易每页条数，不传则获取全部，上限500
	 * @return
	 */
	public static Result<TradeDetail> tradeGet(String tid,String fields,Integer sub_trade_page_no,Integer sub_trade_page_size) {
		if(tid==null) return null;
		String method = "kdt.trade.get";
		System.out.println("kdt.trade.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(tid!=null) params.put("tid", tid);
		if(fields!=null) params.put("fields", fields);
		if(sub_trade_page_no!=null) params.put("sub_trade_page_no", sub_trade_page_no.toString());
		if(sub_trade_page_size!=null) params.put("sub_trade_page_size", sub_trade_page_size.toString());
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
			if(errorResult!=null) return new Result<TradeDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			TradeDetail tradeDetail = KdtApiUtility.jsonToTradeDetail(jsonObjectResponse.getJSONObject("trade"));
			return new Result<TradeDetail>(errorResult,tradeDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改一笔交易备注
	 * 当买家已经付款，卖家不能通过该接口关闭交易
	 * @param tid	交易编号
	 * @param memo	交易备注
	 * @param flag	交易备注加星标，取值为1-5
	 * @param fields	需要返回的交易对象字段，如tid,title,receiver_city等。可选值：TradeDetail交易结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<TradeDetail> tradeMemoUpdate(String tid,String memo,Integer flag,String fields) {
		if(tid==null) return null;
		String method = "kdt.trade.memo.update";
		System.out.println("kdt.trade.memo.update");
		HashMap<String, String> params = new HashMap<String, String>();
		if(tid!=null) params.put("tid", tid);
		if(memo!=null) params.put("memo", memo);
		if(flag!=null) params.put("flag", flag.toString());
		if(fields!=null) params.put("fields", fields);
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			response = kdtApiClient.post(method, params);
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
			if(errorResult!=null) return new Result<TradeDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			return new Result<TradeDetail>(errorResult,KdtApiUtility.jsonToTradeDetail(jsonObjectResponse.getJSONObject("trade")));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询卖家已卖出的交易列表
	 * @param requirement
	 * @return
	 */
	public static Result<TradeDetailWithPage> tradesSoldGet(TradeSoldGetRequirement requirement) {
		if(requirement==null) return null;
		String method = "kdt.trades.sold.get";
		System.out.println("kdt.trades.sold.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getUse_has_next()!=null) params.put("use_has_next", requirement.getUse_has_next().toString());
		if(requirement.getBuyer_nick()!=null) params.put("buyer_nick", requirement.getBuyer_nick());
		if(requirement.getEnd_created()!=null) params.put("end_created", Util.formatDate(requirement.getEnd_created(),Constant.API_DATE_FORMAT));
		if(requirement.getEnd_update()!=null) params.put("end_update", Util.formatDate(requirement.getEnd_update(),Constant.API_DATE_FORMAT));
		if(requirement.getFields()!=null) params.put("fields", requirement.getFields());
		if(requirement.getPage_no()!=null) params.put("page_no", requirement.getPage_no().toString());
		if(requirement.getPage_size()!=null) params.put("page_size", requirement.getPage_size().toString());
		if(requirement.getStart_created()!=null) params.put("start_created", Util.formatDate(requirement.getStart_created(),Constant.API_DATE_FORMAT));
		if(requirement.getStart_update()!=null) params.put("start_update", Util.formatDate(requirement.getStart_update(),Constant.API_DATE_FORMAT));
		if(requirement.getStatus()!=null) params.put("status", requirement.getStatus().toString());
		if(requirement.getWeixin_user_id()!=null) params.put("weixin_user_id", requirement.getWeixin_user_id().toString());
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
			if(errorResult!=null) return new Result<TradeDetailWithPage>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			TradeDetailWithPage tradeDetailWithPage = new TradeDetailWithPage();
			tradeDetailWithPage.setTotal_results(jsonObjectResponse.getInteger("total_results"));
			Boolean hasNext = jsonObjectResponse.getBoolean("has_next");
			hasNext = hasNext!=null ? hasNext : Util.nvl(tradeDetailWithPage.getTotal_results(),0)>(Util.nvl(requirement.getPage_no(), 1))*Util.nvl(requirement.getPage_size(), 40);
			tradeDetailWithPage.setHas_next(hasNext);
			tradeDetailWithPage.setPage_no(requirement.getPage_no());
			tradeDetailWithPage.setPage_size(requirement.getPage_size());
			
			JSONArray jsonArrayTrades = jsonObjectResponse.getJSONArray("trades");
			List<TradeDetail> list = new ArrayList<TradeDetail>();
			if(jsonArrayTrades!=null &&jsonArrayTrades.size()>0) {
				for(int i=0;i<jsonArrayTrades.size();i++) {
					TradeDetail td = KdtApiUtility.jsonToTradeDetail(jsonArrayTrades.getJSONObject(i));
					if(td!=null) list.add(td);
				}
			}
			tradeDetailWithPage.setTrades(list);
			return new Result<TradeDetailWithPage>(errorResult,tradeDetailWithPage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
