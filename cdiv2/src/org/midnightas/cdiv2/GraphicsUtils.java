package org.midnightas.cdiv2;

import java.awt.Graphics2D;

public class GraphicsUtils {
	
	public static void drawStringCentered(Graphics2D g, String s, int y) {
		g.drawString(s, Game.WIDTH / 2 - stringWidth(g, s) / 2, y);
	}
	
	public static void drawStringCentered(Graphics2D g, String s, int y, int xOffset) {
		g.drawString(s, Game.WIDTH / 2 - stringWidth(g, s) / 2 + xOffset, y);
	}
	
	public static int stringWidth(Graphics2D g, String s) {
		return g.getFontMetrics().stringWidth(s);
	}
	
	public static int stringHeight(Graphics2D g, String s) {
		return (int) g.getFont().getLineMetrics(s, g.getFontRenderContext()).getHeight();
	}
	
}
