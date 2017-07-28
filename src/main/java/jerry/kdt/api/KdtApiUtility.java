package jerry.kdt.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jerry.kdt.config.Constant;
import jerry.kdt.config.CouponType;
import jerry.kdt.config.ItemType;
import jerry.kdt.config.PromotionType;
import jerry.kdt.config.QrcodeType;
import jerry.kdt.config.Sex;
import jerry.kdt.config.TradeBuyerType;
import jerry.kdt.config.TradeFeedback;
import jerry.kdt.config.TradePayType;
import jerry.kdt.config.TradeRefundState;
import jerry.kdt.config.TradeShippingType;
import jerry.kdt.config.TradeStatus;
import jerry.kdt.config.TradeType;
import jerry.kdt.result.AdjustFee;
import jerry.kdt.result.Basic;
import jerry.kdt.result.CommonRegion;
import jerry.kdt.result.CrmUserTag;
import jerry.kdt.result.CrmWeixinFans;
import jerry.kdt.result.ErrorResult;
import jerry.kdt.result.GoodsCategory;
import jerry.kdt.result.GoodsDetail;
import jerry.kdt.result.GoodsImage;
import jerry.kdt.result.GoodsQrcode;
import jerry.kdt.result.GoodsSku;
import jerry.kdt.result.GoodsTag;
import jerry.kdt.result.TradeBuyerMessage;
import jerry.kdt.result.TradeDetail;
import jerry.kdt.result.TradeFetch;
import jerry.kdt.result.TradeOrder;
import jerry.kdt.result.TradeOrderPromotion;
import jerry.kdt.result.TradePromotion;
import jerry.kdt.result.UmpTradeCoupon;
import jerry.kdt.utils.Util;

public class KdtApiUtility {
	/** 
	* 将json格式的字符串解析成Map对象 <li> 
	* json格式：{"name":"admin","retries":"3fff","testname" 
	* :"ddd","testretries":"fffffffff"} 
	*/  
	private static Map<String, String> toHashMap(JSONObject jsonObject) {  
		if(jsonObject==null) return null;
		Map<String, String> data = new HashMap<String, String>();  
		// 将json字符串转换成jsonObject  
	 	Set<String> set = jsonObject.keySet();
	 	if(set==null) return null;
	 	for(String key : set) {
	 		data.put(key, jsonObject.getString(key));  
	 	}
	    return data;  
	}  

	/**
	 * 报错json信息转换为ErrorResult对象
	 * @param jsonObject
	 * @return
	 */
	public static ErrorResult jsonToErrorResponse(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		JSONObject jsonObjectResponse = jsonObject.getJSONObject("error_response");//结果集
		if(jsonObjectResponse==null) return null;
		ErrorResult errorReulst = new ErrorResult();
		errorReulst.setCode(jsonObjectResponse.getString("code"));
		errorReulst.setMsg(jsonObjectResponse.getString("msg"));
		JSONObject jsonObjectParams = jsonObject.getJSONObject("params");
		if(jsonObjectParams!=null) {
			errorReulst.setParams(toHashMap(jsonObjectParams));
		}
		return errorReulst;
	}
	
	/**
	 * 逻辑变量转为有赞接口的是否 对应的字符串，1为是，0为否
	 * @param b
	 * @return
	 */
	public static String booleanToStr(Boolean b) {
		if(b==null) return "";
		return b?"1":"0";
	}
	public static CrmWeixinFans jsonToCrmWeixinFans(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		CrmWeixinFans crmWeixinFans = new CrmWeixinFans();
		crmWeixinFans.setAvatar(jsonObject.getString("avatar"));
		crmWeixinFans.setCity(jsonObject.getString("city"));
		crmWeixinFans.setFollow_time(jsonObject.getDate("follow_time"));
		crmWeixinFans.setIs_follow(jsonObject.getBooleanValue("is_follow"));
		crmWeixinFans.setLevel_info(jsonObject.getString("level_info"));
		crmWeixinFans.setNick(jsonObject.getString("nick"));
		crmWeixinFans.setPoints(jsonObject.getInteger("points"));
		crmWeixinFans.setProvince(jsonObject.getString("province"));
		crmWeixinFans.setSex(Sex.getByName(jsonObject.getString("sex")));
		JSONArray jsonArrayTags = jsonObject.getJSONArray("tags");
		if(jsonArrayTags!=null && jsonArrayTags.size()>0) {
			List<CrmUserTag> list = new ArrayList<CrmUserTag>();
			for(int i=0;i<jsonArrayTags.size();i++) {
				CrmUserTag cut = jsonToCrmUserTag(jsonArrayTags.getJSONObject(i));
				if(cut!=null) list.add(cut);
			}
			crmWeixinFans.setTags(list);
		}
		crmWeixinFans.setTraded_money(jsonObject.getDouble("traded_money"));
		crmWeixinFans.setTraded_num(jsonObject.getInteger("traded_num"));
		crmWeixinFans.setUnion_id(jsonObject.getString("union_id"));
		crmWeixinFans.setUser_id(jsonObject.getInteger("user_id"));
		crmWeixinFans.setWeixin_openid(jsonObject.getString("weixin_openid"));
		return crmWeixinFans;
	}
	
	public static CrmUserTag jsonToCrmUserTag(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		CrmUserTag crmUserTag = new CrmUserTag();
		crmUserTag.setId(jsonObject.getInteger(""));
		crmUserTag.setName(jsonObject.getString("name"));
		return crmUserTag;
	}
	
	public static AdjustFee jsonToAdjustFee(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		AdjustFee adjustFee = new AdjustFee();
		adjustFee.setChange(jsonObject.getDouble("change"));
		adjustFee.setPay_change(jsonObject.getDouble("pay_change"));
		adjustFee.setPost_change(jsonObject.getDouble("post_change"));
		return adjustFee;
	}
	
	public static TradeDetail jsonToTradeDetail(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradeDetail tradeDetail = new TradeDetail();
//		tradeDetail.setAdjust_fee(jsonObject.getDouble("adjust_fee"));
		JSONObject jsonObjectAdjustFee = jsonObject.getJSONObject("adjust_fee");
		tradeDetail.setAdjust_fee(jsonToAdjustFee(jsonObjectAdjustFee));
		tradeDetail.setBuyer_area(jsonObject.getString("buyer_area"));
		tradeDetail.setBuyer_id(jsonObject.getInteger("buyer_id"));
		tradeDetail.setBuyer_message(jsonObject.getString("buyer_message"));
		tradeDetail.setBuyer_nick(jsonObject.getString("buyer_nick"));
		tradeDetail.setBuyer_type(TradeBuyerType.getByTypeId(jsonObject.getInteger("buyer_type")));
		tradeDetail.setConsign_time(jsonObject.getDate("consign_time"));
		tradeDetail.setConsign_timeFormat(Util.formatDate(jsonObject.getDate("consign_time"),Constant.API_DATE_FORMAT));
		JSONArray jsonArrayCouponDetails = jsonObject.getJSONArray("coupon_details");
		if(jsonArrayCouponDetails!=null && jsonArrayCouponDetails.size()>0) {
			List<UmpTradeCoupon> list = new ArrayList<UmpTradeCoupon>();
			for(int i=0;i<jsonArrayCouponDetails.size();i++) {
				UmpTradeCoupon utc = jsonToUmpTradeCoupon(jsonArrayCouponDetails.getJSONObject(i));
				if(utc!=null) list.add(utc);
			}
			tradeDetail.setCoupon_details(list);
		}
		tradeDetail.setCreated(jsonObject.getDate("created"));
		tradeDetail.setCreatedFormat(Util.formatDate(jsonObject.getDate("created"),Constant.API_DATE_FORMAT));
		tradeDetail.setDiscount_fee(jsonObject.getDouble("discount_fee"));
		tradeDetail.setFeedback(TradeFeedback.getById(jsonObject.getInteger("feedback")));
		tradeDetail.setFetch_detail(jsonToTradeFetch(jsonObject.getJSONObject("fetch_detail")));
		tradeDetail.setNum(jsonObject.getInteger("num"));
		tradeDetail.setNum_iid(jsonObject.getInteger("num_iid"));
		JSONArray jsonArrayOrders = jsonObject.getJSONArray("orders");
		if(jsonArrayOrders!=null && jsonArrayOrders.size()>0) {
			List<TradeOrder> list = new ArrayList<TradeOrder>();
			for(int i=0;i<jsonArrayOrders.size();i++) {
				TradeOrder to = jsonToTradeOrder(jsonArrayOrders.getJSONObject(i));
				if(to!=null) list.add(to);
			}
			tradeDetail.setOrders(list);
		}
		tradeDetail.setOuter_tid(jsonObject.getString(""));
		tradeDetail.setPay_time(jsonObject.getDate("pay_time"));
		tradeDetail.setPay_timeFormat(Util.formatDate(jsonObject.getDate("pay_time"),Constant.API_DATE_FORMAT));
		tradeDetail.setPay_type(TradePayType.getByName(jsonObject.getString("pay_type")));
		tradeDetail.setPayment(jsonObject.getDouble("payment"));
		tradeDetail.setPic_path(jsonObject.getString("pic_path"));
		tradeDetail.setPic_thumb_path(jsonObject.getString("pic_thumb_path"));
		tradeDetail.setPost_fee(jsonObject.getDouble("post_fee"));
		tradeDetail.setPrice(jsonObject.getDouble("price"));
		JSONArray jsonArrayPromotionDetails = jsonObject.getJSONArray("promotion_details");
		if(jsonArrayPromotionDetails!=null && jsonArrayPromotionDetails.size()>0) {
			List<TradePromotion> list = new ArrayList<TradePromotion>();
			for(int i=0;i<jsonArrayPromotionDetails.size();i++) {
				TradePromotion tp = jsonToTradePromotion(jsonArrayPromotionDetails.getJSONObject(i));
				if(tp!=null) list.add(tp);
			}
			tradeDetail.setPromotion_details(list);
		}
		tradeDetail.setReceiver_address(jsonObject.getString("receiver_address"));
		tradeDetail.setReceiver_city(jsonObject.getString("receiver_city"));
		tradeDetail.setReceiver_district(jsonObject.getString("receiver_district"));
		tradeDetail.setReceiver_mobile(jsonObject.getString("receiver_mobile"));
		tradeDetail.setReceiver_name(jsonObject.getString("receiver_name"));
		tradeDetail.setReceiver_state(jsonObject.getString("receiver_state"));
		tradeDetail.setReceiver_zip(jsonObject.getString("receiver_zip"));
		tradeDetail.setRefunded_fee(jsonObject.getDouble("refunded_fee"));
		tradeDetail.setRefund_state(TradeRefundState.getByName(jsonObject.getString("refund_state")));
		tradeDetail.setSeller_flag(jsonObject.getInteger("seller_flag"));
		tradeDetail.setShipping_type(TradeShippingType.getByName(jsonObject.getString("shipping_type")));
		tradeDetail.setSign_time(jsonObject.getDate("sign_time"));
		tradeDetail.setSign_timeFormat(Util.formatDate(jsonObject.getDate("sign_time"),Constant.API_DATE_FORMAT));
		tradeDetail.setStatus(TradeStatus.getByName(jsonObject.getString("status")));
//		tradeDetail.setSub_trades(subTrades);
		tradeDetail.setTid(jsonObject.getString("tid"));
		tradeDetail.setTitle(jsonObject.getString("title"));
		tradeDetail.setTotal_fee(jsonObject.getDouble("total_fee"));
		tradeDetail.setTrade_memo(jsonObject.getString("trade_memo"));
		tradeDetail.setType(TradeType.getByName(jsonObject.getString("type")));
		tradeDetail.setUpdate_time(jsonObject.getDate("update_time"));
		tradeDetail.setUpdate_timeFormat(Util.formatDate(jsonObject.getDate("update_time"),Constant.API_DATE_FORMAT));
		tradeDetail.setWeixin_user_id(jsonObject.getInteger("weixin_user_id"));
		return tradeDetail;
	}
	
	private static TradeOrder jsonToTradeOrder(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradeOrder tradeOrder = new TradeOrder();
		JSONArray jsonArrayBuyerMessages = jsonObject.getJSONArray("buyer_messages");
		if(jsonArrayBuyerMessages!=null && jsonArrayBuyerMessages.size()>0) {
			List<TradeBuyerMessage> list = new ArrayList<TradeBuyerMessage>();
			for(int i=0;i<jsonArrayBuyerMessages.size();i++) {
				TradeBuyerMessage tbm = jsonToTradeBuyerMessage(jsonArrayBuyerMessages.getJSONObject(i));
				if(tbm!=null) list.add(tbm);
			}
			tradeOrder.setBuyer_messages(list);
		}
		tradeOrder.setDiscount_fee(jsonObject.getDouble("discount_fee"));
		tradeOrder.setFenxiao_payment(jsonObject.getDouble("fenxiao_payment"));
		tradeOrder.setFenxiao_price(jsonObject.getDouble("fenxiao_price"));
		tradeOrder.setItem_type(ItemType.getByTypeId(jsonObject.getInteger("item_type")));
		tradeOrder.setNum(jsonObject.getInteger("num"));
		tradeOrder.setNum_iid(jsonObject.getInteger("num_iid"));
		tradeOrder.setOid(jsonObject.getInteger("oid"));
		JSONArray jsonArrayOrderPromotionDetails = jsonObject.getJSONArray("order_promotion_details");
		if(jsonArrayOrderPromotionDetails!=null && jsonArrayOrderPromotionDetails.size()>0) {
			List<TradeOrderPromotion> list = new ArrayList<TradeOrderPromotion>();
			for(int i=0;i<jsonArrayOrderPromotionDetails.size();i++) {
				TradeOrderPromotion top = jsonToTradeOrderPromotion(jsonArrayOrderPromotionDetails.getJSONObject(i));
				if(top!=null) list.add(top);
			}
			tradeOrder.setOrder_promotion_details(list);
		}
		tradeOrder.setOuter_item_id(jsonObject.getString("outer_item_id"));
		tradeOrder.setOuter_sku_id(jsonObject.getString("outer_sku_id"));
		tradeOrder.setPayment(jsonObject.getDouble("payment"));
		tradeOrder.setPic_path(jsonObject.getString("pic_path"));
		tradeOrder.setPic_thumb_path(jsonObject.getString("pic_thumb_path"));
		tradeOrder.setPrice(jsonObject.getDouble("price"));
		tradeOrder.setSeller_nick(jsonObject.getString("seller_nick"));
		tradeOrder.setSku_id(jsonObject.getInteger("sku_id"));
		tradeOrder.setSku_properties_name(jsonObject.getString("sku_properties_name"));
		tradeOrder.setSku_unique_code(jsonObject.getString("sku_unique_code"));
		tradeOrder.setTitle(jsonObject.getString("title"));
		tradeOrder.setTotal_fee(jsonObject.getDouble("total_fee"));
		return tradeOrder;
	}
	
	private static TradeBuyerMessage jsonToTradeBuyerMessage(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradeBuyerMessage tradeBuyerMessage = new TradeBuyerMessage();
		tradeBuyerMessage.setTitle(jsonObject.getString("title"));
		tradeBuyerMessage.setContent(jsonObject.getString("content"));
		return tradeBuyerMessage;
	}
	
	private static TradeOrderPromotion jsonToTradeOrderPromotion(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradeOrderPromotion tradeOrderPromotion = new TradeOrderPromotion();
		tradeOrderPromotion.setApply_at(jsonObject.getDate("apply_at"));
		tradeOrderPromotion.setApply_atFormat(Util.formatDate(jsonObject.getDate("apply_at"),Constant.API_DATE_FORMAT));
		tradeOrderPromotion.setDiscount_fee(jsonObject.getDouble("discount_fee"));
		tradeOrderPromotion.setPromotion_name(jsonObject.getString("promotion_name"));
		tradeOrderPromotion.setPromotion_type(PromotionType.getByName(jsonObject.getString("promotion_type")));
		return tradeOrderPromotion;
	}
	
	private static UmpTradeCoupon jsonToUmpTradeCoupon(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		UmpTradeCoupon umpTradeCoupon = new UmpTradeCoupon();
		umpTradeCoupon.setCoupon_condition(jsonObject.getString("coupon_condition"));
		umpTradeCoupon.setCoupon_content(jsonObject.getString("coupon_content"));
		umpTradeCoupon.setCoupon_description(jsonObject.getString("coupon_description"));
		umpTradeCoupon.setCoupon_id(jsonObject.getInteger("coupon_id"));
		umpTradeCoupon.setCoupon_name(jsonObject.getString("coupon_name"));
		umpTradeCoupon.setCoupon_type(CouponType.getByName(jsonObject.getString("coupon_type")));
		umpTradeCoupon.setDiscount_fee(jsonObject.getDouble("discount_fee"));
		umpTradeCoupon.setUsed_at(jsonObject.getDate("used_at"));
		umpTradeCoupon.setUsed_atFormat(Util.formatDate(jsonObject.getDate("used_at"),Constant.API_DATE_FORMAT));
		return umpTradeCoupon;
	}
	
	private static TradePromotion jsonToTradePromotion(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradePromotion tradePromotion = new TradePromotion();
		tradePromotion.setDiscount_fee(jsonObject.getDouble("discount_fee"));
		tradePromotion.setPromotion_condition(jsonObject.getString("promotion_condition"));
		tradePromotion.setPromotion_id(jsonObject.getInteger("promotion_id"));
		tradePromotion.setPromotion_name(jsonObject.getString("promotion_name"));
		tradePromotion.setPromotion_type(PromotionType.getByName(jsonObject.getString("promotion_type")));
		tradePromotion.setUsed_at(jsonObject.getDate("used_at"));
		tradePromotion.setUsed_atFormat(Util.formatDate(jsonObject.getDate("used_at"),Constant.API_DATE_FORMAT));
		return tradePromotion;
	}
	
	private static TradeFetch jsonToTradeFetch(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		TradeFetch tradeFetch = new TradeFetch();
		tradeFetch.setFetch_time(jsonObject.getDate("fetch_time"));
		tradeFetch.setFetch_timeFormat(Util.formatDate(jsonObject.getDate("fetch_time"),Constant.API_DATE_FORMAT));
		tradeFetch.setFetcher_mobile(jsonObject.getString("fetcher_mobile"));
		tradeFetch.setFetcher_name(jsonObject.getString("fetcher_name"));
		tradeFetch.setShop_address(jsonObject.getString("shop_address"));
		tradeFetch.setShop_city(jsonObject.getString("shop_city"));
		tradeFetch.setShop_district(jsonObject.getString("shop_district"));
		tradeFetch.setShop_mobile(jsonObject.getString("shop_mobile"));
		tradeFetch.setShop_name(jsonObject.getString("shop_name"));
		tradeFetch.setShop_state(jsonObject.getString("shop_state"));
		return tradeFetch;
	}
	
	public static GoodsTag jsonToGoodsTag(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		GoodsTag goodsTag = new GoodsTag();
		goodsTag.setCreated(Util.parseDate(jsonObject.getString("created")));
		goodsTag.setDesc(jsonObject.getString("desc"));
		goodsTag.setId(jsonObject.getInteger("id"));
		goodsTag.setItem_num(jsonObject.getInteger("item_num"));
		goodsTag.setName(jsonObject.getString("name"));
		goodsTag.setShare_url(jsonObject.getString("share_url"));
		goodsTag.setTag_url(jsonObject.getString("tag_url"));
		goodsTag.setType(jsonObject.getInteger("type"));
		return goodsTag;
	}
	public static GoodsCategory jsonToGoodsCategory(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		GoodsCategory goodsCategory = new GoodsCategory();
		goodsCategory.setCid(jsonObject.getInteger("cid"));
		goodsCategory.setIs_parent(jsonObject.getBoolean("is_parent"));
		goodsCategory.setName(jsonObject.getString("name"));
		goodsCategory.setParent_cid(jsonObject.getInteger("parent_cid"));
		JSONArray jsonArray = jsonObject.getJSONArray("sub_categories");
		if(jsonArray!=null && !jsonArray.isEmpty()) {
			List<GoodsCategory> list = new ArrayList<GoodsCategory>();
			for(int i=0;i<jsonArray.size();i++) {
				GoodsCategory gc = jsonToGoodsCategory(jsonArray.getJSONObject(i));
				if(gc!=null) list.add(gc);
			}
			goodsCategory.setSub_categories(list);
		}
		return goodsCategory;
	}
	public static GoodsDetail jsonToGoodsDetail(JSONObject jsonObjectItem) {
		if(jsonObjectItem==null || jsonObjectItem.isEmpty()) return null;
		GoodsDetail goodsDetail = new GoodsDetail();
		goodsDetail.setAlias(jsonObjectItem.getString("alias"));
		goodsDetail.setAuto_listing_time(new Date(jsonObjectItem.getLong("auto_listing_time")));
		goodsDetail.setAuto_listing_timeFormat(Util.formatDate(new Date(jsonObjectItem.getLong("auto_listing_time")),Constant.API_DATE_FORMAT));
		goodsDetail.setBuy_quota(jsonObjectItem.getInteger("buy_quota"));
		goodsDetail.setCid(jsonObjectItem.getInteger("cid"));
		goodsDetail.setCreated(jsonObjectItem.getDate("created"));
		goodsDetail.setCreatedFormat(Util.formatDate(jsonObjectItem.getDate("created"),Constant.API_DATE_FORMAT));
		goodsDetail.setDelivery_template_fee(jsonObjectItem.getString("delivery_template_fee"));
		goodsDetail.setDesc(jsonObjectItem.getString("desc"));
		goodsDetail.setIs_listing(jsonObjectItem.getBoolean("is_listing"));
		goodsDetail.setIs_lock(jsonObjectItem.getBoolean("is_lock"));
		goodsDetail.setIs_supplier_item(jsonObjectItem.getBoolean("is_supplier_item"));
		goodsDetail.setIs_used(jsonObjectItem.getBoolean("is_used"));
		goodsDetail.setIs_virtual(jsonObjectItem.getBoolean("is_virtual"));
		goodsDetail.setItem_type(jsonObjectItem.getInteger("item_type"));
		goodsDetail.setNum(jsonObjectItem.getInteger("num"));
		goodsDetail.setNum_iid(jsonObjectItem.getInteger("num_iid"));
		goodsDetail.setOrigin_price(jsonObjectItem.getString("origin_price"));
		goodsDetail.setOuter_buy_url(jsonObjectItem.getString("outer_buy_url"));
		goodsDetail.setOuter_id(jsonObjectItem.getString("outer_id"));
		goodsDetail.setPic_thumb_url(jsonObjectItem.getString("pic_thumb_url"));
		goodsDetail.setPic_url(jsonObjectItem.getString("pic_url"));
		goodsDetail.setPost_fee(jsonObjectItem.getDouble("post_fee"));
		goodsDetail.setPost_type(jsonObjectItem.getInteger("post_type"));
		goodsDetail.setPrice(jsonObjectItem.getDouble("price"));
		goodsDetail.setPromotion_cid(jsonObjectItem.getInteger("promotion_cid"));
		goodsDetail.setShare_url(jsonObjectItem.getString("share_url"));
		goodsDetail.setSold_num(jsonObjectItem.getInteger("sold_num"));
		goodsDetail.setTag_ids(jsonObjectItem.getString("tag_ids"));
		goodsDetail.setTitle(jsonObjectItem.getString("title"));
		JSONArray itemTagArray = jsonObjectItem.getJSONArray("item_tags");
		if(itemTagArray!=null && !itemTagArray.isEmpty()) {
			List<GoodsTag> goodsTagList = new ArrayList<GoodsTag>();
			for(int i=0;i<itemTagArray.size();i++) {
				goodsTagList.add(KdtApiUtility.jsonToGoodsTag(itemTagArray.getJSONObject(i)));
			}
			goodsDetail.setItem_tags(goodsTagList);
		}
		JSONArray skus = jsonObjectItem.getJSONArray("skus");
		if(skus!=null && !skus.isEmpty()) {
			List<GoodsSku> goodsSkuList = new ArrayList<GoodsSku>();
			for(int i=0;i<skus.size();i++) {
				goodsSkuList.add(KdtApiUtility.jsonToGoodsSku(skus.getJSONObject(i)));
			}
			goodsDetail.setSkus(goodsSkuList);
		}
		JSONArray itemImgs = jsonObjectItem.getJSONArray("item_imgs");
		if(itemImgs!=null && !itemImgs.isEmpty()) {
			List<GoodsImage> goodsImageList = new ArrayList<GoodsImage>();
			for(int i=0;i<itemImgs.size();i++) {
				goodsImageList.add(KdtApiUtility.jsonToGoodsImage(itemImgs.getJSONObject(i)));
			}
			goodsDetail.setItem_imgs(goodsImageList);
		}
		JSONArray itemQrcodes = jsonObjectItem.getJSONArray("item_qrcodes");
		if(itemQrcodes!=null && !itemQrcodes.isEmpty()) {
			List<GoodsQrcode> goodsQrcodeList = new ArrayList<GoodsQrcode>();
			for(int i=0;i<itemQrcodes.size();i++) {
				goodsQrcodeList.add(KdtApiUtility.jsonToGoodsQrcode(itemQrcodes.getJSONObject(i)));
			}
			goodsDetail.setItem_qrcodes(goodsQrcodeList);
		}
		return goodsDetail;
	}
	public static GoodsImage jsonToGoodsImage(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		GoodsImage goodsImage = new GoodsImage();
		goodsImage.setCombine(jsonObject.getString("combine"));
		goodsImage.setCreated(jsonObject.getDate("created"));
		goodsImage.setCreatedFormat(Util.formatDate(jsonObject.getDate("created"),Constant.API_DATE_FORMAT));
		goodsImage.setId(jsonObject.getInteger("id"));
		goodsImage.setMedium(jsonObject.getString("medium"));
		goodsImage.setThumbnail(jsonObject.getString("thumbnail"));
		goodsImage.setUrl(jsonObject.getString("url"));
		return goodsImage;
	}
	public static GoodsQrcode jsonToGoodsQrcode(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		GoodsQrcode goodsQrcode = new GoodsQrcode();
		goodsQrcode.setCreated(jsonObject.getDate("created"));
		goodsQrcode.setCreatedFormat(Util.formatDate(jsonObject.getDate("created"),Constant.API_DATE_FORMAT));
		goodsQrcode.setDecrease(jsonObject.getDouble("decrease"));
		goodsQrcode.setDesc(jsonObject.getString("desc"));
		goodsQrcode.setDiscount(jsonObject.getString("discount"));
		goodsQrcode.setId(jsonObject.getInteger("id"));
		goodsQrcode.setLink_url(jsonObject.getString("link_url"));
		goodsQrcode.setName(jsonObject.getString("name"));
		goodsQrcode.setType(QrcodeType.getByName(jsonObject.getString("type")));
		goodsQrcode.setWeixin_qrcode_url(jsonObject.getString("weixin_qrcode_url"));
		return goodsQrcode;
	}
	public static GoodsSku jsonToGoodsSku(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		GoodsSku goodsSku = new GoodsSku();
		goodsSku.setCreated(jsonObject.getDate("created"));
		goodsSku.setCreatedFormat(Util.formatDate(jsonObject.getDate("created"),Constant.API_DATE_FORMAT));
		goodsSku.setModified(jsonObject.getDate("modified"));
		goodsSku.setModifiedFormat(Util.formatDate(jsonObject.getDate("modified"),Constant.API_DATE_FORMAT));
		goodsSku.setNum_iid(jsonObject.getInteger("num_iid"));
		goodsSku.setOuter_id(jsonObject.getString("outer_id"));
		goodsSku.setPrice(jsonObject.getDouble("price"));
		goodsSku.setProperties_name(jsonObject.getString("properties_name"));
		goodsSku.setProperties_name_json(jsonObject.getString("properties_name_json"));
		goodsSku.setQuantity(jsonObject.getInteger("quantity"));
		goodsSku.setSku_id(jsonObject.getInteger("sku_id"));
		goodsSku.setSku_unique_code(jsonObject.getString("sku_unique_code"));
		goodsSku.setWith_hold_quantity(jsonObject.getInteger("with_hold_quantity"));
		return goodsSku;
	}
	public static CommonRegion jsonToCommonRegion(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		CommonRegion commonRegion = new CommonRegion();
		commonRegion.setId(jsonObject.getInteger("id"));
		commonRegion.setName(jsonObject.getString("name"));
		commonRegion.setParent_id(jsonObject.getInteger("parent_id"));
		return commonRegion;
	}
	public static Basic jsonToBasic(JSONObject jsonObject) {
		if(jsonObject==null || jsonObject.isEmpty()) return null;
		Basic basic = new Basic();
		basic.setLogo(jsonObject.getString("logo"));
		basic.setName(jsonObject.getString("name"));
		basic.setSid(jsonObject.getInteger("sid"));
		return basic;
	}
}
