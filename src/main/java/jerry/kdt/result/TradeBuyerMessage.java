package jerry.kdt.result;
/**
 * 交易明细中买家留言的数据结构
 * @author dj
 *
 */
public class TradeBuyerMessage {
	/**
	 * 留言的标题
	 */
	private String title;
	/**
	 * 留言的内容
	 */
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
