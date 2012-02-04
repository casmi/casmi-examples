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
import casmi.graphics.element.Quad;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class QuadExample extends Applet {
    
    Quad q1 = new Quad(500, 200, 600, 200, 700, 800, 300, 500);
    Quad q2 = new Quad(200, 300, 300, 300, 200, 500, 300, 400);
        
    public void setup(){
        setSize(1024, 768);

        q1.setFillColor(new Color(80, 180, 80));
        q1.setStrokeColor(new Color(100, 220, 100));
        q2.setFill(false);
        q2.setStrokeWidth(5);
        q2.setStrokeColor(new Color(180, 80, 80));
        
        addObject(q1);
        addObject(q2);
    }
    
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.QuadExample", "Example");
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
