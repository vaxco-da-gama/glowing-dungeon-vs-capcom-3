package Game.Screens;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

public class ScreenAvatar extends JLabel {

    private ImageIcon background;
		private int left;
		private int top;

    public ScreenAvatar(String backgroundImage, int leftPos, int topPos) {
				background = new ImageIcon(getClass().getResource(backgroundImage));
				left = leftPos;
				top = topPos;
    }

		@Override
    public void paint (Graphics g)
    {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
				float newImageHeight = (float) this.getHeight() * 0.8f;
				float newImageWidth = (float) ((float) background.getImage().getWidth(this) /  background.getImage().getHeight(this) ) * newImageHeight;

        g2.drawImage(background.getImage(), this.left, this.top, (int) newImageWidth, (int) newImageHeight, this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
}