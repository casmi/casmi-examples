package casmi.timeline;

import java.util.ArrayList;

import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.tween.Tween;
import casmi.tween.TweenElement;
import casmi.tween.TweenParallelGroup;
import casmi.tween.TweenSerialGroup;
import casmi.tween.TweenType;
import casmi.tween.equations.Linear;

public class SceneTop extends Scene{
	
    static final String IMAGE_PATH = casmi.Applet.class.getResource("logo.png").getPath();
    
    private Texture tex;
    private double rot = 0.0;
    private ArrayList<TweenElement> tes;
    private TweenParallelGroup tg = new TweenParallelGroup();

    private Text text[] = new Text[3];
    private MouseClickCallback mcc;

	public SceneTop(String id) {
		super(id);
    	System.out.println(IMAGE_PATH);
        tex = new Texture(IMAGE_PATH);
        tex.setX(200);
        tex.setY(500);
        tex.setWidth(tex.getWidth() / 1.2);
        tex.setRotation(rot, 0.0, 1.0, 0.0);
        addObject(tex);
        
        text[0] = new Text("Rect");
        text[1] = new Text("Triangle");
        text[2] = new Text("Bezier");
        

        tes = new ArrayList<TweenElement>(text.length);
        
        mcc = new MouseClickCallback() {
			
			@Override
			public void run(MouseClickTypes eventtype, Element element) {
				if(eventtype == MouseClickTypes.PRESSED && element instanceof Text){
					Text t = (Text)element;
					if(t.getText()=="Rect")
						goNextScene("scene1", DissolveMode.CROSS, 3);
					if(t.getText()=="Triangle")
						goNextScene("scene2", DissolveMode.CROSS, 3);
					if(t.getText()=="Bezier")
						goNextScene("scene3", DissolveMode.CROSS, 3);
					
				}				
			}
		};
		
        int index = 0;
        for(Text t : text){
        	t.setPosition(1024-100, 80-index*30);
        	t.setStrokeColor(ColorSet.WHITE_SMOKE);
        	t.setStrokeColorAlpha(0);
        	t.addMouseEventCallback(mcc);
            tes.add(new TweenElement(t));
        	this.addObject(t);
        	index++;
        }
        setTextTween();
        
	}
	
	private void setTextTween() {
        int index = 0;
        for(TweenElement t : tes){
        TweenSerialGroup tgtmp = (TweenSerialGroup)TweenSerialGroup.create(
                TweenParallelGroup.create(
                        Tween.to(t, TweenType.ALPHA_STROKE, 2500, Linear.INOUT).target(1.0f)
                        )
                    ).addDelay(index * 1000);
        index++;
        tg.append(tgtmp);
        }
        addTween(tg);
	}
	
	@Override
	public void EnteredSceneCallback() {
		clearTween();
        for (TweenElement t : tes) {
            t.reset();
        }
		setTextTween();
	}

	@Override
	public void update() {
        rot += 2.0;
        tex.setRotation(rot, 0.0, 1.0, 0.0);
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		
	}

}
