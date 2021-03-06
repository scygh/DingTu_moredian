package com.moredian.entrance.guard.face.drawface;

import android.graphics.Canvas;
import android.hardware.Camera;

import com.moredian.entrance.guard.face.DeviceType;


/**
 * Created by leon on 12/4/17.
 */

public class FaceMaskDrawer extends BaseDrawer {

    public static final int FACE_TYPE_NORMAL = 0;
    public static final int FACE_TYPE_PENDANT = 1;

    private BaseFaceDrawer mFaceDrawer;

    private Camera.Face[] mFaces;

    private int mCurrentType;

    public FaceMaskDrawer(DrawerSurface drawerSurface) {
        super(drawerSurface);
        showFaceType(FACE_TYPE_NORMAL);
    }

    public boolean showFaceType(int type) {
        if(mFaceDrawer != null && type == mCurrentType) {
            return false;
        }
        mCurrentType = type;
        if(DeviceType.isG2()) {
            mFaceDrawer = new FaceDefaultDrawerG2(getContext());
        }else if(DeviceType.isMg1() || DeviceType.isMS4()){
            mFaceDrawer = new FaceDefaultDrawerMg1(getContext());
        }else{
            mFaceDrawer =new FaceDefaultDrawer(getContext());
        }
        return true;
    }

    public boolean setFaces(Camera.Face[] faces) {
        if (faces == null && this.mFaces == null){
            return false;
        }
        this.mFaces = faces;
        if(mFaceDrawer != null) {
            mFaceDrawer.updateFace(faces);
        }
        return true;
    }

    @Override
    public boolean isEnable() {
        if(mFaces != null && mFaces.length > 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        if(mFaceDrawer != null) {
            mFaceDrawer.drawFace(canvas, mFaces);
        }
    }
}
