package Game.Models.Users;

public class User {
	private String id;
	private String name;
	private String email;
	private String password;
	private int level;

	public User(String id, String name, String email, String password, int level) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
