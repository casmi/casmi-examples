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

package casmi.graphics.color;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.element.Rect;

/**
 * Example for lerp of colors.
 *
 * @author Y. Ban
 *
 * @see casmi.graphics.color.RGBColor#lerpColor(Color, Color, double)
 */
public class LerpColorExample extends Applet {

    Rect  rects[] = new Rect[5];
    Color from = new RGBColor(0.8, 0.6, 0.0);
    Color to   = new RGBColor(0.0, 0.4, 0.7);

    @Override
    public void setup() {
        setSize(800, 600);

        for (int i = 0; i < rects.length; ++i) {
            rects[i] = new Rect(100, 300);
            rects[i].setStrokeWidth(5);
            rects[i].setStrokeColor(ColorSet.WHITE);
        }

        Color lerpColor1 = RGBColor.lerpColor(from, to, 0.25);
        Color lerpColor2 = RGBColor.lerpColor(from, to, 0.5);
        Color lerpColor3 = RGBColor.lerpColor(from, to, 0.75);

        rects[0].setFillColor(from);
        rects[1].setFillColor(lerpColor1);
        rects[2].setFillColor(lerpColor2);
        rects[3].setFillColor(lerpColor3);
        rects[4].setFillColor(to);

        int index = 0;
        for (Rect rr : rects) {
            rr.setPosition(200 + 100 * index, 300);
            addObject(rr);
            index++;
        }
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.color.LerpColorExample", "LerpColorExample");
    }

}
