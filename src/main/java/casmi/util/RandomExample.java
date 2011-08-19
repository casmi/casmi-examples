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
  
package casmi.util;


import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.element.Line;
import casmi.util.Random;


/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class RandomExample extends Applet {
    
   Line l[];
   Color c = new Color(0);

    
    public void setup(){
        setSize(1024, 768);
        l = new Line[height];
        for(int i=0; i<height; i++)
            l[i]= new Line();
    }
    
    @Override
    public void draw(Graphics g) {
        for(int i=0; i<height; i++){
            float r = Random.random(-width/2, width/2);
            c.setGray((int)(Math.abs(r*5)));
            l[i].setStrokeColor(c);
            l[i].set(width/2,i,width/2+r,i);
            g.render(l[i]);
        }
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.util.RandomExample", "Example");
    }
}
