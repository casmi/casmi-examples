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

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.graphics.element.Triangle;
import casmi.graphics.group.Group;

/**
 * GlowShading example
 *
 * @see casmi.graphics.shader
 *
 * @author Y. BAN
 */

public class GlowExample extends Applet {

    Rect r1,r2, r3;
    Triangle tr1;
    Circle c;
    MouseClickCallback mouseover;
    Text t;
    double radian = 0;

    TexObject texo;
    Texture tex;
    GroupObject go;

    double rot = 0.0;

    class GroupObject extends Group {
        private Rect r1,r2;

        public GroupObject() {
            r1 = new Rect(100, 100);
            r1.setPosition(100,100);
            r2 = new Rect(100, 100);
            r2.setPosition(150,150);
            r1.setFillColor(ColorSet.DARK_GREEN);
            r1.setStroke(false);
            r2.setFillColor(ColorSet.RED);
            r2.setStroke(false);
           // r1.enableBlur();
           // r2.enableBlur();
           // r2.setBlurMode(BlurMode.Glow);
            add(r1);
            add(r2);
        }

        @Override
        public void update() {
            // TODO Auto-generated method stub

        }

    }

    class TexObject extends Group {

        private URL IMAGE_PATH = Applet.class.getResource("/img/logo.png");
        private Texture tex;
        private double rot = 0.0;

        public TexObject() {
            tex = new Texture(IMAGE_PATH);
            tex.setPosition(500, 100);
            tex.setWidth(tex.getWidth() / 1.2);
            tex.setRotation(rot, 0.0, 1.0, 0.0);

            add(tex);
        }

        @Override
        public void update() {
            rot += 2.0;
            tex.setRotation(rot, 0.0, 1.0, 0.0);

        }

    }



    @Override
    public void setup() {
        setSize(800, 600);
        r1 = new Rect(100, 100);
        r1.setPosition(100,100);
        r2 = new Rect(100, 100);
        r2.setPosition(150,150);
        r3 = new Rect(100, 100);
        r3.setPosition(200,200, 100);
        t = new Text("c");
        t.getFont().setSize(50);
        t.setStrokeColor(ColorSet.LIGHT_BLUE);
        t.setPosition(70, 70);
        tr1 = new Triangle(400, 500, 500, 550, 550, 500);
        r1.setFillColor(ColorSet.DARK_GREEN);
        r2.setFillColor(ColorSet.ORANGE);
        r2.setStroke(false);
        r3.enableBlur();
        r3.setStroke(false);
        r3.setFillColor(ColorSet.BLUE);
        r2.enableBlur();
        r2.setBlurMode(BlurMode.Glow);
        t.enableBlur();
        t.setBlurMode(BlurMode.Glow);
        tr1.setFillColor(ColorSet.BURLY_WOOD);
        tr1.setBlurMode(BlurMode.Blur);
        tr1.setStroke(false);
        tr1.enableBlur();
        c = new Circle(30);
        c.enableBlur();
        c.setBlurMode(BlurMode.MotionBlur);
        c.setFillColor(ColorSet.RED);
        c.setStrokeColor(ColorSet.RED);
        c.setPosition(500 + 100 * Math.cos((radian/180.0) * Math.PI), 300 + 100 * Math.sin((radian/180.0) * Math.PI));
        mouseover = new MouseClickCallback() {

            @Override
            public void run(MouseClickTypes eventtype, Element element) {

                if(eventtype == MouseClickTypes.CLICKED) {
                    BlurMode blur = element.getBlurMode();
                    if(element.isBlur()){
                        if(blur==BlurMode.Blur)
                            element.setBlurMode(BlurMode.Glow);
                        else if(blur==BlurMode.Glow)
                            element.disableBlur();
                    } else {
                        element.enableBlur();
                        element.setBlurMode(BlurMode.Blur);
                    }
                }

            }
        };
        r3.addMouseEventCallback(mouseover);
        addObject(r1);
        addObject(t);
        addObject(r3);
        addObject(r2);
        addObject(tr1);

        URL IMAGE_PATH = Applet.class.getResource("/img/logo.png");
        tex = new Texture(IMAGE_PATH);
        tex.setPosition(500, 100);
        tex.setWidth(tex.getWidth() / 1.2);
        tex.setRotation(rot, 0.0, 1.0, 0.0);
        addObject(tex);
        tex.enableBlur();
        tex.addMouseEventCallback(mouseover);
        //texo = new TexObject();
        //addObject(texo);
       // addObject(c);
        go = new GroupObject();
        go.setPosition(300, 400);
        go.enableBlur();
        addObject(go);
        enableBlurShader();


    }

    @Override
    public void update() {
       // System.out.println(String.format("%4.2f", getWorkingFPS()));
        rot += 2.0;
        tex.setRotation(rot, 0.0, 1.0, 0.0);
        radian+=2;
        if(radian > 360)
            radian = 0;
        c.setPosition(500 + 100 * Math.cos((radian/180.0) * Math.PI), 300 + 100 * Math.sin((radian/180.0) * Math.PI));

    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyEvent(KeyEvent e) {
        if(!isBlur()){
            enableBlurShader();
        }
        else{
            disableBlurShader();
        }

    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.shader.GlowExample", "Glow Example");
    }

}
