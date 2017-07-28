package jerry.kdt.result;

import java.util.List;

/**
 * 商品分类数据结构
 * @author dj
 *
 */
public class GoodsCategory {
	/**
	 * 商品分类的ID
	 */
	private Integer cid;
	/**
	 * 父分类ID，等于0时，代表的是一级的分类
	 */
	private Integer parent_cid;
	/**
	 * 商品分类的名称
	 */
	private String name;
	/**
	 * 该分类是否为父分类(即：该分类是否还有子分类)
	 */
	private Boolean is_parent;
	/**
	 * 子分类列表。如果is_parent为false，则该字段为空
	 */
	private List<GoodsCategory> sub_categories;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getParent_cid() {
		return parent_cid;
	}
	public void setParent_cid(Integer parentCid) {
		parent_cid = parentCid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIs_parent() {
		return is_parent;
	}
	public void setIs_parent(Boolean isParent) {
		is_parent = isParent;
	}
	public List<GoodsCategory> getSub_categories() {
		return sub_categories;
	}
	public void setSub_categories(List<GoodsCategory> subCategories) {
		sub_categories = subCategories;
	}
	
}
