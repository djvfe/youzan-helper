package jerry.kdt.config;

import jodd.util.StringUtil;

public enum Sex {
	MALE("m","男"),
	FAMALE ("f","女"),
	;
	private Sex() {}
	private Sex(String name,String desc) {
		this.name = name;
	}
	/**
	 * 根据name取得枚举对象
	 * 该方法正常运行的前提：每个枚举的定义值必须和构造方法中的name的值一样
	 * @param name
	 * @return
	 */
	public static Sex getByName(String name) {
		if(StringUtil.isEmpty(name)) return null;
		return Sex.valueOf(name);
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
