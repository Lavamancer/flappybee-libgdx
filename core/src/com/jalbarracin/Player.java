package com.jalbarracin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    Texture texture;
    int x;
    int y;


    public void create() {
        texture = new Texture("ship.png");
    }

    public void update() {

    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);
    }


}
