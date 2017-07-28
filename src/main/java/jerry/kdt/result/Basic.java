package jerry.kdt.result;
/**
 * 店铺基本信息
 * @author dj
 *
 */
public class Basic {
	/**
	 * 店铺ID
	 */
	private Integer sid;
	/**
	 * 店铺名称
	 */
	private String name;
	/**
	 * 店铺LOGO
	 */
	private String logo;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
