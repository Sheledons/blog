package domain;

public class Classify {
	private int cid;
	private int cnumber;
	private String cname;
	private int uid;
	public Classify(){
		
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public int getCnumber() {
		return cnumber;
	}
	@Override
	public String toString() {
		return "Classify [cid=" + cid + ", cnumber=" + cnumber + ", cname="
				+ cname + ", uid=" + uid + "]";
	}
}
