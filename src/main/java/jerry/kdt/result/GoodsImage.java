package jerry.kdt.result;

import java.util.Date;

/**
 * 商品图片数据结构
 * @author dj
 *
 */
public class GoodsImage {
	/**
	 * 商品图片的ID
	 */
	private Integer id;
	/**
	 * 图片创建时间，时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;
	/**
	 * 图片创建时间，时间格式：yyyy-MM-dd HH:mm:ss
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * 图片链接地址
	 */
	private String url;
	/**
	 * 图片缩略图链接地址
	 */
	private String thumbnail;
	/**
	 * 中号大小图片链接地址
	 */
	private String medium;
	/**
	 * 组合图片链接地址
	 */
	private String combine;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getCombine() {
		return combine;
	}
	public void setCombine(String combine) {
		this.combine = combine;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	
}
