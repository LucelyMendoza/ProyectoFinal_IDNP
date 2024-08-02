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

public class GaleriaVI extends View {
    private Canvas _canvas;
    private List<PointRoom> points;
    private Context context;

    public GaleriaVI(Context context) {
        super(context);
        init(context);
    }

    public GaleriaVI(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GaleriaVI(Context context, AttributeSet attrs, int defStyle) {
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
        float textY = _canvas.getHeight() / 2;
        _canvas.drawText("Galería VI", textX - 200, textY, paint);
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

        // Líneas para las pinturas en las paredes izquierda y derecha
        _canvas.drawLine(left, top + 100, left, bottom - 1200, paint); // Left1
        _canvas.drawLine(left, top + 700, left, bottom - 600, paint); // Left2
        _canvas.drawLine(left, top + 1300, left, bottom, paint); // Left3

        _canvas.drawLine(right, top + 100, right, bottom - 1200, paint); // Right1
        _canvas.drawLine(right, top + 700, right, bottom - 600, paint); // Right2
        _canvas.drawLine(right, top + 1300, right, bottom, paint); // Right3

        // Líneas horizontales superiores
        _canvas.drawLine(left + roomWidth * 0.12f, top, left + roomWidth * 0.39f, top, paint); // Top-1
        _canvas.drawLine(left + roomWidth * 0.61f, top, left + roomWidth * 0.88f, top, paint); // Top-2

        // Líneas horizontales inferiores
        _canvas.drawLine(left + roomWidth * 0.12f, bottom, left + roomWidth * 0.39f, bottom, paint); // Bottom-1
        _canvas.drawLine(left + roomWidth * 0.61f, bottom, left + roomWidth * 0.88f, bottom, paint); // Bottom-2
    }

    private void drawDoors() {
        Drawable doorDrawable = AppCompatResources.getDrawable(context, R.drawable.door_p2);

        if (doorDrawable != null) {
            float centerX = _canvas.getWidth() / 2;
            float centerY = _canvas.getHeight() / 2;
            float roomWidth = _canvas.getWidth() * 0.8f;
            float roomHeight = _canvas.getHeight() * 0.8f;

            float left = centerX - roomWidth / 2;
            float top = centerY - roomHeight / 2;
            float right = centerX + roomWidth / 2;
            float bottom = centerY + roomHeight / 2;

            // Ajustar la posición de las puertas según la imagen proporcionada

            doorDrawable.setBounds((int) (right - roomWidth * 0.18f), (int) (centerY + roomHeight * 0.15f),
                    (int) (right - roomWidth * 0.03f), (int) (centerY + roomHeight * 0.25f));
            doorDrawable.draw(_canvas);

        }
    }
}

/*package com.example.login.Galerias;

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

public class GaleriaVI extends View {

    private Canvas _canvas;
    private List<PointRoom> points;
    private Context context;
    private int[] drawableResources = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o
    };

    private int[][] positions = {
            {10, 10, 170, 170},      // top-left
            {910, 10, 1070, 170},    // top-right
            {10, 1610, 170, 1770},   // bottom-left
            {910, 1610, 1070, 1770}, // bottom-right
            {10, 410, 170, 570},     // left-middle-top
            {10, 810, 170, 970},     // left-middle-middle
            {10, 1210, 170, 1370},   // left-middle-bottom
            {910, 410, 1070, 570},   // right-middle-top
            {910, 810, 1070, 970},   // right-middle-middle
            {910, 1210, 1070, 1370}, // right-middle-bottom
            {410, 10, 570, 170},     // top-middle-left
            {610, 10, 770, 170},     // top-middle-right
            {410, 1610, 570, 1770},  // bottom-middle-left
            {610, 1610, 770, 1770},  // bottom-middle-right
    };

    public GaleriaVI(Context context) {
        super(context);
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
    }

    private void drawRoom() {
        if (points != null && points.size() > 0) {
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeWidth(10f);
            paint.setStyle(Paint.Style.STROKE);

            Path path = new Path();
            path.moveTo(points.get(0).getX(), points.get(0).getY());

            for (int i = 1; i < points.size(); i++) {
                path.lineTo(points.get(i).getX(), points.get(i).getY());
            }
            path.close();

            _canvas.drawPath(path, paint);
        }
    }

    private void drawPictures() {
        for (int i = 0; i < drawableResources.length && i < positions.length; i++) {
            Drawable pictureDrawable = AppCompatResources.getDrawable(context, drawableResources[i]);
            if (pictureDrawable != null) {
                pictureDrawable.setBounds(positions[i][0], positions[i][1], positions[i][2], positions[i][3]);
                pictureDrawable.draw(_canvas);
            }
        }
    }

    public GaleriaVI(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public GaleriaVI(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }
}*/