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
import casmi.graphics.element.Line;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class LineExample extends Applet {
    
    Line l1 = new Line(300, 200, 600, 600);
    Line l2 = new Line(300, 600, 600, 200);
    
    public void setup(){
        setSize(1024, 768);
        l1.setStrokeColor(new Color(255, 255, 255));
        l2.setStrokeColor(new Color(255, 255, 255));
        l1.setStrokeWidth(25);
        l2.setStrokeWidth(25);
    }
    
    @Override
    public void draw(Graphics g) {
        g.render(l1);
        g.render(l2);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.LineExample", "Example");
    }
}
