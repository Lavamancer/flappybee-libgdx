package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Laser implements Entity {

    Texture texture;
    int x;
    int y;


    public Laser(int x) {
        Sound sound = Gdx.audio.newSound(Gdx.files.internal("laser.wav"));
        sound.play();
        texture = new Texture("laser.png");
        this.x = x - texture.getWidth() / 2;
    }

    @Override
    public void update() {
        y += 10;
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



}
