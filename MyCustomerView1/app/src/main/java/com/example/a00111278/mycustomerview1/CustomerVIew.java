package com.example.a00111278.mycustomerview1;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomerVIew extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public CustomerVIew(Context context) {
        super(context);
        this.mPaint = new Paint();
    }

    public CustomerVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(getCircle(mBitmap), 0, 0, mPaint);
    }

    private Bitmap getCircle(Bitmap bitmap) {
        float radius = bitmap.getWidth() / 2;
        Bitmap bt = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bt);
        Paint paint = new Paint();
        canvas.drawCircle(radius, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return bt;
    }
}
