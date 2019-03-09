package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Asteroid implements Entity {

    Main main;
    Texture texture;
    int x;
    int y;


    public Asteroid(Main main) {
        texture = new Texture("asteroid.png");
        this.main = main;
        main.entities.add(this);
        y = Gdx.graphics.getHeight();
        x = (int) (Math.random() * Gdx.graphics.getWidth());
    }


    @Override
    public void update() {
        y -= 10;
        if (x > main.player.x && x < main.player.x + main.player.texture.getWidth()
                && y > main.player.y && y < main.player.y + main.player.texture.getHeight()) {
            dispose(main.entities);
            System.out.println("Has muerto");
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }

    @Override
    public void dispose(ArrayList<Entity> entities) {
//        entities.remove(this);
    }

    public void destroy(ArrayList<Entity> entities) {
        entities.remove(this);
    }
}
