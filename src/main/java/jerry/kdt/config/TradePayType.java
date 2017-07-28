package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 支付类型
 * @author dj
 *
 */
public enum TradePayType {
	WEIXIN("WEIXIN","微信支付"),
	WEIXIN_DAIXIAO ("WEIXIN_DAIXIAO","微信代销支付"),
	ALIPAY("ALIPAY","支付宝支付"),
	BANKCARDPAY("BANKCARDPAY","银行卡支付"),
	PEERPAY("PEERPAY","代付"),
	CODPAY ("CODPAY","货到付款"),
	BAIDUPAY("BAIDUPAY","百度钱包支付"),
	PRESENTTAKE("PRESENTTAKE","直接领取赠品"),
	COUPONPAY("COUPONPAY","优惠券/码全额抵扣"),
	BULKPURCHASE("BULKPURCHASE","来自分销商的采购"),
	MERGEDPAY("MERGEDPAY","合并付货款"),
	ECARD("ECARD","有赞E卡支付")
	;
	private TradePayType() {}
	private TradePayType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static TradePayType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return TradePayType.valueOf(name);
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
