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
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Line;

/**
 * Example of Noise.
 * 
 * @author Y.Ban
 */
public class NoiseExample extends Applet {

	Line[] lines;
	float noiseScale;
	RGBColor c = new RGBColor(0.0);
	float noiseValue = 0;

	@Override
	public void setup() {
		setSize(1024, 768);
		lines = new Line[getWidth()];
		for (int i = 0; i < getWidth(); i++) {
			lines[i] = new Line();
			addObject(lines[i]);
		}
		noiseScale = 0.02f;
	}
	
	@Override
	public void update() {
		for (int x = 0; x < getWidth(); x++) {
			noiseValue = Noise.noise((getMouseX() + x) * noiseScale, 
									getMouseY() * noiseScale);
					
			c.setGray(noiseValue);
			lines[x].setStrokeColor(c);
			lines[x].set(x, getMouseY() + noiseValue * 80, x, getHeight());
		}
	}

	@Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}
	
	public static void main(String[] args) {
		AppletRunner.run("casmi.util.NoiseExample", "Noise Example");
	}

}
