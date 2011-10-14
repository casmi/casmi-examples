package casmi.graphics;

import static casmi.graphics.color.ColorMode.HSB;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.image.Image.ImageMode;
import casmi.util.Cron;
import casmi.util.DateUtil;

public class Amesh extends Applet {
    private static final long serialVersionUID = 1L;
    private static final String BASE_IMAGE_PATH="http://tokyo-ame.jwa.or.jp/map/map000.jpg";
	private static final String UPPER_IMAGE_PATH="http://tokyo-ame.jwa.or.jp/map/msk000.png";
	Texture baseImage,upperImage,ameImage;
	Rect rct;
	String nowdate;
	private Timer timer;
	int backend = 0;
	Back2HoursTask backtask = null;

    Font font = new Font("San-Serif", FontStyle.PLAIN, 12.0f);
    
    class GetTimeTask extends TimerTask {
		@Override
		public void run() {
			nowdate = getTime(calcTime());
		}
	}
    
    class Back2HoursTask extends TimerTask {
		@Override
		public void run() {
			getTime(back2hours());
		}
	}

    @Override
    public void setup() {

        setSize(1024, 768);
        
     
      timer = new Timer();
		timer.schedule(new GetTimeTask(), 0, (long)(1000.0*60));
        
        try{
        baseImage = new Texture(new URL(BASE_IMAGE_PATH));
        baseImage.getImage().imageMode(ImageMode.CENTER);
        upperImage = new Texture(new URL(UPPER_IMAGE_PATH));
        upperImage.getImage().imageMode(ImageMode.CENTER);
        }catch (IOException e) {
            e.printStackTrace();
        } 
        
        rct = new Rect(baseImage.Width, baseImage.Height);
        rct.setStroke(false);
        rct.setFillColor(new Color(120));
        
        backtask = new Back2HoursTask();
    }

    @Override
    public void draw(Graphics g) {
         g.background(200);
         g.pushMatrix();
         g.translate(width/2+8, height/2-8);
         g.render(rct);
         g.setcolor(255);
         g.popMatrix();
         if(isMouseClicked()==true&&backend==0){
        	 System.out.println("click!");
        	 timer.schedule(backtask, 0, (long)500.0);
         }
         if(backend==2){
        	 backtask.cancel();
        	 backend=0;
         }
         g.image(baseImage.getImage(),width/2,height/2);
         g.image(upperImage.getImage(),width/2,height/2);
         if(ameImage!=null)
        	g.image(ameImage.getImage(), width/2, height/2);
  	  
        }

    
    private final String getTime(String s){
    	String date;
    	date = "http://tokyo-ame.jwa.or.jp/mesh/000/"+s+".gif";
		
    	try{
    		ameImage = null;
    		ameImage = new Texture(new URL(date));
    		ameImage.getImage().imageMode(ImageMode.CENTER);
        	
           System.out.println(s);
           if(ameImage==null){
        	   System.out.println("null");
           }

    	} catch (IOException e) {
    		try {
    			System.out.println("test");
    	           
				ameImage = new Texture(new URL(UPPER_IMAGE_PATH));
				ameImage.getImage().imageMode(ImageMode.CENTER);
           		} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
            e.printStackTrace();
    	}
    	return s;
    }
    
    private final String calcTime(){
    	String d;
    	int pp=0,minute=0;
    	int min = DateUtil.minute();
    	for(int i=0; i<6; i++){
    		if((min>=i*10)&&(min<=(i+1)*10)){
    			pp=i;
    		}
    	}
    	for(int i=0; i<10; i++){
    		if((min%10)<=5){
    			minute = pp*10;
    		}else{
    			minute = pp*10+5;
    		}
    	}
    	d=String.valueOf(DateUtil.year())+String.format("%1$08d",DateUtil.month()*1000000+DateUtil.day()*10000+DateUtil.hour()*100+minute);
    	return d;
    }
    
    int y,m,d,h,min,nowh,nowmin;
	
    public String back2hours(){
    	String date = "";
    	if(backend==0){
        d = Integer.valueOf(nowdate.substring(6,8)).intValue();
    	nowh = h = Integer.valueOf(nowdate.substring(8,10)).intValue();
    	nowmin = min = Integer.valueOf(nowdate.substring(10,12)).intValue();
    	h-=2;
    	backend=1;
    	if(h<0){
    		d--;
    		h=h+24;
    	}
    	}
    	if(backend==1){
    		min += 5;
    			
    		if(min == 60){
    			h++;min=0;
    		}
    		if(h==24&&min==0){
    			h=0;d++;
    		}
    		date = nowdate.substring(0,6)+String.format("%1$06d",d*10000+h*100+min);
    		if(h==nowh&&min==nowmin){
    			backend=2;
    		}
    	}
    	return date;
    }
     
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.Amesh", "Example");
    }
}
