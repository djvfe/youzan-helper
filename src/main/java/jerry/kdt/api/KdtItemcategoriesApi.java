package jerry.kdt.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.YouzanConfig;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.GoodsCategory;
import jerry.kdt.result.GoodsTag;
import jerry.kdt.result.Result;
/**
 * 商品类目接口
 * @author dj
 *
 */
public class KdtItemcategoriesApi {
	public static void main(String[] args) {
		List<GoodsTag> goodsTagList = KdtItemcategoriesApi.itemcategoriesTagsGet(false).getContent();
		if(goodsTagList!=null && goodsTagList.size()>0) {
			for(GoodsTag gt : goodsTagList) {
				System.out.println(gt.getName());
			}
		}
		List<GoodsCategory> goodsCategoryList = KdtItemcategoriesApi.itemcategoriesGet().getContent();
		if(goodsCategoryList!=null && goodsCategoryList.size()>0) {
			for(GoodsCategory gc : goodsCategoryList) {
				System.out.println(gc.getName());
			}
		}
	}

	/**
	 * 获取商品分类二维列表
	 * @return
	 */
	public static Result<List<GoodsCategory>> itemcategoriesGet() {
		String method = "kdt.itemcategories.get";
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
			if(errorResult!=null) return new Result<List<GoodsCategory>>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONArray jsonArrayCategories = jsonObjectResponse.getJSONArray("categories");
			List<GoodsCategory> goodsCategoryList = new ArrayList<GoodsCategory>();
			if(jsonArrayCategories!=null) {
				for(int i=0;i<jsonArrayCategories.size();i++) {
					JSONObject o = jsonArrayCategories.getJSONObject(i);
					GoodsCategory gc = KdtApiUtility.jsonToGoodsCategory(o);
					if(gc!=null) goodsCategoryList.add(gc);
				}
			}
			return new Result<List<GoodsCategory>>(errorResult,goodsCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取商品自定义标签列表
	 * @param isSort	是否排序（按序号）
	 * @return
	 */
	public static Result<List<GoodsTag>> itemcategoriesTagsGet(Boolean isSort) {
		String method = "kdt.itemcategories.tags.get";
		HashMap<String, String> params = new HashMap<String, String>();
		if(isSort!=null) params.put("is_sort", isSort?"0":"1");
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
			if(errorResult!=null) return new Result<List<GoodsTag>>(errorResult,null);
			JSONObject jsonObjectResponse = jsonObject.getJSONObject("response");//结果集
			JSONArray jsonArrayTags = jsonObjectResponse.getJSONArray("tags");
			List<GoodsTag> goodsTagList = new ArrayList<GoodsTag>();
			if(jsonArrayTags!=null) {
				for(int i=0;i<jsonArrayTags.size();i++) {
					JSONObject o = jsonArrayTags.getJSONObject(i);
					GoodsTag gt = KdtApiUtility.jsonToGoodsTag(o);
					if(gt!=null) goodsTagList.add(gt);
				}
			}
			return new Result<List<GoodsTag>>(errorResult,goodsTagList);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
