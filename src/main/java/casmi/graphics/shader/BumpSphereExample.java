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

package casmi.graphics.shader;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Sphere;
import casmi.graphics.element.Texture;
import casmi.graphics.material.Material;
import casmi.graphics.object.Light;
import casmi.graphics.object.LightMode;
import casmi.graphics.object.Perspective;

/**
 * BumpShading example for Sphere.
 *
 * @author Y. Ban
 *
 * @see casmi.graphics.shader.Shader
 */
public class BumpSphereExample extends Applet {

    static final String EARTH_IMAGE_PATH = Applet.class.getResource("earthDiffuse.png").getPath();
    static final String EARTH_NORMAL_IMAGE_PATH = Applet.class.getResource("earthNormal.png").getPath();

    Sphere s = new Sphere(1.3, 50, 50);
    Light light = new Light(LightMode.DIRECTION);
    Material m = new Material();
    Perspective p;
    double lightPos[] = {10.0, 15.0, 10.0, 0.0};
    Shader shader = new Shader("Bump");
    double rot = 90.0;

    @Override
    public void setup() {
        setSize(1024, 768);
        s.setStroke(false);

        float lightAmbient[] = {0.7f, 0.7f, 0.7f, 1.0f};
        float lightDiffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float lightSpecular[] = {1.0f, 1.0f, 1.0f, 1.0f};

        float ambient[] = {0.7f, 0.7f, 0.7f, 1.0f};
        float diffuse[] = {0.7f, 0.7f, 0.7f, 1.0f};
        float specular[] = {0.6f, 0.6f, 0.6f, 1.0f};

        m.ambient(ambient);
        m.diffuse(diffuse);
        m.specular(specular);
        m.shininess(100.0f);

        Texture earth = new Texture(EARTH_IMAGE_PATH);
        Texture normal = new Texture(EARTH_NORMAL_IMAGE_PATH);

        light.setAmbient(lightAmbient);
        light.setDiffuse(lightDiffuse);
        light.setSpecular(lightSpecular);
        light.setDirection(lightPos[0], lightPos[1], lightPos[2]);
        s.setPosition(0, 0, -5);
        s.setRotation(90, 1, 0, 0);
        s.setStroke(false);
        p = new Perspective(50.0, getWidth() / (double)getHeight(), 1.0, 1000.0);
        setPerspective(p);
        s.setMaterial(m);
        s.setShader(shader);
        s.setTexture(earth);
        s.setNormalMap(normal);
        addObject(s);
        addLight(light);
    }

    @Override
    public void update() {
        rot += 0.1;
        s.setRotation(rot, rot * 3, rot * 5);
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {
        if (e == KeyEvent.PRESSED) {
            if (getKey() == 's') {
                if (s.isEnableShader())
                    s.disableShader();
                else
                    s.enableShader();
            }
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.shader.BumpSphereExample", "Bump Sphere Example");
    }

}
