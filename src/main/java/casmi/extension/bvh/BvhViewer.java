/*   casmi examples
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

package casmi.extension.bvh;

import java.util.ArrayList;
import java.util.List;

import casmi.extension.bvh.Bvh;
import casmi.extension.bvh.BvhBone;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Sphere;

/**
 * BvhViewer Class.
 * 
 * @author Y. Ban
 */

public class BvhViewer extends Bvh{
	private List<Sphere> sphereList; 

	public BvhViewer(String[] data) {
		super(data);
	}

	@Override
	public void updateObjects() {
		int index = 0;
		for( BvhBone b : parser.getBones())
	    {
	      sphereList.get(index).setPosition(640+b.absPos.getX(), 350+b.absPos.getY(), b.absPos.getZ());
	      index++;
	      if (!b.hasChildren())
	      {
	    	  sphereList.get(index).setPosition(640+b.absEndPos.getX(), 350+b.absEndPos.getY(), b.absEndPos.getZ());
	  	      index++;
	      } 
	    }
	}

	@Override
	public void addObjects() {
		sphereList = new ArrayList<Sphere>();
		  int index = 0;
			for( BvhBone b : parser.getBones())
		    {
		      Sphere s = new Sphere(2);
		      s.setPosition(b.absPos.getX(), b.absPos.getY(), b.absPos.getZ());	      
		      s.setStroke(false);
		      s.setFillColor(ColorSet.WHITE);
		      sphereList.add(s);
		      add(sphereList.get(index));
		      index++;
		      if (!b.hasChildren())
		      {
		    	  Sphere ss = new Sphere(10);
		    	  ss.setPosition(b.absEndPos.getX(), b.absEndPos.getY(), b.absEndPos.getZ());
			      ss.setStroke(false);
			      ss.setFillColor(ColorSet.WHITE);
		    	  sphereList.add(ss);
			      add(sphereList.get(index));
			      index++;
		      } 
		    }
		
	}

}
