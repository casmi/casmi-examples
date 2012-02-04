/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011-2012, Xcoo, Inc.
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
  
package casmi.tween;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorMode;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Circ;
import casmi.tween.equations.Linear;

/**
 * Example of Tween.
 * 
 * @author Y. Ban
 * 
 */
public class TweenExample extends Applet {

	Rect r1 = new Rect(500, 200);
	Rect r2 = new Rect(150, 150);
	Color c = new Color(20, 100, 100);
	TweenElement te, te2;
	
	public void setup() {
		setSize(1024, 768);
		c.setColorMode(ColorMode.HSB);
		r1.setFillColor(c);
		r1.setStrokeColor(new Color(100, 240, 100));
		r1.setStrokeWidth(3);
		r2.setFill(false);
		r2.setStrokeColor(Color.color(ColorSet.AQUA));
		setPosition(500, 600);
		addObject(r1);
		addObject(r2);
		te = new TweenElement(r1);
		te2 = new TweenElement(r2);
	}

	@Override
    public void update() {}
	
	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if (e == MouseEvent.PRESSED) {
			clearTween();
			te.reset();
			te2.reset();
			
			TweenSerialGroup tsg = TweenSerialGroup.create(
					Tween.to(te, TweenType.POSITION, 2000, Bounce.OUT)
							.target(20, -400),
					TweenParallelGroup
							.create(
									Tween.to(te, TweenType.ALPHA, 2000,
											Linear.INOUT).target(100.0f),
									Tween.to(te, TweenType.POSITION, 1000,
											Circ.OUT).target(500, -400)
											.addDelay(5000)),
					TweenParallelGroup
							.create(
									Tween.to(te2, TweenType.SCALE_X, 2000,
											Bounce.OUT).target(1.5f),
									Tween.to(te2, TweenType.ALPHA, 2000,
											Linear.INOUT).target(0.0f)));
			addTween(tsg);
		}
	}

	@Override
	public void keyEvent(KeyEvent e) {}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenExample", "Example");
    }
}
