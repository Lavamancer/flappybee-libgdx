package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Asteroid implements Entity {

    Texture texture;
    int x;
    int y;


    public Asteroid(Main main) {
        texture = new Texture("asteroid.png");
        main.entities.add(this);
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * Gdx.graphics.getWidth());
    }


    @Override
    public void update() {
        y -= 10;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }

    @Override
    public void dispose(ArrayList<Entity> entities) {

    }
}
