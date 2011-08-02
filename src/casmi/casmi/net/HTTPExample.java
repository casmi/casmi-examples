package casmi.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.exception.NetException;
import casmi.graphics.Font;
import casmi.graphics.FontStyle;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.parser.XML;
import casmi.parser.XMLElement;

public class HTTPExample extends Applet {

    HTTP http = null;
    XML xml = new XML();
    List<Text> textList = new ArrayList<Text>();
    Font font = new Font("San-Serif", FontStyle.ITALIC, 14.0f);

    @Override
    public void setup() {

        setSize(960, 480);

        try {
            http = new HTTP("http://api.twitter.com/1/statuses/public_timeline.xml");
            http.requestGet();

            xml.parseString(http.readAll());

            int y = 50;
            for (XMLElement status : xml.getChildren()) {
                String user = status.getChild("user").getChild("screen_name").getContent();
                String tweet = status.getChild("text").getContent();
                String out = "@" + user + ": " + tweet;
                
                Text text = new Text(out, 50, y, font);
                text.setStrokeColor(Color.color(ColorSet.WHITE));
                textList.add(text);
                
                y += 20;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetException e) {
            e.printStackTrace();
        } finally {
            http.close();
        }
    }

    @Override
    public void draw(Graphics g) {
        
        for (Text text : textList) {
            g.render(text);
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.net.HTTPExample", "HTTP Example");
    }
}
