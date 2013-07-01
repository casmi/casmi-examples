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

package casmi.graphics.element;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;
import casmi.image.Texture;

/**
 * @author Y. Ban
 */
public class SphereTextureExample extends Applet {

    Sphere s;
    double rot = 0.0;

    @Override
    public void setup() {
        setSize(1024, 768);

        s = new Sphere(1);
        s.setStroke(false);

        Texture earth = new Texture(Applet.class.getResource("/casmi/earth.png"));
        s.setTexture(earth);

        Perspective perspective = new Perspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);
        Camera camera = new Camera(2.4, 3.2, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

        setPerspective(perspective);
        setCamera(camera);

        addObject(s);
    }

    @Override
    public void update() {
        s.setRotation(rot, 0, 1, 0);
        rot += 1.0;
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.element.SphereTextureExample", "SphereTextureExample");
    }

}
