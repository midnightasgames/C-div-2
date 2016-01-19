package org.midnightas.cdiv2;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public abstract class State {
	
	public abstract void render(Graphics2D g);
	public abstract void tick();
	public abstract void mouse(int x, int y);
	public abstract void key(KeyEvent keyevent);
	
	public int getWidth() {
		return CDiv2.WIDTH;
	}

	public int getHeight() {
		return CDiv2.HEIGHT;
	}
	
}
