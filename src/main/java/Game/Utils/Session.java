package Game.Utils;

import Game.Models.Users.Admin;
import Game.Models.Users.Player;

public class Session {
	private static Admin admin;
	private static Player player;
	private static Character character;

	public static Admin getAdmin() {
		return admin;
	}

	public static void setAdmin(Admin admin) {
		Session.admin = admin;
	}

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		Session.player = player;
	}

	public static Character getCharacter() {
		return character;
	}

	public static void setCharacter(Character character) {
		Session.character = character;
	}
}
