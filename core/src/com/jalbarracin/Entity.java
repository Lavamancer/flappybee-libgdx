package com.jalbarracin;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public interface Entity {

    void update();

    void render(SpriteBatch spriteBatch);

    void dispose(ArrayList<Entity> entities);

}
