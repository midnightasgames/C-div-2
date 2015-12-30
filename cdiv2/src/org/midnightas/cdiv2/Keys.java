package org.midnightas.cdiv2;

import java.util.ArrayList;
import java.util.List;

public class Keys {
	
	public static class KEYS_APPROXIMATE {
		
		public static final List<ApproximateKeyListener> approximateKeyListeners = new ArrayList<ApproximateKeyListener>();
		
		public static void callEvent(char character) {
			for(ApproximateKeyListener listener : approximateKeyListeners)
				listener.aKeyPressed(character);
		}
	}
	
	public static class KEYS_REPETITIVE {
		static final boolean[] keys = new boolean[65535];
	}
	
}
