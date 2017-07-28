package jerry.kdt.config;
/**
 * 商品类型
 * @author dj
 *
 */
public enum ItemType {
	GENERAL(0,"普通商品"),
	DISTRIBUTION(10,"分销商品")
	;
	private ItemType() {}
	private ItemType(Integer typeId,String desc) {
		this.typeId = typeId;
	}
	/**
	 * 根据typeId取得枚举对象
	 * @param typeId
	 * @return
	 */
	public static ItemType getByTypeId(Integer typeId) {
		if(typeId==null) return null;
		for(ItemType type : ItemType.values()) {
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
