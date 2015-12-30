package org.midnightas.cdiv2;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class GlobalResources {

	public static final BufferedImage IMAGE_PAPERBRICK_BG = ImageUtils.loadFromClasspath("/res/paperbrick.png");
	public static final Font FONT = ImageUtils.loadFont(Game.class.getResourceAsStream("/res/font.ttf"));
}
