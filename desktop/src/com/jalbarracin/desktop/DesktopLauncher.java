package com.jalbarracin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jalbarracin.Main;

public class DesktopLauncher {

	private static final float SIZE_FACTOR = 0.5f;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int) (750 * SIZE_FACTOR);
		config.height = (int) (1334 * SIZE_FACTOR);
		new LwjglApplication(new Main(), config);
	}
}
