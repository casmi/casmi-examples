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
  
package casmi.graphics.mouseover;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.MouseOver;
import casmi.graphics.element.RoundRect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;


public class MouseOverColorSetExample extends Applet {
    
    List<RoundRect> rrList = new ArrayList<RoundRect>();
    List<MouseOver> moList = new ArrayList<MouseOver>();
    Font f;
    Text t;
    
    class ColorRoundrect {
        String colorname;
        RoundRect roundrect;
        MouseOver mouseover;
        ColorSet cset;

        ColorRoundrect(ColorSet set) {
        	cset = set;
            roundrect = new RoundRect(6, 0, 0, 52, 52);
            colorname = set.toString();
            roundrect.setFillColor(set);
            roundrect.setStrokeColor(ColorSet.WHITE);
            roundrect.setStrokeWidth(2.0f);
            roundrect.setStroke(false);
            mouseover = new MouseOver(roundrect);
        }
    }
    
    List<ColorRoundrect> crList = new ArrayList<ColorRoundrect>();
    
    public void setup(){
        setSize(1024, 768);

        for (ColorSet set : ColorSet.values() ) {
            ColorRoundrect cr = new ColorRoundrect(set);
            
            crList.add(cr);
        }
        
        f = new Font();
        f.setSize(35);
        t = new Text(null, f, 750, 710);
        t.setAlign(TextAlign.CENTER);
        t.setStrokeColor(ColorSet.WHITE);
    }
    
    @Override
    public void draw(Graphics g) {
        final float w = 65.0f; 
        final float h = 65.0f;
        
        int numRows = 14;
        
        int index = 0;
                  
        for ( ColorRoundrect cr : crList ) {
            g.pushMatrix();
            
            cr.roundrect.setXY(w*(index%numRows)+100, h*(index/numRows)+70);   
            if(cr.mouseover.isMouseOver(getMouseX(), getMouseY())){
            	cr.roundrect.setStroke(true);
            	t.setText(cr.colorname);
            	t.setStrokeColor(cr.cset);
                if(cr.colorname=="BLACK"){
                	t.setStrokeColor(ColorSet.WHITE);
                	g.render(t);
                	t.setStrokeColor(cr.cset);
                }
            	}
            else{
            	cr.roundrect.setStroke(false);
            	t.setText(" ");
            	}	
            g.render(cr.mouseover);
            
            g.popMatrix();
            g.render(t);
            index ++;
        }
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.mouseover.MouseOverColorSetExample", "Example");
    }
}
