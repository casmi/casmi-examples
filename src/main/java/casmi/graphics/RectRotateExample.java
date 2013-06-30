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

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.element.Rect;
import casmi.util.SystemUtil;

/**
 * Example for rotating Rect.
 *
 * @author Y. Ban
 */
public class RectRotateExample extends Applet {

    Rect rect = new Rect(100,100);
    int r;

    @Override
    public void setup() {
        setFPS(30);
        setSize(800,600);
        rect.setPosition(400, 300);
        addObject(rect);
    }

    @Override
    public void update() {
        r++;
        if (r >= 360)
            r = 0;
        rect.setRotation(r);
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {
        if (e == MouseStatus.PRESSED) {
            capture("rsrc" + SystemUtil.FILE_SEPARATOR + "rectrotate.png", true);
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.RectRotateExample", "RectRotateExample");
    }
}
