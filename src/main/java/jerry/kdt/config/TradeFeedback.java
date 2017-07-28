package jerry.kdt.config;
/**
 * 交易维权状态
 * @author dj
 *
 */
public enum TradeFeedback {
	NOT(0,"无维权"),
	BUYER_START (1,"顾客发起维权"),
	BUYER_REFUSE(2,"顾客拒绝商家的处理结果"),
	BUYER_ACCEPT(3,"顾客接受商家的处理结果"),
	PROCESSING(9,"商家正在处理 "),
	WAIT_AGREE_REFUND(101,"等待卖家同意退款申请"),
	WAIT_AGREE_REFUND_AGAIN(102,"等待卖家同意退款申请（维权失败过）"),
	REFUSE_REFUND(103,"卖家不同意退款申请"),
	REQUIRE_YOUZAN(104,"已经申请有赞客满介入"),
	AGREE_REFUND(105,"卖家已同意退款"),
	GOODS_RETURNED(106,"已退货，等待卖家确认收货"),
	CLOSED(107,"维权已经关闭"),
	REFUND_SUCCESS(110,"退款成功"),
	;
	private TradeFeedback() {}
	private TradeFeedback(Integer id,String desc) {
		this.id = id;
	}
	/**
	 * 根据id取得枚举对象
	 * @param id
	 * @return
	 */
	public static TradeFeedback getById(Integer id) {
		if(id==null) return null;
		for(TradeFeedback tf : TradeFeedback.values()) {
			if(tf.getId()==id) return tf;
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
