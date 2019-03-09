package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private static final int SPEED_PLAYER = 10;
    Texture texture;
    Texture engineTexture;
    int x;
    int y;
    int tickEngine;


    public Player() {
        texture = new Texture("ship.png");
        engineTexture = new Texture("engine.png");
    }

    public void update() {
        // entrada de teclado para mover la nave
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= SPEED_PLAYER;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += SPEED_PLAYER;
        }

        // restriccion de movimiento para que la nave no se salga por los lados de la pantalla
        if (x < 0) {
            x = 0;
        }
        if (x > Gdx.graphics.getWidth() - texture.getWidth()) {
            x = Gdx.graphics.getWidth() - texture.getWidth();
        }

        tickEngine++;
        if (tickEngine > 4) {
            tickEngine = 0;
        }
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);

        if (tickEngine == 0) {
            spriteBatch.draw(engineTexture, x, y);
        }
    }


}
