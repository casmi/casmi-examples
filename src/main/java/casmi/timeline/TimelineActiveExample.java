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

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 */
public class TimelineActiveExample extends Applet {

    Timeline tl;
    SceneTop st;
    Scene1 s1;
    Scene2 s2;
    Scene3 s3;
    Scene4 s4;

    @Override
    public void setup() {
        setSize(1024, 768);

        tl = new Timeline();
        addObject(tl);

        st = new SceneTop("Top");
        s1 = new Scene1("scene1");
        s2 = new Scene2("scene2");
        s3 = new Scene3("scene3");
        s4 = new Scene4("scene4");

        tl.appendScene(st);
        tl.appendScene(s1);
        tl.appendScene(s2);
        tl.appendScene(s3);
        tl.appendScene(s4);

        tl.startTimer();
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.timeline.TimelineActiveExample", "Timeline Active Example");
    }
}
