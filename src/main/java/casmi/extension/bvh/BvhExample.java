/*   casmi examples
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

package casmi.extension.bvh;

import java.io.File;
import java.io.IOException;

import casmi.extension.bvh.BvhEndCallback;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Sphere;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;
import casmi.io.Reader;
import casmi.util.DateUtil;

/**
 * Bvh example.
 * 
 * @see casmi.extension.bvh.Bvh
 * 
 * @author Y. Ban
 */

public class BvhExample extends Applet{
	BvhViewer bvh1,bvh2,bvh3;
	Perspective perspective;
	Camera camera;
	Sphere s = new Sphere(10000);
	double _cos,_sin;
	int startMillis;
	boolean play;
	BvhEndCallback endcallback;
	
	@Override
	public void setup() {
		setSize(1280,720);
		setBackGroundColor(0);
		setFPS(30);
		loadBvh();
		_cos = Math.cos(DateUtil.millis() / 5000.f);
		_sin = Math.sin(DateUtil.millis() / 5000.f);
		perspective = new Perspective();
        camera      = new Camera(getWidth()/4.f + getWidth()/4.f * _cos +200, getHeight()/2.0f-100, 550 + 150 * _sin,-getWidth()/2.0f, getHeight()/2.0f, -400, 0, 1, 0);
        //setPerspective(perspective);
        setCamera(camera);
        Line l1,l2;
        l1 = new Line(getWidth()/2.0, getHeight()/2.0, -30.0, getWidth()/2.0, getHeight()/2.0, 30.0);
		l2 = new Line(getWidth()/2.0-30, getHeight()/2.0, 0, getWidth()/2.0 + 30, getHeight()/2.0, 0);
		l1.setStrokeColor(ColorSet.WHITE_SMOKE);
		l2.setStrokeColor(ColorSet.WHITE_SMOKE);
		//addObject(s);
		addObject(l1);
		addObject(l2);
		addObject(bvh1);
		addObject(bvh2);
		addObject(bvh3);
		
		endcallback = new BvhEndCallback() {
			
			public void run() {
				
				
			}
		};
		
		bvh3.addEndCallback(endcallback);
		
	}
	
	public int getMillis(){
		return DateUtil.millis() - startMillis;
	}

	@Override
	public void update() {
		if(play==true){
		_cos = Math.cos(getMillis() / 5000.f);
		_sin = Math.sin(getMillis() / 5000.f);
		camera.set(getWidth()/4.f + getWidth()/4.f * _cos +200, getHeight()/2.0f-100, 550 + 150 * _sin,-getWidth()/2.0f, getHeight()/2.0f, -400, 0, 1, 0);
		bvh1.update( getMillis() );
		bvh2.update( getMillis() );
		bvh3.update( getMillis() );
		}
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		if(e == KeyEvent.PRESSED){
			if(getKey()=='q'){
				play = false;
			}
			if(getKey()=='s'){
				startMillis = DateUtil.millis();
				play = true;
			}
				
		}
		
	}
	
	public void loadBvh() {
		Reader reader1,reader2,reader3;
		try {
			reader1 = new Reader(new File("src/main/resources/casmi/extension/bvh/A_test.bvh"));
			reader2 = new Reader(new File("src/main/resources/casmi/extension/bvh/B_test.bvh"));
			reader3 = new Reader(new File("src/main/resources/casmi/extension/bvh/C_test.bvh"));
			
			bvh1 = new BvhViewer(reader1.readLines());
			bvh2 = new BvhViewer(reader2.readLines());
			bvh3 = new BvhViewer(reader3.readLines());
			reader1.close();
			reader2.close();
			reader3.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.bvh.BvhExample", "Bvh Example");
    }

}
