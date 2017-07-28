package jerry.kdt.config;

import jodd.util.StringUtil;

/**
 * 优惠的类型
 * @author dj
 *
 */
public enum PromotionType {
	FULLREDUCE("FULLREDUCE","满减满送"),
	
	
	MEMBER_CARD_DISCOUNT("MEMBER_CARD_DISCOUNT","会员卡折扣"),
	SCAN_DISCOUNT("SCAN_DISCOUNT","扫码折扣"),
	SCAN_DECREASE("SCAN_DECREASE","扫码减额优惠")
	;
	private PromotionType() {}
	private PromotionType(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * @param name
	 * @return
	 */
	public static PromotionType getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		for(PromotionType type : PromotionType.values()) {
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
