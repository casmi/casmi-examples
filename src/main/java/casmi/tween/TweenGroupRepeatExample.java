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
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;
import casmi.tween.equations.Bounce;

/**
 * Example of TweenRepeat for TweenGroup.
 * 
 * @author Y. Ban
 */
public class TweenGroupRepeatExample extends Applet {

	Rect r1 = new Rect(200, 200);
	TweenElement te;
	
	@Override
	public void setup() {
		setSize(800,600);
		
		r1.setFillColor(ColorSet.AQUA);
		addObject(r1);
		r1.setPosition(150, 150);
		te = new TweenElement(r1);
		TweenSerialGroup ts = (TweenSerialGroup) TweenSerialGroup.create(
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(550,150),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(550,550),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(150,550),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(150,150)
				).addDelay(1000).repeat(10,300);
		addTween(ts);	
	}

	@Override
	public void update() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenGroupRepeatExample", "TweenGroupRepeatExample");
    }

}
