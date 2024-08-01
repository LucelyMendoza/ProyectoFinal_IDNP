package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.idnp2024a.loginsample.R;

import java.util.List;

public class PaintingAdapter extends ArrayAdapter<Painting> {

    private Context context;
    private List<Painting> paintings;

    public PaintingAdapter(Context context, List<Painting> paintings) {
        super(context, 0, paintings);
        this.context = context;
        this.paintings = paintings;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_painting, parent, false);
        }

        Painting painting = paintings.get(position);

        ImageView paintingImage = convertView.findViewById(R.id.paintingImage);
        TextView paintingTitle = convertView.findViewById(R.id.paintingTitle);
        TextView paintingArtist = convertView.findViewById(R.id.paintingArtist);

        paintingImage.setImageResource(painting.getImageResourceId());
        paintingTitle.setText(painting.getTitle());
        paintingArtist.setText(painting.getArtist());

        return convertView;
    }
}