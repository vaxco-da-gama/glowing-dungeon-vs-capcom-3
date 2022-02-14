package Game.Models.Users;

import Game.Controllers.UserController;
import Game.Utils.Crypto;
import Game.Utils.Form;

public class User {
	private String id;
	private String name;
	private String email;
	private String password;

	public User(String id, String name, String email, String password) throws Exception {
		String crytoPassword = Crypto.getHashMd5(password);

		if (name.length() == 0) {
			throw new Exception("Nome não pode ser vazio.");
		}

		if (email.length() == 0) {
			throw new Exception("Email não pode ser vazio.");
		}

		if (Form.verifyEmail(email) == false) {
			throw new Exception("Email não é válido.");
		}

		if (password.length() < 8) {
			throw new Exception("Senha deve ter no mínimo 8 caracteres.");
		}

		if (UserController.findByEmail(email) != null) {
			throw new Exception("Email já cadastrado");
		}

		this.id = id;
		this.name = name;
		this.email = email;
		this.password = crytoPassword;
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
}
