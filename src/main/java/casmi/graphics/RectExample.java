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
import casmi.graphics.color.Color;
import casmi.graphics.element.Rect;
import static casmi.graphics.color.ColorMode.*;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class RectExample extends Applet {
    
    Rect r1 = new Rect(500, 200);
    Rect r2 = new Rect(200, 400);
    Color c = new Color(20,100,100);
        
    public void setup(){
        setSize(1024, 768);
        c.colorMode(HSB);
        r1.setFillColor(c);
        r1.setStrokeColor(new Color(100, 240, 100));
        r1.setStrokeWidth(3);
        
        r2.setFill(false);
        r2.setStrokeWidth(5);
        r2.setStrokeColor(new Color(180, 80, 80));
    }
    
    @Override
    public void draw(Graphics g) {
    	g.pushMatrix();
    	g.translate(500, 300);
        g.render(r1);
        g.popMatrix();
        
        g.pushMatrix();
        g.translate(200, 300);
        g.render(r2);
        g.popMatrix();
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.RectExample", "Example");
    }
}
