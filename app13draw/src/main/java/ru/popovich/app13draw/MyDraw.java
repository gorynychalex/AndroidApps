package ru.popovich.app13draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {

    // Объявление переменных для параметров рисования: холст, круг, прямоугольник, текст
    private Paint paintCanvas, paintCircle, paintRectangle, paintText;

    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // -------------------------------------------------------- //
        // Параметры рисования определяются в объекте класса Paint
        paintCanvas = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCanvas.setSubpixelText(true);
        paintCanvas.setColor(Color.WHITE);

        // Закрашиваем холст
        canvas.drawPaint(paintCanvas);

        // -------------------------------------------------------- //
        // Параметры рисования для круга
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setColor(Color.argb(127,0,0,255));

        // Полупрозрачный синий круг радиусом 100 пикселей в центре экрана
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, paintCircle);

        // -------------------------------------------------------- //
        // Параметры рисования для прямоугольника
        paintRectangle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintRectangle.setColor(Color.BLUE);

        // Синий прямоугольник вверху экрана
        canvas.drawRect(0, 0, getWidth(),200, paintRectangle);

        // -------------------------------------------------------- //
        // Текст
        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(Color.WHITE);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setTextSize(30);
        canvas.drawText("Простая графика", 50, 100, paintText);

        // -------------------------------------------------------- //
        // Картинка
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.android);

        int xx = canvas.getWidth(), yy = canvas.getHeight();
        canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paintCanvas);

    }
}
