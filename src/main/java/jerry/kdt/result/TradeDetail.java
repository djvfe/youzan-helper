package jerry.kdt.result;

import java.util.Date;
import java.util.List;

import jerry.kdt.config.TradeBuyerType;
import jerry.kdt.config.TradeFeedback;
import jerry.kdt.config.TradePayType;
import jerry.kdt.config.TradeRefundState;
import jerry.kdt.config.TradeShippingType;
import jerry.kdt.config.TradeStatus;
import jerry.kdt.config.TradeType;

/**
 * 交易数据结构
 * @author dj
 *
 */
public class TradeDetail {
	/**
	 * 交易编号
	 */
	private String tid;
	/**
	 * 商品购买数量。当一个trade对应多个order的时候，值为所有商品购买数量之和
	 */
	private Integer num;
	/**
	 * 商品数字编号。当一个trade对应多个order的时候，值为第一个交易明细中的商品的编号
	 */
	private Integer num_iid;
	/**
	 * 商品价格。精确到2位小数；单位：元。当一个trade对应多个order的时候，值为第一个交易明细中的商品的价格
	 */
	private Double price;
	/**
	 * 商品主图片地址。当一个trade对应多个order的时候，值为第一个交易明细中的商品的图片地址
	 */
	private String pic_path;
	/**
	 * 商品主图片缩略图地址
	 */
	private String pic_thumb_path;
	/**
	 * 交易标题，以首个商品标题作为此标题的值
	 */
	private String title;
	/**
	 * 交易类型。取值范围：
	 * FIXED （一口价）
	 * GIFT （送礼）
	 * BULK_PURCHASE（来自分销商的采购）
	 * PRESENT （赠品领取）
	 * COD （货到付款）
	 * QRCODE（扫码商家二维码直接支付的交易）
	 */
	private TradeType type;
	/**
	 * 微信粉丝ID
	 */
	private Integer weixin_user_id;
	/**
	 * 买家类型，取值范围：0 为未知，1 为微信粉丝，2 为微博粉丝
	 */
	private TradeBuyerType buyer_type;
	/**
	 * 买家ID，当 buyer_type 为 1 时，buyer_id 的值等于 weixin_user_id 的值
	 */
	private Integer buyer_id;
	/**
	 * 买家昵称
	 */
	private String buyer_nick;
	/**
	 * 买家购买附言
	 */
	private String buyer_message;
	/**
	 * 卖家备注星标，取值范围 1、2、3、4、5；如果为0，表示没有备注星标
	 */
	private Integer seller_flag;
	/**
	 * 卖家对该交易的备注
	 */
	private String trade_memo;
	/**
	 * 收货人的所在城市。
	 * PS：如果订单类型是送礼订单，收货地址在sub_trades字段中；如果物流方式是到店自提，收货地址在fetch_detail字段中
	 */
	private String receiver_city;
	/**
	 * 收货人的所在地区
	 */
	private String receiver_district;
	/**
	 * 收货人的姓名
	 */
	private String receiver_name;
	/**
	 * 收货人的所在省份
	 */
	private String receiver_state;
	/**
	 * 收货人的详细地址
	 */
	private String receiver_address;
	/**
	 * 收货人的邮编
	 */
	private String receiver_zip;
	/**
	 * 收货人的手机号码
	 */
	private String receiver_mobile;
	/**
	 * 交易维权状态。
	 * 0 无维权，1 顾客发起维权，2 顾客拒绝商家的处理结果，3 顾客接受商家的处理结果，9 商家正在处理，
	 *  101 等待卖家同意退款申请，102 等待卖家同意退款申请（维权失败过），103 卖家不同意退款申请，
	 *  104 已经申请有赞客满介入， 105 卖家已同意退款，106 已退货，等待卖家确认收货，107 维权已经关闭，110 退款成功。
	 * 备注：1到10的状态码是微信那边的维权状态码，100以上的状态码是有赞这边的维权状态码
	 */
	private TradeFeedback feedback;
	/**
	 * 退款状态。取值范围：
	 * NO_REFUND（无退款）
	 * PARTIAL_REFUNDING（部分退款中）
	 * PARTIAL_REFUNDED（已部分退款）
	 * PARTIAL_REFUND_FAILED（部分退款失败）
	 * FULL_REFUNDING（全额退款中）
	 * FULL_REFUNDED（已全额退款）
	 * FULL_REFUND_FAILED（全额退款失败）
	 */
	private TradeRefundState refund_state;
	/**
	 * 外部交易编号。比如，如果支付方式是微信支付，就是财付通的交易单号
	 */
	private String outer_tid;
	/**
	 * 交易状态。取值范围：
	 * TRADE_NO_CREATE_PAY (没有创建支付交易) 
	 * WAIT_BUYER_PAY (等待买家付款) 
	 * WAIT_PAY_RETURN(等待支付确认)
	 * WAIT_SELLER_SEND_GOODS (等待卖家发货，即：买家已付款) 
	 * WAIT_BUYER_CONFIRM_GOODS (等待买家确认收货，即：卖家已发货) 
	 * TRADE_BUYER_SIGNED (买家已签收) 
	 * TRADE_CLOSED (付款以后用户退款成功，交易自动关闭) 
	 * TRADE_CLOSED_BY_USER (付款以前，卖家或买家主动关闭交易)
	 */
	private TradeStatus status;
	/**
	 * 创建交易时的物流方式。取值范围：express（快递），fetch（到店自提）
	 */
	private TradeShippingType shipping_type;
	/**
	 * 运费。单位：元，精确到分
	 */
	private Double post_fee;
	/**
	 * 商品总价（商品价格乘以数量的总金额）。单位：元，精确到分
	 */
	private Double total_fee;
	/**
	 * 交易完成后退款的金额。单位：元，精确到分
	 */
	private Double refunded_fee;
	/**
	 * 交易优惠金额（不包含交易明细中的优惠金额）。单位：元，精确到分
	 */
	private Double discount_fee;
	/**
	 * 实付金额。单位：元，精确到分
	 */
	private Double payment;
	/**
	 * 交易创建时间
	 */
	private Date created;
	/**
	 * 交易创建时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * 交易更新时间。当交易的：状态改变、备注更改、星标更改 等情况下都会刷新更新时间
	 */
	private Date update_time;
	/**
	 * 交易更新时间。当交易的：状态改变、备注更改、星标更改 等情况下都会刷新更新时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String update_timeFormat;
	/**
	 * 买家付款时间
	 */
	private Date pay_time;
	/**
	 * 买家付款时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String pay_timeFormat;
	/**
	 * 支付类型。取值范围：
	 * WEIXIN (微信支付)
	 * ALIPAY (支付宝支付)
	 * BANKCARDPAY (银行卡支付)
	 * PEERPAY (代付)
	 * CODPAY (货到付款)
	 * BAIDUPAY (百度钱包支付)
	 * PRESENTTAKE (直接领取赠品)
	 * COUPONPAY（优惠券/码全额抵扣）
	 * BULKPURCHASE（来自分销商的采购）
	 */
	private TradePayType pay_type;
	/**
	 * 卖家发货时间
	 */
	private Date consign_time;
	/**
	 * 卖家发货时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String consign_timeFormat;
	/**
	 * 买家签收时间
	 */
	private Date sign_time;
	/**
	 * 买家签收时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String sign_timeFormat;
	/**
	 * 买家下单的地区
	 */
	private String buyer_area;
	/**
	 * 交易明细列表
	 */
	private List<TradeOrder> orders;
	/**
	 * 如果是到店自提交易，返回自提详情，否则返回空
	 */
	private TradeFetch fetch_detail;
	/**
	 * 在交易中使用到的卡券的详情，包括：优惠券、优惠码
	 */
	private List<UmpTradeCoupon> coupon_details;
	/**
	 * 在交易中使用到优惠活动详情，包括：满减满送
	 */
	private List<TradePromotion> promotion_details;
	/**
	 * 卖家手工调整订单金额。精确到2位小数；单位：元。若卖家减少订单金额10元2分，则这里为10.02；若卖家增加订单金额10元2分，则这里为-10.02
	 * 
	 * 
	 * 20161104  有赞api修改 以下
	 * change:总改价金额
		pay_change:订单改价
		post_change:邮费改价
		数据为0.00代表没有对应的改价。
		卖家手工调整订单金额。精确到2位小数；单位：元。若卖家减少订单金额10元2分，则这里为10.02；若卖家增加订单金额10元2分，则这里为-10.02
	 */
//	private Double adjust_fee;
	private AdjustFee adjust_fee;
	
	/**
	 * 交易中包含的子交易，目前：仅在送礼订单中会有子交易
	 */
	private TradeDetail sub_trades;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(Integer numIid) {
		num_iid = numIid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String picPath) {
		pic_path = picPath;
	}
	public String getPic_thumb_path() {
		return pic_thumb_path;
	}
	public void setPic_thumb_path(String picThumbPath) {
		pic_thumb_path = picThumbPath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public TradeType getType() {
		return type;
	}
	public void setType(TradeType type) {
		this.type = type;
	}
	public Integer getWeixin_user_id() {
		return weixin_user_id;
	}
	public void setWeixin_user_id(Integer weixinUserId) {
		weixin_user_id = weixinUserId;
	}
	public TradeBuyerType getBuyer_type() {
		return buyer_type;
	}
	public void setBuyer_type(TradeBuyerType buyerType) {
		buyer_type = buyerType;
	}
	public Integer getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(Integer buyerId) {
		buyer_id = buyerId;
	}
	public String getBuyer_nick() {
		return buyer_nick;
	}
	public void setBuyer_nick(String buyerNick) {
		buyer_nick = buyerNick;
	}
	public String getBuyer_message() {
		return buyer_message;
	}
	public void setBuyer_message(String buyerMessage) {
		buyer_message = buyerMessage;
	}
	public Integer getSeller_flag() {
		return seller_flag;
	}
	public void setSeller_flag(Integer sellerFlag) {
		seller_flag = sellerFlag;
	}
	public String getTrade_memo() {
		return trade_memo;
	}
	public void setTrade_memo(String tradeMemo) {
		trade_memo = tradeMemo;
	}
	public String getReceiver_city() {
		return receiver_city;
	}
	public void setReceiver_city(String receiverCity) {
		receiver_city = receiverCity;
	}
	public String getReceiver_district() {
		return receiver_district;
	}
	public void setReceiver_district(String receiverDistrict) {
		receiver_district = receiverDistrict;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiverName) {
		receiver_name = receiverName;
	}
	public String getReceiver_state() {
		return receiver_state;
	}
	public void setReceiver_state(String receiverState) {
		receiver_state = receiverState;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiverAddress) {
		receiver_address = receiverAddress;
	}
	public String getReceiver_zip() {
		return receiver_zip;
	}
	public void setReceiver_zip(String receiverZip) {
		receiver_zip = receiverZip;
	}
	public String getReceiver_mobile() {
		return receiver_mobile;
	}
	public void setReceiver_mobile(String receiverMobile) {
		receiver_mobile = receiverMobile;
	}
	public TradeFeedback getFeedback() {
		return feedback;
	}
	public void setFeedback(TradeFeedback feedback) {
		this.feedback = feedback;
	}
	public TradeRefundState getRefund_state() {
		return refund_state;
	}
	public void setRefund_state(TradeRefundState refundState) {
		refund_state = refundState;
	}
	public String getOuter_tid() {
		return outer_tid;
	}
	public void setOuter_tid(String outerTid) {
		outer_tid = outerTid;
	}
	public TradeStatus getStatus() {
		return status;
	}
	public void setStatus(TradeStatus status) {
		this.status = status;
	}
	public TradeShippingType getShipping_type() {
		return shipping_type;
	}
	public void setShipping_type(TradeShippingType shippingType) {
		shipping_type = shippingType;
	}
	public Double getPost_fee() {
		return post_fee;
	}
	public void setPost_fee(Double postFee) {
		post_fee = postFee;
	}
	public Double getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Double totalFee) {
		total_fee = totalFee;
	}
	public Double getRefunded_fee() {
		return refunded_fee;
	}
	public void setRefunded_fee(Double refundedFee) {
		refunded_fee = refundedFee;
	}
	public Double getDiscount_fee() {
		return discount_fee;
	}
	public void setDiscount_fee(Double discountFee) {
		discount_fee = discountFee;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date updateTime) {
		update_time = updateTime;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date payTime) {
		pay_time = payTime;
	}
	public TradePayType getPay_type() {
		return pay_type;
	}
	public void setPay_type(TradePayType payType) {
		pay_type = payType;
	}
	public Date getConsign_time() {
		return consign_time;
	}
	public void setConsign_time(Date consignTime) {
		consign_time = consignTime;
	}
	public Date getSign_time() {
		return sign_time;
	}
	public void setSign_time(Date signTime) {
		sign_time = signTime;
	}
	public String getBuyer_area() {
		return buyer_area;
	}
	public void setBuyer_area(String buyerArea) {
		buyer_area = buyerArea;
	}
	public List<TradeOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<TradeOrder> orders) {
		this.orders = orders;
	}
	public TradeFetch getFetch_detail() {
		return fetch_detail;
	}
	public void setFetch_detail(TradeFetch fetchDetail) {
		fetch_detail = fetchDetail;
	}
	public List<UmpTradeCoupon> getCoupon_details() {
		return coupon_details;
	}
	public void setCoupon_details(List<UmpTradeCoupon> couponDetails) {
		coupon_details = couponDetails;
	}
	public List<TradePromotion> getPromotion_details() {
		return promotion_details;
	}
	public void setPromotion_details(List<TradePromotion> promotionDetails) {
		promotion_details = promotionDetails;
	}
	public AdjustFee getAdjust_fee() {
		return adjust_fee;
	}
	public void setAdjust_fee(AdjustFee adjustFee) {
		adjust_fee = adjustFee;
	}
	public TradeDetail getSub_trades() {
		return sub_trades;
	}
	public void setSub_trades(TradeDetail subTrades) {
		sub_trades = subTrades;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	public String getUpdate_timeFormat() {
		return update_timeFormat;
	}
	public void setUpdate_timeFormat(String updateTimeFormat) {
		update_timeFormat = updateTimeFormat;
	}
	public String getPay_timeFormat() {
		return pay_timeFormat;
	}
	public void setPay_timeFormat(String payTimeFormat) {
		pay_timeFormat = payTimeFormat;
	}
	public String getConsign_timeFormat() {
		return consign_timeFormat;
	}
	public void setConsign_timeFormat(String consignTimeFormat) {
		consign_timeFormat = consignTimeFormat;
	}
	public String getSign_timeFormat() {
		return sign_timeFormat;
	}
	public void setSign_timeFormat(String signTimeFormat) {
		sign_timeFormat = signTimeFormat;
	}
	
}
