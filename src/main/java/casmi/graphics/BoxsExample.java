package casmi.graphics;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.GLUT;

public class BoxsExample extends JFrame implements GLEventListener{
    GLU glu;
    GLUT glut;

    GLCapabilities caps = new GLCapabilities();
    GLJPanel mycanvas   = new GLJPanel(caps);
    
    private static final double STROKE_BIAS_RATIO = 1.00;

	private double width  = 100.4;
	private double height = 100.4;
	private double depth  = 100.4;

    public BoxsExample(String title){
        mycanvas.addGLEventListener(this);

        setSize(800,600);
        setContentPane(mycanvas);

    }
    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
    	BoxsExample myframe = new BoxsExample("テスト");
        myframe.setLocationRelativeTo(null);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setVisible(true);
    }

    public void init(GLAutoDrawable drawable){
        GL gl = drawable.getGL();
        glu = new GLU();
        glut = new GLUT();
        //
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_FLAT);        
    }
    public void display(GLAutoDrawable drawable){
        GL gl = drawable.getGL();
        //
        gl.glClear(GL.GL_COLOR_BUFFER_BIT|GL.GL_DEPTH_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glLoadIdentity(); 
        
    //    glu.gluLookAt(2.0, 2.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
        draw(gl);
     //   glut.glutSolidCube(1.0f);
        gl.glColor3f(1.0f,0,0);
      //  glut.glutWireCube(1.0f);
        gl.glFlush();       
    }
    
    public void draw(GL gl){
    	gl.glEnable(GL.GL_DEPTH_TEST);

        gl.glPushMatrix();
        {

                gl.glEnable(GL.GL_POLYGON_OFFSET_FILL);
                gl.glPolygonOffset(1.0f, 1.0f);
            
                gl.glTranslated(300.3, 200.3, 0);
                gl.glRotated(30, 0.1, 0.2, 0.3);

            //    gl.glLineWidth(1);

                gl.glPushMatrix();
                {
                    gl.glColor4d(1.0, 0, 0, 1);
                    drawBox(gl, this.width, this.height, this.depth, GL.GL_QUADS);
                }
                gl.glPopMatrix();
            

                gl.glPushMatrix();
                {

                		gl.glColor4d(0, 1, 1, 1);
                       drawBox(gl, this.width, this.height, this.depth, GL.GL_LINE_STRIP);
                    
                }
                gl.glPopMatrix();
            

                gl.glDisable(GL.GL_POLYGON_OFFSET_FILL);
            
        }
        gl.glPopMatrix();


		gl.glDisable(GL.GL_DEPTH_TEST);
        

    }
    
    private static float[][] boxVertices;

    private static final float[][] boxNormals = {
        { -1.0f,  0.0f,  0.0f },
        {  0.0f,  1.0f,  0.0f }, 
        {  1.0f,  0.0f,  0.0f },
        {  0.0f, -1.0f,  0.0f },
        {  0.0f,  0.0f,  1.0f },
        {  0.0f,  0.0f, -1.0f }
    };

    private static final int[][] boxFaces = { 
        { 0, 1, 2, 3 },
        { 3, 2, 6, 7 },
        { 7, 6, 5, 4 },
        { 4, 5, 1, 0 },
        { 5, 6, 2, 1 },
        { 7, 4, 0, 3 }
    };

    private final void drawBox(GL gl, double width, double height, double depth, int type) {
		if (boxVertices == null) {
			boxVertices = new float[8][3];
			boxVertices[0][0] = boxVertices[1][0] = boxVertices[2][0] = boxVertices[3][0] = -0.5f;
			boxVertices[4][0] = boxVertices[5][0] = boxVertices[6][0] = boxVertices[7][0] =  0.5f;
			boxVertices[0][1] = boxVertices[1][1] = boxVertices[4][1] = boxVertices[5][1] = -0.5f;
			boxVertices[2][1] = boxVertices[3][1] = boxVertices[6][1] = boxVertices[7][1] =  0.5f;
			boxVertices[0][2] = boxVertices[3][2] = boxVertices[4][2] = boxVertices[7][2] = -0.5f;
			boxVertices[1][2] = boxVertices[2][2] = boxVertices[5][2] = boxVertices[6][2] =  0.5f;
		}

		float[][] v = boxVertices;
		float[][] n = boxNormals;
		int[][] faces = boxFaces;

		for (int i = 5; 0 <= i; i--) {
			if (type == GL.GL_QUADS) {
			//	System.out.println("test");
			}
			gl.glBegin(type);
			gl.glNormal3fv(n[i], 0);

			float[] vt = v[faces[i][0]];

			
			gl.glVertex3d(vt[0] * width, vt[1] * height, vt[2] * depth);

			vt = v[faces[i][1]];
			
			gl.glVertex3d(vt[0] * width, vt[1] * height, vt[2] * depth);

			vt = v[faces[i][2]];
			
			gl.glVertex3d(vt[0] * width, vt[1] * height, vt[2] * depth);

			vt = v[faces[i][3]];
			
			gl.glVertex3d(vt[0] * width, vt[1] * height, vt[2] * depth);

			if (type == GL.GL_LINE_STRIP) {
				vt = v[faces[i][0]];
				gl.glVertex3d(vt[0] * width, vt[1] * height, vt[2] * depth);
			}

			
			gl.glEnd();
		}
	}

    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged){

    }
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h){
        GL gl = drawable.getGL();
        //
        System.out.println("reshape");
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
      //  glu.gluPerspective(20.0, (double)w/(double)h, 1.0, 20.0);
        gl.glOrtho(0, w, 0, h, -1.0e10, 1.0e10);
        gl.glMatrixMode(GL.GL_MODELVIEW);
    }
}