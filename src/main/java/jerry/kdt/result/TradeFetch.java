package jerry.kdt.result;

import java.util.Date;
/**
 * 到店自提详情
 * @author dj
 *
 */
public class TradeFetch {
	/**
	 * 领取人（即：预约人）的姓名
	 */
	private String fetcher_name;
	/**
	 * 领取人的手机号
	 */
	private String fetcher_mobile;
	/**
	 * 预约的领取时间
	 */
	private Date fetch_time;
	/**
	 * 预约的领取时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String fetch_timeFormat;
	/**
	 * 自提点名称
	 */
	private String shop_name;
	/**
	 * 自提点联系方式
	 */
	private String shop_mobile;
	/**
	 * 自提点所在省份
	 */
	private String shop_state;
	/**
	 * 自提点所在城市
	 */
	private String shop_city;
	/**
	 * 自提点所在地区
	 */
	private String shop_district;
	/**
	 * 自提点详细地址
	 */
	private String shop_address;
	public String getFetcher_name() {
		return fetcher_name;
	}
	public void setFetcher_name(String fetcherName) {
		fetcher_name = fetcherName;
	}
	public String getFetcher_mobile() {
		return fetcher_mobile;
	}
	public void setFetcher_mobile(String fetcherMobile) {
		fetcher_mobile = fetcherMobile;
	}
	public Date getFetch_time() {
		return fetch_time;
	}
	public void setFetch_time(Date fetchTime) {
		fetch_time = fetchTime;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shopName) {
		shop_name = shopName;
	}
	public String getShop_mobile() {
		return shop_mobile;
	}
	public void setShop_mobile(String shopMobile) {
		shop_mobile = shopMobile;
	}
	public String getShop_state() {
		return shop_state;
	}
	public void setShop_state(String shopState) {
		shop_state = shopState;
	}
	public String getShop_city() {
		return shop_city;
	}
	public void setShop_city(String shopCity) {
		shop_city = shopCity;
	}
	public String getShop_district() {
		return shop_district;
	}
	public void setShop_district(String shopDistrict) {
		shop_district = shopDistrict;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shopAddress) {
		shop_address = shopAddress;
	}
	public String getFetch_timeFormat() {
		return fetch_timeFormat;
	}
	public void setFetch_timeFormat(String fetchTimeFormat) {
		fetch_timeFormat = fetchTimeFormat;
	}
	
}
