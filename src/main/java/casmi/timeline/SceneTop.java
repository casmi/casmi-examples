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

package casmi.timeline;

import java.util.ArrayList;

import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.tween.Tween;
import casmi.tween.Tweener;
import casmi.tween.TweenParallelGroup;
import casmi.tween.TweenSerialGroup;
import casmi.tween.TweenType;
import casmi.tween.equations.Linear;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 */
public class SceneTop extends Scene {

    static final String IMAGE_PATH = casmi.Applet.class.getResource("logo.png").getPath();

    private Texture tex;
    private double rot = 0.0;
    private ArrayList<Tweener> tes;
    private TweenParallelGroup tg = new TweenParallelGroup();

    private Text[] text = new Text[4];
    private MouseClickCallback mcc;

    public SceneTop(String id) {
        super(id);
        System.out.println(IMAGE_PATH);
        tex = new Texture(IMAGE_PATH);
        tex.setX(200);
        tex.setY(500);
        tex.setWidth(tex.getWidth() / 1.2);
        tex.setRotation(rot, 0.0, 1.0, 0.0);
        addObject(tex);

        text[0] = new Text("Rect");
        text[1] = new Text("Triangle");
        text[2] = new Text("Bezier");
        text[3] = new Text("Box");

        tes = new ArrayList<Tweener>(text.length);

        mcc = new MouseClickCallback() {

            @Override
            public void run(MouseClickTypes eventtype, Element element) {
                if (eventtype == MouseClickTypes.PRESSED && element instanceof Text) {
                    Text t = (Text)element;
                    System.out.println("goNextScene:" + t.getText());
                    if (t.getText() == "Rect")
                        goNextScene("scene1", DissolveMode.CROSS, 3);
                    if (t.getText() == "Triangle")
                        goNextScene("scene2", DissolveMode.CROSS, 3);
                    if (t.getText() == "Bezier")
                        goNextScene("scene3", DissolveMode.CROSS, 3);
                    if (t.getText() == "Box")
                        goNextScene("scene4", DissolveMode.CROSS, 3);
                }				
            }
        };

        int index = 0;
        for (Text t : text) {
            t.setPosition(1024 - 100, 110 - index * 30);
            t.setStrokeColor(ColorSet.WHITE_SMOKE);
            t.setStrokeColorAlpha(0);
            t.addMouseEventCallback(mcc);
            tes.add(new Tweener(t));
            this.addObject(t);
            index++;
        }
        setTextTween();
    }

    private void setTextTween() {
        int index = 0;
        for (Tweener t : tes) {
            TweenSerialGroup tgtmp = (TweenSerialGroup)TweenSerialGroup.create(
                TweenParallelGroup.create(
                    Tween.to(t, TweenType.ALPHA_STROKE, 2500, Linear.INOUT).target(1.0f)
                    )
                ).addDelay(index * 1000);
            index++;
            tg.append(tgtmp);
        }
        addTween(tg);
    }

    @Override
    public void EnteredSceneCallback() {
        clearTween();
        for (Tweener t : tes) {
            t.reset();
        }
        setTextTween();
    }

    @Override
    public void update() {
        rot += 2.0;
        tex.setRotation(rot, 0.0, 1.0, 0.0);
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}
}
