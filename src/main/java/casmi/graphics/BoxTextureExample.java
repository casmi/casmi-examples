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

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Box;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;
import casmi.image.Texture;

/**
 * Example of Graphics.
 *
 * @author K. Nishimura
 *
 */
public class BoxTextureExample extends Applet {

	private static final String[] imageNames = {
	    "sai4.png",
	    "sai2.png",
	    "sai3.png",
	    "sai5.png",
	    "sai1.png",
	    "sai6.png"
	};

	private static URL[] imageURLs = new URL[6];

	static {
		for (int i = 0; i < imageNames.length; i++) {
			imageURLs[i] = BoxTextureExample.class.getResource(imageNames[i]);
		}
	}

	private Texture[] textures = new Texture[6];
	private Box b = new Box(1);

	private double rot = 0;
	private Perspective p;
	private Camera c;

	@Override
	public void setup() {
		setSize(800, 600);

		b.setStrokeWidth(1);
		b.setFillColor(new RGBColor(1.0, 1.0, 1.0));
		b.setFill(true);
		b.setStroke(false);
		b.setRotation(rot, 1, 3, 5);

		p = new Perspective(30, (double)getWidth() / (double)getHeight(),
				            1.00, 500);
		c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

		setPerspective(p);
		setCamera(c);

		for (int i = 0; i < textures.length; i++) {
			textures[i] = new Texture(imageURLs[i]);
			b.setTexture(i, textures[i]);
		}

		addObject(b);
	}

	@Override
    public void update() {
        rot += 0.1;
        b.setRotation(rot, 1, 3, 5);
    }

    @Override
    public void exit() {}

	@Override
	public void mouseEvent(MouseStatus e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}

	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.BoxTextureExample", "BoxTextureExample");
    }

}
