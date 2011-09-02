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
  
package casmi.graphics.color;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Roundrect;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class GraphicsExampleColorSet extends Applet {
    
    List<Roundrect> rrList = new ArrayList<Roundrect>();
    
    public void setup(){
        setSize(1024, 768);

        for (ColorSet set : ColorSet.values() ) {
            Roundrect rr = new Roundrect(6, 0, 0, 40, 40);
            rr.setFillColor( Color.color(set) );
            rr.setStroke(false);
            
            rrList.add(rr);
        }
    }
    
    @Override
    public void draw(Graphics g) {
        final float w = 65.0f; 
        final float h = 65.0f;
        
        int numRows = 14;
        
        int index = 0;
        
        g.translate(100, 70);
                
        for ( Roundrect rr : rrList ) {
            g.pushMatrix();
            
            g.translate(w*(index%numRows), h*(index/numRows));            
            g.render(rr);
            
            g.popMatrix();
            
            index ++;
        }
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.color.GraphicsExampleColorSet", "Example");
    }
}
