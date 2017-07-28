package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 交易状态(用于查询参数)
 * @author dj
 *
 */
public enum TradeStatusForQuery {
	TRADE_NO_CREATE_PAY("TRADE_NO_CREATE_PAY","没有创建支付交易"),
	WAIT_BUYER_PAY("WAIT_BUYER_PAY","等待买家付款"),
	WAIT_SELLER_SEND_GOODS("WAIT_SELLER_SEND_GOODS","等待卖家发货，即：买家已付款"),
	WAIT_BUYER_CONFIRM_GOODS ("WAIT_BUYER_CONFIRM_GOODS","等待买家确认收货，即：卖家已发货"),
	TRADE_BUYER_SIGNED("TRADE_BUYER_SIGNED","买家已签收"),
	TRADE_CLOSED("TRADE_CLOSED","付款以后用户退款成功，交易自动关闭"),
	ALL_WAIT_PAY("ALL_WAIT_PAY","包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY"),
	ALL_CLOSED("ALL_CLOSED","所有关闭订单")
	;
	private TradeStatusForQuery() {}
	private TradeStatusForQuery(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static TradeStatusForQuery getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return TradeStatusForQuery.valueOf(name);
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
