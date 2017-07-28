package jerry.kdt.requirement;
/**
 * kdt.item.sku.update 更新SKU信息请求参数
 * @author dj
 *
 */
public class ItemSkuUpdateRequirement {
	/**
	 * 必须
	 * 商品数字编号
	 */
	private Integer num_iid;
	/**
	 * 必须
	 * Sku数字ID
	 */
	private Integer sku_id;
	/**
	 * Sku的库存数量
	 */
	private Integer quantity;
	/**
	 * Sku的销售价格。精确到2位小数；单位：元
	 */
	private Double price;
	/**
	 * 商家编码（商家为Sku设置的外部编号）
	 */
	private String outer_id;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outerId) {
		outer_id = outerId;
	}
	
}
