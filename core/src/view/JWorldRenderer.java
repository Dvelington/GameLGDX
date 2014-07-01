/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import java.util.Iterator;
import model.JBall;
import model.JBlock;
import model.JWorld;

/**
 *
 * @author qwerty
 */
public class JWorldRenderer {
    
    private static final float CAMERA_WIDTH = 30f;
    private static final float CAMERA_HEIGHT = 21f;
    
    private JWorld world;
    private OrthographicCamera cam;
    
    private Texture _ballTexture;
    private Texture _brickTexture;
    
    private SpriteBatch _spriteBatch;
    private boolean _debug = false;
    
    private int width;
    private int height;
    private float ppuX;
    private float ppuY;
    
    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float) width / CAMERA_WIDTH;
        ppuY = (float) height / CAMERA_HEIGHT;
    }

    /**
     * for debug rendering *
     */
    ShapeRenderer debugRenderer = new ShapeRenderer();

    public JWorldRenderer(JWorld world, boolean debug) {
        this.world = world;
        this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cam.position.set(CAMERA_WIDTH/2f, CAMERA_HEIGHT/2f, 0);
        this.cam.update();
        this._debug = debug;
        _spriteBatch = new SpriteBatch();
        loadTextures();
    }
    
    public void DrawBlock()
    {
        for (Iterator it = world.GetBlocks().iterator(); it.hasNext();) 
        {
            JBlock block = (JBlock) it.next();
            _spriteBatch.draw(_brickTexture,
                    block.GetPos().x*ppuX,
                    block.GetPos().y*ppuX,
                    JBlock.SIZE * ppuX,
                    JBlock.SIZE*ppuY);
        }
    }
    
    public void DrawBall()
    {
        JBall ball = world.GetBall();
        _spriteBatch.draw(_ballTexture,
                ball.GetPos().x * ppuX, 
                ball.GetPos().y * ppuX, 
                JBlock.SIZE * ppuX,
                JBlock.SIZE * ppuY);
    }
    
    public void render() {
        _spriteBatch.begin();
            DrawBlock();
            DrawBall();
        _spriteBatch.end();
        if(_debug)
            DrawDebug();
    }

    public void DrawDebug() {
        debugRenderer.setProjectionMatrix(cam.combined);
        debugRenderer.begin(ShapeType.Line);
        for (Iterator it = world.GetBlocks().iterator(); it.hasNext();) 
        {
            JBlock block = (JBlock) it.next();
            Rectangle rect = block.GetBounds();
            float x1 = block.GetPos().x + rect.x;
            float y1 = block.GetPos().y + rect.y;
            debugRenderer.setColor(new Color(1, 0, 0, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }
        JBall _ball = world.GetBall();
        Rectangle rect = _ball.GetBounds();
        float x1 = _ball.GetPos().x + rect.x;
        float y1 = _ball.GetPos().y + rect.y;
        debugRenderer.setColor(new Color(0, 1, 0, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);
        debugRenderer.end();
    }

    private void loadTextures() {
        _ballTexture = new Texture(Gdx.files.internal("images/ball.png"));
        _brickTexture = new Texture(Gdx.files.internal("images/brick.png"));
    }
    
}
