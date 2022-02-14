package Game;

import Game.Database.Database;
import Game.View.AuthView;
import Game.View.WaveView;

public class Application {

	public static void main(String[] args) {
		Database.load();

		renderPages();

		Database.save();
	}

	public static void renderPages() {
		new AuthView();
	}
}
