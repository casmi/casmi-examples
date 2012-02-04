/*
 *   casmi
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 *  casmi is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package casmi.timeline;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.timeline.Timeline.DisolveMode;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class TimelineExample extends Applet  {
	
	  Timeline tl = new Timeline();
	  Scene0 s0 = new Scene0(0,8);
	  Scene1 s1 = new Scene1(1,6);
	  Scene2 s2 = new Scene2(2,6);
	  Scene3 s3 = new Scene3(3,6);
	    
	    public void setup(){
	        setSize(1024, 768);
	        tl.appendScene(s0);
	        tl.appendDisolve(3,DisolveMode.NORMAL);
	        tl.appendScene(s1);
	        tl.appendDisolve(2);
	        tl.appendScene(s2);
	        tl.appendDisolve(2);
	        tl.appendScene(s3);
	        tl.appendDisolve(2,DisolveMode.NORMAL);
	        
	        tl.startTimer();
	        
	        addObject(tl);
	    }
	    
	    public static void main(String args[]) {
	        AppletRunner.run( "casmi.timeline.TimelineExample", "Example");
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
