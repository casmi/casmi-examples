/*
 *   casmi examples
 *   http://casmi.github.com/
<<<<<<< HEAD
 *   Copyright (C) 2011-2012, Xcoo, Inc.
=======
 *   Copyright (C) 2011, Xcoo, Inc.
>>>>>>> e4cd2efc5bb81fc95a0f2243a280e7337d6eb0a0
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

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.Line;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.tween.equations.Back;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Circ;
import casmi.tween.equations.Cubic;
import casmi.tween.equations.Elastic;
import casmi.tween.equations.Expo;
import casmi.tween.equations.Linear;
import casmi.tween.equations.Quad;
import casmi.tween.equations.Quart;
import casmi.tween.equations.Quint;
import casmi.tween.equations.Sine;

/**
 * Example of Tween.
 *
 * @author Y. Ban
 *
 */
public class TweenEquationsExample extends Applet {

    class EqRect {

        int index;
        Rect rect;

        public EqRect(int index) {
            this.index = index;
            rect = new Rect(850, 625 - index * 50, 150, 40);
            rect.setStroke(false);
            Color c = new RGBColor(ColorSet.BLACK, 0.001);
            rect.setFillColor(c);
        }
    }

    static final String[] EQ_NAME = {
        "Back",
        "Bounce",
        "Circ",
        "Cubic",
        "Elastic",
        "Expo",
        "Linear",
        "Quad",
        "Quart",
        "Quint",
        "Sine"
    };

    Line l1 = new Line(100, 200, 600, 200);
    Line l2 = new Line(100, 550, 600, 550);
    Rect r = new Rect(150, 50);
    Ellipse el = new Ellipse(20);
    Font f, f2;
    Text inText, outText;

    private int eq = 0;
    private int io = 1;
    Tweener te, te2;

    private boolean modeChange = false;
    Color pink, blue;
    int start = 0;

    List<EqRect> eqRectList = new ArrayList<EqRect>();

    @Override
    public void setup() {
        pink = new RGBColor(ColorSet.LIGHT_PINK);
        blue = new RGBColor(ColorSet.LIGHT_BLUE);
        setSize(1024, 768);
        l1.setStrokeColor(ColorSet.AQUAMARINE);
        l2.setStrokeColor(ColorSet.AQUAMARINE);
        el.setFillColor(ColorSet.ORANGE);

        f = new Font("San-Serif");
        f2 = new Font("San-Serif");
        f.setSize(40);
        f2.setSize(25);

        inText = new Text("IN", f2, 100, 550 + 5);
        pink.setAlpha(0.4);
        inText.setStrokeColor(pink);
        inText.getSceneStrokeColor().setAlpha(0.4);
        outText = new Text("OUT", f2, 100, 200 + 5);
        outText.setStrokeColor(blue);
        r.setFill(false);
        r.setStrokeColor(ColorSet.LIGHT_BLUE);

        addObject(inText);
        addObject(outText);
        addObject(l1);
        addObject(l2);
        el.setPosition(350, 550);
        addObject(el);

        r.setPosition(850, 625);
        addObject(r);

        int index = 0;
        for (String name : EQ_NAME) {
            Text t = new Text(name, f);
            t.setStrokeColor(ColorSet.WHITE);
            t.setAlign(TextAlign.CENTER);
            t.setPosition(850, 610 - 50 * index);
            addObject(t);
            index++;
        }

        for (int i = 0; i < 11; i++) {
            EqRect eq = new EqRect(i);
            eqRectList.add(eq);
        }

        index = 0;
        for (final EqRect eqRect : eqRectList) {
            addObject(eqRect.rect);

            eqRect.rect.addMouseEventCallback(new MouseClickCallback() {

                @Override
                public void run(MouseClickTypes eventtype, Element element) {
                    if (eventtype == MouseClickTypes.CLICKED) {
                        modeChange = true;
                        eq = eqRect.index;
                        start = 1;
                    }
                }
            });

            eqRect.rect.addMouseEventCallback(new MouseOverCallback() {

                @Override
                public void run(MouseOverTypes eventtype, Element element) {
                    switch (eventtype) {
                    case ENTERED:
                        setCursor(CursorMode.HAND);
                        break;
                    case EXITED:
                        setCursor(CursorMode.DEFAULT);
                        break;
                    }
                }
            });

            index++;
        }

        te2 = null;
        te2 = new Tweener(r);
        te = null;
        te = new Tweener(el);
    }

    @Override
    public void update() {
        if (modeChange) {
            modeChange = false;

            Tween changeTween = Tween.to(te2, TweenType.POSITION, 1000,
                Cubic.INOUT).target(r.getX(), eqRectList.get(eq).rect.getY());
            addTween(changeTween);
            if (io == 0) {
                r.setStrokeColor(ColorSet.LIGHT_PINK);
                pink.setAlpha(1.0);
                blue.setAlpha(0.4);
                inText.setStrokeColor(pink);
                outText.setStrokeColor(blue);
            }
            if (io == 1) {
                r.setStrokeColor(ColorSet.LIGHT_BLUE);
                pink.setAlpha(0.4);
                blue.setAlpha(1.0);
                inText.setStrokeColor(pink);
                outText.setStrokeColor(blue);
            }
            if (io == 2) {
                r.setStrokeColor(ColorSet.LIGHT_GREEN);
                pink.setAlpha(1.0);
                blue.setAlpha(1.0);
                inText.setStrokeColor(pink);
                outText.setStrokeColor(blue);
            }
        }
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            if (start == 0) {
                clearTween();
                el.setPosition(350, 550);
                te.reset();
                if (io == 0) {
                    switch (eq) {
                    case 0:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Back.IN).target(
                            el.getX(), 200));
                        break;
                    case 1:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Bounce.IN).target(
                            el.getX(), 200));
                        break;
                    case 2:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Circ.IN).target(
                            el.getX(), 200));
                        break;
                    case 3:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Cubic.IN).target(
                            el.getX(), 200));
                        break;
                    case 4:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Elastic.IN).target(
                            el.getX(), 200));
                        break;
                    case 5:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Expo.IN).target(
                            el.getX(), 200));
                        break;
                    case 6:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Linear.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 7:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quad.IN).target(
                            el.getX(), 200));
                        break;
                    case 8:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quart.IN).target(
                            el.getX(), 200));
                        break;
                    case 9:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quint.IN).target(
                            el.getX(), 200));
                        break;
                    case 10:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Sine.IN).target(
                            el.getX(), 200));
                        break;
                    }
                }
                if (io == 1) {
                    switch (eq) {
                    case 0:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Back.OUT).target(
                            el.getX(), 200));
                        break;
                    case 1:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Bounce.OUT).target(
                            el.getX(), 200));
                        break;
                    case 2:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Circ.OUT).target(
                            el.getX(), 200));
                        break;
                    case 3:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Cubic.OUT).target(
                            el.getX(), 200));
                        break;
                    case 4:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Elastic.OUT).target(
                            el.getX(), 200));
                        break;
                    case 5:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Expo.OUT).target(
                            el.getX(), 200));
                        break;
                    case 6:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Linear.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 7:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quad.OUT).target(
                            el.getX(), 200));
                        break;
                    case 8:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quart.OUT).target(
                            el.getX(), 200));
                        break;
                    case 9:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quint.OUT).target(
                            el.getX(), 200));
                        break;
                    case 10:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Sine.OUT).target(
                            el.getX(), 200));
                        break;
                    }
                }
                if (io == 2) {
                    switch (eq) {
                    case 0:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Back.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 1:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Bounce.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 2:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Circ.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 3:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Cubic.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 4:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Elastic.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 5:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Expo.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 6:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Linear.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 7:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quad.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 8:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quart.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 9:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Quint.INOUT).target(
                            el.getX(), 200));
                        break;
                    case 10:
                        addTween(Tween.to(te,
                            TweenType.POSITION, 2000, Sine.INOUT).target(
                            el.getX(), 200));
                        break;
                    }
                }
            } else {
                start = 0;
            }
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {
        switch (e) {
        case PRESSED:
            if (getKeyCode() == 37) {
                io--;
                if (io < 0)
                    io = 0;
                modeChange = true;
            } else if (getKeyCode() == 39) {
                io++;
                if (io > 2)
                    io = 2;
                modeChange = true;
            }
            break;
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenEquationsExample", "TweenEquationExample");
    }

}
