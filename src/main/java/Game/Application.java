package Game;

import Game.Database.Database;
import Game.View.AuthView;

public class Application {

	public static void main(String[] args) {
		Database.load();

		renderPages();
		
		Database.save();
	}

	public static void renderPages() {
		AuthView authView = new AuthView();
		authView.render();
	}
}
