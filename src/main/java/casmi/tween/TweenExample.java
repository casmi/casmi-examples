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
import casmi.MouseStatus;
import casmi.graphics.color.Color;
import casmi.graphics.color.HSBColor;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Rect;
import casmi.matrix.Vector2D;
import casmi.tween.equations.QuadraticInOut;
import casmi.tween.equations.SinusoidalInOut;

/**
 * Example of Tween.
 *
 * @author Y. Ban
 *
 */
public class TweenExample extends Applet {

	Rect r = new Rect(500, 200);
	Color c = new HSBColor(0.1, 0.4, 0.4);
	Tweener t;

	@Override
	public void setup() {
		setSize(1024, 768);

		r.setFillColor(c);
		r.setStrokeColor(new RGBColor(0.4, 0.9, 0.4));
		r.setStrokeWidth(3);

		r.setPosition(500, 600);
		addObject(r);

		t = new Tweener(r);
        t.animatePosition(new Vector2D(500, 200), 2000, QuadraticInOut.class);
        t.animateStrokeAlpha(0.0, 2000, SinusoidalInOut.class);
        t.animateRotation(180, 2000, QuadraticInOut.class);

        addTweener(t);
//        t.start();
	}

	@Override
    public void update() {}

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseStatus e, MouseButton b) {
		if (e == MouseStatus.CLICKED) {
		    t.reset();
		    t.start();
		}
	}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenExample", "TweenExample");
    }
}