package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements Entity {

    private static final int SPEED_PLAYER = 10;

    Main main;
    Texture texture;
    Texture engineTexture;
    int x;
    int y;
    int tickEngine;


    public Player(Main main) {
        this.main = main;
        texture = new Texture("ship.png");
        engineTexture = new Texture("engine.png");
    }

    @Override
    public void update() {
        updateInput();
        updateEngine();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y);

        if (tickEngine == 0) {
            spriteBatch.draw(engineTexture, x, y);
        }
    }


    private void updateInput() {
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

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            Laser laser = new Laser(x + texture.getWidth() / 2);
            main.entities.add(laser);
        }
    }

    private void updateEngine() {
        // aqui actualizamos los tick de pintado del motor
        tickEngine++;
        if (tickEngine > 4) {
            tickEngine = 0;
        }
    }



}
