package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 卡券的类型
 * @author dj
 *
 */
public enum CouponType {
	PROMOCARD("PROMOCARD","优惠券"),
	PROMOCODE("PROMOCODE","优惠码")
	;
	private CouponType() {}
	private CouponType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * @param name
	 * @return
	 */
	public static CouponType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		for(CouponType type : CouponType.values()) {
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
