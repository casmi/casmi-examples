/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
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
import casmi.graphics.color.GrayColor;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.object.Mask;

/**
 * Color of Group example.
 *
 * @author Y. Ban
 */
public class GroupColorExample extends Applet {

    class GroupX extends Group {

        Line l1 = new Line(200, 200, 400, 400);
        Line l2 = new Line(200, 400, 400, 200);

        public GroupX() {
            this.add(l1);
            this.add(l2);
        }

        @Override
        public void update() {}
    }

	GroupX    group;
	double    gray;
	GrayColor color;
	Mask mask;
	Rect rect;

    @Override
    public void setup() {
        setSize(600, 600);
        mask = new Mask();
        group = new GroupX();
        gray = 1.0;
        color = new GrayColor(gray);
        group.setStrokeColor(color);
        group.setStrokeWidth(25);
        rect = new Rect(150,150);
        rect.setPosition(300, 300);
        mask.add(rect);
        group.setMask(mask);
        addObject(group);
    }

    @Override
	public void update() {
    	if (gray < 0.0)
    		gray = 1.0;
    	gray -= 0.01;
    	rect.setScale(1-gray);
    	color.setGray(gray);
    }

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.group.GroupColorExample", "GroupColorExample");
    }
}
