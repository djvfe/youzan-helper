package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 交易类型
 * @author dj
 *
 */
public enum TradeType {
	FIXED("FIXED","一口价"),
	GIFT ("GIFT","送礼"),
	BULK_PURCHASE("BULK_PURCHASE","来自分销商的采购"),
	COD("COD","赠品领取"),
	PRESENT ("PRESENT","货到付款"),
	QRCODE("QRCODE","扫码商家二维码直接支付的交易")
	;
	private TradeType() {}
	private TradeType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static TradeType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return TradeType.valueOf(name);
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
