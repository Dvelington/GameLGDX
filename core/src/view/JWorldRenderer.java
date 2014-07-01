/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    
    private JWorld world;
    private OrthographicCamera cam;

    /**
     * for debug rendering *
     */
    ShapeRenderer debugRenderer = new ShapeRenderer();

    public JWorldRenderer(JWorld world) {
        this.world = world;
        this.cam = new OrthographicCamera(30, 21);
        this.cam.position.set(15, 10.5f, 0);
        this.cam.update();
    }

    public void render() {
        // render blocks
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
        // render Bob
        JBall _ball = world.GetBall();
        Rectangle rect = _ball.GetBounds();
        float x1 = _ball.GetPos().x + rect.x;
        float y1 = _ball.GetPos().y + rect.y;
        debugRenderer.setColor(new Color(0, 1, 0, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);
        debugRenderer.end();
    }
    
}
