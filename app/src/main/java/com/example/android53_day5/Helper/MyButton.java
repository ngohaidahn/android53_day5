package com.example.android53_day5.Helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.load.engine.Resource;

public class MyButton {
    private String text;
    private int imgResId, textSize, color, pos;
    private RectF clickRegion;
    private MyButtonClickListener listener;
    private Context context;
    private Resources resources;

    public MyButton() {
    }

    public MyButton(Context context, String text, int textSize, int imgResId, int color, MyButtonClickListener listener) {
        this.text = text;
        this.imgResId = imgResId;
        this.textSize = textSize;
        this.color = color;
//        this.pos = pos;
//        this.clickRegion = clickRegion;
        this.listener = listener;
        this.context = context;
//        this.resources = resources;
        resources = context.getResources();
    }

    public boolean onClick(float x, float y) {
        if (clickRegion != null && clickRegion.contains(x, y)) {
            listener.onClick(pos);
            return true;
        }
        return false;
    }

    public void onDraw(Canvas c, RectF rectF, int pos) {
        Paint p = new Paint();
        p.setColor(color);
        c.drawRect(rectF, p);
        p.setColor(Color.WHITE);
        p.setTextSize(textSize);
        Rect r = new Rect();
        float cHeight = rectF.height();
        float cWidth = rectF.width();
        p.setTextAlign(Paint.Align.LEFT);
        p.getTextBounds(text, 0, text.length(), r);
        float x = 0, y = 0;
        if (imgResId == 0) {
            x = cWidth / 2f - r.width() / 2f - r.left;
            y = cHeight / 2f + r.height() / 2f - r.bottom;
            c.drawText(text, rectF.left + x, rectF.top + y, p);
        } else {
            Drawable d = ContextCompat.getDrawable(context, imgResId);
            Bitmap bitmap = drawableToBitMap(d);
            c.drawBitmap(bitmap, (rectF.left + rectF.right) / 2, (rectF.top + rectF.bottom) / 2, p);
        }
        clickRegion = rectF;
        this.pos = pos;
    }

    private Bitmap drawableToBitMap(Drawable d) {
        if (d instanceof BitmapDrawable)
            return ((BitmapDrawable) d).getBitmap();
        Bitmap bitmap = Bitmap.createBitmap(d.getIntrinsicWidth(),
                d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        d.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        d.draw(canvas);
        return bitmap;
    }
}
