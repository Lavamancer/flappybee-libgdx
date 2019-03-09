package com.jalbarracin;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {

	SpriteBatch spriteBatch;
	ArrayList<Entity> entities = new ArrayList<>();
	ArrayList<Entity> entitiesAux = new ArrayList<>();
	Player player;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		player = new Player(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();
		entitiesAux.clear();
		entitiesAux.addAll(entities);

		for (Entity entity : entitiesAux) {
			entity.dispose(entities);
			entity.update();
			entity.render(spriteBatch);
		}

		player.update();
		player.render(spriteBatch);

		spriteBatch.end();
	}
	
	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
