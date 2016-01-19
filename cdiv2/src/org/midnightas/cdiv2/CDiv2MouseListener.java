package org.midnightas.cdiv2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CDiv2MouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent event) {
		Game.getGame().getState().mouseEvent(event);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
