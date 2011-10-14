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

import casmi.graphics.Graphics;
import casmi.image.Image;
import casmi.util.SystemUtil;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class Scene0 extends Scene{

    Image image = null;
    double rot = 0.0;
	
	public Scene0(int id,double time){
		setId(id);
		setTime(time);
		setup();
	}
	
	
	
	public void setup(){
		image = new Image( getClass().getResource("/logo.png") );
	}
	
	public void draw(Graphics g){
		  g.pushMatrix();
	        
	        g.translate(300, 300);
	        g.rotateY(rot);

	        g.setcolor(255);
	        g.texture(image);
	        g.beginShape();
	        g.vertex(-180, 20, 0, 1);
	        g.vertex(180, 20, 1, 1);
	        g.vertex(180, 93, 1, 0);
	        g.vertex(-180, 93, 0, 0);
	        g.endShape();
	        g.notexture(image);
	        
	      g.popMatrix();
	        
	        rot += 1.0;
	}
}
