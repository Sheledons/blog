package domain;

public class User {
	private int uid;
	private String name;
	private String pwd;
	public User(){
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public int getUid() {
		return uid;
	}
	@Override
	public String toString() {
		return "name="+this.name+"&"+"pwd"+this.pwd;
	}
}
