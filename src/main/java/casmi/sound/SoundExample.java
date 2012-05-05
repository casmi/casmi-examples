package casmi.sound;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;

public class SoundExample extends Applet{

	Sound sound;
	AudioPlayer player;
	List<Line> Llines;
	List<Line> Rlines;
	
	@Override
	public void setup() {
		setSize(512,200);
		sound = new Sound();
		player = sound.loadFile("src/main/resources/casmi/test.mp3", 2048);
		Llines = new ArrayList<Line>();
		Rlines = new ArrayList<Line>();
		setLine();
	}
	
	public void setLine(){
		for(int i = 0; i < player.bufferSize() - 1; i++)
		  {
		    double x1 = map(i, 0, player.bufferSize(), 0, getWidth());
		    double x2 = map(i+1, 0, player.bufferSize(), 0, getWidth());
		    Llines.add(new Line(x1, 50 + player.left.get(i)*50, x2, 50 + player.left.get(i+1)*50));
		    Rlines.add(new Line(x1, 150 + player.right.get(i)*50, x2, 150 + player.right.get(i+1)*50));
		    Llines.get(i).setStrokeColor(ColorSet.AQUAMARINE);
		    Rlines.get(i).setStrokeColor(ColorSet.AQUAMARINE);
		    addObject(Llines.get(i));
		    addObject(Rlines.get(i));
		  }
		//addObject(Llines);
		//addObject(Rlines);
	}
	
	static public final double map(double value,
            float istart, double istop,
            float ostart, double ostop) {
		return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
	}
	
	@Override
	public void end(){
		player.close();
		sound.stop();
	}

	@Override
	public void update() {
		for(int i = 0; i < player.bufferSize() - 1; i++)
		  {
		    double x1 = map(i, 0, player.bufferSize(), 0, getWidth());
		    double x2 = map(i+1, 0, player.bufferSize(), 0, getWidth());
		    Llines.get(i).set(x1, 50 + player.left.get(i)*50, x2, 50 + player.left.get(i+1)*50);
		    Rlines.get(i).set(x1, 150 + player.right.get(i)*50, x2, 150 + player.right.get(i+1)*50);
		  }
		
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
        AppletRunner.run("casmi.sound.SoundExample", "Sound Example");
    }

}
