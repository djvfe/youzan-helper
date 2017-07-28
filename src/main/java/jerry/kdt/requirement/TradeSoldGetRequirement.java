package jerry.kdt.requirement;

import java.util.Date;

import jerry.kdt.config.TradeStatusForQuery;

/**
 * 查询卖家已卖出的交易列表 参数
 * @author dj
 *
 */
public class TradeSoldGetRequirement {
	/**
	 * 需要返回的交易对象字段，如tid,title,receiver_city等。
	 * 可选值：TradeDetail交易结构体中所有字段均可返回；多个字段用“,”分隔。如果为空则返回所有
	 */
	private String fields;
	/**
	 * 交易状态，默认查询所有交易状态的数据，除了默认值外每次只能查询一种状态。
	 * 可选值：
	 * TRADE_NO_CREATE_PAY（没有创建支付交易）
	 * WAIT_BUYER_PAY（等待买家付款）
	 * WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）
	 * WAIT_BUYER_CONFIRM_GOODS（等待买家确认收货，即：卖家已发货）
	 * TRADE_BUYER_SIGNED（买家已签收）
	 * TRADE_CLOSED（付款以后用户退款成功，交易自动关闭）
	 * ALL_WAIT_PAY（包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY）
	 * ALL_CLOSED（所有关闭订单）
	 */
	private TradeStatusForQuery status;
	/**
	 * 交易创建开始时间。查询在该时间之后（包含该时间）创建的交易，为空则不限制
	 */
	private Date start_created;
	/**
	 * 交易创建结束时间。查询在该时间之前创建的交易，为空则不限制
	 */
	private Date end_created;
	/**
	 * 交易状态更新的开始时间。查询在该时间之后（包含该时间）交易状态更新过的交易，为空则不限制
	 */
	private Date start_update;
	/**
	 * 交易状态更新的结束时间。查询在该时间之前交易状态更新过的交易，为空则不限制
	 */
	private Date end_update;
	/**
	 * 微信粉丝ID
	 */
	private Integer weixin_user_id;
	/**
	 * 买家昵称
	 */
	private String buyer_nick;
	/**
	 * 页码。取值范围：大于零的整数；默认值：1
	 */
	private Integer page_no;
	/**
	 * 每页条数。取值范围：大于零的整数；默认值：40；最大值：100
	 */
	private Integer page_size;
	/**
	 * 是否启用has_next的分页方式，是的话返回的结果中不包含总记录数，但是会新增一个是否存在下一页的的字段
	 */
	private Boolean use_has_next;
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	public TradeStatusForQuery getStatus() {
		return status;
	}
	public void setStatus(TradeStatusForQuery status) {
		this.status = status;
	}
	public Date getStart_created() {
		return start_created;
	}
	public void setStart_created(Date startCreated) {
		start_created = startCreated;
	}
	public Date getEnd_created() {
		return end_created;
	}
	public void setEnd_created(Date endCreated) {
		end_created = endCreated;
	}
	public Date getStart_update() {
		return start_update;
	}
	public void setStart_update(Date startUpdate) {
		start_update = startUpdate;
	}
	public Date getEnd_update() {
		return end_update;
	}
	public void setEnd_update(Date endUpdate) {
		end_update = endUpdate;
	}
	public Integer getWeixin_user_id() {
		return weixin_user_id;
	}
	public void setWeixin_user_id(Integer weixinUserId) {
		weixin_user_id = weixinUserId;
	}
	public String getBuyer_nick() {
		return buyer_nick;
	}
	public void setBuyer_nick(String buyerNick) {
		buyer_nick = buyerNick;
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
	public Boolean getUse_has_next() {
		return use_has_next;
	}
	public void setUse_has_next(Boolean useHasNext) {
		use_has_next = useHasNext;
	}
	
}
