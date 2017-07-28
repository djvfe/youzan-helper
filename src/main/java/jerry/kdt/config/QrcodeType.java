package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 商品二维码类型
 * @author dj
 *
 */
public enum QrcodeType {
	GOODS_SCAN_FOLLOW("GOODS_SCAN_FOLLOW","扫码关注后购买商品"),
	GOODS_SCAN_FOLLOW_DECREASE("GOODS_SCAN_FOLLOW_DECREASE","扫码关注后减优惠额"),
	GOODS_SCAN_FOLLOW_DISCOUNT("GOODS_SCAN_FOLLOW_DISCOUNT","扫码关注后折扣"),
	GOODS_SCAN_DECREASE("GOODS_SCAN_DECREASE","扫码直接减优惠额"),
	GOODS_SCAN_DISCOUNT("GOODS_SCAN_DISCOUNT","扫码直接折扣")
	;
	private QrcodeType() {}
	private QrcodeType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static QrcodeType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return QrcodeType.valueOf(name);
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
