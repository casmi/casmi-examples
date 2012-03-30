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
import casmi.graphics.color.HSBColor;
import casmi.graphics.element.Rect;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class RectExample extends Applet {
    
    Rect r1 = new Rect(500, 200);
    Rect r2 = new Rect(200, 400);
    Color c = new HSBColor(0.1, 0.4, 0.4);
        
    @Override
    public void setup() {
        setSize(1024, 768);
        
        r1.setFillColor(c);
        r1.setStrokeColor(new HSBColor(0.4, 0.9, 0.4));
        r1.setStrokeWidth(3);
        r1.setPosition(500, 300);
        
        r2.setFill(false);
        r2.setStrokeWidth(5);
        r2.setStrokeColor(new HSBColor(0.7, 0.3, 0.3));
        r2.setPosition(200, 300);
        
        addObject(r1);
        addObject(r2);
    }
    
    @Override
    public void update() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.RectExample", "RectExample");
    }

}
