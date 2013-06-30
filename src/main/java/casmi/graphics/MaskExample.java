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
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Texture;
import casmi.graphics.object.Mask;

/**
 * Mask example.
 *
 * @author Y. Ban
 *
 * @see casmi.graphics.object.Mask
 */
public class MaskExample extends Applet {

    static final String IMAGE_PATH = Applet.class.getResource("sora.png").getPath();

    Mask    mask;
	Circle  circle;
	Texture tex;

	@Override
	public void setup() {
		setSize(1024, 768);

		mask = new Mask();

		circle = new Circle(60);
		circle.setPosition(300, 300);

		tex = new Texture(IMAGE_PATH);

		mask.add(circle);

		tex.setPosition(getWidth() / 2.0, getHeight() / 2.0);
		tex.setMask(mask);
		addObject(tex);
	}

	@Override
	public void update() {}

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseStatus e, MouseButton b) {
		if (e == MouseStatus.DRAGGED || e == MouseStatus.PRESSED) {
			circle.setPosition(getMouseX(), getMouseY());
		}
	}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
	    AppletRunner.run("casmi.graphics.MaskExample", "Mask Example");
	}

}
