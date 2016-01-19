package org.midnightas.cdiv2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CDiv2 extends JPanel implements Runnable, MouseListener {

	public static CDiv2 instance;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "c/2";
	
	private Font font;
	
	private State state;

	private Thread thread;
	private boolean running;

	public void init() {
		try {
			font = Font.createFont(Font.PLAIN, CDiv2.class.getResourceAsStream("/res/mariomaker.ttf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		state = new StateStartup();
	}

	public void start() {
		running = true;
		thread = new Thread(this);
		thread.setName("c/2 Thread");
		thread.start();
	}

	public void tick() {
		if(this.state != null)
			this.state.tick();
	}

	public void paintComponent(Graphics g_old) {
		super.paintComponent(g_old);
		Graphics2D g = (Graphics2D) g_old;
		if(this.font != null)
			g.setFont(font);
		if(this.state != null)
			this.state.render(g);
	}

	public void run() {
		init();
		do {
			tick();
			repaint();
			try {
				Thread.sleep(1000 / 30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (running);
	}

	public static final void main(String[] args) {
		CDiv2 instance = new CDiv2();
		instance.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		instance.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		instance.setMaximumSize(new Dimension(WIDTH, HEIGHT));

		JFrame frame = new JFrame(TITLE);
		frame.add(instance);
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		
		instance.addMouseListener(instance);
		
		instance.start();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.state != null)
			this.state.mouse(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
