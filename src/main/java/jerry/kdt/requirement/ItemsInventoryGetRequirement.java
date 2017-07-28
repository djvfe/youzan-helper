package jerry.kdt.requirement;

import jerry.kdt.config.ItemsGetOrderBy;
import jerry.kdt.config.ItemsInventoryBanner;

/**
 * kdt.items.inventory.get	获取仓库中的商品列表请求参数
 * @author dj
 *
 */
public class ItemsInventoryGetRequirement {
	/**
	 * 需要返回的商品对象字段，如title,price,desc等。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 */
	private String fields;
	/**
	 * 搜索字段。搜索商品的title
	 */
	private String q;
	/**
	 * 分类字段。可选值：for_shelved（已下架的）/ sold_out（已售罄的）
	 * 默认for_shelved
	 */
	private ItemsInventoryBanner banner;
	/**
	 * 商品标签的ID
	 */
	private Integer tag_id;
	/**
	 * 页码	默认1
	 */
	private Integer page_no;
	/**
	 * 每页条数	默认40
	 */
	private Integer page_size;
	/**
	 * 排序方式。格式为column:asc/desc，column可选值：created 创建时间 / modified 修改时间
	 * 默认值 created:desc
	 */
	private ItemsGetOrderBy order_by;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public ItemsInventoryBanner getBanner() {
		return banner;
	}
	public void setBanner(ItemsInventoryBanner banner) {
		this.banner = banner;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tagId) {
		tag_id = tagId;
	}
	public Integer getPage_no() {
		return page_no;
	}
	public void setPage_no(Integer pageNo) {
		page_no = pageNo;
	}
	public Integer getPage_size() {
		return page_size;
	}
	public void setPage_size(Integer pageSize) {
		page_size = pageSize;
	}
	public ItemsGetOrderBy getOrder_by() {
		return order_by;
	}
	public void setOrder_by(ItemsGetOrderBy orderBy) {
		order_by = orderBy;
	}
	
}
