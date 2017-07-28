package jerry.kdt.result;

import java.util.Date;
/**
 * 商品标签数据结构
 * @author dj
 *
 */
public class GoodsTag {
	/**
	 * 商品标签的ID
	 */
	private Integer id;
	/**
	 * 商品标签的名称
	 */
	private String name;
	/**
	 * 商品标签类型，0 自定义，1 未分类，2 最新，3 最热，4 隐藏
	 */
	private Integer type;
	/**
	 * 商品标签创建时间
	 */
	private Date created;
	/**
	 * 商品标签创建时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * 商品标签内的商品数量
	 */
	private Integer item_num;
	/**
	 * 商品标签的展示的URL地址
	 */
	private String tag_url;
	/**
	 * 分享出去的商品标签展示地址
	 */
	private String share_url;
	/**
	 * 商品标签描述
	 */
	private String desc;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Integer getItem_num() {
		return item_num;
	}
	public void setItem_num(Integer itemNum) {
		item_num = itemNum;
	}
	public String getTag_url() {
		return tag_url;
	}
	public void setTag_url(String tagUrl) {
		tag_url = tagUrl;
	}
	public String getShare_url() {
		return share_url;
	}
	public void setShare_url(String shareUrl) {
		share_url = shareUrl;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	
}
