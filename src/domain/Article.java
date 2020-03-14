package domain;

public class Article {
	private int aid;
	private int uid;
	private String aname;
	private String time;
	private int viewTimes;
	private String content;
	private int cid;
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Article(){
		
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAname() {
		return aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int long1) {
		this.aid = long1;
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
	@Override
	public String toString() {
		return "Article [aid=" + aid + ", uid=" + uid + ", aname=" + aname
				+ ", time=" + time + ", viewTimes=" + viewTimes + ", content="
				+ content + ", cid=" + cid + ", cname=" + cname + "]";
	}
	
}
