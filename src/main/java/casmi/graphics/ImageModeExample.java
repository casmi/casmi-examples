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

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Texture;
import casmi.image.ImageMode;
import casmi.util.SystemUtil;

/**
 * Example of Graphics.
 *
 * @author Y. BAN
 *
 */
public class ImageModeExample extends Applet {

    static final String IMAGE_PATH = Applet.class.getResource("logo.png").getPath();

    Texture tex1,tex2;
    Circle c1, c2;

    @Override
    public void setup() {
        setSize(1024, 768);

        System.out.println(SystemUtil.USER_DIR);

        tex1 = new Texture(IMAGE_PATH);
        tex1.setMode(ImageMode.CORNER);
        tex1.setPosition(300, 300);
        c1 = new Circle(300, 300, 10);
        c1.setFillColor(ColorSet.RED);

        addObject(tex1);
        addObject(c1);

        tex2 = new Texture(IMAGE_PATH);
        tex2.setMode(ImageMode.CENTER);
        tex2.setPosition(600, 600);
        c2 = new Circle(600, 600, 10);
        c2.setFillColor(ColorSet.RED);

        addObject(tex2);
        addObject(c2);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.ImageModeExample", "ImageModeExample");
    }

}
