package com.jalbarracin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	Player player;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		player = new Player();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();

		player.render(spriteBatch);

		spriteBatch.end();

		player.update();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
