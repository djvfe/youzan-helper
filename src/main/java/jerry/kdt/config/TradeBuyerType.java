package jerry.kdt.config;

public enum TradeBuyerType {
	UNKOWN(0,"未知"),
	WEIXIN(1,"微信粉丝"),
	WEIBO(2,"微博粉丝"),
	;
	private TradeBuyerType() {}
	private TradeBuyerType(Integer typeId,String desc) {
		this.typeId = typeId;
	}
	/**
	 * 根据typeId取得枚举对象
	 * @param typeId
	 * @return
	 */
	public static TradeBuyerType getByTypeId(Integer typeId) {
		if(typeId==null) return null;
		for(TradeBuyerType type : TradeBuyerType.values()) {
			if(type.getTypeId()==typeId) return type;
		}
		return null;
	}
	private Integer typeId;
	private String desc;
	public Integer getTypeId() {
		return typeId;
	}
	public String getDesc() {
		return desc;
	}
}
