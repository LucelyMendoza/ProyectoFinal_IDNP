package com.example.login.canvas;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.login.fragments.HomeFragment;
import com.idnp2024a.loginsample.R;

import java.util.ArrayList;
import java.util.List;

public class MapaView extends View {
    private Paint paint;
    private Mapa[] mapas;
    private List<Linea> lineas;
    private float centerX;  // Coordenada X del centro del círculo adicional
    private float centerY;  // Coordenada Y del centro del círculo adicional
    private float radius;   // Radio del círculo adicional
    private float offsetX = 0.0f;
    private float offsetY = 0.0f;

    // Coordenadas de los textos de galería
    private float galeria1TextX = 400;
    private float galeria1TextY = 1740;
    private float galeria2TextX = 100;
    private float galeria2TextY = 1420;
    private float galeria3TextX = 400;
    private float galeria3TextY = 1320;
    private float galeria4TextX = 810;
    private float galeria4TextY = 1530;
    private float galeria5TextX = 810;
    private float galeria5TextY = 1320;
    private float galeria6TextX = 95;
    private float galeria6TextY = 830;
    private float galeria7TextX = 600;
    private float galeria7TextY = 230;
    private float laSalaTextX = 430;
    private float laSalaTextY = 730;
    private float scale;
    // Método para dibujar los textos de las galerías
    private void drawGalleryText(Canvas canvas) {
        Paint textPaint = new Paint();
        textPaint.setColor(0xFFDEA617);  // Orange text color
        textPaint.setTextSize(40 / scale); // Adjust text size for scaling

        canvas.drawText("Galería I", galeria1TextX, galeria1TextY, textPaint);
        canvas.drawText("Galería II", galeria2TextX, galeria2TextY, textPaint);
        canvas.drawText("Galería III", galeria3TextX, galeria3TextY, textPaint);
        canvas.drawText("Galería IV", galeria4TextX, galeria4TextY, textPaint);
        canvas.drawText("Galería V", galeria5TextX, galeria5TextY, textPaint);
        canvas.drawText("Galería VI", galeria6TextX, galeria6TextY, textPaint);
        canvas.drawText("Galería VII", galeria7TextX, galeria7TextY, textPaint);
        canvas.drawText("La Sala", laSalaTextX, laSalaTextY, textPaint);
    }

    private Canvas _canvas;
    private Context context;
    // Drawables para las imágenes
    private Drawable[] drawables;
    private static final int IMAGE_SIZE = 40;
    private int[][] positions = {
            {470, 1370, 470 + IMAGE_SIZE, 1370 + IMAGE_SIZE},   // Coordenadas para R.drawable.door
            {230, 1500, 230 + IMAGE_SIZE, 1500 + IMAGE_SIZE}, // Coordenadas para R.drawable.door_p2
            {790, 1500, 790 + IMAGE_SIZE, 1500 + IMAGE_SIZE},   // Coordenadas para R.drawable.door_p3
            {470, 1610, 470 + IMAGE_SIZE, 1610 + IMAGE_SIZE}, // Coordenadas para R.drawable.door_p4
            {230, 900, 230 + IMAGE_SIZE, 900 + IMAGE_SIZE}, //Galería 6
            {790, 1300, 790 + IMAGE_SIZE, 1300 + IMAGE_SIZE}, //Galería 5
            {470, 1210, 470 + IMAGE_SIZE, 1210 + IMAGE_SIZE}, //Puerta galería III
            {170, 1610, 170 + IMAGE_SIZE, 1610 + IMAGE_SIZE}, //Puerta galería I
            {230, 1300, 230 + IMAGE_SIZE, 1300 + IMAGE_SIZE},//Puerta galería 2
            {470, 770, 470 + IMAGE_SIZE, 770 + IMAGE_SIZE}, //Puerta la Sala
            {790, 790, 790 + IMAGE_SIZE, 790 + IMAGE_SIZE}, //Puerta prohibida I
            {230, 400, 230 + IMAGE_SIZE, 400 + IMAGE_SIZE}, //Puerta prohibida II
            {230, 500, 230 + IMAGE_SIZE, 500 + IMAGE_SIZE}, //Puerta prohibida III
            {700, 270, 700 + IMAGE_SIZE, 270 + IMAGE_SIZE}, //Galería VII
            {870, 460,870 + IMAGE_SIZE, 460+ IMAGE_SIZE}, //Baño I
            {870, 400,870 + IMAGE_SIZE, 400+ IMAGE_SIZE}, //Baño II
            {370, 1540, 370 + IMAGE_SIZE, 1540 + IMAGE_SIZE}, // silla 1
            {560, 1540, 560 + IMAGE_SIZE, 1540 + IMAGE_SIZE}, // silla 2
            {560, 1440, 560 + IMAGE_SIZE, 1440 + IMAGE_SIZE}, //silla 3
            {880, 790, 880 + IMAGE_SIZE, 790 + IMAGE_SIZE},
            {680, 140, 680 + IMAGE_SIZE, 140 + IMAGE_SIZE},
            {160, 390, 160 + IMAGE_SIZE, 390 + IMAGE_SIZE},
            {160, 500, 160 + IMAGE_SIZE, 500 + IMAGE_SIZE},
            {690, 1740, 730 + IMAGE_SIZE, 1770 + IMAGE_SIZE}
            // Ajusta las posiciones según sea necesario para más imágenes
    };

    public MapaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(0xFF000000);  // Set default paint color to black
        paint.setStrokeWidth(5);

        // Inicialización de las imágenes de las galerías
        drawables = new Drawable[]{
                context.getDrawable(R.drawable.door),
                context.getDrawable(R.drawable.door_p2),
                context.getDrawable(R.drawable.door_p3),
                context.getDrawable(R.drawable.door_p4),
                context.getDrawable(R.drawable.door_p2),
                context.getDrawable(R.drawable.door_p3),
                context.getDrawable(R.drawable.door_p4),
                context.getDrawable(R.drawable.door_p4),
                context.getDrawable(R.drawable.door_p2),
                context.getDrawable(R.drawable.door),
                context.getDrawable(R.drawable.door_p3),
                context.getDrawable(R.drawable.door_p2),
                context.getDrawable(R.drawable.door_p2),
                context.getDrawable(R.drawable.door),
                context.getDrawable(R.drawable.banio),
                context.getDrawable(R.drawable.banio2),
                context.getDrawable(R.drawable.chair2),
                context.getDrawable(R.drawable.chair2),
                context.getDrawable(R.drawable.chair),
                context.getDrawable(R.drawable.prohibido),
                context.getDrawable(R.drawable.prohibido),
                context.getDrawable(R.drawable.prohibido),
                context.getDrawable(R.drawable.prohibido),
                context.getDrawable(R.drawable.port_n),
                // Agrega más drawables según sea necesario
        };

        // Inicialización de las áreas del mapa (galerías)
        mapas = new Mapa[]{
                new Mapa(80, 100, 920, 1720, " "),
                new Mapa(80, 1600, 600, 220, "galeria1"),
                new Mapa(80, 1200, 200, 400, "galeria 2"),
                new Mapa(280, 1200, 400, 220, "galeria 3"),
                new Mapa(780, 1420, 220, 400, "galeria 4"),
                new Mapa(780, 1200, 220, 220, "galeria 5"),
                new Mapa(80, 600, 200, 420, "galeria 6"),
                new Mapa(280, 600, 400, 220, "galeria la sala"),
                new Mapa(780, 600, 220, 420, "no entrar 1"),
                new Mapa(80, 100, 200, 500, "no entrar 2"),
                new Mapa(280, 100, 720, 220, "galeria 7"),
                new Mapa(780, 400, 220, 100, "baños")
                // Agrega más áreas del mapa según sea necesario
        };

        // Establecer los límites iniciales de los drawables
        for (Drawable drawable : drawables) {
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }}

        // Inicializar la lista de líneas
        lineas = new ArrayList<>();

        // Agregar líneas de ejemplo
        lineas.add(new Linea(280, 1600, 280, 1680));  // Ejemplo de línea entre galería 1 y 2
        lineas.add(new Linea(280, 1730, 280, 1820));
        lineas.add(new Linea(780, 1600, 860, 1600)); //galeria horizontal 4
        lineas.add(new Linea(920, 1600, 1000, 1600));
        // Ejemplo de línea entre galería 2 y 3

        // Coordenadas y radio del círculo adicional (óvalo del lugar)
        centerX = 500;  // Ejemplo: coordenada X del centro
        centerY = 460;  // Ejemplo: coordenada Y del centro
        radius = 100;  // Ejemplo: radio del círculo

        // Log the vertices of each polygon
        for (Mapa mapa : mapas) {
            List<PointF> vertices = mapa.getVertices();
            StringBuilder verticesStr = new StringBuilder("Vértices de " + mapa.getName() + ": ");
            for (PointF vertex : vertices) {
                verticesStr.append("(").append(vertex.x).append(", ").append(vertex.y).append(") ");
            }
            Log.d("MapaView", verticesStr.toString());
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Verificar si el toque está dentro de alguna galería
                if (estaEnAreaGaleria(galeria1TextX, galeria1TextY, "Galería I", touchX, touchY)) {
                    // Manejar el evento de clic en "GALERÍA 1"
                    Log.d(TAG, "Se ha presionado Galería I");

                    // Aquí puedes iniciar la navegación a otro fragmento
                    FragmentManager fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, new HomeFragment());
                    fragmentTransaction.addToBackStack(null); // Permite volver al fragmento anterior con el botón de retroceso
                    fragmentTransaction.commit();

                    // Indicar que se ha manejado el evento de toque
                    return true;
                } else if (estaEnAreaGaleria(galeria2TextX, galeria2TextY, "Galería II", touchX, touchY)) {
                    // Manejar el evento de clic en "GALERÍA 2"
                    Log.d(TAG, "Se ha presionado Galería II");

                    // Aquí puedes iniciar la navegación a otro fragmento o realizar otra acción
                    return true;
                }
                // Agrega más casos para el resto de galerías si es necesario
                break;
        }

        // Si no se maneja el evento, dejar que lo maneje el padre
        return super.onTouchEvent(event);
    }

    // Método para verificar si el toque está dentro del área de una galería específica
    private boolean estaEnAreaGaleria(float textX, float textY, String galeriaText, float touchX, float touchY) {
        Paint textPaint = new Paint();
        textPaint.setColor(0xFFDEA617);
        textPaint.setTextSize(40 / scale); // Ajusta el tamaño del texto según sea necesario

        float textWidth = textPaint.measureText(galeriaText);  // Ancho del texto
        float textHeight = textPaint.getTextSize();            // Altura del texto

        float textLeft = textX;
        float textTop = textY - textHeight;  // Ajusta según cómo se dibuja el texto
        float textRight = textX + textWidth;
        float textBottom = textY;

        // Verificar si las coordenadas del toque están dentro del área del texto de la galería
        return touchX >= textLeft && touchX <= textRight && touchY >= textTop && touchY <= textBottom;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Dibujar las imágenes en el Canvas
        for (int i = 0; i < drawables.length; i++) {
            Drawable drawable = drawables[i];
            int[] position = positions[i];
            if (drawable != null && position.length == 4) {
                int left = position[0];
                int top = position[1];
                int right = position[2];
                int bottom = position[3];

                drawable.setBounds(left, top, right, bottom);
                drawable.draw(canvas);
            }
        }

        float viewWidth = getWidth();
        float viewHeight = getHeight();
        float contentWidth = 1080; // Ancho original del contenido del mapa
        float contentHeight = 1500; // Alto original del contenido del mapa

        float scaleX = viewWidth / contentWidth;
        float scaleY = viewHeight / contentHeight;
        float scale = Math.min(scaleX, scaleY);

        // Guardar la escala para usarla en otros métodos como drawGalleryText
        this.scale = scale;

        // Resto de tu lógica de dibujo
        // Llama a drawGalleryText o métodos similares que necesiten usar scale
        drawGalleryText(canvas);

        // Dibujar cada área del mapa con su forma correspondiente
        for (Mapa mapa : mapas) {
            mapa.draw(canvas, paint);
        }

        // Dibujar líneas para simular espacios vacíos
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0xFFAAAAAA);  // Color gris claro como ejemplo

        for (Linea linea : lineas) {
            canvas.drawLine(linea.startX, linea.startY, linea.endX, linea.endY, paint);
        }

        // Dibujar cada área del mapa con su círculo correspondiente
        for (Mapa mapa : mapas) {
            mapa.draw(canvas, paint);
        }

        // Dibujar el círculo adicional (óvalo del lugar)
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xFFD9D9D9);  // Color verde como ejemplo
        canvas.drawCircle(centerX, centerY, radius, paint);

        scaleX = viewWidth / contentWidth;
        scaleY = viewHeight / contentHeight;

        // Calculate the offsets
        offsetX = 0; // Start from the left edge
        offsetY = 0; // Start from the top edge

        canvas.save();
        canvas.translate(offsetX, offsetY);
        canvas.scale(scale, scale);

        // Draw each area of the map
        for (Mapa mapa : mapas) {
            mapa.draw(canvas, paint);
        }

    }
}

