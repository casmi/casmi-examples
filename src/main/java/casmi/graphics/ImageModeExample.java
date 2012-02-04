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
import casmi.graphics.element.Rect;
import casmi.graphics.element.Texture;
import casmi.image.ImageMode;
import casmi.util.SystemUtil;

/**
 * Example of Graphics.
 * 
 * @author Y. BAN
 * 
 */
public class ImageModeExample extends Applet {

   Texture tex = null;
    Rect r1 = new Rect(100,100);
    
   // String imagePath = ".." + SystemUtil.FILE_SEPARATOR + "rsrc" + SystemUtil.FILE_SEPARATOR + "logo.png";  // TODO can not work when running as Java Application
   // String imagePath = "rsrc" + SystemProperty.FILE_SEPARATOR + "logo.png";
    String imagePath = "rsrc" + SystemUtil.FILE_SEPARATOR + "logo.png";
    
    
    public void setup(){
        setSize(1024, 768);
        System.out.println(SystemUtil.USER_DIR);
        tex = new Texture(imagePath);
        tex.setMode(ImageMode.CORNER);
        tex.setPosition(300, 300);
        addObject(tex);
        addObject(r1);
        tex.setMode(ImageMode.CENTER);
        tex.setPosition(600, 600);
        addObject(tex);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.ImageModeExample", "Example");
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