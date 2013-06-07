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

package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Sphere;
import casmi.graphics.object.Camera;

/**
 * Camera example.
 *
 * @author Y. Ban
 *
 * @see casmi.graphics.object.Camera
 */
public class CameraExample extends Applet {

	@Override
	public void setup() {
		setSize(800, 600);

		Line lineX = new Line(0.0, 0.0, 0.0,
		                      1.0, 0.0, 0.0);
		lineX.setStrokeColor(ColorSet.RED);
		lineX.setStrokeWidth(2.0);
		addObject(lineX);

		Line lineY = new Line(0.0, 0.0, 0.0,
		                      0.0, 1.0, 0.0);
		lineY.setStrokeColor(ColorSet.BLUE);
		lineY.setStrokeWidth(2.0);
		addObject(lineY);

		Line lineZ = new Line(0.0, 0.0, 0.0,
		                      0.0, 0.0, 1.0);
		lineZ.setStrokeColor(ColorSet.GREEN);
		lineZ.setStrokeWidth(2.0);
		addObject(lineZ);

		Sphere sphere = new Sphere(1.0);
		sphere.setStrokeColor(ColorSet.AQUA, 0.4);
		sphere.setFill(false);
		addObject(sphere);

		setPerspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);

		Camera camera = new Camera(2.4, 3.2, 4.0,  // eye
		                           0.0, 0.0, 0.0,  // center
		                           0.0, 1.0, 0.0); // orientation
        setCamera(camera);
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
        AppletRunner.run( "casmi.graphics.CameraExample", "CameraExample");
    }
}
