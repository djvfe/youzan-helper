package jerry.kdt.config;
/**
 * 商品列表分类字段。
 * @author dj
 *
 */
public enum ItemsInventoryBanner {
	/**
	 * 已下架的
	 */
	FOR_SHELVED("for_shelved"),
	/**
	 * 已售罄的
	 */
	SOLD_OUT("sold_out")
	;
	private ItemsInventoryBanner() {}
	private ItemsInventoryBanner(String name) {
		this.name = name;
	}
	private String name;
	public String getName() {
		return name;
	}
}
