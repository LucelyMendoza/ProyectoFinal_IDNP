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

public class GaleriaVIISala extends View {

    private Canvas _canvas;
    private List<PointRoom> points;
    private Context context;

    public GaleriaVIISala(Context context) {
        super(context);
        init(context);
    }

    public GaleriaVIISala(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GaleriaVIISala(Context context, AttributeSet attrs, int defStyle) {
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
        drawText();
    }

    private void drawRoom() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(60f); // Grosor de las líneas grises
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFD3D3D3); // Gris claro

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;
        float roomWidth = _canvas.getWidth() * 0.9f;
        float roomHeight = _canvas.getHeight() * 0.3f; // Hacer el rectángulo más bajo

        float left = centerX - roomWidth / 2;
        float top  = centerY - roomHeight / 2;
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
        float roomWidth = _canvas.getWidth() * 0.9f;
        float roomHeight = _canvas.getHeight() * 0.3f; // Ajustar al nuevo tamaño del rectángulo

        float left = centerX - roomWidth / 2;
        float top = centerY - roomHeight / 2;
        float right = centerX + roomWidth / 2;
        float bottom = centerY + roomHeight / 2;

        // Líneas en la parte superior
        _canvas.drawLine(left + roomWidth * 0.01f, top, left + roomWidth * 0.15f, top, paint);
        _canvas.drawLine(left + roomWidth * 0.29f, top, left + roomWidth * 0.43f, top, paint);
        _canvas.drawLine(left + roomWidth * 0.57f, top, left + roomWidth * 0.71f, top, paint);
        _canvas.drawLine(left + roomWidth * 0.85f, top, left + roomWidth * 0.99f, top, paint);

        // Líneas en la parte inferior
        _canvas.drawLine(left + roomWidth * 0.01f, bottom, left + roomWidth * 0.15f, bottom, paint);
        _canvas.drawLine(left + roomWidth * 0.29f, bottom, left + roomWidth * 0.43f, bottom, paint);
        _canvas.drawLine(left + roomWidth * 0.57f, bottom, left + roomWidth * 0.71f, bottom, paint);
        _canvas.drawLine(left + roomWidth * 0.85f, bottom, left + roomWidth * 0.99f, bottom, paint);

        // Líneas en los laterales (solo 2 en cada lado, más separadas)
        _canvas.drawLine(left, top + roomHeight * 0.2f, left, top + roomHeight * 0.4f, paint);
        _canvas.drawLine(left, top + roomHeight * 0.6f, left, top + roomHeight * 0.8f, paint);

        _canvas.drawLine(right, top + roomHeight * 0.2f, right, top + roomHeight * 0.4f, paint);
        _canvas.drawLine(right, top + roomHeight * 0.6f, right, top + roomHeight * 0.8f, paint);
    }

    private void drawDoors() {
        Drawable doorDrawableTop = AppCompatResources.getDrawable(context, R.drawable.door_p4);
        Drawable doorDrawableBottom = AppCompatResources.getDrawable(context, R.drawable.door);

        if (doorDrawableTop != null && doorDrawableBottom != null) {
            float centerX = _canvas.getWidth() / 2;
            float centerY = _canvas.getHeight() / 2;
            float roomWidth = _canvas.getWidth() * 0.9f;
            float roomHeight = _canvas.getHeight() * 0.3f; // Ajustar al nuevo tamaño del rectángulo

            float left = centerX - roomWidth / 2;
            float top = centerY - roomHeight / 2;
            float bottom = centerY + roomHeight / 2;

            // Ajustar la posición de las puertas según la imagen proporcionada

            doorDrawableBottom.setBounds((int) (left + roomWidth * 0.4f), (int) (bottom - 75), (int) (left + roomWidth * 0.6f), (int) (bottom + 15)); // Puerta inferior
            doorDrawableBottom.draw(_canvas);
        }
    }

    private void drawText() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100f);
        paint.setColor(0xFFFFA500); // Naranja
        paint.setTextAlign(Paint.Align.CENTER);

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;

        _canvas.drawText("La Sala", centerX, centerY + 30, paint); // Ajustar la posición del texto si es necesario
    }
}
