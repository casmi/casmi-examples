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
import casmi.graphics.color.Color;
import casmi.graphics.element.Sphere;
import casmi.graphics.material.Material;
import casmi.graphics.object.Light;
import casmi.graphics.object.Light.LightMode;
import casmi.matrix.Vertex;

/**
 * Example of Graphics.
 * 
 * @author Y.Ban
 */
public class MaterialExample extends Applet {

	Sphere s1 = new Sphere(70.0);
	Sphere s2 = new Sphere(70.0);
	Sphere s3 = new Sphere(70.0);

	Material m1 = new Material();
	Material m2 = new Material();
	Material m3 = new Material();

	Light l = new Light(LightMode.SPOT);
	
	Color c = new Color(250, 250, 250);
	
	Vertex v1 = new Vertex(1000, 1000, 1000);
	Vertex v2 = new Vertex(-10, 0, -10);

	float emerald_ambient[] = { 255 * 0.0115f, 255 * 0.745f, 255 * 0.0115f, 255 * 1.0f },
		  emerald_diffuse[] = { 255 * 0.07568f, 255 * 0.61424f, 255 * 0.07568f, 255 * 1.0f },
		  emerald_specular[] = { 255 * 0.733f, 255 * 0.927811f, 255 * 0.733f, 255 * 1.0f },
		  emerald_shininess[] = { 60.8f };

	public void setup() {
		setSize(1024, 768);

		s1.setStroke(false);
		m1.shininess(3);
		m1.ambient(2);
		m1.diffuse((float) (255 * 0.5), (float) (255 * 0.5), (float) (255 * 0.9));
		m1.specular(30);
		s1.setMaterial(m1);

		s2.setStroke(false);
		m2.shininess(emerald_shininess);
		m2.ambient(emerald_ambient);
		m2.diffuse(emerald_diffuse);
		m2.specular(emerald_specular);
		s2.setMaterial(m2);

		s3.setStroke(false);
		m3.shininess(100f);
		m3.ambient(10);
		m3.diffuse((float) (255 * 0.9), (float) (255 * 0.6), (float) (255 * 0.6));
		m3.specular(200);
		s3.setMaterial(m3);
		
		s1.setPosition(300,430,100);
		s2.setPosition(500,430,100);
		s3.setPosition(700,430,100);
		addObject(s1);
		addObject(s2);
		addObject(s3);
		addLight(l);
		l.setAngle(30);
		l.setPosition(v2);
		l.setDirection(1, 0, 1);
		l.setColor(c);
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.graphics.MaterialExample", "Example");
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}