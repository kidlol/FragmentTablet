package com.example.afdal.fragmenttablet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Kawasaki extends AppCompatActivity implements View.OnClickListener
{
    private ImageView l1image1,l1image2;
    private ImageView l2image1,l2image2;
    private int mInputImageForBitmap;
    private ImageView pointer;
    private Bitmap image2Bitmap;
    private ResizableImageView imageLayer1,imageLayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kawasaki);
        findViewById();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int screenWidth = displayMetrics.widthPixels;

        l1image1.setOnClickListener(this);
        l1image2.setOnClickListener(this);

        l2image1.setOnClickListener(this);
        l2image2.setOnClickListener(this);

        if (mInputImageForBitmap == 0 || mInputImageForBitmap == -1)
        {
            image2Bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yamaha2);
        }

        pointer.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int sliderX = (int) event.getRawX();
                if (sliderX > 0 && sliderX < screenWidth - 80) {
                    pointer.setX(sliderX);
                }

                int fX = ScaleFunction(sliderX+50, 0, screenWidth, 0, image2Bitmap.getWidth());
                final Bitmap outputBitmap = Bitmap.createBitmap(imageLayer2.getWidth(), imageLayer2.getHeight(), Bitmap.Config.ARGB_8888);
                final Canvas canvas = new Canvas(outputBitmap);
                final Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setStrokeWidth(0);
                final Rect rect = new Rect(fX, 0, image2Bitmap.getWidth(), image2Bitmap.getHeight());
                final double imageWidth = image2Bitmap.getWidth();
                final double imageHeight = image2Bitmap.getHeight();
                final double imageAspect = imageWidth / imageHeight;
                final double finalImageHeight = imageLayer2.getWidth() / imageAspect;
                final double startY = (imageLayer2.getHeight() / 2.0) - (finalImageHeight / 2.0);
                final RectF rectF = new RectF(sliderX+50, (int) startY, imageLayer2.getWidth(), (int) startY + (int) finalImageHeight);
                paint.setAntiAlias(true);
                paint.setColor(Color.RED);
                canvas.drawRect(rectF, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(image2Bitmap, rect, rectF, paint);
                imageLayer2.setImageBitmap((outputBitmap));
                return true;
            }
        });
    }
    private void findViewById()
    {
        l1image1 = (ImageView)findViewById(R.id.layer1Image1);
        l1image2 = (ImageView)findViewById(R.id.layer1Image2);


        l2image1 = (ImageView)findViewById(R.id.layer2Image1);
        l2image2 = (ImageView)findViewById(R.id.layer2Image2);


        imageLayer1 = (ResizableImageView)findViewById(R.id.imageLayer1);
        imageLayer2 = (ResizableImageView)findViewById(R.id.imageLayer2);
        pointer = (ImageView) findViewById(R.id.pointer);
    }

    public void onClick(View v)
    {
        int vId = v.getId();
        if (vId == l1image1.getId())
        {
            imageLayer1.setImageResource(R.drawable.ducati);
        }
        if (vId == l1image2.getId())
        {
            imageLayer1.setImageResource(R.drawable.ducati1);
        }


        if (vId == l2image1.getId())
        {
            image2Bitmap = drawableToBitmap(l2image1.getDrawable());
            mInputImageForBitmap = l2image1.getId();
        }
        if (vId == l2image2.getId())
        {
            image2Bitmap = drawableToBitmap(l2image2.getDrawable());
            mInputImageForBitmap = l2image2.getId();
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public int ScaleFunction(int xCoordinate, double A, double B, double C, double D) {
        double resultData = 0.0;
        double data1 = xCoordinate - A;
        double data2 = B - A;
        if (data2 != 0) {
            resultData = data1 / data2;
        }
        double start = Math.round((C * (1.0 - resultData)));
        double end = D * resultData;
        double finalResult = (start + end);
        return (int) finalResult;
    }
}
