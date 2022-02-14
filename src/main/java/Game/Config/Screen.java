package Game.Config;

import java.awt.*;

public class Screen {
	public static Toolkit toolkit = Toolkit.getDefaultToolkit();
	public static Dimension dimension = toolkit.getScreenSize();

	private static int height = dimension.height;
	private static int width = dimension.width;

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Screen.height = height;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Screen.width = width;
	}
}
