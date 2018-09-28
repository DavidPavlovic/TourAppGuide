package com.example.android.zemuntour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {


    public LocationAdapter(Activity context, ArrayList<Location> location) {
        super(context, 0, location);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;
        if(listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        TextView nameTextView = listViewItem.findViewById(R.id.location_name);
        nameTextView.setText(currentLocation.getLocName());

        TextView adressTextView = listViewItem.findViewById(R.id.location_adress);
        adressTextView.setText(currentLocation.getLocAdress());

        ImageView locImage = listViewItem.findViewById(R.id.location_image);

        if(currentLocation.hasImage()) {
            locImage.setImageResource(currentLocation.getlImageId());
            locImage.setVisibility(View.VISIBLE);
        }else {
            locImage.setVisibility(View.GONE);
        }

        RatingBar ratingBar = listViewItem.findViewById(R.id.rating_bar);
        ratingBar.setRating(currentLocation.getStarRate());

        if(ratingBar.getRating() == 0) {
            ratingBar.setVisibility(View.GONE);
        }


        return listViewItem;
    }
}
