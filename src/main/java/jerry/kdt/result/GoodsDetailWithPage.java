package jerry.kdt.result;

import java.util.List;

/**
 * 商品列表，含总数
 * @author dj
 *
 */
public class GoodsDetailWithPage {
	/**
	 * 商品列表
	 */
	private List<GoodsDetail> items;
	/**
	 * 搜索到符合条件的结果总数
	 * total_results很可能不是items的长度（items可能是分页查询后的单页结果）
	 */
	private Integer total_results;
	/**
	 * 当前页数
	 */
	private Integer page_no;
	/**
	 * 每页显示数
	 * page_size不一定等于items的长度（当为末页时）
	 */
	private Integer page_size;
	public List<GoodsDetail> getItems() {
		return items;
	}
	public void setItems(List<GoodsDetail> items) {
		this.items = items;
	}
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer totalResults) {
		total_results = totalResults;
	}
	public Integer getPage_no() {
		return page_no;
	}
	public void setPage_no(Integer pageNo) {
		page_no = pageNo;
	}
	public Integer getPage_size() {
		return page_size;
	}
	public void setPage_size(Integer pageSize) {
		page_size = pageSize;
	}
}
