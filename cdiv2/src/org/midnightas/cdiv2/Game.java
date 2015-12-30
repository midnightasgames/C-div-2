package org.midnightas.cdiv2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "c / 2 - MidnightasGames";

	public boolean running = false;
	private Thread gameThread;

	private State currentState;

	public void start() {
		running = true;
		gameThread = new Thread(this);
		gameThread.setName("cDiv2 Main Thread");
		gameThread.start();
	}

	public void init() {
		currentState = new StateMenu();
	}

	public void tick() {
		currentState.tick();
	}

	public void render(Graphics2D g) {
		if (currentState != null)
			currentState.render(g);
	}

	public void paintComponent(Graphics g_old) {
		super.paintComponent(g_old);
		Graphics2D g = (Graphics2D) g_old;
		render(g);
	}

	@Override
	public void run() {
		init();
		while (running) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tick();
			repaint();
		}
	}

	public static final void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		game.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		game.setMaximumSize(new Dimension(WIDTH, HEIGHT));

		JFrame frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(3);
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}

}
