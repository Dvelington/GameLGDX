/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


/**
 *
 * @author qwerty
 */
public class JBall 
{
    public enum STATE
    {
        STOP,FLY;
    }
    
    static final float SPEED = 2f;
    static final float SIZE = 1.5f;

    public Vector2      _curPos = new Vector2();
    public Vector2      _velocity = new Vector2();
    public Vector2      _acceletarion = new Vector2();
    public Rectangle    _bounds = new Rectangle();
    public STATE        _state;   
    
    public JBall(Vector2 v)
    {
        _curPos         = v;
        _bounds.height  = SIZE;
        _bounds.width   = SIZE;
        _state          = STATE.STOP;     
    }
    
    public Rectangle GetBounds(){return _bounds;}
    public Vector2 GetPos(){return _curPos;}
}
