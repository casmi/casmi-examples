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

import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Triangle;

/**
 * Mouse example.
 * 
 * @see casmi.Applet
 * 
 * @author K. Nishimura
 */
public class MouseExample extends Applet {

    Triangle t = new Triangle(100, 300, 400, 400, 700, 300);

    @Override
    public void setup() {
        setFPS(60);
        setSize(800, 600);
        t.setFillColor(new RGBColor(0.9, 0.25, 0.25, 0.7));
        t.setStrokeColor(new RGBColor(0.9, 0.25, 0.25, 1.0));
        addObject(t);
    }

    @Override
    public void update() {
        t.set(100, 300, getMouseX(), getMouseY(), 700, 300);
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        boolean mouseFlag = false;
     
        switch (e) {
        case CLICKED:
            System.out.println("Clicked!!");
            mouseFlag = true;
            break;
        case PRESSED:
            System.out.println("Pressed!!");
            mouseFlag = true;
            break;
        case RELEASED:
            System.out.println("Released!!");
            mouseFlag = true;
            break;
        }
        
        if (mouseFlag) {
            switch (b) {
            case LEFT:
                System.out.println(": Left");
                break;
            case RIGHT:
                System.out.println(": Right");
                break;
            }
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.MouseExample", "Mouse Example");
    }
}
