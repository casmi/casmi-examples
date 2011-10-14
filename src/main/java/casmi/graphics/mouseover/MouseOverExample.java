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

package casmi.graphics.mouseover;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.graphics.Graphics;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.*;
/**
 * Example of MouseOver.
 * 
 * @author Y. Ban
 * 
 */
public class MouseOverExample extends Applet {
    
    MouseOver r,e,t,t2,q,a,rr;
    Rect rect;
    Ellipse ellipse;
    Triangle triangle,triangle2;
    Quad quad;
    Arc arc;
    RoundRect roundrect;

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
        ellipse.setStrokeColor(ColorSet.LIGHTBLUE);
        ellipse.setFill(false);
        triangle.setFillColor(ColorSet.LAVENDER);
        triangle.setStroke(false);
        triangle2.setFillColor(ColorSet.LEMONCHIFFON);
        quad.setStrokeColor(ColorSet.AQUA);
        quad.setFill(false);
        arc.setStroke(false);
        arc.setFillColor(ColorSet.OLIVEDRAB);
        roundrect.setStroke(false);
        roundrect.setFillColor(ColorSet.GOLD);
        roundrect.setRadius(20);
        r = new MouseOver(rect);
        e = new MouseOver(ellipse);
        t = new MouseOver(triangle);
        t2 = new MouseOver(triangle2);
        q = new MouseOver(quad);
        a = new MouseOver(arc);
        rr = new MouseOver(roundrect);
    }

    @Override
    public void draw(Graphics g) {
    	if(r.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.HAND);
    		}
    	else if(e.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.CROSS);
    	}
    	else if(t.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.TEXT);
    	}
    	else if(t2.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.WAIT);
    	}
    	else if(q.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.HAND);
    	}
    	else if(a.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.CROSS);
    	}
    	else if(rr.isMouseOver(getMouseX(), getMouseY())){
    		cursor(CursorMode.WAIT);
    	}
    	else 
    		cursor(CursorMode.DEFAULT);
    	rect.setRotate(10);
    	ellipse.setRotate(-15);
    	roundrect.setRotate(-25);
        g.render(r);
        g.render(e);
        g.render(t);
        g.render(t2);
        g.render(q);
        g.render(a);
        g.render(rr);
    }

    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.mouseover.MouseOverExample", "Example");
    }
}
