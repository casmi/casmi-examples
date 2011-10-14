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
import casmi.graphics.element.Cone;

/**
 * Example of Graphics.
 * 
 * @author Y. Ban
 * 
 */
public class ConeExample extends Applet {
    
    Cone s = new Cone(300.0,300);
    
    double rot = 90.0;
    
    public void setup(){
        setSize(1024, 768);
        s.setFill(false);
        s.setStrokeColor(new Color(100, 100, 200));
        s.setStrokeWidth(4);
    }
    
    @Override
    public void draw(Graphics g) {
    	g.translate(512.0,430.0, 100.0);
        g.render(s);
        
        rot += 0.1;
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.ConeExample", "Example");
    }
}
