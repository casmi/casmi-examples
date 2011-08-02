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
import casmi.graphics.element.Lines;

import static casmi.graphics.color.ColorMode.*;

/**
 * Example of Graphics.
 * 
 * @author Y. Ban
 * 
 */
public class GraphicsExampleLines extends Applet {

    Lines l, l2;
    Color c = new Color(20,250,200);
        
    public void setup(){
        setSize(1024, 768);
        l = new Lines();
        l.vertex(210, 120);
        l.vertex(280, 115);
        l.vertex(495, 390);
        l.vertex(240, 345);
        l.vertex(200, 445);
        l.setStrokeColor(new Color(100,255,100));
        

        c.colorMode(HSB);
        l2 = new Lines();
        l2.vertex(310, 20);
        l2.vertex(380, 115);
        l2.vertex(695, 290);
        l2.vertex(440, 345);
        l2.vertex(200, 445);
        l2.setStrokeColor(c);
        l2.setStrokeWidth(5);
    }
    
    @Override
    public void draw(Graphics g) {
        
        g.render(l);
        g.render(l2);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleLines", "Example");
    }
}
