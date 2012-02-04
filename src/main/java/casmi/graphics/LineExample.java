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
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;

/**
 * Line example.
 * 
 * @see casmi.graphics.element.Line
 * 
 * @author K. Nishimura
 * 
 */
public class LineExample extends Applet {

    Line l1 = new Line(200, 200, 600, 400);
    Line l2 = new Line(200, 400, 600, 200);

    @Override
    public void setup() {
        setSize(800, 600);
        
        l1.setStrokeColor(ColorSet.WHITE);
        l2.setStrokeColor(ColorSet.WHITE);
        
        l1.setStrokeWidth(25);
        l2.setStrokeWidth(25);
       // l1.setPosition(100,100);
        addObject(l1);
        addObject(l2);
    }

    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.LineExample", "Line Example");
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
