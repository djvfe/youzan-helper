package jerry.kdt.result;

import java.util.Date;

/**
 * Sku数据结构
 * @author dj
 *
 */
public class GoodsSku {
	/**
	 * 商家编码（商家为Sku设置的外部编号）
	 */
	private String outer_id;
	/**
	 * Sku的ID，sku_id 在系统里并不是唯一的，结合商品ID一起使用才是唯一的。
	 */
	private Integer sku_id;
	/**
	 * Sku在系统中的唯一编号，可以在开发者的系统中用作 Sku 的唯一ID，但不能用于调用接口
	 */
	private String sku_unique_code;
	/**
	 * Sku所属商品的数字编号
	 */
	private Integer num_iid;
	/**
	 * 属于这个Sku的商品的数量
	 */
	private Integer quantity;
	/**
	 * Sku所对应的销售属性的中文名字串，格式如：pid1:vid1:pid_name1:vid_name1;pid2:vid2:pid_name2:vid_name2……
	 */
	private String properties_name;
	/**
	 * Sku所对应的销售属性的Json字符串（需另行解析）， 该字段内容与properties_name字段除了格式不一样，内容完全一致。 由于产品规格信息难以避免涉及到‘:’、‘,’、‘;’这些与解析规则冲突的字符，所以增加该字段。 
	 * 格式定义：
	 * [
			{
				"kid": "20000",
				"vid": "3275069",
				"k": "品牌",
				"v": "盈讯"
			},
			{
				"kid": "1753146",
				"vid": "3485013",
				"k": "型号",
				"v": "F908"
			}
			......
		]
	 */
	private String properties_name_json;
	/**
	 * 商品在付款减库存的状态下，该Sku上未付款的订单数量
	 */
	private Integer with_hold_quantity;
	/**
	 * 商品的这个Sku的价格；精确到2位小数；单位：元
	 */
	private Double price;
	/**
	 * Sku创建日期，时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;
	/**
	 * Sku创建日期，时间格式：yyyy-MM-dd HH:mm:ss
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * Sku最后修改日期，时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date modified;
	/**
	 * Sku最后修改日期，时间格式：yyyy-MM-dd HH:mm:ss
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String modifiedFormat;
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outerId) {
		outer_id = outerId;
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
	public Integer getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(Integer numIid) {
		num_iid = numIid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProperties_name() {
		return properties_name;
	}
	public void setProperties_name(String propertiesName) {
		properties_name = propertiesName;
	}
	public String getProperties_name_json() {
		return properties_name_json;
	}
	public void setProperties_name_json(String propertiesNameJson) {
		properties_name_json = propertiesNameJson;
	}
	public Integer getWith_hold_quantity() {
		return with_hold_quantity;
	}
	public void setWith_hold_quantity(Integer withHoldQuantity) {
		with_hold_quantity = withHoldQuantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	public String getModifiedFormat() {
		return modifiedFormat;
	}
	public void setModifiedFormat(String modifiedFormat) {
		this.modifiedFormat = modifiedFormat;
	}
	
}
