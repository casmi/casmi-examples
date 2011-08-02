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
import casmi.graphics.element.Bezier;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class GraphicsExampleRotate extends Applet {

    Bezier b1 = new Bezier(0.0,0.0,0.0, 400.0,400.0,-30.0,
                           500.0,600.0,-10.0, 400.0,100.0,-20.0);
    
    public void setup(){
        setSize(1024, 768);
        b1.setFill(false);
        b1.setStrokeColor(new Color(200, 80, 80));
        b1.setStrokeWidth(3);
    }
    
    @Override
    public void draw(Graphics g) {

        g.pushMatrix();
        
        g.translate(700, 200, 0);
        
        for(int i=0; i<36; i++){
            g.render(b1);
            g.rotateZ(5);
            g.render(b1);
        }
        
        g.popMatrix();

    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleRotate", "Example");
    }
}
