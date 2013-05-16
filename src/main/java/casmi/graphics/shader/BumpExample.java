package casmi.graphics.shader;


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


import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.Trackball;
import casmi.graphics.element.Texture;
import casmi.graphics.group.Group;
import casmi.graphics.material.Material;
import casmi.graphics.object.Light;
import casmi.graphics.object.LightMode;
import casmi.graphics.object.Perspective;

/**
 * BumpShading example
 *
 * @see casmi.graphics.shader
 *
 * @author Y. BAN
 */
public class BumpExample extends Applet {

    TexObject texo;
    double rot = 0.0;
    Light light = new Light(LightMode.DIRECTION);
    Perspective p;
    int prvMouseX = 0, prvMouseY = 0;
    double lightPos[] = {10.0, 15.0, 10.0, 0.0};
    Trackball trackball;

    class TexObject extends Group {

        private Texture tex,normal;
        private double rot = 0.0;
        Shader shader = new Shader("Bump");
        Material m = new Material();

        public TexObject() {
            tex = new Texture(Applet.class.getResource("japan.png"));
            normal = new Texture(Applet.class.getResource("japanNormal.png"));
            tex.setWidth(tex.getWidth() / 1.2);
            tex.setRotation(rot, 0.0, 1.0, 0.0);


            float ambient[] = {0.8f, 0.8f, 0.8f, 1.0f};
            float diffuse[] = {0.7f, 0.7f, 0.7f, 1.0f};
            float specular[] = {0.5f, 0.5f, 0.5f, 1.0f};

            m.ambient(ambient);
            m.diffuse(diffuse);
            m.specular(specular);
            m.shininess(100.0f);
            tex.setMaterial(m);
            tex.setShader(shader);
            tex.setNormalMap(normal);
            add(tex);
        }

        @Override
        public void update() {
            /*    rot += 1.0;
            tex.setRotation(rot, 0.0, 1.0, 0.0);
*/
        }
    }

    @Override
    public void setup() {
        setSize(1024, 768);
        texo = new TexObject();
        float lightAmbient[] = {0.5f, 0.5f, 0.5f, 1.0f};
        float lightDiffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float lightSpecular[] = {1.0f, 1.0f, 1.0f, 1.0f};

        light.setAmbient(lightAmbient);
        light.setDiffuse(lightDiffuse);
        light.setSpecular(lightSpecular);
        light.setDirection(lightPos[0], lightPos[1], lightPos[2]);

        p = new Perspective(50.0f, getWidth()/(double)getHeight(), 1.0, 1000.0);
        setPerspective(p);
        texo.setScale(0.01);
        texo.setPosition(0,0,-5);
        addObject(texo);
        addLight(light);
        trackball = new Trackball(this);
    }

    @Override
    public void update() {
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            prvMouseX = getMouseX();
            prvMouseY = getMouseY();
        }

        if (e == MouseEvent.DRAGGED && b == MouseButton.LEFT) {
            int mouseX = getMouseX();
            int mouseY = getMouseY();

            // Update Trackball.
            trackball.update(mouseX, mouseY, prvMouseX, prvMouseY);

            // Rotate an object with Trackball.
            trackball.rotate(texo);

            prvMouseX = mouseX;
            prvMouseY = mouseY;
        }
    }
    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.shader.BumpExample", "Bump Example");
    }

}
