package org.midnightas.cdiv2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class StateMenu extends State implements ApproximateKeyListener {

	public static final BufferedImage IMAGE_LOGO = ImageUtils.loadFromURL("http://images.cooltext.com/4543269.png");

	public int selectedOption = 1;
	public int amountOfOptions = 2;

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics2D g) {
		for (int x = 0; x < getWidth(); x += 32)
			for (int y = 0; y < getHeight(); y += 32)
				g.drawImage(GlobalResources.IMAGE_PAPERBRICK_BG, x, y, 32, 32, null);
		if (!Game.getGame().showCopyright()) {
			g.drawImage(IMAGE_LOGO, getWidth() / 2 - IMAGE_LOGO.getWidth(), getHeight() / 8, IMAGE_LOGO.getWidth() * 2,
					IMAGE_LOGO.getHeight() * 2, null);
			g.setColor(new Color(114, 114, 114));
			g.fill3DRect(getWidth() / 2 - 256, getHeight() / 2 - 32, 512, 232, true);
			g.setFont(g.getFont().deriveFont(70f));
			g.setColor(selectedOption == 1 ? Color.WHITE : Color.BLACK);
			int height = (int) (getHeight() / 2
					+ g.getFont().getLineMetrics("PLAY", g.getFontRenderContext()).getHeight());
			GraphicsUtils.drawStringCentered(g, "PLAY", height);
			g.setColor(selectedOption == 2 ? Color.WHITE : Color.BLACK);
			height += (int) g.getFont().getLineMetrics("MAKE", g.getFontRenderContext()).getHeight();
			GraphicsUtils.drawStringCentered(g, "MAKE", height);
		} else {
			GraphicsUtils.drawStringCentered(g, "MidnightasGames", getHeight() / 2);
		}
	}

	@Override
	public void aKeyPressed(char character) {
		System.out.println(character);
		if (!Game.getGame().showCopyright()) {
			if (character == KeyEvent.VK_ENTER) {
				if(selectedOption == 1)
					Game.getGame().setState(new StateCourseSelection());
			} else if (character == KeyEvent.VK_DOWN) {
				if (selectedOption == amountOfOptions)
					selectedOption = 1;
				else
					selectedOption++;
			} else if (character == KeyEvent.VK_UP) {
				if (selectedOption == 1)
					selectedOption = amountOfOptions;
				else
					selectedOption--;
			}
		}
	}

}
