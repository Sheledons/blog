package domain;

public class ResultInfo {
	private boolean flag;
	private Object data;
	private Long num;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num2) {
		this.num = num2;
	}
	public ResultInfo() {
		// TODO Auto-generated constructor stub
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public boolean getFlag() {
		return flag;
	}
}
