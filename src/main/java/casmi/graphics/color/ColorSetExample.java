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
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.RoundRect;

/**
 * Example of Graphics.
 * 
 * @author K. Nishimura
 * 
 */
public class ColorSetExample extends Applet {
    
    List<RoundRect> rrList = new ArrayList<RoundRect>();
    
    public void setup(){
        setSize(1024, 768);
        final float w = 65.0f; 
        final float h = 65.0f;
        
        int numRows = 14;
        int index = 0;
        
        for (ColorSet set : ColorSet.values() ) {
            RoundRect rr = new RoundRect(6, 0, 0, 52, 52);
            rr.setFillColor( Color.color(set) );
            rr.setStroke(false);
            rr.setXY(w*(index%numRows), h*(index/numRows)); 
            rrList.add(rr);
            index++;
        }
       
        
        setPosition(100, 70);
        for ( RoundRect rr : rrList ) {
        	addObject(rr);
        }
    }
    
   
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.color.ColorSetExample", "Example");
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