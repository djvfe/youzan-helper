package jerry.kdt.config;

public enum RegionGetLevel {
	ALL_REGION(0,"获取所有区域列表"),
	PROVICE(1,"获取省份列表"),
	CITY(2,"获取城市列表"),
	DISTRICT(3,"获取县区列表"),
	ASSIGN_AND_PARENT(4,"获取指定ID区域及其上级区域信息")
	;
	private RegionGetLevel() {}
	private RegionGetLevel(Integer id,String desc) {
		this.id = id;
	}
	/**
	 * 根据typeId取得枚举对象
	 * @param typeId
	 * @return
	 */
	public static RegionGetLevel getByTypeId(Integer id) {
		if(id==null) return null;
		for(RegionGetLevel R : RegionGetLevel.values()) {
			if(R.getId()==id) return R;
		}
		return null;
	}
	private Integer id;
	private String desc;
	public Integer getId() {
		return id;
	}
	public String getDesc() {
		return desc;
	}
}
