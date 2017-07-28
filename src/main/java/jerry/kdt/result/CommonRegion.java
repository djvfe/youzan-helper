package jerry.kdt.result;
/**
 * 区域数据结构
 * @author dj
 *
 */
public class CommonRegion {
	/**
	 * 区域ID
	 */
	private Integer id;
	/**
	 * 区域全称
	 */
	private String name;
	/**
	 * 上级区域ID
	 */
	private Integer parent_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parentId) {
		parent_id = parentId;
	}
	
}
