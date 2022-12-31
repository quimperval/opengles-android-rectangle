package com.perval.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends Activity {
    private GLSurfaceView glSurfaceView;
    private boolean rendererSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new CRenderer(this));
        rendererSet = true;
        setContentView(glSurfaceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(rendererSet){
            glSurfaceView.onResume();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(rendererSet){
            glSurfaceView.onPause();
        }
    }

}