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
import casmi.graphics.element.MouseEventCallback.MouseOverTypes;
import casmi.graphics.group.Group;

/**
 * MouseOverGroup example.
 * 
 * @author Y. Ban
 */
public class MouseOverExampletmp extends Applet {

    Circle circle = new Circle(20);
    Circle circle2 = new Circle(10);
    MouseOverCallback mouseoverCircle;

    class TriangleGroup extends Group {

        Triangle t1, t2;
        MouseOverCallback mouseovertriangle;

        public TriangleGroup() {
            setup();
        }

        @Override
        public void setup() {
            t1 = new Triangle(100, 100, 200, 100, 150, 150);
            t2 = new Triangle(10, 10, 30, 10, 20, 20);
            t1.setStroke(false);
            t1.setFillColor(ColorSet.CYAN);
            t2.setStroke(false);
            t2.setFillColor(ColorSet.FIREBRICK);
            this.add(t1);
            this.add(t2);
            
            mouseovertriangle = new MouseOverCallback() {

                @Override
                public void run(MouseOverTypes eventtype,
                    Element element) {
                    switch (eventtype) {
                    case ENTERED:
                        if (element == t1)
                            setCursor(CursorMode.WAIT);
                        else if (element == t2)
                            setCursor(CursorMode.TEXT);
                        break;
                    case EXITED:
                        setCursor(CursorMode.DEFAULT);
                        break;
                    }
                }
            };

            t1.addMouseEventCallback(mouseovertriangle);
            
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
            r1.setStroke(false);
            r1.setFillColor(ColorSet.CHARTREUSE);
            r2 = new Rect(100, 200);
            r2.setStroke(false);
            r2.setFillColor(ColorSet.TOMATO);

            r1.setPosition(300, 300);
            r2.setPosition(500, 200);
        }

        @Override
        public void update() {}
    }

    TriangleGroup triangleGroup1, triangleGroup2;
    MouseOverCallback mouseoverTriangles;

    @Override
    public void setup() {
        setSize(800, 600);
        
        triangleGroup1 = new TriangleGroup();
        triangleGroup2 = new TriangleGroup();
        circle.setFillColor(ColorSet.DARK_VIOLET);
        circle2.setFillColor(ColorSet.AQUA);
        mouseoverTriangles = new MouseOverCallback() {

            @Override
            public void run(MouseOverTypes eventtype, Element element) {
                switch (eventtype) {
                case ENTERED:
                	setBackGroundColor(ColorSet.ALICE_BLUE);
                    break;
                case EXITED:
                	setBackGroundColor(ColorSet.BLACK);
					break;
                }
            }
        };
        
        
       // triangleGroup2.addMouseEventCallback(mouseoverTriangles);
        triangleGroup2.setPosition(200, 200);
        addObject(triangleGroup1);
        addObject(triangleGroup2);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.mouseover.MouseOverExampletmp", "MouseOverGroupExample");
    }
    
}
