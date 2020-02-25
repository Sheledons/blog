package domain;

public class User {
	private int uid;
	private String name;
	private String pwd;
	private String imageUrl;
	private String classify;
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public User(){
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	public String getImageUrl() {
		return imageUrl;
	}
	@Override
	public String toString() {
		return "name="+this.name+"&"+"pwd"+this.pwd;
	}
}
