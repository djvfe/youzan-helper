package jerry.kdt.requirement;

import java.util.Map;
/**
 * kdt.item.sku.add 新增一个商品sku请求参数中的sku参数
 * @author dj
 *
 */
public class ItemAddSkuRequirement {
	/**
	 * Sku的价格
	 */
	private Double sku_price;
	/**
	 * Sku的属性 键值对
	 */
	private Map<String,String> sku_property;
	/**
	 * Sku的数量
	 */
	private Integer sku_quantity;
	/**
	 * Sku的商家编码
	 */
	private String sku_outer_id;
	public Double getSku_price() {
		return sku_price;
	}
	public void setSku_price(Double skuPrice) {
		sku_price = skuPrice;
	}
	public Map<String, String> getSku_property() {
		return sku_property;
	}
	public void setSku_property(Map<String, String> skuProperty) {
		sku_property = skuProperty;
	}
	public Integer getSku_quantity() {
		return sku_quantity;
	}
	public void setSku_quantity(Integer skuQuantity) {
		sku_quantity = skuQuantity;
	}
	public String getSku_outer_id() {
		return sku_outer_id;
	}
	public void setSku_outer_id(String skuOuterId) {
		sku_outer_id = skuOuterId;
	}
	
}
