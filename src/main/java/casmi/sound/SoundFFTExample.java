package casmi.sound;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Line;
import casmi.graphics.element.Text;
import casmi.sound.analysis.FFT;

public class SoundFFTExample extends Applet{

	Sound sound;
	AudioPlayer player;
	List<Line> lines;
	FFT fft;
	AudioMetaData meta;
	Text title,author;

    Color from = new RGBColor(ColorSet.LIGHT_BLUE);
    Color to   = new RGBColor(ColorSet.ORANGE);
	
	
	@Override
	public void setup() {
		setSize(512,200);
		sound = new Sound();
		player = sound.loadFile("src/main/resources/casmi/test.mp3", 2048);
		fft = new FFT(player.bufferSize(), player.sampleRate());
		meta = player.getMetaData();
		lines = new ArrayList<Line>();
		setLine();
		title = new Text(meta.title());
		author= new Text(meta.album());
		title.setStrokeColor(ColorSet.WHITE);
		author.setStrokeColor(ColorSet.WHITE);
	    addObject(title);
		addObject(author);
		title.setPosition(380, 170);
		author.setPosition(450, 170);
	}
	
	public void setLine(){
		fft.forward(player.mix);
		for(int i = 0; i < fft.specSize(); i++)
		  {
		    lines.add(new Line(i, 0, i, fft.getBand(i)*3));
		    lines.get(i).setStrokeColor(RGBColor.lerpColor(from, to, i/(double)fft.specSize()));
		    lines.get(i).setStrokeWidth(1);
		    addObject(lines.get(i));
		  }
	}
	
	
	@Override
	public void end(){
		player.close();
		sound.stop();
	}

	@Override
	public void update() {
		fft.forward(player.mix);
		for(int i = 0; i < fft.specSize(); i++)
		    lines.get(i).set(i, 0, i, fft.getBand(i)*4);
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		if(e==KeyEvent.PRESSED){
			if(getKey()=='s'){
				player.play();
			}
			if(getKey()=='q'){
				player.close();
			}
			if(getKey()=='p'){
				player.pause();
			}
				
		}
		
	}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.sound.SoundFFTExample", "Sound Example");
    }

}
