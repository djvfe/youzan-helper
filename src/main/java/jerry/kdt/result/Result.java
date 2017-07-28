package jerry.kdt.result;

public class Result<T> {
	private ErrorResult errorReult;
	private T content;
	public Result(){}
	public Result(ErrorResult errorReult,T content){
		this.setContent(content);
		this.setErrorReult(errorReult);
	}
	public ErrorResult getErrorReult() {
		return errorReult;
	}
	public void setErrorReult(ErrorResult errorReult) {
		this.errorReult = errorReult;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	
}
