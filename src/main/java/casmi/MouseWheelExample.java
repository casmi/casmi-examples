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

package casmi;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;

/**
 * Mouse wheel example.
 * <p>
 * When scroll a mouse wheel, up/down a rect.
 *
 * @author T. Takeuchi
 *
 * @see casmi.Applet#getMouseWheelRotation()
 */
public class MouseWheelExample extends Applet {

    Rect rect;

    @Override
    public void setup() {
        setSize(800, 600);

        rect = new Rect(getWidth() / 2.0, getHeight() / 2.0, 100.0, 100.0);
        rect.setFillColor(ColorSet.BLUE);
        addObject(rect);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {
        if (event == MouseEvent.WHEEL_ROTATED) {
            double wrot = mouse.getWheelRotation();
            rect.setY(rect.getY() + wrot);
        }
    }

    @Override
    public void keyEvent(KeyEvent event, Keyboard keyboard) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.MouseWheelExample", "MouseWheelExample");
    }

}
