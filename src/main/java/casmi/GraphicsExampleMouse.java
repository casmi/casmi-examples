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
  
package casmi;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.element.Triangle;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class GraphicsExampleMouse extends Applet {
    
    Triangle t = new Triangle(100, 500, 600, 600, 1000, 500);
        
    public void setup(){
        setSize(1024, 768);
        t.setFillColor(new Color(230, 70, 70, 180));
        t.setStrokeColor(new Color(230, 70, 70, 255));
    }
    
    @Override
    public void draw(Graphics g) {
        t =  new Triangle(100, 500, getMouseX(), getMouseY(), 1000, 500);
        t.setFillColor(new Color(230, 70, 70, 180));
        t.setStrokeColor(new Color(230, 70, 70, 255));
        g.render(t);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.GraphicsExampleMouse", "Example");
    }
}
