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
import casmi.callback.MouseClickCallback;
import casmi.callback.MouseClickEventType;
import casmi.graphics.canvas.Canvas;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;

/**
 * Object removal example.
 *
 * @author Y. Ban
 */
public class RemoveExample extends Applet {

    Canvas canvas;
    Triangle t1, t2;
    Rect r1, r2;

	class RemoveElementCallback implements MouseClickCallback {
	    @Override
	    public void run(MouseClickEventType eventType, Element element) {
	        if(eventType == MouseClickEventType.CLICKED) {
	            removeObject(element);
	        }
	    }
	}

	class RemoveCanvasCallback implements MouseClickCallback {
        @Override
        public void run(MouseClickEventType eventType, Element element) {
            if(eventType == MouseClickEventType.CLICKED) {
                removeCanvas(canvas);
            }
        }
    }

	@Override
	public void setup() {
		setSize(800, 600);

		canvas = new Canvas();

        t1 = new Triangle(100, 100, 200, 100, 150, 150);
        t1.setStroke(false);
        t1.setFillColor(ColorSet.CYAN);
        t1.addMouseEventCallback(new RemoveCanvasCallback());
        canvas.add(t1);

        t2 = new Triangle(10, 10, 30, 10, 20, 20);
        t2.setStroke(false);
        t2.setFillColor(ColorSet.FIREBRICK);
        t2.addMouseEventCallback(new RemoveCanvasCallback());
        canvas.add(t2);

        addCanvas(canvas);

		r1 = new Rect(100, 100);
		r1.setPosition(700,200);
		r1.setFillColor(ColorSet.ALICE_BLUE);
		r1.addMouseEventCallback(new RemoveElementCallback());

		r2 = new Rect(200, 120);
		r2.setPosition(200,500);
		r2.setFillColor(ColorSet.CHOCOLATE);
		r2.addMouseEventCallback(new RemoveElementCallback());

		addObject(r2);
		addObject(r1);
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
        AppletRunner.run("casmi.graphics.RemoveExample", "RemoveExample");
    }
}
