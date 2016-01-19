package org.midnightas.cdiv2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class StateOwnedCoursesSelection extends State {

	private Rectangle BUTTON_NEW_LEVEL_HITBOX = null;

	@Override
	public void aKeyPressed(char character) {

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		super.drawBrickBackground(g);
		g.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(50f));
		g.drawString("NEW LEVEL", 6, getHeight() - 8);
		if (BUTTON_NEW_LEVEL_HITBOX == null)
			BUTTON_NEW_LEVEL_HITBOX = new Rectangle(6, getHeight() - 8 - GraphicsUtils.stringHeight(g, "NEW LEVEL"),
					GraphicsUtils.stringWidth(g, "NEW LEVEL"), GraphicsUtils.stringHeight(g, "NEW LEVEL"));
	}

	@Override
	public void mouseEvent(MouseEvent event) {
		if(BUTTON_NEW_LEVEL_HITBOX.contains(event.getX(), event.getY()))
			System.out.println("HAHA");
	}

}
