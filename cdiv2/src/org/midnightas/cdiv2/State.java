package org.midnightas.cdiv2;

import java.awt.Graphics2D;

public abstract class State implements ApproximateKeyListener {
	
	public abstract void tick();
	public abstract void render(Graphics2D g);
	
	public final int getWidth() {
		return Game.WIDTH;
	}	
	public final int getHeight() {
		return Game.HEIGHT;
	}
	
}
