package com.bawei.chenyipeng.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bawei.chenyipeng.R;

import static android.R.attr.radius;

/**
 * Use:自定义控件
 * Author:陈懿鹏
 * Data:2017/4/10.
 */

public class MyView  extends ImageView{

    private float yuankuan;
    private int yuanresId;
    private int jinduiresId;
    private int textResId;
    private Paint paint;


    public MyView(Context context) {
        super(context);
        initPaint();


    }



    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initArrts(attrs);
        initPaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initArrts(attrs);
        initPaint();
    }
    //初始化话属性
    private void initArrts(AttributeSet attrs){
        //获取属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyView);
        yuankuan = typedArray.getFloat(R.styleable.MyView_yuankuan,10);
        yuanresId = typedArray.getResourceId(R.styleable.MyView_yuancolor,-1);
        jinduiresId = typedArray.getResourceId(R.styleable.MyView_jinducolor,-1);
        textResId = typedArray.getResourceId(R.styleable.MyView_textcolor,-1);
        setImageResource(yuanresId);

        typedArray.recycle();


    }
    //初始化画笔
    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //k开始画
        canvas.drawColor(Color.BLUE);
       canvas.drawCircle(120,120,100,paint);
        paint.setColor(textResId);
        paint.setTextSize(30);
        paint.setStrokeWidth(2);
        canvas.drawText("78%",120,120,paint);
        RectF rect = new RectF(120-100,120-100,120+100,120+100);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(20);
        canvas.drawArc(rect,0,90,false,paint);
    }
}
