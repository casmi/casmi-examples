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

package casmi.callback;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.canvas.Canvas;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Rect;

/**
 * MouseOverGroup example.
 *
 * @author Y. Ban
 */
public class MouseOverGroupExample extends Applet {

    class RectCanvas extends Canvas {

        Rect r1, r2;

        MouseOverCallback callback = new MouseOverCallback() {

            @Override
            public void run(MouseOverEventType eventType, Element element) {
                switch (eventType) {
                case ENTERED:
                    if (element == r1)
                        setCursor(CursorMode.HAND);
                    if (element == r2)
                        setCursor(CursorMode.CROSS);
                    break;
                case EXITED:
                    setCursor(CursorMode.DEFAULT);
                    break;
                default:
                    break;
                }
            }
        };

        public RectCanvas() {
            r1 = new Rect(100, 100);
            r1.setPosition(300, 300);
            r1.setStroke(false);
            r1.setFillColor(ColorSet.CHARTREUSE);

            r2 = new Rect(100, 200);
            r2.setPosition(500, 200);
            r2.setStroke(false);
            r2.setFillColor(ColorSet.TOMATO);

            r1.addMouseEventCallback(callback);
            r2.addMouseEventCallback(callback);

            this.add(r1);
            this.add(r2);
        }
    }

    @Override
    public void setup() {
        setSize(800, 600);

        RectCanvas r1 = new RectCanvas();
        r1.setPosition(0, 0);
        addCanvas(r1);

        RectCanvas r2 = new RectCanvas();
        r2.setPosition(200, 100);
        addCanvas(r2);
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
        AppletRunner.run("casmi.callback.MouseOverGroupExample", "MouseOverGroupExample");
    }
}
