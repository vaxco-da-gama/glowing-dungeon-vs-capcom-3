package Game.Users;

public class Player extends User {
	private int matches;
	private int wins;
	private int loses;
	private Character[] characters;

	public Player(String name, String email, String password, int matches, int wins, int loses, Character[] characters) {
		super(name, email, password);
		this.matches = matches;
		this.wins = wins;
		this.loses = loses;
		this.characters = characters;
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

	public Character[] getCharacters() {
		return characters;
	}

	public void setCharacters(Character[] characters) {
		this.characters = characters;
	}
}
