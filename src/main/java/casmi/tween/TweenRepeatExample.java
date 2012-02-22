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

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Texture;
import casmi.tween.equations.Bounce;
import casmi.util.SystemUtil;

/**
 * Example of TweenRepeat.
 * 
 * @author Y. Ban
 * 
 */
public class TweenRepeatExample  extends Applet{

    Texture tex = null;
    TweenElement te;  
    
    URL imagePath = Applet.class.getResource("logo.png");
    
    
    
    
    @Override
    public void setup(){
        setSize(1024, 768);
        System.out.println(SystemUtil.USER_DIR);
       tex = new Texture(imagePath);
       tex.setPosition(200, 500);
       addObject(tex);
		te = new TweenElement(tex);
		addTween(Tween.to(te, TweenType.POSITION, 3000, Bounce.OUT).targetRelative(45,0).addDelay(1000).repeat(-1, 300));
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.tween.TweenRepeatExample", "Example");
	}

}
