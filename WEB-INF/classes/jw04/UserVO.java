package jw04;

/*
 * 1. Client Data를 Object Modeling
 * 2. Value Object (Value Object Pattern) : Data를 갖는 객체
 * */
public class UserVO {
	private String id;
	private String pwd;
	private boolean active;
	
	public UserVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserVo [ id = " + id + ", pwd = " + pwd +", active = " + active + " ]";
	}
}
