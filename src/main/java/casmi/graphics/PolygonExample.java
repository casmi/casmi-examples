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
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.element.Polygon;

/**
 * Example of Graphics.
 * 
 * @author Y. Ban
 * 
 */
public class PolygonExample extends Applet {
    
    Polygon poly, poly2;
        
    public void setup(){
        setSize(1024, 768);
        poly = new Polygon();
        poly.vertex(210, 120);
        poly.vertex(280, 115);
        poly.vertex(495, 390);
        poly.vertex(240, 345);
        poly.vertex(200, 445);
        

        poly2 = new Polygon();
        poly2.vertex(310, 20);
        poly2.vertex(380, 115);
        poly2.vertex(695, 290);
        poly2.vertex(440, 345);
        poly2.vertex(200, 445);
        poly2.setFill(false);
        poly2.setStrokeColor(new Color(200,0,100));
        poly2.setStrokeWidth(7);
    }
    
    @Override
    public void draw(Graphics g) {
        
        g.render(poly);
        g.render(poly2);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.PolygonExample", "Example");
    }
}
