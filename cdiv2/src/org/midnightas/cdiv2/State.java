package org.midnightas.cdiv2;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class State implements ApproximateKeyListener {
	
	public abstract void tick();
	public abstract void render(Graphics2D g);
	
	public final int getWidth() {
		return Game.WIDTH;
	}	
	public final int getHeight() {
		return Game.HEIGHT;
	}
	
	public void drawBrickBackground(Graphics2D g) {
		for (int x = 0; x < getWidth(); x += 32)
			for (int y = 0; y < getHeight(); y += 32)
				g.drawImage(GlobalResources.IMAGE_PAPERBRICK_BG, x, y, 32, 32, null);
	}
	
	public abstract void mouseEvent(MouseEvent event);
	
}
