package casmi.net;

import java.io.IOException;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.exception.ParserException;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.io.Reader;
import casmi.parser.XML;
import casmi.parser.XMLElement;

public class HTTPExample extends Applet {

    HTTP http = null;
    XML xml = new XML();
    Font font = new Font("San-Serif", FontStyle.ITALIC, 14.0f);

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
                text.setStrokeColor(Color.color(ColorSet.WHITE));
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

    public static void main(String[] args) {
        AppletRunner.run("casmi.net.HTTPExample", "HTTP Example");
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}
}
