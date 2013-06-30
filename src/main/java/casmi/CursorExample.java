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

package casmi;

import casmi.callback.MouseOverCallback;
import casmi.callback.MouseOverEventType;
import casmi.graphics.color.GrayColor;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;

/**
 * Cursor example.
 *
 * @see casmi.Applet.CursorMode
 *
 * @author Y. Ban
 */
public class CursorExample extends Applet {

	Circle circle = new Circle(400.0, 300.0, 50.0);

	@Override
	public void setup() {
		setSize(800, 600);

		circle.setFillColor(new GrayColor(0.4));

		circle.addMouseEventCallback(new MouseOverCallback() {

            @Override
            public void run(MouseOverEventType eventType, Element element) {
                switch (eventType) {
                case ENTERED:
                case EXISTED:
                    setCursor(CursorMode.HAND);
                    break;
                case EXITED:
                    setCursor(CursorMode.DEFAULT);
                    break;
                }
            }
        });

		addObject(circle);
	}

	@Override
	public void update() {}

	@Override
    public void exit() {}

	@Override
    public void mouseEvent(MouseStatus e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
		AppletRunner.run("casmi.CursorExample", "CursorExample");
	}

}
