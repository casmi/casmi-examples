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
import casmi.graphics.element.Box;

/**
 * Example of Graphics.
 * 
 * @author Y. BAN
 * 
 */
public class GraphicsExampleBox extends Applet {

    Box b1 = new Box(256);
    Box b2 = new Box(256);
    
    double rot = 0.0;
    
    public void setup(){
        setSize(1024, 768);
        
        b1.setStrokeWidth(3);
        b1.setFillColor(new Color(100, 100, 100));
        b1.setStrokeColor(new Color(255, 255, 255));
     //   b1.setFill(false);
        
        b2.setStrokeWidth(3);
        b2.setFillColor(new Color(0, 0, 100, 120));
        b2.setStrokeColor(new Color(0, 0, 255));
    }
    
    @Override
    public void draw(Graphics g) {
    	g.pushMatrix();
    	
    	g.translate(500, 300);
        g.rotate(rot, 1f, 3f, 5f);
        g.render(b1);
        
        g.popMatrix();
        
        g.pushMatrix();

    	g.translate(500, 500, 1000);
        g.rotate(-rot, 1f, 3f, 5f);
        g.render(b2);
        b2.setFill(false);
        g.scale(1.2);
        g.render(b2);
        b2.setFill(true);
        
        g.popMatrix();
        
        rot += 0.1;
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleBox", "Example");
    }
}
