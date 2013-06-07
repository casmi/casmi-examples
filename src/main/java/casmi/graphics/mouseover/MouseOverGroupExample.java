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

package casmi.graphics.mouseover;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;
import casmi.graphics.group.Group;

/**
 * MouseOverGroup example.
 *
 * @author Y. Ban
 */
public class MouseOverGroupExample extends Applet {

    class TriangleGroup extends Group {

        Triangle t1, t2;

        public TriangleGroup() {
            setup();
        }

        @Override
        public void setup() {
            t1 = new Triangle(100, 100, 200, 100, 150, 150);
            t1.setStroke(false);
            t1.setFillColor(ColorSet.CYAN);
            add(t1);

            t2 = new Triangle(10, 10, 30, 10, 20, 20);
            t2.setStroke(false);
            t2.setFillColor(ColorSet.FIREBRICK);
            add(t2);
        }

        @Override
        public void update() {}
    }

    class RectGroup extends Group {

        Rect r1, r2;

        MouseOverCallback mouseoverrect;

        public RectGroup() {
            setup();
        }

        @Override
        public void setup() {
            r1 = new Rect(100, 100);
            r1.setPosition(300, 300);
            r1.setStroke(false);
            r1.setFillColor(ColorSet.CHARTREUSE);

            r2 = new Rect(100, 200);
            r2.setPosition(500, 200);
            r2.setStroke(false);
            r2.setFillColor(ColorSet.TOMATO);

            mouseoverrect = new MouseOverCallback() {

                @Override
                public void run(MouseOverTypes eventtype, Element element) {
                    switch (eventtype) {
                    case ENTERED:
                        if (element == r1)
                            setCursor(CursorMode.HAND);
                        if (element == r2)
                            setCursor(CursorMode.CROSS);
                        element.setFillColor(ColorSet.WHITE);
                        break;
                    case EXITED:
                        setCursor(CursorMode.DEFAULT);
                        break;
                    }
                }
            };

            r1.addMouseEventCallback(mouseoverrect);
            r2.addMouseEventCallback(mouseoverrect);

            this.add(r1);
            this.add(r2);
        }

        @Override
        public void update() {}
    }

    Circle        circle;
    RectGroup     rectGroup1, rectGroup2;
    TriangleGroup triangleGroup1, triangleGroup2;

    @Override
    public void setup() {
        setSize(800, 600);

        circle = new Circle(20);
        circle.setPosition(300, 100);
        circle.setFillColor(ColorSet.DARK_VIOLET);
        circle.addMouseEventCallback(new MouseOverCallback() {

            @Override
            public void run(MouseOverTypes eventtype, Element element) {
                switch (eventtype) {
                case ENTERED:
                    setCursor(CursorMode.CROSS);
                    element.setFillColor(ColorSet.WHEAT);
                    break;
                case EXITED:
                    setCursor(CursorMode.DEFAULT);
                    element.setFillColor(ColorSet.DARK_VIOLET);
                    break;
                }
            }
        });
        addObject(circle);

        rectGroup1 = new RectGroup();
        rectGroup1.setPosition(0, 0);
        rectGroup2 = new RectGroup();
        rectGroup2.setPosition(200, 100);
        addObject(rectGroup2);
        addObject(rectGroup1);

        triangleGroup1 = new TriangleGroup();
        addObject(triangleGroup1);

        triangleGroup2 = new TriangleGroup();
        triangleGroup2.setPosition(200, 200);
        triangleGroup2.addMouseEventCallback(new MouseOverCallback() {

            @Override
            public void run(MouseOverTypes eventtype, Element element) {
                System.out.println("hogehoge");
                switch (eventtype) {
                case ENTERED:
                    circle.setScaleX(1.5);
                    break;
                case EXITED:
                    circle.setScaleX(1.0);
                    break;
                }
            }
        });
        addObject(triangleGroup2);
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
        AppletRunner.run("casmi.graphics.mouseover.MouseOverGroupExample", "MouseOverGroupExample");
    }
}
