package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Asteroid implements Entity {

    private static final int SPEED = 1;
    int speedAmount;
    Main main;
    Texture texture;
    int x;
    int y;
    float offset = (float) ((Math.random() * 4) - 2);
    float rotation;
    float rotationAmount;


    public Asteroid(Main main) {
        texture = new Texture("asteroid.png");
        this.main = main;
        main.entities.add(this);
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * Gdx.graphics.getWidth());
        rotationAmount = (float) Math.random();
        speedAmount = (int) (Math.random() * 6);
    }


    @Override
    public void update() {
//        rotation += rotationAmount;
        y -= SPEED + speedAmount;
        x += offset;
        if (x > main.player.x && x < main.player.x + main.player.texture.getWidth()
                && y > main.player.y && y < main.player.y + main.player.texture.getHeight()) {
            dispose(main.entities);
            System.out.println("Has muerto");
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(
                texture, x, y, x + texture.getWidth() / 2, y + texture.getHeight() / 2,
                texture.getWidth(), texture.getHeight(),
                1, 1,
                rotation,
                0, 0, texture.getWidth(), texture.getHeight(),
                false, false
        );
    }

    @Override
    public void dispose(ArrayList<Entity> entities) {
        if (x < 0) {
            entities.remove(this);
            System.out.println("Asteroid dispose");
        }
    }

    public void destroy(ArrayList<Entity> entities) {
        entities.remove(this);
    }
}
