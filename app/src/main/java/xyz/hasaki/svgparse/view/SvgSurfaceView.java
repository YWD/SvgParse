package xyz.hasaki.svgparse.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ywd on 2017/11/28.
 */

public class SvgSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public SvgSurfaceView(Context context) {
        super(context);
    }

    public SvgSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SvgSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = holder.lockCanvas();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
