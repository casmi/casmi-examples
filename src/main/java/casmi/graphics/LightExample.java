/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorMode;
import casmi.graphics.element.Sphere;
import casmi.graphics.object.Light;
import casmi.graphics.object.Light.LightMode;
import casmi.matrix.Vertex;

/**
 * Lighting example.
 * 
 * @see casmi.graphics.Graphics#ambientLight(float, float, float, Vertex)
 * @see casmi.graphics.Graphics#directionalLight(int, Color, float, float, float)
 * 
 * @author Y.Ban
 */
public class LightExample extends Applet {

    Sphere s = new Sphere(70);
    Color  c;
    Vertex v = new Vertex(100, 100, 100);
    Light l1,l2;
    int r=0;

    @Override
    public void setup() {
        setSize(800, 600);

        s.setStroke(true);
        s.setStrokeColor(new Color(100, 100, 200));
        
        c = new Color(0, 200, 150);
        c.setColorMode(ColorMode.HSB);
        
        l1 = new Light(LightMode.AMBIENT);
        l1.setColor(1, 1, 1);
        l1.setPosition(v);
        addLight(l1);
        
        l2 = new Light(LightMode.DIRECTION);
        l2.setColor(c);
        l2.setDirection(1, 0, 1);
        addLight(l2);
        
        setPosition(400, 300, 100);
        addObject(s);     
    }
    
    @Override
    public void update(){
    	c.setR(r);
    	r++;
    	if(r>=360)
    		r=0;
    }



    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.LightExample", "Light Example");
    }

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
