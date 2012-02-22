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
package casmi.extension.coni;

import java.util.HashMap;
import java.util.Map;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.extension.coni.exception.CONIException;
import casmi.extension.coni.listener.PoseDetectionListener;
import casmi.extension.coni.listener.SkeletonListener;
import casmi.extension.coni.listener.UserListener;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Line;
import casmi.graphics.element.Text;
import casmi.graphics.element.Texture;
import casmi.graphics.object.GraphicsObject;
import casmi.matrix.Vertex;

/**
 * CONI (casmi OpenNI) user tracking example.
 * <p>
 * This example shows a depth view and tracks users and their skeletons.
 * 
 * @author T. Takeuchi
 */
public class UserTrackerExample extends Applet 
implements UserListener, SkeletonListener, PoseDetectionListener {

    private static final RGBColor[] COLORS = {
        new RGBColor(ColorSet.RED),
        new RGBColor(ColorSet.BLUE),
        new RGBColor(ColorSet.CYAN),
        new RGBColor(ColorSet.GREEN),
        new RGBColor(ColorSet.MAGENTA),
        new RGBColor(ColorSet.PINK),
        new RGBColor(ColorSet.YELLOW),
        new RGBColor(ColorSet.WHITE)
    };
    
    private CONI coni;
    private Map<Integer, Map<SkeletonJoint, Joint>> joints;

    private GraphicsObject group;
    private Texture tex;
    
    @Override
    public void setup() {
        setSize(640, 480);
        
        coni = new CONI();
        coni.enableDepth(640, 480, 30);
        coni.enableUser();
        coni.enableSkeleton();
        coni.addUserListener(this);
        coni.addSkeletonListener(this);
        coni.addPoseDetectionListener(this);
        coni.setMirror(true);
        
        joints = new HashMap<Integer, Map<SkeletonJoint,Joint>>();
        
        group = new GraphicsObject();
    }

    @Override
    public void update() {
        group.clear();
        
        try {
            // update sensor data
            coni.update();
            
            // rendering depth and users
            tex = coni.getDepthMap().getTexture();
            tex.setPosition(getWidth() / 2, getHeight() / 2);
            group.add(tex);
            tex = coni.getUserMap().getTexture();
            tex.setPosition(getWidth() / 2, getHeight() / 2);
            tex.setFillColor(ColorSet.BLUE);
            group.add(tex);
            
            // rendering skeletons and labels
            int[] users = coni.getUsers();
            for (int i = 0; i < users.length; i++) {
                drawSkeleton(users[i]);
                drawLabel(users[i]);
            }
        } catch (CONIException e) {
            e.printStackTrace();
        }
        
        addObject(group);
    }
    
    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    @Override
    public void outOfPose(CONI coni) {}

    @Override
    public void poseDetected(CONI coni, String pose, int userID) {
        coni.stopPoseDetection(userID);
        coni.requestSkeletonCalibration(userID);
    }

    @Override
    public void poseDetectionInProgress(CONI coni, int userID) {}

    @Override
    public void calibrationComplete(CONI coni, int userID, CalibrationStatus status) {
        if (status == CalibrationStatus.OK) {
            coni.startSkeletonTracking(userID);
            joints.put(userID, new HashMap<SkeletonJoint, Joint>());
        } else {
            coni.startPoseDetection(userID);
        }
    }

    @Override
    public void calibrationInProgress(CONI coni) {}

    @Override
    public void calibrationStart(CONI coni, int userID) {}

    @Override
    public void newUser(CONI coni, int userID) {
        coni.startPoseDetection(userID);
    }

    @Override
    public void lostUser(CONI coni, int userID) {
        joints.remove(userID);
    }
    
    private void getJoint(int userID, SkeletonJoint sj) {
        Joint j = coni.getJoint(userID, sj);
        
        if (j.getPosition().getZ() != 0) {
            Joint newJ = new Joint(coni.convertRealWorldToProjective(j.getPosition()),
                                                                     j.getConfidence());
            newJ.getPosition().setY(getHeight() - newJ.getPosition().getY());
            joints.get(userID).put(sj, newJ);
        } else {
            joints.get(userID).put(sj, new Joint());
        }
    }
    
    private void getJoints(int userID) {
        getJoint(userID, SkeletonJoint.HEAD);
        getJoint(userID, SkeletonJoint.NECK);
        
        getJoint(userID, SkeletonJoint.LEFT_SHOULDER);
        getJoint(userID, SkeletonJoint.LEFT_ELBOW);
        getJoint(userID, SkeletonJoint.LEFT_HAND);

        getJoint(userID, SkeletonJoint.RIGHT_SHOULDER);
        getJoint(userID, SkeletonJoint.RIGHT_ELBOW);
        getJoint(userID, SkeletonJoint.RIGHT_HAND);

        getJoint(userID, SkeletonJoint.TORSO);

        getJoint(userID, SkeletonJoint.LEFT_HIP);
        getJoint(userID, SkeletonJoint.LEFT_KNEE);
        getJoint(userID, SkeletonJoint.LEFT_FOOT);

        getJoint(userID, SkeletonJoint.RIGHT_HIP);
        getJoint(userID, SkeletonJoint.RIGHT_KNEE);
        getJoint(userID, SkeletonJoint.RIGHT_FOOT);
    }
    
    private void drawLine(Map<SkeletonJoint, Joint> joints,
                          SkeletonJoint sj1, SkeletonJoint sj2,
                          Color c) {
        if (joints.get(sj1).getConfidence() == 0 ||
            joints.get(sj2).getConfidence() == 0) {
            return;
        }
        
        Vertex p1 = joints.get(sj1).getPosition();
        Vertex p2 = joints.get(sj2).getPosition();

        Line l = new Line(p1, p2);
        l.setStrokeColor(c);
        group.add(l);
    }
    
    private void drawSkeleton(int userID) {
        if (!coni.isSkeletonTracking(userID)) {
            return;
        }
        
        getJoints(userID);
        Map<SkeletonJoint, Joint> m = joints.get(userID);
        Color c = COLORS[userID % COLORS.length].getComplementaryColor();

        drawLine(m, SkeletonJoint.HEAD,           SkeletonJoint.NECK,           c);

        drawLine(m, SkeletonJoint.LEFT_SHOULDER,  SkeletonJoint.TORSO,          c);
        drawLine(m, SkeletonJoint.RIGHT_SHOULDER, SkeletonJoint.TORSO,          c);

        drawLine(m, SkeletonJoint.NECK,           SkeletonJoint.LEFT_SHOULDER,  c);
        drawLine(m, SkeletonJoint.LEFT_SHOULDER,  SkeletonJoint.LEFT_ELBOW,     c);
        drawLine(m, SkeletonJoint.LEFT_ELBOW,     SkeletonJoint.LEFT_HAND,      c);

        drawLine(m, SkeletonJoint.NECK,           SkeletonJoint.RIGHT_SHOULDER, c);
        drawLine(m, SkeletonJoint.RIGHT_SHOULDER, SkeletonJoint.RIGHT_ELBOW,    c);
        drawLine(m, SkeletonJoint.RIGHT_ELBOW,    SkeletonJoint.RIGHT_HAND,     c);

        drawLine(m, SkeletonJoint.LEFT_HIP,       SkeletonJoint.TORSO,          c);
        drawLine(m, SkeletonJoint.RIGHT_HIP,      SkeletonJoint.TORSO,          c);
        drawLine(m, SkeletonJoint.LEFT_HIP,       SkeletonJoint.RIGHT_HIP,      c);

        drawLine(m, SkeletonJoint.LEFT_HIP,       SkeletonJoint.LEFT_KNEE,      c);
        drawLine(m, SkeletonJoint.LEFT_KNEE,      SkeletonJoint.LEFT_FOOT,      c);

        drawLine(m, SkeletonJoint.RIGHT_HIP,      SkeletonJoint.RIGHT_KNEE,     c);
        drawLine(m, SkeletonJoint.RIGHT_KNEE,     SkeletonJoint.RIGHT_FOOT,     c);
    }
    
    private void drawLabel(int userID) {
        Text label = null;
        if (coni.isSkeletonTracking(userID)) {
            label = new Text(userID + " - Tracking");
        } else if (coni.isSkeletonCalibrating(userID)) {
            label = new Text(userID + " - Calibrating");
        } else {
            label = new Text(userID + " - Looking for pose");
        }
        
        Vertex com = coni.convertRealWorldToProjective(coni.getUserCoM(userID));
        Color c = COLORS[userID % COLORS.length].getComplementaryColor();
        
        label.setPosition(com);
        label.setStrokeColor(c);
        group.add(label);
    }
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.coni.UserTrackerExample", "CONI (casmi-OpenNI): user tracking example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
