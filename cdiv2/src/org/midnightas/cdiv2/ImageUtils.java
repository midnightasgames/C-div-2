package org.midnightas.cdiv2;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static BufferedImage loadFromURL(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage loadFromClasspath(String uri) {
		try {
			return ImageIO.read(Game.class.getResourceAsStream(uri));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Font loadFont(InputStream stream) {
		try {
			return Font.createFont(Font.PLAIN, stream);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
