package xyz.hasaki.svgparse.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import xyz.hasaki.svgparse.svg.SvgParseUtil;

/**
 * Created by ywd on 2017/11/28.
 */

public class SvgView extends View {

    private float[] size;

    public SvgView(Context context) {
        super(context);
    }

    public SvgView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //        mModelMap.put( zhuanjiaoshuzhuo ,"zhuanjiaoshuzhuo,转角书桌,1200,1200,750,0,120,120");
        size = new float[]{120, 120, 120, 120};
    }

    public SvgView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        Path path = SvgParseUtil.parseSvgPathFromXml(getContext(), "flatmodels/ic_model_zhuanjiaoshuzhuo.xml", size);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);


        Path destPath = new Path();
        destPath.addPath(path);
        Matrix matrix = new Matrix();
        matrix.setScale(2,2);
        destPath.transform(matrix);
        canvas.drawPath(destPath,paint);
    }
}
