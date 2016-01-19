package org.midnightas.cdiv2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class StateStartup extends State {

	public Rectangle BUTTON_PLAY_HITBOX = null;
	public Rectangle BUTTON_EXIT_HITBOX = null;

	private boolean animationRunning = false;
	private int animationOn = 0;
	private int animationTicks = 0;

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(new Color(123, 64, 0));
		g.setFont(g.getFont().deriveFont(30f));
		g.drawString("©MidnightasGames", 4, getHeight() - 10);
		g.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(90f));
		GraphicsUtils.drawCenteredString(g, "c/2", getHeight() / 3, getWidth());
		g.setFont(g.getFont().deriveFont(60f + (animationRunning && animationOn == 0 ? animationTicks / 4 : 0)));
		int textX = GraphicsUtils.drawCenteredString(g, "Play", getHeight() / 2, getWidth());
		if (BUTTON_PLAY_HITBOX == null)
			BUTTON_PLAY_HITBOX = GraphicsUtils.stringToHitbox(g, "Play", textX, getHeight() / 2);
		g.setFont(g.getFont().deriveFont(60f + (animationRunning && animationOn == 1 ? animationTicks / 4 : 0)));
		textX = GraphicsUtils.drawCenteredString(g, "Exit", getHeight() / 2 + 72, getWidth());
		if (BUTTON_EXIT_HITBOX == null)
			BUTTON_EXIT_HITBOX = GraphicsUtils.stringToHitbox(g, "Exit", textX, getHeight() / 2 + 72);
	}

	@Override
	public void tick() {
		if (animationRunning)
			animationTicks++;
		else if (!animationRunning && animationTicks > 0)
			animationTicks = 0;
	}

	@Override
	public void mouse(int x, int y) {
		System.out.println(x + "," + y + " - " + BUTTON_EXIT_HITBOX.toString());
		if (BUTTON_PLAY_HITBOX.contains(x, y)) {
			animationOn = 0;
			animationRunning = true;
			Timer timer = new Timer(1000, new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
			timer.setRepeats(false);
			timer.start();
		} else if (BUTTON_EXIT_HITBOX.contains(x, y)) {
			animationOn = 1;
			animationRunning = true;
			Timer timer = new Timer(1000, new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			timer.setRepeats(false);
			timer.start();
		}
	}

	@Override
	public void key(KeyEvent keyevent) {

	}

}
