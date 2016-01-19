package org.midnightas.cdiv2;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GraphicsUtils {

	public static int drawCenteredString(Graphics2D g, String string, int y, int width) {
		int x = (width - g.getFontMetrics().stringWidth(string)) / 2;
		g.drawString(string, x, y);
		return x;
	}

	public static Rectangle stringToHitbox(Graphics2D g, String string, int x, int y) {
		int height = (int) g.getFont().getLineMetrics(string, g.getFontRenderContext()).getHeight();
		return new Rectangle(x, y - height, g.getFontMetrics().stringWidth(string),
				height);
	}

}
