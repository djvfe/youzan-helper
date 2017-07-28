package jerry.kdt.result;

import java.util.Date;

import jerry.kdt.config.CouponType;

/**
 * 订单中使用到的卡券的数据结构
 * @author dj
 *
 */
public class UmpTradeCoupon {
	/**
	 * 该组卡券的ID
	 */
	private Integer coupon_id;
	/**
	 * 该组卡券的名称
	 */
	private String coupon_name;
	/**
	 * 卡券的类型。可选值：PROMOCARD（优惠券）、PROMOCODE（优惠码）
	 */
	private CouponType coupon_type;
	/**
	 * 卡券内容。当卡券类型为优惠码时，值为优惠码字符串
	 */
	private String coupon_content;
	/**
	 * 卡券的说明
	 */
	private String coupon_description;
	/**
	 * 卡券使用条件说明
	 */
	private String coupon_condition;
	/**
	 * 使用时间
	 */
	private Date used_at;
	/**
	 * 使用时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String used_atFormat;
	/**
	 * 优惠的金额，单位：元，精确到小数点后两位
	 */
	private Double discount_fee;
	public Integer getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Integer couponId) {
		coupon_id = couponId;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String couponName) {
		coupon_name = couponName;
	}
	public CouponType getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(CouponType couponType) {
		coupon_type = couponType;
	}
	public String getCoupon_content() {
		return coupon_content;
	}
	public void setCoupon_content(String couponContent) {
		coupon_content = couponContent;
	}
	public String getCoupon_description() {
		return coupon_description;
	}
	public void setCoupon_description(String couponDescription) {
		coupon_description = couponDescription;
	}
	public String getCoupon_condition() {
		return coupon_condition;
	}
	public void setCoupon_condition(String couponCondition) {
		coupon_condition = couponCondition;
	}
	public Date getUsed_at() {
		return used_at;
	}
	public void setUsed_at(Date usedAt) {
		used_at = usedAt;
	}
	public Double getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(Double discountFee) {
		discount_fee = discountFee;
	}
	public String getUsed_atFormat() {
		return used_atFormat;
	}
	public void setUsed_atFormat(String usedAtFormat) {
		used_atFormat = usedAtFormat;
	}
	
}
