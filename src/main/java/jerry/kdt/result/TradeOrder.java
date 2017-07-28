package jerry.kdt.result;

import java.util.List;

import jerry.kdt.config.ItemType;

/**
 * 交易明细数据结构
 * @author dj
 *
 */
public class TradeOrder {
	/**
	 * 交易明细编号。该编号并不唯一，只用于区分交易内的多条明细记录
	 */
	private Integer oid;
	/**
	 * 商品数字编号
	 */
	private Integer num_iid;
	/**
	 * Sku的ID，sku_id 在系统里并不是唯一的，结合商品ID一起使用才是唯一的。
	 */
	private Integer sku_id;
	/**
	 * Sku在系统中的唯一编号，可以在开发者的系统中用作 Sku 的唯一ID，但不能用于调用接口
	 */
	private String sku_unique_code;
	/**
	 * 商品购买数量
	 */
	private Integer num;
	/**
	 * 商家编码（商家为Sku设置的外部编号）
	 */
	private String outer_sku_id;
	/**
	 * 商品货号（商家为商品设置的外部编号）
	 */
	private String outer_item_id;
	/**
	 * 商品标题
	 */
	private String title;
	/**
	 * 卖家昵称
	 */
	private String seller_nick;
	/**
	 * 商品在分销商那边的出售价格。精确到2位小数；单位：元。如果是采购单才有值，否则值为 0
	 */
	private Double fenxiao_price;
	/**
	 * 商品在分销商那边的实付金额。精确到2位小数；单位：元。如果是采购单才有值，否则值为 0
	 */
	private Double fenxiao_payment;
	/**
	 * 商品价格。精确到2位小数；单位：元
	 */
	private Double price;
	/**
	 * 应付金额（商品价格乘以数量的总金额）
	 */
	private Double total_fee;
	/**
	 * 交易明细内的优惠金额。精确到2位小数，单位：元
	 */
	private Double discount_fee;
	/**
	 * 实付金额。精确到2位小数，单位：元
	 */
	private Double payment;
	/**
	 * SKU的值，即：商品的规格。如：机身颜色:黑色;手机套餐:官方标配
	 */
	private String sku_properties_name;
	/**
	 * 商品主图片地址
	 */
	private String pic_path;
	/**
	 * 商品主图片缩略图地址
	 */
	private String pic_thumb_path;
	/**
	 * 商品类型。
	 * 0：普通商品；
	 * 10：分销商品;
	 */
	private ItemType item_type;
	/**
	 * 交易明细中的买家留言列表
	 */
	private List<TradeBuyerMessage> buyer_messages;
	/**
	 * 交易明细中的优惠信息列表
	 */
	private List<TradeOrderPromotion> order_promotion_details;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(Integer numIid) {
		num_iid = numIid;
	}
	public Integer getSku_id() {
		return sku_id;
	}
	public void setSku_id(Integer skuId) {
		sku_id = skuId;
	}
	public String getSku_unique_code() {
		return sku_unique_code;
	}
	public void setSku_unique_code(String skuUniqueCode) {
		sku_unique_code = skuUniqueCode;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getOuter_sku_id() {
		return outer_sku_id;
	}
	public void setOuter_sku_id(String outerSkuId) {
		outer_sku_id = outerSkuId;
	}
	public String getOuter_item_id() {
		return outer_item_id;
	}
	public void setOuter_item_id(String outerItemId) {
		outer_item_id = outerItemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSeller_nick() {
		return seller_nick;
	}
	public void setSeller_nick(String sellerNick) {
		seller_nick = sellerNick;
	}
	public Double getFenxiao_price() {
		return fenxiao_price;
	}
	public void setFenxiao_price(Double fenxiaoPrice) {
		fenxiao_price = fenxiaoPrice;
	}
	public Double getFenxiao_payment() {
		return fenxiao_payment;
	}
	public void setFenxiao_payment(Double fenxiaoPayment) {
		fenxiao_payment = fenxiaoPayment;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Double totalFee) {
		total_fee = totalFee;
	}
	public Double getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(Double discountFee) {
		discount_fee = discountFee;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getSku_properties_name() {
		return sku_properties_name;
	}
	public void setSku_properties_name(String skuPropertiesName) {
		sku_properties_name = skuPropertiesName;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String picPath) {
		pic_path = picPath;
	}
	public String getPic_thumb_path() {
		return pic_thumb_path;
	}
	public void setPic_thumb_path(String picThumbPath) {
		pic_thumb_path = picThumbPath;
	}
	public ItemType getItem_type() {
		return item_type;
	}
	public void setItem_type(ItemType itemType) {
		item_type = itemType;
	}
	public List<TradeBuyerMessage> getBuyer_messages() {
		return buyer_messages;
	}
	public void setBuyer_messages(List<TradeBuyerMessage> buyerMessages) {
		buyer_messages = buyerMessages;
	}
	public List<TradeOrderPromotion> getOrder_promotion_details() {
		return order_promotion_details;
	}
	public void setOrder_promotion_details(
			List<TradeOrderPromotion> orderPromotionDetails) {
		order_promotion_details = orderPromotionDetails;
	}
	
}
