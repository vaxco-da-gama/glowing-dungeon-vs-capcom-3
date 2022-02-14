package Game;

import java.util.ArrayList;
import java.util.List;

import Game.Database.Database;
import Game.Models.Creatures.Enemy;
import Game.View.AuthView;
import Game.View.WaveView;

public class Application {

	public static void main(String[] args) {
		Database.load();

		Database.save();
	}

	public static void renderPages() {
		AuthView authView = new AuthView();
		authView.render();
	}
}
