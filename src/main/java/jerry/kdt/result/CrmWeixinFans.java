package jerry.kdt.result;

import java.util.Date;
import java.util.List;

import jerry.kdt.config.Sex;

/**
 * 微信粉丝用户数据结构
 * @author dj
 *
 */
public class CrmWeixinFans {
	/**
	 * 微信粉丝用户ID
	 */
	private Integer user_id;
	/**
	 * 微信粉丝用户的openid，可用于微信Api
	 */
	private String weixin_openid;
	/**
	 * 微信粉丝用户的昵称
	 */
	private String nick;
	/**
	 * 微信粉丝用户的头像Url
	 */
	private String avatar;
	/**
	 * 关注时间
	 */
	private Date follow_time;
	/**
	 * 性别。可选值：m(男)，f(女)。未知则为空
	 */
	private Sex sex;
	/**
	 * 所在省份
	 */
	private String province;
	/**
	 * 所在城市
	 */
	private String city;
	/**
	 * 当前积分
	 */
	private Integer points;
	/**
	 * 成交订单笔数
	 */
	private Integer traded_num;
	/**
	 * 成交订单总额。单位：元
	 */
	private Double traded_money;
	/**
	 * 粉丝标签列表
	 */
	private List<CrmUserTag> tags;
	/**
	 * 粉丝会员等级信息
	 */
	private String level_info;
	/**
	 * 公众号绑定到微信开放平台帐号后，粉丝的唯一ID
	 */
	private String union_id;
	/**
	 * 是否关注
	 */
	private boolean is_follow;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	public String getWeixin_openid() {
		return weixin_openid;
	}
	public void setWeixin_openid(String weixinOpenid) {
		weixin_openid = weixinOpenid;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getFollow_time() {
		return follow_time;
	}
	public void setFollow_time(Date followTime) {
		follow_time = followTime;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getTraded_num() {
		return traded_num;
	}
	public void setTraded_num(Integer tradedNum) {
		traded_num = tradedNum;
	}
	public Double getTraded_money() {
		return traded_money;
	}
	public void setTraded_money(Double tradedMoney) {
		traded_money = tradedMoney;
	}
	public List<CrmUserTag> getTags() {
		return tags;
	}
	public void setTags(List<CrmUserTag> tags) {
		this.tags = tags;
	}
	public String getLevel_info() {
		return level_info;
	}
	public void setLevel_info(String levelInfo) {
		level_info = levelInfo;
	}
	public String getUnion_id() {
		return union_id;
	}
	public void setUnion_id(String unionId) {
		union_id = unionId;
	}
	public boolean isIs_follow() {
		return is_follow;
	}
	public void setIs_follow(boolean isFollow) {
		is_follow = isFollow;
	}
	
}
