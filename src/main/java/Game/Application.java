package Game;

import Game.Database.Database;
import Game.View.ZoneAdminView;

public class Application {

	public static void main(String[] args) {		
		Database.load();
		new ZoneAdminView();
	}
}
