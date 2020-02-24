package domain;

public class Article {
	private int aid;
	private int uid;
	private String time;
	private int viewTimes;
	private String content;
	private int cid;
	public Article(){
		
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViewTimes() {
		return viewTimes;
	}
	public void setViewTimes(int number) {
		this.viewTimes = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
}
