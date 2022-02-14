package Game.Models.Users;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {
	private int matches;
	private int wins;
	private int loses;
	private List<Character> characters = new ArrayList<>();

	public Player(String id, String name, String email, String password) {
		super(id, name, email, password);
		this.matches = 0;
		this.wins = 0;
		this.loses = 0;
	}

	public int getMatches() {
		return matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {
		this.loses = loses;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
}
