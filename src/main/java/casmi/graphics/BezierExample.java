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
import casmi.graphics.element.Bezier;

/**
 * Bezier example.
 * 
 * @see casmi.graphics.element.Bezier
 * 
 * @author K. Nishimura
 */
public class BezierExample extends Applet {

    Bezier b1 = new Bezier(100, 200, 200, 400, 300, 300, 400, 200);
    Bezier b2 = new Bezier(400, 200, 500, 100, 700, 300, 700, 500);
    Bezier b3 = new Bezier(100, 200, -20, 700, 400, -100, 300, 600, -50, 700, 500, -70);

    public void setup() {
        setSize(800, 600);

        b1.setFill(false);
        b2.setFill(false);
        b3.setFill(false);
        
        b1.setStrokeColor(new Color(200, 80, 80));
        b2.setStrokeColor(new Color(80, 200, 80));
        b3.setStrokeColor(new Color(80, 80, 200));
        
        b1.setStrokeWidth(5);
        b2.setStrokeWidth(5);
        b3.setStrokeWidth(5);
        
        addObject(b1);
        addObject(b2);
        addObject(b3);
    }


    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.BezierExample", "Bezier Example");
    }


	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
