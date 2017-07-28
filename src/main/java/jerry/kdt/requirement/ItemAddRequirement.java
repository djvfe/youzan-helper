package jerry.kdt.requirement;

import java.util.List;

/**
 * kdt.item.add 新增一个商品请求参数
 * @author dj
 *
 */
public class ItemAddRequirement {
	/**
	 * 商品分类的叶子类目id，可参考API：kdt.itemcategories.get
	 */
	private Integer cid;
	/**
	 * 商品推广栏目id，可参考API：kdt.itemcategories.promotions.get
	 */
	private Integer promotion_cid;
	/**
	 * 商品标签id串，结构如：1234,1342,...，可参考API：kdt.itemcategories.tags.get
	 */
	private List<Integer> tag_ids;
	/**
	 * 必须
	 * 商品价格。取值范围：0.01-100000000；精确到2位小数；单位：元。需要在Sku价格所决定的的区间内
	 */
	private Double price;
	/**
	 * 必须
	 * 商品标题。不能超过100字，受违禁词控制
	 */
	private String title;
	/**
	 * 必须
	 * 商品描述。字数要大于5个字符，小于25000个字符 ，受违禁词控制
	 */
	private String desc;
	/**
	 * 必须
	 * 是否是虚拟商品。目前不支持虚拟商品
	 */
	private Boolean is_virtual;
	/**
	 * 必须
	 * 商品图片文件列表，可一次上传多张。最大支持 1M，支持的文件类型：gif,jpg,jpeg,png 
	 * 注：图片参数不参与通讯协议签名，参数名中的中括号"[]"必须有，否则不能正常工作
	 */
//	private byte[] images;
	private List<String> images;
	/**
	 * 必须
	 * 运费。取值范围：0.00-999.00；精确到2位小数；单位：元
	 */
	private Double post_fee;
	/**
	 * Sku的属性串。格式：pText:vText;pText:vText，多个sku之间用逗号分隔，如：颜色:黄色;尺寸:M,颜色:黄色;尺寸:S。pText和vText文本中不可以存在冒号和分号以及逗号 
	 * 为了兼顾移动端商品界面展示的美观，目前有赞仅支持Sku的属性个数小于等于三个（比如：颜色、尺寸、重量 这三个属性）。无Sku则为空
	 */
	private String sku_properties;
	/**
	 * Sku的数量串。结构如：num1,num2,num3 如：2,3。无Sku则为空
	 */
	private String sku_quantities;
	/**
	 * Sku的价格串。结构如：10.00,5.00,... 精确到2位小数。单位:元。无Sku则为空
	 */
	private String sku_prices;
	/**
	 * Sku的商家编码（商家为Sku设置的外部编号）串。结构如：1234,1342,... 。sku_properties, sku_quantities, sku_prices, sku_outer_ids在输入数据时要一一对应，即使商家编码为空，也要用逗号相连。无Sku则为空
	 */
	private String sku_outer_ids;
	/**
	 * 转换为相应的json字符串再传到有赞接口
	 * 
	 * 商品Sku信息的Json字符串， 调用时，参数 sku_properties、sku_quantities、sku_prices、sku_outer_ids四个字段组合方式 和 skus_with_json 单字段输入方式 选其一个方式即可，无Sku则为空。 
	 * 具体参见kdt.item.update文档描述。
	 * 例
	 * [{"sku_price":"10.00","sku_property":{"颜色":"黄色","尺寸":"M","重量":"1KG"},"sku_quantity":"2","sku_outer_id":"1234"}
	 * ,{"sku_price":"5.00","sku_property":{"颜色":"黄色","尺寸":"S","重量":"1KG"},"sku_quantity":"3","sku_outer_id":"1242"}]
	 */
	private List<ItemAddSkuRequirement> skus;
	/**
	 * 显示在“原价”一栏中的信息
	 */
	private String origin_price;
	/**
	 * 该商品的外部购买地址。当用户购买环境不支持微信或微博支付时会跳转到此地址
	 */
	private String buy_url;
	/**
	 * 商品货号（商家为商品设置的外部编号）
	 */
	private String outer_id;
	/**
	 * 每人限购多少件。0代表无限购，默认为0
	 */
	private Integer buy_quota;
	/**
	 * 商品总库存。当商品没有Sku的时候有效，商品有Sku时，总库存会自动按所有Sku库存之和计算
	 */
	private Integer quantity;
	/**
	 * 是否隐藏商品库存。在商品展示时不显示商品的库存，默认显示库存
	 */
	private Boolean hide_quantity;
	/**
	 * 需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 */
	private String fields;
	/**
	 * 是否上架商品。默认上架商品
	 */
	private Boolean is_display;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPromotion_cid() {
		return promotion_cid;
	}
	public void setPromotion_cid(Integer promotionCid) {
		promotion_cid = promotionCid;
	}
	public List<Integer> getTag_ids() {
		return tag_ids;
	}
	public void setTag_ids(List<Integer> tagIds) {
		tag_ids = tagIds;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Boolean getIs_virtual() {
		return is_virtual;
	}
	public void setIs_virtual(Boolean isVirtual) {
		is_virtual = isVirtual;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Double getPost_fee() {
		return post_fee;
	}
	public void setPost_fee(Double postFee) {
		post_fee = postFee;
	}
	public String getSku_properties() {
		return sku_properties;
	}
	public void setSku_properties(String skuProperties) {
		sku_properties = skuProperties;
	}
	public String getSku_quantities() {
		return sku_quantities;
	}
	public void setSku_quantities(String skuQuantities) {
		sku_quantities = skuQuantities;
	}
	public String getSku_prices() {
		return sku_prices;
	}
	public void setSku_prices(String skuPrices) {
		sku_prices = skuPrices;
	}
	public String getSku_outer_ids() {
		return sku_outer_ids;
	}
	public void setSku_outer_ids(String skuOuterIds) {
		sku_outer_ids = skuOuterIds;
	}
	public List<ItemAddSkuRequirement> getSkus() {
		return skus;
	}
	public void setSkus(List<ItemAddSkuRequirement> skus) {
		this.skus = skus;
	}
	public String getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(String originPrice) {
		origin_price = originPrice;
	}
	public String getBuy_url() {
		return buy_url;
	}
	public void setBuy_url(String buyUrl) {
		buy_url = buyUrl;
	}
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outerId) {
		outer_id = outerId;
	}
	public Integer getBuy_quota() {
		return buy_quota;
	}
	public void setBuy_quota(Integer buyQuota) {
		buy_quota = buyQuota;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Boolean getHide_quantity() {
		return hide_quantity;
	}
	public void setHide_quantity(Boolean hideQuantity) {
		hide_quantity = hideQuantity;
	}
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public Boolean getIs_display() {
		return is_display;
	}
	public void setIs_display(Boolean isDisplay) {
		is_display = isDisplay;
	}
	
}
