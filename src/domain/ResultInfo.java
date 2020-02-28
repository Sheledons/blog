package domain;

public class ResultInfo {
	private boolean flag;
	private Object data;
	private Integer num;
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
