package jerry.kdt.result;

import java.util.Date;
import java.util.List;
/**
 * 商品数据结构
 * @author dj
 *
 */
public class GoodsDetail {
	/**
	 * 商品数字编号
	 */
	private Integer num_iid;
	/**
	 * 商品别称
	 */
	private String alias;
	/**
	 * 商品标题
	 */
	private String title;
	/**
	 * 商品分类的叶子类目id，可参考API：kdt.itemcategories.get
	 */
	private Integer cid;
	/**
	 * 商品推广栏目id，可参考API：kdt.itemcategories.promotions.get
	 */
	private Integer promotion_cid;
	/**
	 * 商品标签id串，结构如：1234,1342,...，可参考API：kdt.itemcategories.tags.get
	 */
	private String tag_ids;
	/**
	 * 商品描述
	 */
	private String desc;
	/**
	 * 显示在“原价”一栏中的信息
	 */
	private String origin_price;
	/**
	 * 商品货号（商家为商品设置的外部编号，可与商家外部系统对接）
	 */
	private String outer_id;
	/**
	 * 商品外部购买链接
	 */
	private String outer_buy_url;
	/**
	 * 每人限购多少件。0代表无限购，默认为0
	 */
	private Integer buy_quota;
	/**
	 * 商品的发布时间
	 */
	private Date created;
	/**
	 * 商品的发布时间
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String createdFormat;
	/**
	 * 是否为虚拟商品
	 */
	private Boolean is_virtual;
	/**
	 * 商品上架状态。true 为已上架，false 为已下架
	 */
	private Boolean is_listing;
	/**
	 * 商品是否锁定。true 为已锁定，false 为未锁定
	 */
	private Boolean is_lock;
	/**
	 * 是否为二手商品
	 */
	private Boolean is_used;
	/**
	 * 商品定时上架（定时开售）的时间。没设置则为空
	 */
	private Date auto_listing_time;
	/**
	 * 商品定时上架（定时开售）的时间。没设置则为空
	 * 格式化数据 yyyy-MM-dd HH:mm:ss
	 */
	private String auto_listing_timeFormat;
	/**
	 * 适合wap应用的商品详情url
	 */
	private String detail_url;
	/**
	 * 分享出去的商品详情url
	 */
	private String share_url;
	/**
	 * 商品主图片地址
	 */
	private String pic_url;
	/**
	 * 商品主图片缩略图地址
	 */
	private String pic_thumb_url;
	/**
	 * 商品数量
	 */
	private Integer num;
	/**
	 * 商品销量
	 */
	private Integer sold_num;
	/**
	 * 商品价格，格式：5.00；单位：元；精确到：分
	 */
	private Double price;
	/**
	 * 运费类型。1：统一邮费；2：运费模版;
	 */
	private Integer post_type;
	/**
	 * 运费（针对“统一运费”），格式：5.00；单位：元；精确到：分
	 */
	private Double post_fee;
	/**
	 * 运费（针对“运费模版”），格式：5.00；单位：元；精确到：分 若存在运费区间，中间用逗号隔开，如 “5.00,9.00”
	 */
	private String delivery_template_fee;
	/**
	 * Sku列表
	 */
	private List<GoodsSku> skus;
	/**
	 * 商品图片列表
	 */
	private List<GoodsImage> item_imgs;
	/**
	 * 商品二维码列表。注：仅 kdt.item.get 和 kdt.items.custom.get 接口会返回该字段
	 */
	private List<GoodsQrcode> item_qrcodes;
	/**
	 * 商品标签数据结构
	 */
	private List<GoodsTag> item_tags;
	/**
	 * 商品类型。0：普通商品；10：分销商品
	 */
	private Integer item_type;
	/**
	 * 是否是供货商商品。
	 */
	private Boolean is_supplier_item;
	public Integer getNum_iid() {
		return num_iid;
	}
	public void setNum_iid(Integer numIid) {
		num_iid = numIid;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPromotion_cid() {
		return promotion_cid;
	}
	public void setPromotion_cid(Integer promotionCid) {
		promotion_cid = promotionCid;
	}
	public String getTag_ids() {
		return tag_ids;
	}
	public void setTag_ids(String tagIds) {
		tag_ids = tagIds;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(String originPrice) {
		origin_price = originPrice;
	}
	public String getOuter_id() {
		return outer_id;
	}
	public void setOuter_id(String outerId) {
		outer_id = outerId;
	}
	public String getOuter_buy_url() {
		return outer_buy_url;
	}
	public void setOuter_buy_url(String outerBuyUrl) {
		outer_buy_url = outerBuyUrl;
	}
	public Integer getBuy_quota() {
		return buy_quota;
	}
	public void setBuy_quota(Integer buyQuota) {
		buy_quota = buyQuota;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Boolean getIs_virtual() {
		return is_virtual;
	}
	public void setIs_virtual(Boolean isVirtual) {
		is_virtual = isVirtual;
	}
	public Boolean getIs_listing() {
		return is_listing;
	}
	public void setIs_listing(Boolean isListing) {
		is_listing = isListing;
	}
	public Boolean getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(Boolean isLock) {
		is_lock = isLock;
	}
	public Boolean getIs_used() {
		return is_used;
	}
	public void setIs_used(Boolean isUsed) {
		is_used = isUsed;
	}
	public Date getAuto_listing_time() {
		return auto_listing_time;
	}
	public void setAuto_listing_time(Date autoListingTime) {
		auto_listing_time = autoListingTime;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detailUrl) {
		detail_url = detailUrl;
	}
	public String getShare_url() {
		return share_url;
	}
	public void setShare_url(String shareUrl) {
		share_url = shareUrl;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String picUrl) {
		pic_url = picUrl;
	}
	public String getPic_thumb_url() {
		return pic_thumb_url;
	}
	public void setPic_thumb_url(String picThumbUrl) {
		pic_thumb_url = picThumbUrl;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getSold_num() {
		return sold_num;
	}
	public void setSold_num(Integer soldNum) {
		sold_num = soldNum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getPost_type() {
		return post_type;
	}
	public void setPost_type(Integer postType) {
		post_type = postType;
	}
	public Double getPost_fee() {
		return post_fee;
	}
	public void setPost_fee(Double postFee) {
		post_fee = postFee;
	}
	public String getDelivery_template_fee() {
		return delivery_template_fee;
	}
	public void setDelivery_template_fee(String deliveryTemplateFee) {
		delivery_template_fee = deliveryTemplateFee;
	}
	public Integer getItem_type() {
		return item_type;
	}
	public void setItem_type(Integer itemType) {
		item_type = itemType;
	}
	public Boolean getIs_supplier_item() {
		return is_supplier_item;
	}
	public void setIs_supplier_item(Boolean isSupplierItem) {
		is_supplier_item = isSupplierItem;
	}
	public List<GoodsSku> getSkus() {
		return skus;
	}
	public void setSkus(List<GoodsSku> skus) {
		this.skus = skus;
	}
	public List<GoodsImage> getItem_imgs() {
		return item_imgs;
	}
	public void setItem_imgs(List<GoodsImage> itemImgs) {
		item_imgs = itemImgs;
	}
	public List<GoodsQrcode> getItem_qrcodes() {
		return item_qrcodes;
	}
	public void setItem_qrcodes(List<GoodsQrcode> itemQrcodes) {
		item_qrcodes = itemQrcodes;
	}
	public List<GoodsTag> getItem_tags() {
		return item_tags;
	}
	public void setItem_tags(List<GoodsTag> itemTags) {
		item_tags = itemTags;
	}
	public String getCreatedFormat() {
		return createdFormat;
	}
	public void setCreatedFormat(String createdFormat) {
		this.createdFormat = createdFormat;
	}
	public String getAuto_listing_timeFormat() {
		return auto_listing_timeFormat;
	}
	public void setAuto_listing_timeFormat(String autoListingTimeFormat) {
		auto_listing_timeFormat = autoListingTimeFormat;
	}
	
}
