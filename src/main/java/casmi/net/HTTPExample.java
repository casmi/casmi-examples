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

package casmi.net;

import java.io.IOException;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.exception.ParserException;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.io.Reader;
import casmi.parser.XML;
import casmi.parser.XMLElement;

/**
 * HTTP class example.
 * <p>
 * Gets public timeline of Twitter and shows.
 * 
 * @author T. Takeuchi
 * 
 * @see casmi.net.HTTP
 */
public class HTTPExample extends Applet {

    HTTP http = null;
    XML  xml  = new XML();
    Font font = new Font("San-Serif", FontStyle.ITALIC, 14.0);

    @Override
    public void setup() {
        setSize(960, 480);

        try {
            http = new HTTP("http://api.twitter.com/1/statuses/public_timeline.xml");
            Reader r = http.requestGet();

            xml.parseString(r.readAll());

            int y = 50;
            for (XMLElement status : xml.getChildren()) {
                String user = status.getChildren("user")[0].getChildren("screen_name")[0].getContent();
                String tweet = status.getChildren("text")[0].getContent();
                String out = "@" + user + ": " + tweet;
                
                Text text = new Text(out, font, 50, y);
                text.setStrokeColor(ColorSet.WHITE);
                addObject(text);
                
                y += 20;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserException e) {
            e.printStackTrace();
        } finally {
        	// do nothing
        }
    }

	@Override
	public void update() {}

	@Override
	public void keyEvent(KeyEvent e) {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.net.HTTPExample", "HTTP Example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
