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
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.RoundRect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

/**
 * Example of MouseOver.
 * 
 * @author Y. Ban
 * 
 */
public class MouseOverColorSetExample extends Applet {
    
    List<RoundRect> rrList = new ArrayList<RoundRect>();
    List<ColorRoundrect> crList = new ArrayList<ColorRoundrect>();
    Font f;
    Text t,backt;
    MouseOverCallback callback;
      int index;
      
      class ColorRoundrect {
          String colorname;
          RoundRect roundrect;
          ColorSet cset;
          int index;

          ColorRoundrect(ColorSet set) {
          	cset = set;
              roundrect = new RoundRect(6, 0, 0, 52, 52);
              colorname = set.toString();
              roundrect.setFillColor(set);
              roundrect.setStrokeColor(ColorSet.WHITE);
              roundrect.setStrokeWidth(2.0f);
              roundrect.setStroke(false);
          }
      }
      
      
    
    public void setup(){
        setSize(1024, 768);
        final float w = 65.0f; 
        final float h = 65.0f;
        
        int numRows = 14;
        index = 0;
        
        for (ColorSet set : ColorSet.values() ) {
            ColorRoundrect cr = new ColorRoundrect(set);
            
            crList.add(cr);
        }
        f = new Font("San-Serif", FontStyle.BOLD_ITALIC, 43);
        t = new Text(" ",f);
        backt = new Text(" ",f);
        t.setAlign(TextAlign.CENTER);
        t.setStrokeColor(ColorSet.WHITE);
        t.setPosition(770, 710);
        backt.setAlign(TextAlign.CENTER);
        backt.setStrokeColor(ColorSet.WHITE);
        backt.setPosition(770, 710);
        
        index = 0;
        for(final ColorRoundrect cr : crList ){
        	callback = new MouseOverCallback(){

				@Override
				public void run(MouseOverTypes eventtype,
						Element element) {

            		if(eventtype == MouseOverTypes.ENTERED){
            			element.setStroke(true);
            			t.setText(cr.colorname);
            			backt.setText(cr.colorname);
                    	t.setStrokeColor(cr.cset);
            		}
            		if(eventtype == MouseOverTypes.EXITED){
            			t.setText(" ");
            			backt.setText(" ");
            			element.setStroke(false);
            		}
					
				}

				
            };
        	cr.roundrect.setPosition(w*(index%numRows)+100, h*(index/numRows)+70); 
        	cr.roundrect.addMouseEventCallback(callback);
        	cr.index = index;
        	addObject(cr.roundrect);
        	index ++;
        }
        addObject(backt);
        addObject(t);
    }
    
   
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.mouseover.MouseOverColorSetExample", "Example");
    }


	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
