package Game;

import Game.Controllers.AdminController;
import Game.Database.Database;
import Game.View.SelectZoneView;
import Game.View.WaveView;

public class Application {

	public static void main(String[] args) {
		// Database.load();

		AdminController.create("Admin", "admin@gmail.com", "senha123");

		new WaveView();
	}
}
