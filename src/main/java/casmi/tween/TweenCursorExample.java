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
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Ellipse;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Linear;
import casmi.tween.equations.Quart;
import casmi.tween.simpletweenables.TweenFloat;
import casmi.util.Random;

/**
 * Tween cursor example.
 * 
 * @author Y. Ban
 */
public class TweenCursorExample extends Applet {

    Ellipse el = new Ellipse(40);
    TweenElement te;
    TweenFloat tf = new TweenFloat(0.0f);
    Color c = new RGBColor(ColorSet.ORANGE);
    Color cc = new RGBColor(ColorSet.ORANGE);

    @Override
    public void setup() {
        setSize(1024, 768);
        el.setFillColor(c);
        el.setPosition(getWidth() / 2, getHeight() / 2);
        te = new TweenElement(el);
        addObject(el);
    }

    @Override
    public void update() {
        el.setFillColor(RGBColor.lerpColor(c, cc, tf.getValue()));
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            c = cc.clone();
            float sr = Random.random(0.5f, 2.0f);
            int rr = (int)Random.random(0, 255);
            int rg = (int)Random.random(0, 255);
            int rb = (int)Random.random(0, 255);
            cc.setBlue(rb / 255.0);
            cc.setGreen(rg / 255.0);
            cc.setRed(rr / 255.0);
            tf.setValue(0.0f);
            TweenSerialGroup tg = TweenSerialGroup.create(
                Tween.to(te, TweenType.SCALE, 500, Bounce.IN).target(sr),
                TweenParallelGroup.create(
                    Tween.to(tf, 1000, Linear.INOUT).target(1.0f),
                    Tween.to(te, TweenType.POSITION, 1000, Quart.INOUT).target(getMouseX(), getMouseY())
                    )
                );
            addTween(tg);
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenCursorExample", "TweenCursorExample");
    }

}