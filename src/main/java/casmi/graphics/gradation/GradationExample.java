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

package casmi.graphics.gradation;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.GradationMode2D;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Quad;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;

/**
 * Gradation example.
 *
 * @see casmi.GradationMode2D
 *
 * @author Y.Ban
 */
public class GradationExample extends Applet {

    Circle circle = new Circle(80);
    Quad quad;
    Triangle triangle = new Triangle(200, 200, 300, 100, 100, 100);
    Color color = new RGBColor(ColorSet.BLUE);
    Rect r1, r2, r3;

    @Override
    public void setup() {
        setSize(1024, 768);

        color.setAlpha(0.0);
        circle.setFillColor(new RGBColor(0.3, 0.7, 0.3));
        circle.setStroke(false);
        circle.setStrokeWidth(1);
        circle.setPosition(400, 300);
        circle.setCenterColor(ColorSet.BLUE);
        circle.setEdgeColor(color);
        addObject(circle);

        quad = new Quad(20, 600, 70, 550, 200, 630, 80, 680);
        quad.setStroke(false);
        quad.setCornerColor(0, ColorSet.BEIGE);
        quad.setCornerColor(1, ColorSet.CHOCOLATE);
        quad.setCornerColor(2, ColorSet.YELLOW_GREEN);
        quad.setCornerColor(3, ColorSet.GREEN);
        addObject(quad);

        triangle.setFillColor(ColorSet.CHOCOLATE);
        triangle.setStroke(false);
        triangle.setCornerColor(0, ColorSet.YELLOW);
        addObject(triangle);

        r1 = new Rect(200, 100);
        r2 = new Rect(200, 100);
        r3 = new Rect(200, 100);
        r1.setGradationColor(GradationMode2D.HORIZONTAL,    ColorSet.BURLY_WOOD,   ColorSet.CRIMSON);
        r2.setGradationColor(GradationMode2D.VERTICAL,      ColorSet.DARK_MAGENTA, ColorSet.HONEYDEW);
        r3.setGradationColor(GradationMode2D.LEFT_SIDEWAYS, ColorSet.DARK_BLUE,    ColorSet.MAROON);
        r1.setPosition(900, 100);
        r2.setPosition(700, 400);
        r3.setPosition(300, 500);
        addObject(r1);
        addObject(r2);
        addObject(r3);
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
        AppletRunner.run("casmi.graphics.gradation.GradationExample", "Gradation Example");
    }

}
