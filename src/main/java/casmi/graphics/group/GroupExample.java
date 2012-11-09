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

package casmi.graphics.group;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.tween.Tween;
import casmi.tween.TweenCallback;
import casmi.tween.TweenCallbackTypes;
import casmi.tween.TweenElement;
import casmi.tween.TweenParallelGroup;
import casmi.tween.TweenSerialGroup;
import casmi.tween.TweenType;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Circ;
import casmi.tween.equations.Linear;

/**
 * Group example.
 * 
 * @author Y. Ban
 *
 * @see casmi.graphics.group.Group
 */
public class GroupExample extends Applet {

    SampleGroup group = new SampleGroup();
    TweenElement te;
    TweenCallback tc;

    @Override
    public void setup() {
        setSize(800, 600);
        setBackGroundColor(ColorSet.GRAY);
        
        tc = new TweenCallback() {

            @Override
            public void run(TweenCallbackTypes eventType, Tween tween) {
                group.setTweenstart(true);
            }
        };
        
        group.setPosition(getWidth() / 2.0, getHeight() / 2.0);
        
        addObject(group);
    }

    @Override
    public void update() {}
    
    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        
        if (e == MouseEvent.PRESSED) {
            te = null;
            te = new TweenElement(group);

            TweenSerialGroup tsg = TweenSerialGroup.create(
                Tween.to(te, TweenType.POSITION, 2000, Bounce.OUT).target(getWidth() / 2, getHeight() / 2 - 200).addCompleteCallback(tc),
                TweenParallelGroup.create(
                    Tween.to(te, TweenType.ALPHA, 2000, Linear.INOUT).target(50.0f),
                    Tween.to(te, TweenType.ROTATION_2D, 1000, Circ.OUT).target(-360).addDelay(1000)
                    ),
                    Tween.to(te, TweenType.SCALE, 2000, Bounce.OUT).target(1.5f, 1.0f)
                );

            addTween(tsg);
        }
    }
   
    @Override
    public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.group.GroupExample", "GroupExample");
    }
	
}
