/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 *
 * @author qwerty
 */
public class JWorld {
    
    private Array _blocks =new Array();
    private JBall _ball;
    
    private static final int SIZEX = 30;
    private static final int SIZEY = 21;
    
    
    public Array GetBlocks(){return _blocks;}
    public JBall GetBall(){return _ball;}
    
    public JWorld()
    {
        _ball = new JBall(new Vector2(SIZEX/2, SIZEY/2));
        for(int i=0;i<SIZEX;i++)
        {
            _blocks.add(new JBlock(new Vector2(i, 0)));
            _blocks.add(new JBlock(new Vector2(i, SIZEY-1)));
        }
        for(int i=1;i<SIZEY-1;i++)
        {
            _blocks.add(new JBlock(new Vector2(0, i)));
            _blocks.add(new JBlock(new Vector2(SIZEX-1, i)));
        }
    }
    
}
