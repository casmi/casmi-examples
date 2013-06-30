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
import casmi.MouseStatus;
import casmi.callback.MouseClickCallback;
import casmi.callback.MouseClickEventType;
import casmi.callback.MouseOverCallback;
import casmi.callback.MouseOverEventType;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.matrix.Vector2D;
import casmi.tween.equations.BackIn;
import casmi.tween.equations.BackInOut;
import casmi.tween.equations.BackOut;
import casmi.tween.equations.BounceIn;
import casmi.tween.equations.BounceInOut;
import casmi.tween.equations.BounceOut;
import casmi.tween.equations.CircularIn;
import casmi.tween.equations.CircularInOut;
import casmi.tween.equations.CircularOut;
import casmi.tween.equations.CubicIn;
import casmi.tween.equations.CubicInOut;
import casmi.tween.equations.CubicOut;
import casmi.tween.equations.ElasticIn;
import casmi.tween.equations.ElasticInOut;
import casmi.tween.equations.ElasticOut;
import casmi.tween.equations.ExponentialIn;
import casmi.tween.equations.ExponentialInOut;
import casmi.tween.equations.ExponentialOut;
import casmi.tween.equations.Linear;
import casmi.tween.equations.QuadraticIn;
import casmi.tween.equations.QuadraticInOut;
import casmi.tween.equations.QuadraticOut;
import casmi.tween.equations.QuarticIn;
import casmi.tween.equations.QuarticInOut;
import casmi.tween.equations.QuarticOut;
import casmi.tween.equations.QuinticIn;
import casmi.tween.equations.QuinticInOut;
import casmi.tween.equations.QuinticOut;
import casmi.tween.equations.SinusoidalIn;
import casmi.tween.equations.SinusoidalInOut;
import casmi.tween.equations.SinusoidalOut;

/**
 * Example of Tween.
 *
 * @author Y. Ban
 *
 */
public class TweenEquationsExample extends Applet {

    class EquationRect extends Rect {
        private int index;

        public EquationRect(int index) {
            super(850, 625 - index * 50, 150, 40);
            this.index = index;
            this.setStroke(false);
            this.setFillColor(new RGBColor(ColorSet.BLACK, 0.001));
        }

        public int getIndex() {
            return index;
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

    private Line l1 = new Line(100, 200, 600, 200);
    private Line l2 = new Line(100, 550, 600, 550);
    private Rect r = new Rect(150, 50);
    private Ellipse el = new Ellipse(20);
    private Font f, f2;
    private Text inText, outText;

    private int equationNumber = 0;
    private int mode = 1;

    private Tweener t1, t2;

    private boolean modeChange = false;
    private Color pink, blue;
    private List<EquationRect> eqRectList = new ArrayList<EquationRect>();

    @Override
    public void setup() {
        setSize(1024, 768);

        pink = new RGBColor(ColorSet.LIGHT_PINK);
        pink.setAlpha(0.4);

        blue = new RGBColor(ColorSet.LIGHT_BLUE);

        l1.setStrokeColor(ColorSet.AQUAMARINE);
        l2.setStrokeColor(ColorSet.AQUAMARINE);
        el.setFillColor(ColorSet.ORANGE);

        f = new Font("San-Serif");
        f.setSize(40);

        f2 = new Font("San-Serif");
        f2.setSize(25);

        inText = new Text("IN", f2, 100, 550 + 5);
        inText.setStrokeColor(pink);
        inText.getSceneStrokeColor().setAlpha(0.4);

        outText = new Text("OUT", f2, 100, 200 + 5);
        outText.setStrokeColor(blue);

        r.setFill(false);
        r.setStrokeColor(ColorSet.LIGHT_BLUE);
        r.setPosition(850, 625);

        el.setPosition(350, 550);

        addObject(inText);
        addObject(outText);
        addObject(l1);
        addObject(l2);
        addObject(el);
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
            EquationRect eq = new EquationRect(i);
            eqRectList.add(eq);
        }

        index = 0;
        for (final EquationRect eqRect : eqRectList) {
            addObject(eqRect);

            eqRect.addMouseEventCallback(new MouseClickCallback() {

                @Override
                public void run(MouseClickEventType eventType, Element element) {
                    if (eventType == MouseClickEventType.CLICKED) {
                        modeChange = true;
                        equationNumber = eqRect.getIndex();
                    }
                }
            });

            eqRect.addMouseEventCallback(new MouseOverCallback() {

                @Override
                public void run(MouseOverEventType eventType, Element element) {
                    switch (eventType) {
                    case ENTERED:
                        setCursor(CursorMode.HAND);
                        break;
                    case EXITED:
                        setCursor(CursorMode.DEFAULT);
                        break;
                    default:
                        break;
                    }
                }
            });

            index++;
        }

        t1 = new Tweener(el);
        t2 = new Tweener(r);

        addTweener(t1);
        addTweener(t2);
    }

    @Override
    public void update() {
        if (modeChange) {
            modeChange = false;

            t2.clear();
            t2.animatePosition(new Vector2D(r.getX(), eqRectList.get(equationNumber).getY()), 1000, CubicInOut.class);
            t2.start();

            if (mode == 0) {
                r.setStrokeColor(ColorSet.LIGHT_PINK);
                pink.setAlpha(1.0);
                blue.setAlpha(0.4);
                inText.setStrokeColor(pink);
                outText.setStrokeColor(blue);
            }
            if (mode == 1) {
                r.setStrokeColor(ColorSet.LIGHT_BLUE);
                pink.setAlpha(0.4);
                blue.setAlpha(1.0);
                inText.setStrokeColor(pink);
                outText.setStrokeColor(blue);
            }
            if (mode == 2) {
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
    public void mouseEvent(MouseStatus e, MouseButton b) {
        if (e == MouseStatus.PRESSED) {
            el.setPosition(350, 550);
            t1.reset();
            if (mode == 0) {
                switch (equationNumber) {
                case 0:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BackIn.class);
                    break;
                case 1:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BounceIn.class);
                    break;
                case 2:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CircularIn.class);
                    break;
                case 3:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CubicIn.class);
                    break;
                case 4:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ElasticIn.class);
                    break;
                case 5:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ExponentialIn.class);
                    break;
                case 6:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, Linear.class);
                    break;
                case 7:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuadraticIn.class);
                    break;
                case 8:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuarticIn.class);
                    break;
                case 9:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuinticIn.class);
                    break;
                case 10:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, SinusoidalIn.class);
                    break;
                }
            } else if (mode == 1) {
                switch (equationNumber) {
                case 0:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BackOut.class);
                    break;
                case 1:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BounceOut.class);
                    break;
                case 2:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CircularOut.class);
                    break;
                case 3:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CubicOut.class);
                    break;
                case 4:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ElasticOut.class);
                    break;
                case 5:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ExponentialOut.class);
                    break;
                case 6:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, Linear.class);
                    break;
                case 7:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuadraticOut.class);
                    break;
                case 8:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuarticOut.class);
                    break;
                case 9:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuinticOut.class);
                    break;
                case 10:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, SinusoidalOut.class);
                    break;
                }
            }
            if (mode == 2) {
                switch (equationNumber) {
                case 0:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BackInOut.class);
                    break;
                case 1:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, BounceInOut.class);
                    break;
                case 2:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CircularInOut.class);
                    break;
                case 3:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, CubicInOut.class);
                    break;
                case 4:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ElasticInOut.class);
                    break;
                case 5:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, ExponentialInOut.class);
                    break;
                case 6:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, Linear.class);
                    break;
                case 7:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuadraticInOut.class);
                    break;
                case 8:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuarticInOut.class);
                    break;
                case 9:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, QuinticInOut.class);
                    break;
                case 10:
                    t1.animatePosition(new Vector2D(el.getX(), 200), 2000, SinusoidalInOut.class);
                    break;
                }
            }
            t1.start();
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {
        switch (e) {
        case PRESSED:
            if (getKeyCode() == 37) {
                mode--;
                if (mode < 0)
                    mode = 0;
                modeChange = true;
            } else if (getKeyCode() == 39) {
                mode++;
                if (mode > 2)
                    mode = 2;
                modeChange = true;
            }
            break;
        default:
            break;
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenEquationsExample", "TweenEquationExample");
    }

}
