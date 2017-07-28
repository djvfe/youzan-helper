package jerry.kdt.result;

import java.util.Date;

import jerry.kdt.config.QrcodeType;

/**
 * 商品二维码数据结构
 * @author dj
 *
 */
public class GoodsQrcode {
	/**
	 * 商品二维码的ID
	 */
	private Integer id;
	/**
	 * 二维码的名称
	 */
	private String name;
	/**
	 * 二维码的描述
	 */
	private String desc;
	/**
	 * 商品二维码创建时间，时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;
	/**
	 * 商品二维码创建时间，时间格式：yyyy-MM-dd HH:mm:ss
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * 商品二维码类型。可选值：
GOODS_SCAN_FOLLOW(扫码关注后购买商品) 
GOODS_SCAN_FOLLOW_DECREASE(扫码关注后减优惠额) 
GOODS_SCAN_FOLLOW_DISCOUNT(扫码关注后折扣) 
GOODS_SCAN_DECREASE(扫码直接减优惠额) 
GOODS_SCAN_DISCOUNT(扫码直接折扣) 
	 */
	private QrcodeType type;
	/**
	 * 折扣，格式：9.0；单位：折，精确到小数点后 1 位。如果没有折扣，则为 0
	 */
	private String discount;
	/**
	 * 减金额优惠，格式：5.00；单位：元；精确到：分。如果没有减额优惠，则为 0
	 */
	private Double decrease;
	/**
	 * 扫码直接购买的二维码基于这个url生成。如果不是扫码直接购买的类型，则为空
	 */
	private String link_url; 
	/**
	 * 扫码关注购买的二维码图片地址。如果不是扫码关注购买的类型，则为空
	 */
	private String weixin_qrcode_url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public QrcodeType getType() {
		return type;
	}
	public void setType(QrcodeType type) {
		this.type = type;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Double getDecrease() {
		return decrease;
	}
	public void setDecrease(Double decrease) {
		this.decrease = decrease;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String linkUrl) {
		link_url = linkUrl;
	}
	public String getWeixin_qrcode_url() {
		return weixin_qrcode_url;
	}
	public void setWeixin_qrcode_url(String weixinQrcodeUrl) {
		weixin_qrcode_url = weixinQrcodeUrl;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	
}
