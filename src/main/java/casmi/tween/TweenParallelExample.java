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

import java.util.ArrayList;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Circ;
import casmi.tween.equations.Linear;

/**
 * Example of Tween.
 * 
 * @author Y. Ban
 * 
 */
public class TweenParallelExample extends Applet {

    Rect r1 = new Rect(500, 200);
    Rect r2 = new Rect(150, 150);
    Color white = new RGBColor(1.0, 1.0, 1.0, 1.0);
    Color lb;
    TweenElement te, te2;
    TweenCallback tweencallback;
    String s = "casmi";
    private boolean tmfinish = true;
    Font f = null;
    Text text;
    Line l;
    private ArrayList<TweenElement> tes;
    TweenParallelGroup tg = new TweenParallelGroup();

    TweenCallback tc;

    private Text ttt[] = new Text[5];

    @Override
    public void setup() {
        setSize(1024, 768);

        tc = new TweenCallback() {

            @Override
            public void run(TweenCallbackTypes eventType, Tween tween) {
                tmfinish = true;

            }
        };

        f = new Font("San-Serif");
        tes = new ArrayList<TweenElement>(5);

        f.setSize(45);
        lb = new RGBColor(ColorSet.LIGHT_BLUE, 0.0);
        for (int i = 0; i < s.length(); i++) {
            if (i == 4) ttt[i] = new Text(s.substring(i, i + 1), f, 100 + 60 * i + 20, 700);
            else ttt[i] = new Text(s.substring(i, i + 1), f, 100 + 60 * i, 700);
            ttt[i].setStrokeColor(lb);
            ttt[i].setAlign(TextAlign.CENTER);
        }

        for (int i = 0; i < s.length(); i++) {
            tes.add(new TweenElement(ttt[i]));
        }

        for (int i = 0; i < s.length(); i++) {
            addObject(ttt[i]);
        }

        tweencallback = new TweenCallback() {

            @Override
            public void run(TweenCallbackTypes eventType, Tween tween) {
                tmfinish = true;

            }
        };
    }

    @Override
    public void update() {
        if (tmfinish) {
            tmfinish = false;
            clearTween();
            for (int i = 0; i < tes.size(); i++) {
                tes.get(i).reset();
            }

            for (int i = 0; i < 5; i++) {
                TweenSerialGroup tgtmp;
                if (i != 4) {
                    tgtmp = (TweenSerialGroup)TweenSerialGroup.create(
                        TweenParallelGroup.create(
                            Tween.to(tes.get(i), TweenType.ALPHA_STROKE, 2500, Linear.INOUT).target(255.0f),
                            Tween.to(tes.get(i), TweenType.POSITION, 2500, Circ.OUT).target(100 + 60 * i, 700 - 316)
                            ),
                        TweenParallelGroup.create(
                            Tween.to(tes.get(i), TweenType.POSITION, 4000, Bounce.OUT).target(100 + 60 * i, 700 - 316 * 2),
                            Tween.to(tes.get(i), TweenType.ALPHA_STROKE, 4000, Linear.INOUT).target(0.0f).addDelay(200)
                            ).addDelay(3000)
                        ).addDelay(i * 500);
                } else {
                    tgtmp = (TweenSerialGroup)TweenSerialGroup.create(
                        TweenParallelGroup.create(
                            Tween.to(tes.get(i), TweenType.ALPHA_STROKE, 2500, Linear.INOUT).target(255.0f),
                            Tween.to(tes.get(i), TweenType.POSITION, 2500, Circ.OUT).target(100 + 60 * i, 700 - 316)
                            ),
                        TweenParallelGroup.create(
                            Tween.to(tes.get(i), TweenType.POSITION, 4000, Bounce.OUT).target(100 + 60 * i, 700 - 316 * 2),
                            Tween.to(tes.get(i), TweenType.ALPHA_STROKE, 4000, Linear.INOUT).target(0.0f).addDelay(200).addCompleteCallback(tweencallback)
                            ).addDelay(3000)
                        ).addDelay(i * 500);

                }
                tg.append(tgtmp);
            }

            addTween(tg);
        }
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenParallelExample", "Example");
    }
}
