package casmi.graphics.mouseover;

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

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Arc;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Quad;
import casmi.graphics.element.Rect;
import casmi.graphics.element.RoundRect;
import casmi.graphics.element.Triangle;
/**
 * Example of MouseOver.
 * 
 * @author Y. Ban
 * 
 */
public class MouseOverExample extends Applet {
    
    Rect rect;
    Ellipse ellipse;
    Triangle triangle,triangle2;
    Quad quad;
    Arc arc;
    RoundRect roundrect;
    
    MouseOverCallback mouseovercb;
    MouseClickCallback mouseclickcb;

    public void setup() {
        setSize(1024, 768);
       
        rect = new Rect(800,500,200,150);
        ellipse = new Ellipse(150, 300, 100, 150);
        triangle = new Triangle(500,100,600,250,650,50);
        triangle2 = new Triangle(400,500,500,700,550,550);
        quad = new Quad(20,600,70,550,200,630,80,680);
        arc = new Arc(800, 100, 70, 30, 100, 30);
        roundrect = new RoundRect(10,200,100,100,60);
        rect.setFillColor(ColorSet.ORANGE);
        rect.setStroke(false);
        ellipse.setStrokeColor(ColorSet.LIGHT_BLUE);
        ellipse.setFill(false);
        triangle.setFillColor(ColorSet.LAVENDER);
        triangle.setStroke(false);
        triangle2.setFillColor(ColorSet.LEMON_CHIFFON);
        quad.setStrokeColor(ColorSet.AQUA);
        quad.setFill(false);
        arc.setStroke(false);
        arc.setFillColor(ColorSet.OLIVE_DRAB);
        roundrect.setStroke(false);
        roundrect.setFillColor(ColorSet.GOLD);
        roundrect.setRadius(20);
        addObject(rect);
        addObject(ellipse);
        addObject(triangle);
        addObject(triangle2);
        addObject(quad);
        addObject(arc);
        addObject(roundrect);
        
        mouseovercb = new MouseOverCallback() {
        	@Override
        	public void run(MouseOverTypes eventtype, Element element){
        		switch(eventtype){
        		case ENTERED:
        			if(element == rect)
        				cursor(CursorMode.HAND);
        			if(element == ellipse)
        				cursor(CursorMode.CROSS);
        			if(element == triangle)
        				cursor(CursorMode.CROSS);
        			if(element == triangle2)
        				cursor(CursorMode.TEXT);
        			if(element == arc || element == quad)
        				cursor(CursorMode.WAIT);
        			if(element == roundrect)
        				cursor(CursorMode.HAND);
        			break;
        		case EXITED:
        			cursor(CursorMode.DEFAULT);
        			break;
        		}
        	}
        };
        
        mouseclickcb = new MouseClickCallback() {
			
			@Override
			public void run(MouseClickTypes eventtype,
					Element element) {
				switch(eventtype){
				case DRAGGED:
					element.setPosition(element.getX()+getMouseX()-getPreMouseX(), element.getY()+getMouseY()-getPreMouseY());
				}
				
			}
		};
        
        rect.addMouseEventCallback(mouseovercb);
        ellipse.addMouseEventCallback(mouseovercb);
        triangle.addMouseEventCallback(mouseovercb);
        triangle2.addMouseEventCallback(mouseovercb);
        quad.addMouseEventCallback(mouseovercb);
        arc.addMouseEventCallback(mouseovercb);
        roundrect.addMouseEventCallback(mouseovercb);
        
        rect.addMouseEventCallback(mouseclickcb);
        ellipse.addMouseEventCallback(mouseclickcb);
        triangle.addMouseEventCallback(mouseclickcb);
        triangle2.addMouseEventCallback(mouseclickcb);
        quad.addMouseEventCallback(mouseclickcb);
        arc.addMouseEventCallback(mouseclickcb);
        roundrect.addMouseEventCallback(mouseclickcb);
    }
    

    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.mouseover.MouseOverExample", "Example");
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


	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
