package com.zhushen.pdfdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Zhushen on 2018/4/28.
 */
public class PathDrawer extends View {
    private Context context;
    private Paint mPaint;
    private Path path;

    public PathDrawer(Context context) {
        this(context,null);
    }

    public PathDrawer(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathDrawer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,mPaint);
    }
}
