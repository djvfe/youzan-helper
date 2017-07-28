package jerry.kdt.result;

import java.util.Date;

import jerry.kdt.config.PromotionType;
/**
 * 交易明细中的优惠信息的数据结构
 * @author dj
 *
 */
public class TradeOrderPromotion {
	/**
	 * 优惠的名称
	 */
	private String promotion_name;
	/**
	 * 优惠的类型。可选值：
	 * MEMBER_CARD_DISCOUNT（会员卡折扣） 
	 * SCAN_DISCOUNT（扫码折扣） 
	 * SCAN_DECREASE（扫码减额优惠）
	 */
	private PromotionType promotion_type;
	/**
	 * 应用优惠的时间
	 */
	private Date apply_at;
	/**
	 * 应用优惠的时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String apply_atFormat;
	/**
	 * 优惠的金额，单位：元，精确到小数点后两位
	 */
	private Double discount_fee;
	public String getPromotion_name() {
		return promotion_name;
	}
	public void setPromotion_name(String promotionName) {
		promotion_name = promotionName;
	}
	public PromotionType getPromotion_type() {
		return promotion_type;
	}
	public void setPromotion_type(PromotionType promotionType) {
		promotion_type = promotionType;
	}
	public Date getApply_at() {
		return apply_at;
	}
	public void setApply_at(Date applyAt) {
		apply_at = applyAt;
	}
	public Double getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(Double discountFee) {
		discount_fee = discountFee;
	}
	public String getApply_atFormat() {
		return apply_atFormat;
	}
	public void setApply_atFormat(String applyAtFormat) {
		apply_atFormat = applyAtFormat;
	}
	
}
