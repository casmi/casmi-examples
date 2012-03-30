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
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;

/**
 * Example of texture mask.
 * 
 * @author Y. BAN
 */
public class TextureMaskExample extends Applet {

    Texture tex = null;
    Texture mask = null;
    Texture masked = null;
    Text t;

    String imagePath = Applet.class.getResource("sora.png").getPath();
    String maskPath = Applet.class.getResource("cloudMask.png").getPath();

    int flg = 0;

    @Override
    public void setup() {
        setSize(1024, 768);
        setBackGroundColor(ColorSet.GRAY);

        tex = new Texture(imagePath);
        tex.setX(getWidth() / 2);
        tex.setY(getHeight() / 2);

        mask = new Texture(maskPath);
        mask.setX(getWidth() / 2);
        mask.setY(getHeight() / 2);

        masked = new Texture(imagePath);
        masked.setX(getWidth() / 2);
        masked.setY(getHeight() / 2);

        masked.setMask(mask);

        tex.hidden();
        mask.hidden();
        flg = 0;

        t = new Text("MaskedImage");
        t.setStrokeColor(ColorSet.WHITE);
        t.setPosition(50, 20);

        addObject(tex);
        addObject(mask);
        addObject(masked);
        addObject(t);

        capture(Applet.class.getResource("save.png").getPath());
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            flg++;
            if (flg > 2)
                flg = 0;
            if (flg == 0) {
                masked.visible();
                mask.hidden();
                t.setText("MaskedImage");
            }
            if (flg == 1) {
                tex.visible();
                masked.hidden();
                t.setText("BaseImage");
            }
            if (flg == 2) {
                mask.visible();
                tex.hidden();
                t.setText("MaskImage");
            }
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (e == KeyEvent.PRESSED) {
            if (getKeycode() == 's')
                capture(Applet.class.getResource("save_without_bg.png").getPath(), false);
            if (getKeycode() == 'b')
                capture(Applet.class.getResource("save_with_bg.png").getPath());
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.TextureMaskExample", "Texture Mask Example");
    }

}
