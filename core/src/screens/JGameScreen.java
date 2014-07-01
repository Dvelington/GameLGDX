/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import model.JWorld;
import view.JWorldRenderer;
import com.badlogic.gdx.graphics.GL20;



/**
 *
 * @author qwerty
 */
public class JGameScreen implements Screen
{
    
    private JWorld _world;
    private JWorldRenderer _renderer;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        _renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        _renderer.setSize(width, width);
    }

    @Override
    public void show() {
        _world = new JWorld();
        _renderer = new JWorldRenderer(_world,false);
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
