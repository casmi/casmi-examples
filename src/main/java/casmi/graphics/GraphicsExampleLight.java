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

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorMode;
import casmi.graphics.element.Sphere;
import casmi.matrix.Vertex;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class GraphicsExampleLight extends Applet {

	Sphere s = new Sphere(70.0);
	Color c;
	Vertex v = new Vertex(100, 100, 100);
	int h = 0, t = 0;

	public void setup() {
		setSize(1024, 768);

		c = new Color(h, 200, 150);
		s.setStroke(true);
		s.setStrokeColor(new Color(100, 100, 200));
		c.colorMode(ColorMode.HSB);
	}

	@Override
	public void draw(Graphics g) {
		g.pushMatrix();
		
		g.translate(512.0, 430.0, 100.0);
		
		// setup ambient light
		g.ambientLight(1, 1, 1, v);
		
		// setup directional light
		c.setR(h);
		g.directionalLight(1, c, 1.0f, 0.0f, 1.0f);
		
		// render
		g.render(s);
		
		g.popMatrix();
		
		t++;
		if (t % 3 == 0)
			h += 1;
		if (h >= 360) {
			t = h = 0;
		}
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.graphics.GraphicsExampleLight", "Example");
	}
}
