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
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Circle;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class CircleExample extends Applet {
    
    Circle cl = new Circle(100);
        
    public void setup(){
        setSize(1024, 768);

        cl.setFillColor(new Color(80, 180, 80));
        cl.setStrokeColor(ColorSet.LIGHTCORAL);
        cl.setStrokeWidth(3);
    }
    
    @Override
    public void draw(Graphics g) {
    	g.translate(200,300);
        g.render(cl);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.CircleExample", "Example");
    }
}
