/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011-2012, Xcoo, Inc.
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

package casmi.tween;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Ellipse;
import casmi.matrix.Vector2D;
import casmi.tween.equations.Linear;
import casmi.tween.equations.QuadraticInOut;
import casmi.util.Random;

/**
 * Tween cursor example.
 *
 * @author Y. Ban
 */
public class TweenCursorExample extends Applet {

    Ellipse el = new Ellipse(40);

    Color c = new RGBColor(ColorSet.ORANGE);

    @Override
    public void setup() {
        setSize(1024, 768);
        el.setFillColor(c);
        el.setPosition(getWidth() / 2, getHeight() / 2);
        addObject(el);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {
        if (e == MouseStatus.PRESSED) {
            float scale = Random.random(0.5f, 2.0f);

            Tweener t = new Tweener(el);

            t.animateScale(scale, 500, Linear.class);
            t.animatePosition(new Vector2D(getMouseX(), getMouseY()), 1000, QuadraticInOut.class);

            addTweener(t);
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenCursorExample", "TweenCursorExample");
    }

}