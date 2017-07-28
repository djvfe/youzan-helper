package jerry.kdt.result;

import java.util.List;

/**
 * 交易数据结构分页结果
 * @author dj
 *
 */
public class TradeDetailWithPage {
	/**
	 * 交易列表
	 */
	private List<TradeDetail> trades;
	/**
	 * 搜索到符合条件的结果总数
	 * total_results很可能不是items的长度（trades可能是分页查询后的单页结果）
	 */
	private Integer total_results;
	/**
	 * 是否存在下一页
	 */
	private Boolean has_next;
	/**
	 * 当前页数
	 */
	private Integer page_no;
	/**
	 * 每页显示数
	 * page_size不一定等于trades的长度（当为末页时）
	 */
	private Integer page_size;
	public List<TradeDetail> getTrades() {
		return trades;
	}
	public void setTrades(List<TradeDetail> trades) {
		this.trades = trades;
	}
	public Integer getTotal_results() {
		return total_results;
	}
	public void setTotal_results(Integer totalResults) {
		total_results = totalResults;
	}
	public Boolean getHas_next() {
		return has_next;
	}
	public void setHas_next(Boolean hasNext) {
		has_next = hasNext;
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
