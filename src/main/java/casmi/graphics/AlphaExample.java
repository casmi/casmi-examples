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

import static casmi.graphics.color.ColorMode.HSB;
import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.color.Color;
import casmi.graphics.element.Rect;
/**
 * Example of Graphics.
 * 
 * @author Y. Ban
 * 
 */
public class AlphaExample extends Applet {
    
    Rect r1 = new Rect(300, 300);
    Rect r2 = new Rect(300, 300);
    Color c = new Color(20,100,100);
    int alpha = 250;
        
    public void setup(){
        setSize(1024, 768);
        c.colorMode(HSB);
        r1.setStroke(false);
        r1.setFillColor(new Color(100, 240, 100, 150));
        
        r2.setStroke(false);
        r2.setFillColor(new Color(180, 20, 20, 150));
//        r2.rectMode(CENTER);
    }
    
    @Override
    public void draw(Graphics g) {
        g.background(240);
        if(getKey()=='a')
            alpha+=1;
        if(getKey()=='A')
            alpha-=1;
        
        g.pushMatrix();
        g.translate(500, 400);
        g.render(r1);
        g.popMatrix();
        
        g.pushMatrix();
        g.translate(600, 500);
        g.render(r2);
        g.popMatrix();
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.AlphaExample", "Example");
    }
}
