package org.midnightas.cdiv2;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class StateMenu extends State {
	
	public static final BufferedImage IMAGE_LOGO = ImageUtils.loadFromURL("http://images.cooltext.com/4543269.png");
	
	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		for(int x = 0; x < getWidth(); x += 32)
			for(int y = 0; y < getHeight(); y += 32)
				g.drawImage(GlobalResources.IMAGE_PAPERBRICK_BG, x, y, 32, 32, null);
		g.drawImage(IMAGE_LOGO, getWidth() / 2 - IMAGE_LOGO.getWidth(), getHeight() / 3, IMAGE_LOGO.getWidth() * 2, IMAGE_LOGO.getHeight() * 2, null);
	}

}
