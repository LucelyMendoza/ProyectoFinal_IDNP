package com.example.login.canvas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private float x;
    private float y;
    private float width;
    private float height;
    private String name;

    public Mapa(float x, float y, float width, float height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<PointF> getVertices() {
        // Obtener los vértices del rectángulo
        List<PointF> vertices = new ArrayList<>();
        vertices.add(new PointF(x, y));
        vertices.add(new PointF(x + width, y));
        vertices.add(new PointF(x + width, y + height));
        vertices.add(new PointF(x, y + height));
        return vertices;
    }

    public void draw(Canvas canvas, Paint paint) {
        // Dibujar fondo transparente primero
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0x00FFFFFF);  // Color transparente, 0x00 elimina el color de fondo
        canvas.drawRect(x, y, x + width, y + height, paint);

        // Luego, dibujar borde grueso
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);  // Grosor del borde, ajusta según tus necesidades
        paint.setColor(0xFF919191);  // Color del borde #919191
        canvas.drawRect(x, y, x + width, y + height, paint);
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
