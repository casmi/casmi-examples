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

package casmi.util;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.element.Line;
import casmi.util.Noise;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 * 
 */
public class NoiseExample extends Applet {

	Line l[];
	float noiseScale;
	Color c = new Color(0);
	float noiseVal = 0f;

	public void setup() {
		setSize(1024, 768);
		l = new Line[width];
		for (int i = 0; i < width; i++)
			l[i] = new Line();
	}

	@Override
	public void draw(Graphics g) {
		noiseScale = 0.02f;
		for (int x = 0; x < width; x++) {
			noiseVal = Noise.noise((getMouseX() + x) * noiseScale, 
									getMouseY() * noiseScale);
					
			c.setGray((int) (noiseVal * 255));
			l[x].setStrokeColor(c);
			l[x].set(x, getMouseY() + noiseVal * 80, x, height);
			g.render(l[x]);
		}
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.util.NoiseExample", "Example");
	}
}
