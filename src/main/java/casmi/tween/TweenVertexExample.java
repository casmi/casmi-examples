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
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.tween.equations.Bounce;

/**
 * Example of Tween.
 * 
 * @author Y. Ban
 * 
 */
public class TweenVertexExample extends Applet {

    Line l1 = new Line(100, 600, 500, 600);
    TweenVertex v1, v2;
    Rect r1 = new Rect(500, 200);
    Rect r2 = new Rect(150, 150);
    Color c = new RGBColor(0.1, 0.4, 0.4);
    TweenElement te, te2;
    private boolean tmfinish = false;
    TweenCallback tc;

    @Override
    public void setup() {
        setSize(1024, 768);
        
        l1.setStrokeColor(ColorSet.ALICE_BLUE);
        v1 = new TweenVertex(100, 600);
        v2 = new TweenVertex(500, 500);
        tc = new TweenCallback() {

            @Override
            public void run(TweenCallbackTypes eventType, Tween tween) {
                tmfinish = true;
            }
        };
        addObject(l1);
    }

    @Override
    public void update() {
        if (tmfinish) {
            tmfinish = false;
            v1 = v2 = null;
            v1 = new TweenVertex(100, 600);
            v2 = new TweenVertex(500, 500);

            addTween(TweenParallelGroup.create(
                Tween.to(v1, TweenType.POSITION, 3000, Bounce.OUT).target(200, 100),
                Tween.to(v2, TweenType.POSITION, 2000, Bounce.OUT).target(650, 110).addDelay(1500).addCompleteCallback(tc)
                ));
        }
        l1.set(v1, v2);
    }
    
    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED)
            tmfinish = true;
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.tween.TweenVertexExample", "TweenVertexExample");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}