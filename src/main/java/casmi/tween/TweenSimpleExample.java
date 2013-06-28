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
import casmi.graphics.element.Circle;
import casmi.tween.equations.Bounce;

/**
 * Simple tween example.
 *
 * @author Y. Ban
 */
public class TweenSimpleExample extends Applet {

	Circle circle;
	Tweener te;

	@Override
	public void setup() {
		setSize(800,600);

		circle = new Circle(100);
		circle.setPosition(400,500);
		addObject(circle);

		te = new Tweener(circle);
    	addTween(Tween.to(te, TweenType.POSITION, 3000, Bounce.OUT).addDelay(3000).target(200, 100).repeat(-1, 500));
	}

	@Override
	public void update() {}

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenSimpleExample", "TweenSimpleExample");
    }

}
