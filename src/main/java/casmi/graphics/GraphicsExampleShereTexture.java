package casmi.graphics;

import static casmi.graphics.color.ColorMode.HSB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.sun.opengl.util.BufferUtil;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Box;
import casmi.graphics.element.Cone;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Sphere;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.graphics.element.Text.TextAlign;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.image.Image.ImageMode;
import casmi.matrix.Vertex;
import casmi.parser.CSV;
import casmi.util.Cron;
import casmi.util.DateUtil;

public class GraphicsExampleShereTexture  extends Applet {
    Sphere s;
    Texture earth;
    Vertex v;
    Color maxC = new Color(240,0,0),minC = new Color(180,180,0);
    Rect board;
    Rect capacityR[] = new Rect[num];
    Font font = null,font2 = null,fonttitle = null;
    Text capacity,capMax,capMin,name,content,title;
    
    Box b = new Box(1.1);

   
    private int cx, cy;
    private double sx, sy;
    private double ex = 0.0, ey = 0.0, ez = 0.0;
    private double tx = 0.0, ty = 0.0, tz = 0.0;
    
    private double cq[] = {1.0, 0.0, 0.0, 0.0};
    private double tq[] = new double[4];
    private double rt[] = new double[16];
    
    private static double powerMax = 6000.0;
    private static double powerMin = 1000.0;
    private static int num = 10;
    
    private static final int BUFSIZE = 512;
    private Vertex mousepoint;
    
    class Plant {
        String name;
        String country;
        double capacity;
        double longitude;
        double latitude;
        Cone cone;

        Plant(String name, double capacity, String country, double longitude, double latitude) {
            this.name = name;
            this.country = country;
            this.capacity = capacity;
            this.longitude = longitude;
            this.latitude = latitude;
            cone = new Cone(0.015, this.capacity/15000.0);
            cone.setStroke(false);
            cone.setFillColor(Color.lerpColor(minC, maxC, (float)((this.capacity-powerMin)/(powerMax-powerMin))));
        }
    }
    
    List<Plant> plantList = new CopyOnWriteArrayList<Plant>();
    
    private double rot = 90.0;
    
	public void setup(){
		
		s = new Sphere(1);
        setSize(1024, 768);
        s.setStroke(false);
        earth = new Texture("rsrc/earthDiffuse2.png");
        readNuclearPowerPlant("rsrc/nuclear.csv");
        v = new Vertex(0, 0, 10);
        rt[ 0] = rt[ 5] = rt[ 10] = rt[ 15] = 1.0;
        
        board = new Rect(300,150);
        board.setStroke(false);
        board.setFillColor(new Color(255,255,255,100));
        
        for(int i = 0; i<num; i++){
        	capacityR[i] = new Rect((board.getWidth()-30)/(double)num, 10);
        	capacityR[i].setStrokeWidth(5);
        	capacityR[i].setFillColor(Color.lerpColor(minC, maxC, i/(float)(num-1)));
        	capacityR[i].setStroke(false);
        }
        
        font = new Font("San-Serif");
        font.setSize(12);
        font2 = new Font("San-Serif");
        font2.setSize(10);
        fonttitle = new Font("San-Serif");
        fonttitle.setSize(18);
        name = new Text("Name:",font);
        name.setStrokeColor(Color.color((ColorSet.WHEAT)));
        content = new Text("content",font);
        name.setStrokeColor(Color.color((ColorSet.WHITESMOKE)));
        capacity = new Text("CapacityLevel", font2);
        capacity.setStrokeColor(Color.color(ColorSet.WHITE));
        String min = Double.toString(powerMin);
        String max = Double.toString(powerMax);
        capMin = new Text(min, font2);
        capMin.setStrokeColor(Color.color(ColorSet.WHITE));
        capMax = new Text(max, font2);
        capMax.setStrokeColor(Color.color(ColorSet.WHITE));
        capMax.textAlign(TextAlign.RIGHT);
        title = new Text("NuclearPlantMap", fonttitle);
        title.setStrokeColor(Color.color(ColorSet.ORANGE));
        
        mousepoint = new Vertex(0,0);

	}
	
	private void readNuclearPowerPlant(String csvfile){
        String name;
        String country;
        double latitude;
        double longitude;
        double capacity;
        CSV csv;
        try {
            csv = new CSV(csvfile);
        	String[] test;
        	List<Plant> list = new ArrayList<Plant>();
            while ((test = csv.readLine()) != null) {
            	name = test[0];
            	String[] capacityAry = test[1].split(",");
            	capacity = Double.valueOf(capacityAry[0]).doubleValue()*1000+Double.valueOf(capacityAry[1]).doubleValue();
            	country = test[2];
            	latitude = Double.valueOf(test[3]).doubleValue();
            	longitude = Double.valueOf(test[4]).doubleValue();
            	Plant plant = new Plant(name, capacity, country, latitude, longitude);
            	System.out.println(name+" "+capacity+" "+country+" "+latitude+" "+longitude);
            	if(!plantList.contains(plant)){
            		list.add(plant);
            	}
            }
            plantList.addAll(0, list);
            csv.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }

	}
    
	
	@Override
	public void draw(Graphics g) {
		if(isMousePressed()==true){
			mousepoint.x=getMouseX();mousepoint.y=getMouseY();
			System.out.println(mousepoint.x+" "+mousepoint.y);
		}
		drawBoard(g);
    	g.perspective(30,(double)width/(double)height,1.0,100);
    	sx = 1.0 / (double)width;
    	sy = 1.0 / (double)height;
    	g.camera(2.4, 3.2, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    	trackball();
    	g.applyMatrix(rt);
    		g.pushMatrix();
    			earth.enableTexture();
    			g.pushMatrix();
    			g.rotateX(90);
    		//	g.render(s);	
    			g.popMatrix();
    			earth.disableTexture();
    			g.pushMatrix();
					g.rotateY(180);
					g.rotateX(90);
					g.pushMatrix();
						if(mousepoint != null)
							pickCone(g,g.getGL());
					g.popMatrix();
					drawCone(g,g.getGL(),GL.GL_RENDER);
				g.popMatrix();
			g.popMatrix();
		rot += 1.1;
	}
	
	public void drawBoard(Graphics g){
		g.pushMatrix();
		g.translate((double)width-board.getWidth()/2-10, 105);
		g.render(board);
		g.translate(capacityR[0].getWidth()/2, -50);
			g.pushMatrix();
				g.translate(-capacityR[0].getWidth()-(board.getWidth()/2-15), -15);
				g.render(capMin);
			g.popMatrix();
			g.pushMatrix();
				g.translate((board.getWidth()/2-15), -15);
				g.render(capMax);
			g.popMatrix();
			g.pushMatrix();
				g.translate(-board.getWidth()/2-5, 10);
				g.render(capacity);
				g.translate(-5, 95);
				g.render(title);
				g.translate(5, -18);
				name.setText("Name:");
				g.render(name);
				g.translate(0,-18);
				name.setText("Capacity:");
				g.render(name);
				g.translate(0, -18);
				name.setText("Country:");
				g.render(name);
				g.translate(0, -18);
				name.setText("Location:");
				g.render(name);
			g.popMatrix();
		for(int i=0;i<num;i++){
			g.pushMatrix();
				g.translate((i-num/2)*capacityR[i].getWidth(), 0);
				g.render(capacityR[i]);
			g.popMatrix();
		}
	g.popMatrix();
	}
	
	public void drawCone(Graphics g,GL gl,int mode){
		if(mode == GL.GL_SELECT) gl.glLoadName(0);
			g.render(b);
		for(int i = 1; i<plantList.size(); i++){
		g.pushMatrix();
			g.rotateZ(-plantList.get(i).latitude);
			g.rotateX(-plantList.get(i).longitude);
			g.translate(0,1,0);
			if(mode == GL.GL_SELECT) gl.glLoadName(i);
			g.render(plantList.get(i).cone);
		g.popMatrix();
		}
	}
	
	public void pickCone(Graphics g,GL gl){
		int selectBuff[] = new int[BUFSIZE];
		IntBuffer selectBuffer = BufferUtil.newIntBuffer(BUFSIZE);
		int hits;
		int viewport[] = new int[4];
		//DoubleBuffer projection = BufferUtil.newDoubleBuffer(16);
		
		gl.glGetIntegerv(GL.GL_VIEWPORT, viewport, 0);
		//gl.glGetDoublev(GL.GL_PROJECTION, projection);
		gl.glSelectBuffer(BUFSIZE, selectBuffer);
		gl.glRenderMode(GL.GL_SELECT);
		
		gl.glInitNames();
		
		gl.glMatrixMode(GL.GL_PROJECTION);
		g.pushMatrix();
		g.resetMatrix();
		g.getGLU().gluPickMatrix((double)mousepoint.x, (double)(mousepoint.y), 10.0, 10.0, viewport, 0);
		//g.applyMatrix(projection);
		g.perspective(30,(double)width/(double)height,1.0,100);
		gl.glMatrixMode(GL.GL_MODELVIEW);
    	g.camera(2.4, 3.2, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
    	g.applyMatrix(rt);
    	g.rotateY(180);
		g.rotateX(90);
		drawCone(g,gl,GL.GL_SELECT);
		gl.glMatrixMode(GL.GL_PROJECTION);
		g.popMatrix();
		gl.glFlush();
		hits = gl.glRenderMode(GL.GL_RENDER);
		selectBuffer.get(selectBuff);
		processHits(hits,selectBuff);
		gl.glMatrixMode(GL.GL_MODELVIEW);
	}
	
	private void processHits(int hits, int buffer[]){
		if(hits>0)
			System.out.println(hits+" "+buffer[0]+" "+buffer[1]+" "+buffer[2]+" "+buffer[3]);
	}
	
	private boolean track = false;
	private int fx, fy;
	private double dma,dmr;
	public void trackball(){
		if(isMouseDragged()==true){
		double dx, dy, a;
		dx = (getMouseX() - cx) * sx;
		dy = -(getMouseY() - cy) * sy;
		a = Math.sqrt(dx * dx + dy * dy);
		  if (a != 0.0) {
			    double ar = a * 2.0 * Math.PI * 0.5;
			    double as = Math.sin(ar) / a;
			    double dq[] = { Math.cos(ar), dy * as, dx * as, 0.0 }; 
			    qmul(tq, dq, cq);
			    qrot(rt, tq);
			  }
		}
		
		if(isMousePressed()==true){
			if(track == true){
				cq[0] = tq[0];
				cq[1] = tq[1];
				cq[2] = tq[2];
				cq[3] = tq[3];
				track = false;
				dma = 0;}
			cx = getMouseX();
			cy = getMouseY();
		}
		
		if(track == true && dma<0.5){
			cq[0] = tq[0];
			cq[1] = tq[1];
			cq[2] = tq[2];
			cq[3] = tq[3];
			track = false;
			dma = 0;
		}
		if(track == true){
			double dx, dy, a, dmx, dmy;
			
			dma -=0.5;
			//System.out.println(dma);
			dmx = dma*Math.cos(dmr);
			dmy = dma*Math.sin(dmr);
			
			fx+=dmx;
			fy+=dmy;
			dx = (fx - cx) * sx;
			dy = -(fy - cy) * sy;
			a = Math.sqrt(dx * dx + dy * dy);
			  if (a != 0.0) {
				    double ar = a * 2.0 * Math.PI * 0.5;
				    double as = Math.sin(ar) / a;
				    double dq[] = { Math.cos(ar), dy * as, dx * as, 0.0 }; 
				    qmul(tq, dq, cq);
				    qrot(rt, tq);
				  }
		}
		
		
		if(isMouseReleased()==true){
			double dmx,dmy;
			track = true;
			fx = getMouseX();
			fy = getMouseY();
			dmx = getPreMouseX() - getMouseX();
			dmy = getPreMouseY() - getMouseY();
			dma = Math.sqrt(dmx * dmx + dmy * dmy);
			dmr = Math.acos(dma/dmx);

			
		}
	}
	
	
	void qmul(double r[], double p[], double q[])
	{
	  r[0] = p[0] * q[0] - p[1] * q[1] - p[2] * q[2] - p[3] * q[3];
	  r[1] = p[0] * q[1] + p[1] * q[0] + p[2] * q[3] - p[3] * q[2];
	  r[2] = p[0] * q[2] - p[1] * q[3] + p[2] * q[0] + p[3] * q[1];
	  r[3] = p[0] * q[3] + p[1] * q[2] - p[2] * q[1] + p[3] * q[0];
	}
	
	void qrot(double r[], double q[])
	{
	  double x2 = q[1] * q[1] * 2.0;
	  double y2 = q[2] * q[2] * 2.0;
	  double z2 = q[3] * q[3] * 2.0;
	  double xy = q[1] * q[2] * 2.0;
	  double yz = q[2] * q[3] * 2.0;
	  double zx = q[3] * q[1] * 2.0;
	  double xw = q[1] * q[0] * 2.0;
	  double yw = q[2] * q[0] * 2.0;
	  double zw = q[3] * q[0] * 2.0;
	  
	  r[ 0] = 1.0 - y2 - z2;
	  r[ 1] = xy + zw;
	  r[ 2] = zx - yw;
	  r[ 4] = xy - zw;
	  r[ 5] = 1.0 - z2 - x2;
	  r[ 6] = yz + xw;
	  r[ 8] = zx + yw;
	  r[ 9] = yz - xw;
	  r[10] = 1.0 - x2 - y2;
	  r[ 3] = r[ 7] = r[11] = r[12] = r[13] = r[14] = 0.0;
	  r[15] = 1.0;
	}
	
	public static void main(String args[]) {
	        AppletRunner.run( "casmi.graphics.GraphicsExampleShereTexture", "Example");
	    }

}
