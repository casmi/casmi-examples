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
import casmi.tween.equations.Bounce;

/**
 * Example of Timeline.
 *
 * @author Y. Ban
 */
public class TimelineExample extends Applet {

    Timeline tl;
    Scene0 s0;
    Scene1 s1;
    Scene2 s2;
    Scene3 s3;

    @Override
    public void setup() {
        setSize(1024, 768);

        tl = new Timeline();
        s0 = new Scene0("scene0", 2);
        s1 = new Scene1("scene1", 2);
        s2 = new Scene2("scene2", 2);
        s3 = new Scene3("scene3", 2);

        tl.appendScene(s0, DissolveMode.CURTAIN_TOP, 1, Bounce.OUT);
        tl.appendScene(s1, DissolveMode.CURTAIN_RIGHT, 1, Bounce.OUT);
        tl.appendScene(s2, DissolveMode.CURTAIN_BOTTOM, 1, Bounce.OUT);
        tl.appendScene(s3, DissolveMode.CURTAIN_LEFT, 1, Bounce.OUT);

        tl.startTimer();

        addObject(tl);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.timeline.TimelineExample", "Timeline Example");
    }
}
