package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 退款状态
 * @author dj
 *
 */
public enum TradeRefundState {
	NO_REFUND("NO_REFUND","无退款"),
	PARTIAL_REFUNDING ("PARTIAL_REFUNDING","部分退款中"),
	PARTIAL_REFUNDED("PARTIAL_REFUNDED","已部分退款"),
	PARTIAL_REFUND_FAILED("PARTIAL_REFUND_FAILED","部分退款失败"),
	FULL_REFUNDING ("FULL_REFUNDING","全额退款中"),
	FULL_REFUNDED ("FULL_REFUNDED","已全额退款"),
	FULL_REFUND_FAILED("FULL_REFUND_FAILED","全额退款失败")
	;
	private TradeRefundState() {}
	private TradeRefundState(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static TradeRefundState getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return TradeRefundState.valueOf(name);
	}
	private String name;
	private String desc;
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
}
