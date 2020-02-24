package domain;

public class ResultInfo {
	private boolean flag;
	private Object data;
	private String error;
	public ResultInfo() {
		// TODO Auto-generated constructor stub
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Object getData() {
		return data;
	}
	public String getError() {
		return error;
	}
	public boolean getFlag() {
		return flag;
	}
}
