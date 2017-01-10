package model;

public class User {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String createtime;
	
	private String email;
	
	private String status;
	
	private String level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public User(int id, String username, String password, String createtime, String email, String status, String level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createtime = createtime;
		this.email = email;
		this.status = status;
		this.level = level;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
