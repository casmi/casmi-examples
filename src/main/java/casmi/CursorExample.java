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

import casmi.graphics.color.Color;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;

/**
 * Cursor example.
 * 
 * @see casmi.Applet
 * @see casmi.Applet.CursorMode
 * 
 * @author Y. Ban
 */
public class CursorExample extends Applet {

	Circle circle = new Circle(400, 300, 50);

	@Override
	public void setup() {
		setSize(800, 600);
		
		circle.setFillColor(new Color(100, 100));
		circle.addMouseEventCallback(new MouseOverCallback() {
            @Override
            public void run(MouseOverTypes eventtype, Element element) {
                if (eventtype == MouseOverTypes.EXISTED) {
                    cursor(CursorMode.HAND);
                } else {
                    cursor(CursorMode.DEFAULT);
                }
            }
        });
		addObject(circle);
	}
	
	@Override
	public void update() {}
	
	@Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
		AppletRunner.run("casmi.CursorExample", "Cursor Example");
	}
}