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
public class JBlock {
    
    static final float SIZE = 1f;

    public Vector2 _position = new Vector2();
    public Rectangle _bounds = new Rectangle();

    public JBlock(Vector2 v) {
        _position = v;
        _bounds.width = SIZE;
        _bounds.height = SIZE;
    }
    
    public Rectangle GetBounds(){return _bounds;}
    public Vector2 GetPos(){return _position;}
}
