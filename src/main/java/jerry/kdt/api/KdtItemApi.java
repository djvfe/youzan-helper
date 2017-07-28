package jerry.kdt.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.OuterIdPrefix;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.requirement.ItemAddRequirement;
import jerry.kdt.requirement.ItemAddSkuRequirement;
import jerry.kdt.requirement.ItemSkuUpdateRequirement;
import jerry.kdt.requirement.ItemUpdateRequirement;
import jerry.kdt.requirement.ItemsInventoryGetRequirement;
import jerry.kdt.requirement.ItemsOnsaleGetRequirement;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.GoodsDetail;
import jerry.kdt.result.GoodsDetailWithPage;
import jerry.kdt.result.GoodsSku;
import jerry.kdt.result.Result;
/**
 * 商品接口
 * @author dj
 *
 */
public class KdtItemApi {
	public static void main(String[] args) {
		ItemAddRequirement itemAddRequirement = new ItemAddRequirement();
		itemAddRequirement.setPrice(100d);
		itemAddRequirement.setTitle("测试酒店");
		itemAddRequirement.setDesc("我是描述");
		itemAddRequirement.setIs_virtual(false);
		itemAddRequirement.setOuter_id(OuterIdPrefix.HOTEL+"12345");
		itemAddRequirement.setIs_display(false);
		
		List<ItemAddSkuRequirement> skuRequirementList = new ArrayList<ItemAddSkuRequirement>();
		ItemAddSkuRequirement ikr1 = new ItemAddSkuRequirement();
		ikr1.setSku_outer_id("1111");
		ikr1.setSku_price(100d);
		ikr1.setSku_quantity(20);
		Map<String,String> skuPropertyMap1 = new HashMap<String,String>();
		skuPropertyMap1.put("日期", "20151102");
		skuPropertyMap1.put("房型", "行政房大床");
		ikr1.setSku_property(skuPropertyMap1);
		ItemAddSkuRequirement ikr2 = new ItemAddSkuRequirement();
		ikr2.setSku_outer_id("1111");
		ikr2.setSku_price(200d);
		ikr2.setSku_quantity(30);
		Map<String,String> skuPropertyMap2 = new HashMap<String,String>();
		skuPropertyMap2.put("日期", "20151027");
		skuPropertyMap2.put("房型", "行政房大床");
		ikr2.setSku_property(skuPropertyMap2);
		
		skuRequirementList.add(ikr1);
		skuRequirementList.add(ikr2);
		itemAddRequirement.setSkus(skuRequirementList);
		//GoodsDetail GoodsDetail = itemAdd(itemAddRequirement);
		//System.out.println(GoodsDetail);
	}
	
	
	/**
	 * 新增一个商品
	 * @param requirement	请求参数
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Result<GoodsDetail> itemAdd(ItemAddRequirement requirement) {
		if(requirement==null) return null;
		String method = "kdt.item.add";
		System.out.println("kdt.item.add");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getCid()!=null) params.put("cid", requirement.getCid().toString());
		if(requirement.getPromotion_cid()!=null) params.put("promotion_cid", requirement.getPromotion_cid().toString());
		List<Integer> tagIdList = requirement.getTag_ids();
		if(requirement.getTag_ids()!=null) params.put("tag_ids",StringUtil.join(tagIdList, ",") );
		if(requirement.getPrice()!=null) params.put("price", requirement.getPrice().toString());
		if(requirement.getTitle()!=null) params.put("title", requirement.getTitle());
		if(requirement.getIs_virtual()!=null) params.put("is_virtual", KdtApiUtility.booleanToStr(requirement.getIs_virtual()));
//		if(requirement.getImages()!=null) params.put("images[]", new String(requirement.getImages(),"utf-8"));
//		if(requirement.getPost_fee()!=null) params.put("post_fee", requirement.getPost_fee().toString());
		params.put("post_fee", "0");//运费为0
		if(requirement.getSku_properties()!=null) params.put("sku_properties", requirement.getSku_properties());
		if(requirement.getSku_quantities()!=null) params.put("sku_quantities", requirement.getSku_quantities());
		if(requirement.getSku_prices()!=null) params.put("sku_prices", requirement.getSku_prices());
		if(requirement.getSku_outer_ids()!=null) params.put("sku_outer_ids", requirement.getSku_outer_ids());
		List<ItemAddSkuRequirement> itemAddSkuRequirementList = requirement.getSkus();
		if(itemAddSkuRequirementList!=null && itemAddSkuRequirementList.size()>0) {
			String skus_with_json = JSONArray.toJSONString(itemAddSkuRequirementList);
			if(skus_with_json!=null) params.put("skus_with_json", skus_with_json);
		}
		if(requirement.getOrigin_price()!=null) params.put("origin_price", requirement.getOrigin_price());
		if(requirement.getBuy_url()!=null) params.put("buy_url", requirement.getBuy_url());
		if(requirement.getOuter_id()!=null) params.put("outer_id", requirement.getOuter_id());
		if(requirement.getBuy_quota()!=null) params.put("buy_quota", requirement.getBuy_quota().toString());
		if(requirement.getQuantity()!=null) params.put("quantity", requirement.getQuantity().toString());
		if(requirement.getHide_quantity()!=null) params.put("hide_quantity", KdtApiUtility.booleanToStr(requirement.getHide_quantity()));
		if(requirement.getFields()!=null) params.put("fields", requirement.getFields());
		if(requirement.getIs_display()!=null) params.put("is_display", KdtApiUtility.booleanToStr(requirement.getIs_display()));

		HashMap<String, String> formparams = new HashMap<String, String>();
		if(requirement.getDesc()!=null) formparams.put("desc", requirement.getDesc());
		
		String fileKey = "images[]";  
	    List<String> filePaths = requirement.getImages();
	    
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			if(filePaths!=null && filePaths.size()>0) {
				response = kdtApiClient.post(method, params,formparams, filePaths, fileKey);
			} else {
				response = kdtApiClient.post(method, params,formparams);
			}
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
			if(errorResult!=null) return new Result<GoodsDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("item");
			return new Result<GoodsDetail>(errorResult,KdtApiUtility.jsonToGoodsDetail(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 删除一个商品
	 * @param num_iid	商品ID
	 * @return
	 */
	public static Result<Boolean> itemDelete(Integer num_iid) {
		if(num_iid==null) return new Result<Boolean>(null,false);
		String method = "kdt.item.delete";
		System.out.println("kdt.item.delete");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("num_iid", num_iid.toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				result.append(line);
			}
			
			System.out.println(result.toString());

			JSONObject jsonObject = JSONObject.parseObject(result.toString());
			ErrorResult errorResult = KdtApiUtility.jsonToErrorResponse(jsonObject);
			if(errorResult!=null) return new Result<Boolean>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			return new Result<Boolean>(errorResult,jsonObjectResponse.getBoolean("is_success"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 得到单个商品信息
	 * @param num_iid	商品数字编号
	 * @param alias		商品别名调用时，参数 num_iid 和 alias 必须选其一
	 * @param fields	需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<GoodsDetail> itemGet(Integer num_iid,String alias,String fields) {
		if(num_iid==null && alias==null) return null;
		String method = "kdt.item.get";
		System.out.println("kdt.item.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(num_iid!=null) params.put("num_iid", num_iid.toString());
		if(alias!=null) params.put("alias", alias.toString());
		if(fields!=null) params.put("fields", fields.toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("item");
			return new Result<GoodsDetail>(errorResult,KdtApiUtility.jsonToGoodsDetail(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 更新单个商品信息
	 * @param requirement
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static Result<GoodsDetail> itemUpdate(ItemUpdateRequirement requirement) {
		if(requirement==null) return null;
		String method = "kdt.item.update";
		System.out.println("kdt.item.update");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getNum_iid()!=null) params.put("num_iid", requirement.getNum_iid().toString());
		if(requirement.getCid()!=null) params.put("cid", requirement.getCid().toString());
		if(requirement.getPromotion_cid()!=null) params.put("promotion_cid", requirement.getPromotion_cid().toString());
		List<Integer> tagIdList = requirement.getTag_ids();
		if(requirement.getTag_ids()!=null) params.put("tag_ids",StringUtil.join(tagIdList, ",") );
		if(requirement.getPrice()!=null) params.put("price", requirement.getPrice().toString());
		if(requirement.getTitle()!=null) params.put("title", requirement.getTitle());
		if(requirement.getIs_virtual()!=null) params.put("is_virtual", KdtApiUtility.booleanToStr(requirement.getIs_virtual()));
//		if(requirement.getImages()!=null) params.put("images[]", new String(requirement.getImages(),"utf-8"));
//		if(requirement.getImages()!=null) params.put("images[]", Utility.Bin2HexString(requirement.getImages()));
		if(requirement.getKeep_item_img_ids()!=null) params.put("keep_item_img_ids", requirement.getKeep_item_img_ids());
		if(requirement.getPost_fee()!=null) params.put("post_fee", requirement.getPost_fee().toString());
		if(requirement.getSku_properties()!=null) params.put("sku_properties", requirement.getSku_properties());
		if(requirement.getSku_quantities()!=null) params.put("sku_quantities", requirement.getSku_quantities());
		if(requirement.getSku_prices()!=null) params.put("sku_prices", requirement.getSku_prices());
		if(requirement.getSku_outer_ids()!=null) params.put("sku_outer_ids", requirement.getSku_outer_ids());
		List<ItemAddSkuRequirement> itemAddSkuRequirementList = requirement.getSkus();
		
		if(requirement.getOrigin_price()!=null) params.put("origin_price", requirement.getOrigin_price());
		if(requirement.getBuy_url()!=null) params.put("buy_url", requirement.getBuy_url());
		if(requirement.getOuter_id()!=null) params.put("outer_id", requirement.getOuter_id());
		if(requirement.getBuy_quota()!=null) params.put("buy_quota", requirement.getBuy_quota().toString());
		if(requirement.getQuantity()!=null) params.put("quantity", requirement.getQuantity().toString());
		if(requirement.getHide_quantity()!=null) params.put("hide_quantity", KdtApiUtility.booleanToStr(requirement.getHide_quantity()));
		if(requirement.getFields()!=null) params.put("fields", requirement.getFields());
		
		HashMap<String, String> formparams = new HashMap<String, String>();
		if(itemAddSkuRequirementList!=null && itemAddSkuRequirementList.size()>0) {
			String skus_with_json = JSONArray.toJSONString(itemAddSkuRequirementList);
			if(skus_with_json!=null) formparams.put("skus_with_json", skus_with_json);
		}
		
		if(requirement.getDesc()!=null) formparams.put("desc", requirement.getDesc());
		
		String fileKey = "images[]";  
	    List<String> filePaths = requirement.getImages();
	    
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
			if(filePaths!=null && filePaths.size()>0) {
				response = kdtApiClient.post(method, params,formparams, filePaths, fileKey);
			} else {
				response = kdtApiClient.post(method, params,formparams);
			}
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
			if(errorResult!=null) return new Result<GoodsDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("item");
			return new Result<GoodsDetail>(errorResult,KdtApiUtility.jsonToGoodsDetail(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 商品上架
	 * @param num_iid	商品数字编号
	 * @param fields	需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<GoodsDetail> itemUpdateListing(Integer num_iid,String fields) {
		if(num_iid==null) return null;
		String method = "kdt.item.update.listing";
		System.out.println("kdt.item.update.listing");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("num_iid", num_iid.toString());
		if(fields!=null) params.put("fields", fields.toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("item");
			return new Result<GoodsDetail>(errorResult,KdtApiUtility.jsonToGoodsDetail(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 商品下架
	 * @param num_iid	商品数字编号
	 * @param fields	需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<GoodsDetail> itemUpdateDelisting(Integer num_iid,String fields) {
		if(num_iid==null) return null;
		String method = "kdt.item.update.delisting";
		System.out.println("kdt.item.update.delisting");
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("num_iid", num_iid.toString());
		if(fields!=null) params.put("fields", fields.toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsDetail>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("item");
			return new Result<GoodsDetail>(errorResult,KdtApiUtility.jsonToGoodsDetail(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据商品货号获取商品
	 * 跟据商品货号（商家为商品设置的外部编号）获取商品，如果一个outer_id对应多个商品会返回所有符合条件的商品
	 * @param outer_id	商品货号（商家为商品设置的外部编号）
	 * @param fields	需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<List<GoodsDetail>> itemCustomerGet(String outer_id,String fields) {
		if(outer_id==null) return null;
		String method = "kdt.items.custom.get";
		System.out.println("kdt.items.custom.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(outer_id!=null) params.put("outer_id", outer_id);
		if(fields!=null) params.put("fields", fields);
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<List<GoodsDetail>>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONArray jsonArrayItems = jsonObjectResponse.getJSONArray("items");
			if(jsonArrayItems!=null && !jsonArrayItems.isEmpty()) {
				List<GoodsDetail> list = new ArrayList<GoodsDetail>();
				for(int i=0;i<jsonArrayItems.size();i++) {
					JSONObject o = jsonArrayItems.getJSONObject(i);
					GoodsDetail gd = KdtApiUtility.jsonToGoodsDetail(o);
					if(gd!=null) list.add(gd);
				}
				return new Result<List<GoodsDetail>>(errorResult,list);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取仓库中的商品列表
	 * @param requirement
	 * @return
	 */
	public Result<GoodsDetailWithPage> itemsInventoryGet(ItemsInventoryGetRequirement requirement) {
		String method = "kdt.items.inventory.get";
		System.out.println("kdt.items.inventory.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getBanner()!=null) params.put("banner", requirement.getBanner().getName());
		if(requirement.getFields()!=null) params.put("fields", requirement.getFields());
		if(requirement.getOrder_by()!=null) params.put("order_by", requirement.getOrder_by().getName());
		if(requirement.getPage_no()!=null) params.put("page_no", requirement.getPage_no().toString());
		if(requirement.getPage_size()!=null) params.put("page_size", requirement.getPage_size().toString());
		if(requirement.getQ()!=null) params.put("q", requirement.getQ());
		if(requirement.getTag_id()!=null) params.put("tag_id", requirement.getTag_id().toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsDetailWithPage>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			GoodsDetailWithPage goodsDetailWithCount = new GoodsDetailWithPage();
			goodsDetailWithCount.setTotal_results(jsonObjectResponse.getInteger("total_results"));
			JSONArray jsonArrayItems = jsonObjectResponse.getJSONArray("items");
			if(jsonArrayItems!=null && !jsonArrayItems.isEmpty()) {
				List<GoodsDetail> list = new ArrayList<GoodsDetail>();
				for(int i=0;i<jsonArrayItems.size();i++) {
					JSONObject o = jsonArrayItems.getJSONObject(i);
					GoodsDetail gd = KdtApiUtility.jsonToGoodsDetail(o);
					if(gd!=null) list.add(gd);
				}
				goodsDetailWithCount.setItems(list);
			}
			return new Result<GoodsDetailWithPage>(errorResult,goodsDetailWithCount);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取出售中的商品列表
	 * @param requirement
	 * @return
	 */
	public Result<GoodsDetailWithPage> itemsOnsaleGet(ItemsOnsaleGetRequirement requirement) {
		String method = "kdt.items.onsale.get";
		System.out.println("kdt.items.onsale.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getFields()!=null) params.put("fields", requirement.getFields());
		if(requirement.getOrder_by()!=null) params.put("order_by", requirement.getOrder_by().getName());
		if(requirement.getPage_no()!=null) params.put("page_no", requirement.getPage_no().toString());
		if(requirement.getPage_size()!=null) params.put("page_size", requirement.getPage_size().toString());
		if(requirement.getQ()!=null) params.put("q", requirement.getQ());
		if(requirement.getTag_id()!=null) params.put("tag_id", requirement.getTag_id().toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsDetailWithPage>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			GoodsDetailWithPage goodsDetailWithPage = new GoodsDetailWithPage();
			goodsDetailWithPage.setTotal_results(jsonObjectResponse.getInteger("total_results"));
			JSONArray jsonArrayItems = jsonObjectResponse.getJSONArray("items");
			if(jsonArrayItems!=null && !jsonArrayItems.isEmpty()) {
				List<GoodsDetail> list = new ArrayList<GoodsDetail>();
				for(int i=0;i<jsonArrayItems.size();i++) {
					JSONObject o = jsonArrayItems.getJSONObject(i);
					GoodsDetail gd = KdtApiUtility.jsonToGoodsDetail(o);
					if(gd!=null) list.add(gd);
				}
				goodsDetailWithPage.setPage_no(requirement.getPage_no());
				goodsDetailWithPage.setPage_size(requirement.getPage_size());
				goodsDetailWithPage.setItems(list);
			}
			return new Result<GoodsDetailWithPage>(errorResult,goodsDetailWithPage);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 更新SKU信息
	 * @param requirement
	 * @return
	 */
	public Result<GoodsSku> itemSkuUpdate(ItemSkuUpdateRequirement requirement) {
		if(requirement==null) return null;
		String method = "kdt.item.sku.update";
		System.out.println("kdt.item.sku.update");
		HashMap<String, String> params = new HashMap<String, String>();
		if(requirement.getNum_iid()!=null) params.put("num_iid", requirement.getNum_iid().toString());
		if(requirement.getOuter_id()!=null) params.put("outer_id", requirement.getOuter_id());
		if(requirement.getPrice()!=null) params.put("price", requirement.getPrice().toString());
		if(requirement.getQuantity()!=null) params.put("quantity", requirement.getQuantity().toString());
		if(requirement.getSku_id()!=null) params.put("sku_id", requirement.getSku_id().toString());
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<GoodsSku>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONObject jsonObjectItem = jsonObjectResponse.getJSONObject("sku");
			return new Result<GoodsSku>(errorResult,KdtApiUtility.jsonToGoodsSku(jsonObjectItem));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 跟据商家编码（商家为Sku设置的外部编号）获取商品Sku，如果一个outer_id对应多个Sku会返回所有符合条件的Sku
	 * @param outer_id	商家编码（商家为Sku设置的外部编号）
	 * @param num_iid	商品数字编号
	 * @param fields	需要返回的Sku对象字段，如sku_id,num_iid,quantity等。可选值：Sku结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 * @return
	 */
	public static Result<List<GoodsSku>> skusCustomGet(String outer_id,Integer num_iid,String fields) {
		if(outer_id==null||num_iid==null) return null;
		String method = "kdt.skus.custom.get";
		System.out.println("kdt.skus.custom.get");
		HashMap<String, String> params = new HashMap<String, String>();
		if(outer_id!=null) params.put("outer_id", outer_id);
		if(fields!=null) params.put("fields", fields);
		KdtApiClient kdtApiClient;
		HttpResponse response;
		
		try {
			kdtApiClient = new KdtApiClient(YouzanConfig.getAppId(), YouzanConfig.getAppSecret());
//			response = kdtApiClient.post(method, params, filePaths, fileKey);
			response = kdtApiClient.post(method, params, null, null);
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
			if(errorResult!=null) return new Result<List<GoodsSku>>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONArray jsonArrayItems = jsonObjectResponse.getJSONArray("skus");
			if(jsonArrayItems!=null && !jsonArrayItems.isEmpty()) {
				List<GoodsSku> list = new ArrayList<GoodsSku>();
				for(int i=0;i<jsonArrayItems.size();i++) {
					JSONObject o = jsonArrayItems.getJSONObject(i);
					GoodsSku gs = KdtApiUtility.jsonToGoodsSku(o);
					if(gs!=null) list.add(gs);
				}
				return new Result<List<GoodsSku>>(errorResult,list);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
