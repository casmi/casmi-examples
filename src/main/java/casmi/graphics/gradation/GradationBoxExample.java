/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2012, Xcoo, Inc.
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
import casmi.GradationMode3D;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Box;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;

/**
 * Example for Box with gradation color.
 *
 * @author Y. Ban
 */
public class GradationBoxExample extends Applet {

    Box b1 = new Box(1.0);

    Perspective p;
    Camera c;

    @Override
    public void setup() {
        setSize(800, 600);

        b1.setStrokeWidth(1.0);
        b1.setFillColor(new RGBColor(0.4, 0.4, 0.4));
        b1.setStroke(false);
        b1.setGradationColor(GradationMode3D.Y_AXIS,ColorSet.AQUA, ColorSet.ORANGE_RED);

        p = new Perspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);
        c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

        setPerspective(p);
        setCamera(c);

        addObject(b1);
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
        AppletRunner.run("casmi.graphics.gradation.GradationBoxExample", "Gradation Box Example");
    }
}
