package jerry.kdt.result;

public class AdjustFee {
	/**订单改价*/
	private Double pay_change;
	/**总改价金额**/
	private Double change;
	/**邮费改价*/
	private Double post_change;
	public Double getPay_change() {
		return pay_change;
	}
	public void setPay_change(Double payChange) {
		pay_change = payChange;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Double getPost_change() {
		return post_change;
	}
	public void setPost_change(Double postChange) {
		post_change = postChange;
	}
	
}
