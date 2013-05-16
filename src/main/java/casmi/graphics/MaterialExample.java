/*
 *   casmi examples
 *   http://casmi.github.io/
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
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Sphere;
import casmi.graphics.material.Material;
import casmi.graphics.object.Light;
import casmi.graphics.object.LightMode;
import casmi.matrix.Vertex;

/**
 * Example of Graphics.
 *
 * @author Y.Ban
 */
public class MaterialExample extends Applet {

    Sphere s1 = new Sphere(70.0);
    Sphere s2 = new Sphere(70.0);
    Sphere s3 = new Sphere(70.0);

    Material m1 = new Material();
    Material m2 = new Material();
    Material m3 = new Material();

    Light l = new Light(LightMode.SPOT);

    Color c = new RGBColor(1.0, 1.0, 1.0);

    Vertex v1 = new Vertex(1000, 1000, 1000);
    Vertex v2 = new Vertex(-10, 0, -10);

    float emerald_ambient[] = {0.0115f, 0.745f, 0.0115f, 1.0f};
    float emerald_diffuse[] = {0.07568f, 0.61424f, 0.07568f, 1.0f};
    float emerald_specular[] = {0.733f, 0.927811f, 0.733f, 1.0f};
    float emerald_shininess = 60.8f;

    @Override
    public void setup() {
        setSize(800, 600);

        s1.setStroke(false);
        m1.shininess(3);
        m1.ambient(2);
        m1.diffuse((float)(0.5), (float)(0.5), (float)(0.9));
        m1.specular((float)(30 / 255.0));
        s1.setMaterial(m1);

        s2.setStroke(false);
        m2.shininess(emerald_shininess);
        m2.ambient(emerald_ambient);
        m2.diffuse(emerald_diffuse);
        m2.specular(emerald_specular);
        s2.setMaterial(m2);

        s3.setStroke(false);
        m3.shininess(100f);
        m3.ambient((float)(250 / 255.0));
        m3.diffuse((float)(0.9), (float)(0.6), (float)(0.6));
        m3.specular((float)(200 / 255.0));
        s3.setMaterial(m3);

        s1.setPosition(150, 300, 100);
        s2.setPosition(400, 300, 100);
        s3.setPosition(650, 300, 100);
        addObject(s1);
        addObject(s2);
        addObject(s3);
        addLight(l);
        l.setAngle(30);
        l.setPosition(v2);
        l.setDirection(1, 0, 1);
        l.setColor(c);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.MaterialExample", "MaterialExample");
    }

}
