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

import casmi.graphics.element.Texture;
import casmi.util.SystemUtil;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

public class Scene0 extends Scene{

	 Texture tex = null;
	    
	    
	   // String imagePath = ".." + SystemUtil.FILE_SEPARATOR + "rsrc" + SystemUtil.FILE_SEPARATOR + "logo.png";  // TODO can not work when running as Java Application
	   // String imagePath = "rsrc" + SystemProperty.FILE_SEPARATOR + "logo.png";
	    String imagePath = "rsrc" + SystemUtil.FILE_SEPARATOR + "logo.png";
	    
	    double rot = 0.0;
	
	public Scene0(int id,double time){
		setId(id);
		setTime(time);
		setup();
	}
	
	    
	    public void setup(){
	        System.out.println(SystemUtil.USER_DIR);
	       tex = new Texture(imagePath);
	       tex.setX(200);
	       tex.setY(500);
	       tex.setWidth(tex.getWidth()/1.2);
	       tex.setRotation(rot,0.0,1.0,0.0);
	       addObject(tex);
	    }
	    
	    @Override
	    public void updateFunc(){
	    	rot+=2.0;
	    	tex.setRotation(rot,0.0,1.0,0.0);
	    }
}
