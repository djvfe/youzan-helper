package jerry.kdt.result;

import java.util.Date;

import jerry.kdt.config.PromotionType;

/**
 * 订单中使用到的优惠活动的数据结构
 * @author dj
 *
 */
public class TradePromotion {
	/**
	 * 该优惠活动的ID
	 */
	private Integer promotion_id;
	/**
	 * 该优惠活动的名称
	 */
	private String promotion_name;
	/**
	 * 优惠的类型。可选值：FULLREDUCE（满减满送）
	 */
	private PromotionType promotion_type;
	/**
	 * 优惠使用条件说明
	 */
	private String promotion_condition;
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
	public Integer getPromotion_id() {
		return promotion_id;
	}
	public void setPromotion_id(Integer promotionId) {
		promotion_id = promotionId;
	}
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
	public String getPromotion_condition() {
		return promotion_condition;
	}
	public void setPromotion_condition(String promotionCondition) {
		promotion_condition = promotionCondition;
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
