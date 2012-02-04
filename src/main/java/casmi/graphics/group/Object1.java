/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011-2012, Xcoo, Inc.
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

package casmi.graphics.group;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.Triangle;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;
import casmi.tween.Tween;
import casmi.tween.TweenElement;
import casmi.tween.TweenManager;
import casmi.tween.TweenParallelGroup;
import casmi.tween.TweenType;
import casmi.tween.equations.Linear;
import casmi.tween.equations.Quint;
import casmi.tween.simpletweenables.TweenFloat;

public class Object1 extends Group{
	
	Rect r1,r2;
	Triangle t1;
	Line l1;
	Text text;
	Font f;
	TweenElement te;                                     
	private TweenManager manager = new TweenManager();   
	private boolean tweenstart;
	private TweenFloat tf;
	private double tx, ty;
	
	public Object1(){
		super();
		setup();
	}
	
	public void setup(){
		r2 = new Rect(420,90);
		r2.setStroke(false);
		r2.setFillColor(ColorSet.BLACK);
		r1 = new Rect(420,210);
		r1.setStroke(false);
		r1.setFillColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
		l1 = new Line(-90,0,210,0);
		l1.setStrokeColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
		l1.setStrokeWidth(2);
		t1 = new Triangle(-90,0,-70,0,-80,8);
		t1.setStroke(false);
		t1.setFillColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
		f = new Font("COPPERPLATE", FontStyle.PLAIN, 14);
		tf = new TweenFloat(0);
        
		text = new Text("LINE ARK",f,-165,-40);
		text.setStrokeColor(ColorSet.LIGHT_GOLDENROD_YELLOW);
		text.setScaleX(1.4);

		tx = t1.getX();
		ty = t1.getY();
		this.add(r1);
		this.add(r2);
		t1.setPosition(tx+tf.getValue(), ty);
		this.add(t1);
		l1.set((-90+tf.getValue()),0,210,0);
		this.add(l1);
		this.add(text);
		
	}
	
	@Override
	public void update(){
		if(isTweenstart()){
			tf.setValue(280);
			setTweenstart(false);
			text.getStrokeColor().setA(0);
			te = null;
			te = new TweenElement(text);
    		manager = null;
    		manager = new TweenManager();
    		this.addTweenManager(manager);
    		
    		TweenParallelGroup tpg = TweenParallelGroup.create(
        			Tween.to(tf, 3500, Quint.OUT).target(0),
        			Tween.to(te, TweenType.ALPHA_STROKE, 3500, Linear.INOUT).target(255)
        		);
    		manager.add(tpg);
			
		}
		t1.setPosition(tx+tf.getValue(),ty);
		l1.set((-90+tf.getValue()),0,210,0);
	}
	
	public boolean isTweenstart() {
		return tweenstart;
	}

	public void setTweenstart(boolean tweenstart) {
		this.tweenstart = tweenstart;
	}

}
