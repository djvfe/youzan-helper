package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 创建交易时的物流方式
 * @author dj
 *
 */
public enum TradeShippingType {
	EXPRESS("express","快递"),
	FETCH("fetch","到店自提")
	;
	private TradeShippingType() {}
	private TradeShippingType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * @param name
	 * @return
	 */
	public static TradeShippingType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		for(TradeShippingType type : TradeShippingType.values()) {
			if(type.getName().equals(name)) return type;
		}
		return null;
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
