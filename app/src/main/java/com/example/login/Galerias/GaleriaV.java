package com.example.login.Galerias;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.content.res.AppCompatResources;

import com.idnp2024a.loginsample.R;

public class GaleriaV extends View {
    private Canvas _canvas;
    private Context context;

    public GaleriaV(Context context) {
        super(context);
        init(context);
    }

    public GaleriaV(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GaleriaV(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        _canvas = canvas;
        drawRoom();
        drawTitle();
        drawPaintings();
        drawDoors();
    }

    private void drawRoom() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(40f); // Grosor de las líneas grises
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFD3D3D3); // Gris claro

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;
        float roomSize = Math.min(_canvas.getWidth(), _canvas.getHeight()) * 0.8f;

        float left = centerX - roomSize / 2;
        float top = centerY - roomSize / 2;
        float right = centerX + roomSize / 2;
        float bottom = centerY + roomSize / 2;

        Path path = new Path();
        path.moveTo(left, top); // Top-left
        path.lineTo(right, top); // Top-right
        path.lineTo(right, bottom); // Bottom-right
        path.lineTo(left, bottom); // Bottom-left
        path.close();

        _canvas.drawPath(path, paint);
    }

    private void drawTitle() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(100f); // Tamaño del texto
        paint.setColor(0xFFFFA500); // Color amarillo
        float textX = _canvas.getWidth() / 2;
        float textY = _canvas.getHeight() / 2;
        _canvas.drawText("Galería V", textX - 200, textY, paint);
    }

    private void drawPaintings() {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(30f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFF800080); // Morado

        float centerX = _canvas.getWidth() / 2;
        float centerY = _canvas.getHeight() / 2;
        float roomSize = Math.min(_canvas.getWidth(), _canvas.getHeight()) * 0.8f;

        float left = centerX - roomSize / 2;
        float top = centerY - roomSize / 2;
        float right = centerX + roomSize / 2;
        float bottom = centerY + roomSize / 2;

        float thirdWidth = roomSize / 3;
        float thirdHeight = roomSize / 3;

        // Dibujar 3 líneas azules para cada lado

        // Izquierda (bajando más las pinturas)
        _canvas.drawLine(left, top + thirdHeight * 0 + 100, left, top + thirdHeight * 0.5f + 100, paint);

        _canvas.drawLine(left, top + thirdHeight * 2 + 100, left, top + thirdHeight * 2.5f + 100, paint);

        // Derecha (bajando más las pinturas)
        _canvas.drawLine(right, top + thirdHeight * 0 + 100, right, top + thirdHeight * 0.5f + 100, paint);
        _canvas.drawLine(right, top + thirdHeight * 1 + 100, right, top + thirdHeight * 1.5f + 100, paint);
        _canvas.drawLine(right, top + thirdHeight * 2 + 100, right, top + thirdHeight * 2.5f + 100, paint);

        // Arriba (moviendo a la derecha)
        _canvas.drawLine(left + thirdWidth * 0 + 20, top, left + thirdWidth * 0.5f + 20, top, paint);
        _canvas.drawLine(left + thirdWidth * 1 + 40, top, left + thirdWidth * 1.5f + 40, top, paint);
        _canvas.drawLine(left + thirdWidth * 2 + 60, top, left + thirdWidth * 2.5f + 60, top, paint);

        // Abajo (moviendo a la derecha)
        _canvas.drawLine(left + thirdWidth * 0 + 20, bottom, left + thirdWidth * 0.5f + 20, bottom, paint);
        _canvas.drawLine(left + thirdWidth * 1 + 40, bottom, left + thirdWidth * 1.5f + 40, bottom, paint);
        _canvas.drawLine(left + thirdWidth * 2 + 60, bottom, left + thirdWidth * 2.5f + 60, bottom, paint);
    }

    private void drawDoors() {
        Drawable doorDrawable = AppCompatResources.getDrawable(context, R.drawable.door_p3);

        if (doorDrawable != null) {
            float centerX = _canvas.getWidth() / 2;
            float centerY = _canvas.getHeight() / 2;
            float roomSize = Math.min(_canvas.getWidth(), _canvas.getHeight()) * 0.8f;

            float left = centerX - roomSize / 2;
            float top = centerY - roomSize / 2;
            float bottom = centerY + roomSize / 2;

            // Ajustar la posición y tamaño de la puerta
            int doorWidth = doorDrawable.getIntrinsicWidth() / 2; // Hacer la puerta la mitad de su ancho
            int doorHeight = doorDrawable.getIntrinsicHeight() / 2; // Hacer la puerta la mitad de su alto

            int doorLeft = (int) left;
            int doorTop = (int) (centerY - doorHeight / 2);
            int doorRight = doorLeft + doorWidth;
            int doorBottom = doorTop + doorHeight;

            doorDrawable.setBounds(doorLeft, doorTop, doorRight, doorBottom);
            doorDrawable.draw(_canvas);
        } else {
            // Mensaje de error si la imagen no se encuentra
            Paint errorPaint = new Paint();
            errorPaint.setColor(0xFFFF0000); // Rojo
            errorPaint.setTextSize(50);
            _canvas.drawText("Error: La imagen de la puerta no se encontró", 50, 50, errorPaint);
        }
    }
}
