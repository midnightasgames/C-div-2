package org.midnightas.cdiv2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Game extends JPanel implements Runnable, ApproximateKeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "c / 2 - MidnightasGames";

	public static Game game = null;

	public boolean running = false;
	private Thread gameThread;

	private State currentState;
	private boolean showCopyright = true;

	public void start() {
		running = true;
		gameThread = new Thread(this);
		gameThread.setName("cDiv2 Main Thread");
		gameThread.start();
		Timer hideCopyright = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showCopyright = false;
			}
		});
		hideCopyright.setRepeats(false);
		hideCopyright.start();
	}

	public void init() {
		currentState = new StateMenu();
		game.addKeyListener(new RepetitiveKeyListener());
		game.addMouseListener(new CDiv2MouseListener());
		Keys.KEYS_APPROXIMATE.approximateKeyListeners.add(this);
		for (char c = 65; c < 123; c++) {
			final char cDuplicate = c;
			String identifier = "key_" + (int) c;
			game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(c), identifier);
			game.getActionMap().put(identifier, new AbstractAction() {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("action performed.");
					Keys.KEYS_APPROXIMATE.callEvent(cDuplicate);
				}
			});
		}
		game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER),
				"key_" + KeyEvent.VK_ENTER);
		game.getActionMap().put("key_" + KeyEvent.VK_ENTER, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Keys.KEYS_APPROXIMATE.callEvent((char) KeyEvent.VK_ENTER);
			}
		});
		game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"),
				"key_" + KeyEvent.VK_LEFT);
		game.getActionMap().put("key_" + KeyEvent.VK_LEFT, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Keys.KEYS_APPROXIMATE.callEvent((char) KeyEvent.VK_LEFT);
			}
		});
		game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"),
				"key_" + KeyEvent.VK_RIGHT);
		game.getActionMap().put("key_" + KeyEvent.VK_RIGHT, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Keys.KEYS_APPROXIMATE.callEvent((char) KeyEvent.VK_RIGHT);
			}
		});
		game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"),
				"key_" + KeyEvent.VK_UP);
		game.getActionMap().put("key_" + KeyEvent.VK_UP, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Keys.KEYS_APPROXIMATE.callEvent((char) KeyEvent.VK_UP);
			}
		});
		game.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"),
				"key_" + KeyEvent.VK_DOWN);
		game.getActionMap().put("key_" + KeyEvent.VK_DOWN, new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				Keys.KEYS_APPROXIMATE.callEvent((char) KeyEvent.VK_DOWN);
			}
		});
	}

	public void tick() {
		currentState.tick();
	}

	public void render(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g.setFont(GlobalResources.FONT.deriveFont(60f));
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

	// Getters & Setters -- START

	public boolean showCopyright() {
		return this.showCopyright;
	}

	public static Game getGame() {
		return game;
	}

	public void setState(State newState) {
		this.currentState = newState;
	}
	
	public State getState() {
		return this.currentState;
	}

	// Getters & Setters -- END

	public static final void main(String[] args) {
		game = new Game();
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

	@Override
	public void aKeyPressed(char character) {
		currentState.aKeyPressed(character);
	}

}
