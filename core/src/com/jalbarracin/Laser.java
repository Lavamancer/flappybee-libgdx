package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Laser implements Entity {

    Main main;
    Texture texture;
    int x;
    int y;
    private static Sound laserSound = Gdx.audio.newSound(Gdx.files.internal("laser.wav"));
    private static Sound explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));



    public Laser(Main main, int x) {
        this.main = main;
        laserSound.play(Main.VOLUME);
        texture = new Texture("laser.png");
        this.x = x - texture.getWidth() / 2;
    }

    @Override
    public void update() {
        y += 10;

        ArrayList<Entity> aux = new ArrayList<>(main.entities);
        for (Entity entity : aux) {
            if (entity instanceof Asteroid) {
                Asteroid asteroid = (Asteroid) entity;
                if (x > asteroid.x && x < asteroid.x + asteroid.texture.getWidth()
                        && y > asteroid.y && y < asteroid.y + asteroid.texture.getHeight()) {
                    destroy(main.entities);
                    asteroid.destroy(main.entities);
                    explosionSound.play(Main.VOLUME);
                }
            }
        }

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }

    @Override
    public void dispose(ArrayList<Entity> entities) {
        if (y > Gdx.graphics.getHeight()) {
            entities.remove(this);
        }
    }

    public void destroy(ArrayList<Entity> entities) {
        entities.remove(this);
    }



}
