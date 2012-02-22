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
 * Random example.
 * 
 * @author Y.Ban
 */
public class RandomExample extends Applet {

    Line l[];
    RGBColor c = new RGBColor(0.0);

    @Override
    public void setup() {
        setSize(1024, 768);
        l = new Line[getHeight()];
        for (int i = 0; i < getHeight(); i++) {
            l[i] = new Line();
            addObject(l[i]);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < getHeight(); i++) {
            float r = Random.random(-getWidth() / 2, getWidth() / 2);
            c.setGray(Math.abs(r * 5) / getWidth());
            l[i].setStrokeColor(c);
            l[i].set(getWidth() / 2, i, getWidth() / 2 + r, i);
        }
    }    

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.util.RandomExample", "Random Example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
