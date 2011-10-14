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

package casmi.timeline;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
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
	    }
	    
	    @Override
	    public void draw(Graphics g) {
	    	g.render(tl);
	    }
	    
	    public static void main(String args[]) {
	        AppletRunner.run( "casmi.timeline.TimelineExample", "Example");
	    }

}
