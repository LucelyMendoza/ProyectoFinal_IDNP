package com.example.login.Galerias;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.content.res.AppCompatResources;

import com.example.login.PointRoom;
import com.idnp2024a.loginsample.R;

import java.util.List;

public class GaleriaIV extends View {
    private Canvas _canvas;
    private List<PointRoom> points;
    private Context context;

    public GaleriaIV(Context context) {
        super(context);
        init(context);
    }

    public GaleriaIV(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GaleriaIV(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    public void setData(List<PointRoom> points) {
        this.points = points;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        _canvas = canvas;
        drawRoom();
        drawPictures();
        drawDoors();
        drawTitle();
    }
    private void drawTitle() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100f); // Tamaño del texto
        paint.setColor(0xFFFFA500); // Color amarillo
        float textX = _canvas.getWidth() /2;
        float textY = _canvas.getHeight() / 4;
        _canvas.drawText("Galería IV", textX - 200, textY + 550, paint);//POSICION TEXTO
    }
    private void drawRoom() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(60f); // Grosor de las líneas grises
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFD3D3D3); // Gris claro

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;
        float roomWidth = _canvas.getWidth() * 0.8f;
        float roomHeight = _canvas.getHeight() * 0.8f;

        float left = centerX - roomWidth / 2;
        float top = centerY - roomHeight / 2;
        float right = centerX + roomWidth / 2;
        float bottom = centerY + roomHeight / 2;

        Path path = new Path();
        path.moveTo(left, top); // Top-left
        path.lineTo(right, top); // Top-right
        path.lineTo(right, bottom); // Bottom-right
        path.lineTo(left, bottom); // Bottom-left
        path.close();

        _canvas.drawPath(path, paint);
    }

    private void drawPictures() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(30f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFF800080); // Morado

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;
        float roomWidth = _canvas.getWidth() * 0.8f;
        float roomHeight = _canvas.getHeight() * 0.8f;

        float left = centerX - roomWidth / 2;
        float top = centerY - roomHeight / 2;
        float right = centerX + roomWidth / 2;
        float bottom = centerY + roomHeight / 2;

        // Dibujar líneas azules para las pinturas (rectángulos)

        _canvas.drawLine(left + roomWidth * 0.12f, top, left + roomWidth * 0.39f, top, paint); // Top-1
        _canvas.drawLine(left + roomWidth * 0.61f, top, left + roomWidth * 0.88f, top, paint); // Top-2

        _canvas.drawLine(left, top + 100, left, bottom - 1200, paint); // Left1
        _canvas.drawLine(left, top + 700, left, bottom - 600, paint); // Left2
        _canvas.drawLine(left, top + 1300, left, bottom - 0, paint); // Left3

        _canvas.drawLine(right, top + 100, right, bottom - 1200, paint); // Right1
        _canvas.drawLine(right, top + 700, right, bottom - 600, paint); // Right2
        _canvas.drawLine(right, top + 1300, right, bottom - 0, paint); // Right3

        _canvas.drawLine(left + roomWidth * 0.12f, bottom, left + roomWidth * 0.39f, bottom, paint); // Bottom-1
        _canvas.drawLine(left + roomWidth * 0.61f, bottom, left + roomWidth * 0.88f, bottom, paint); // Bottom-2
    }

    private void drawDoors() {
        Drawable doorDrawableTop = AppCompatResources.getDrawable(context, R.drawable.door_p4);
        Drawable doorDrawableBottom = AppCompatResources.getDrawable(context, R.drawable.door);

        if (doorDrawableTop != null && doorDrawableBottom != null) {
            float centerX = _canvas.getWidth() / 2;
            float centerY = _canvas.getHeight() / 2;
            float roomWidth = _canvas.getWidth() * 0.8f;
            float roomHeight = _canvas.getHeight() * 0.8f;

            float left = centerX - roomWidth / 2;
            float top = centerY - roomHeight / 2;
            float bottom = centerY + roomHeight / 2;

            // Ajustar la posición de las puertas según la imagen proporcionada
            doorDrawableTop.setBounds((int) (left + roomWidth * 0.4f), (int) (top - 15), (int) (left + roomWidth * 0.6f), (int) (top + 75)); // Puerta superior
            doorDrawableTop.draw(_canvas);

            doorDrawableBottom.setBounds((int) (left + roomWidth * 0.4f), (int) (bottom - 75), (int) (left + roomWidth * 0.6f), (int) (bottom + 15)); // Puerta inferior
            doorDrawableBottom.draw(_canvas);
        }
    }
}
