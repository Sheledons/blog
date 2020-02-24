package domain;

public class Classify {
	private int cid;
	private int cnumber;
	private String cname;
	public Classify(){
		
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
}
