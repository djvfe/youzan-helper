package jerry.kdt.config;

public enum ItemsGetOrderBy {
	/**创建时间，升序*/
	CREATED_ASC("created:asc"),
	/**修改时间，升序*/
	CREATED_DESC("created:desc"),
	/**创建时间，降序*/
	MODIFIED_ASC("modified:asc"),
	/**修改时间，降序*/
	MODIFIED_DESC("modified:desc")
	;
	private ItemsGetOrderBy() {}
	private ItemsGetOrderBy(String name) {
		this.name = name;
	}
	private String name;
	public String getName() {
		return name;
	}
}
