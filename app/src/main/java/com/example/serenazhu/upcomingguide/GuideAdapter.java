package com.example.serenazhu.upcomingguide;

import java.util.ArrayList;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;


import com.squareup.picasso.Picasso;

/**
 * A custom adapter for the Guide ListView Items
 */

public class GuideAdapter extends ArrayAdapter<Guide>{

    Context context;
    GuideList values;

    public GuideAdapter(Context context, GuideList values){
        super(context, -1);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView nameView = (TextView) rowView.findViewById(R.id.name_view);
        TextView venueView = (TextView) rowView.findViewById(R.id.venue_view);
        TextView endDateView = (TextView) rowView.findViewById(R.id.end_date_view);

        Guide g = values.get(position);

        //Would not have concatenated string within setText with more time
        nameView.setText("Event Name: " + String.valueOf(g.getName()));
        venueView.setText("City, State: " + String.valueOf(g.getVenue()));
        endDateView.setText("End Date: " + String.valueOf(g.getEndDate()));



        //Would load the icon image beside the text
        ImageView iconView = (ImageView) rowView.findViewById(R.id.icon_view);
        Picasso.get().load(String.valueOf(g.getUrl())).into(iconView);

        return rowView;
    }
}
