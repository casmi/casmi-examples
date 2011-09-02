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
import casmi.graphics.element.Arc;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class GraphicsExampleArc extends Applet {

    Arc a = new Arc(500.0, 400.0, 400.0, 20.0, 160.0, 1.0);
    
    public void setup() {
        setSize(1024, 768);

        a.setFillColor(new Color(70, 180, 70));
        a.setStrokeColor(new Color(120, 240, 120));
        a.setStrokeWidth(3);
    }

    @Override
    public void draw(Graphics g) {
        g.render(a);
    }
        
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleArc", "Example");
    }
}
