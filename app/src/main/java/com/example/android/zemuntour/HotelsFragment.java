package com.example.android.zemuntour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HotelsFragment extends Fragment {

    public HotelsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations;
        locations = new ArrayList<>();

        locations.add(new Location("Villa Akacija", "Trg Branka Radičevića 6", R.drawable.vila_akacija, 4.5f));
        locations.add(new Location("Hostel Ruler", "Svetosavska 29", R.drawable.hostel_ruler , 4));
        locations.add(new Location("Villa Marija", "Bezanijska 4", R.drawable.vila_marija, 5));
        locations.add(new Location("Hostel 1910", "Lagumska 5", R.drawable.hostel_1910, 4.5f));
        locations.add(new Location("Hostel Kavala", "Karamatina 25", R.drawable.hostel_kavala, 4));
        locations.add(new Location("Theater 011", "Magistratski trg", R.drawable.hostel_011, 4.5f));
        locations.add(new Location("Side One Design Hotel", "Kej Osobodjenja 14", R.drawable.side_one_design_hotel , 4));
        locations.add(new Location("Villa Petra", "Dubrovačka 10", R.drawable.vila_petra, 4.5f));
        locations.add(new Location("Theater Hotel", "Karadjordjeva 9", R.drawable.theater_hotel , 4));

        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Location location = locations.get(i);


                Intent itemActivity = new Intent(view.getContext(), LocationItemActivity.class);
                Bundle extras = new Bundle();

                Toast.makeText(getContext(), location.getLocName(), Toast.LENGTH_SHORT).show();

                extras.putInt("image", location.getlImageId());
                extras.putString("name", location.getLocName());
                extras.putString("adress", location.getLocAdress());
                extras.putBoolean("starRate", location.hasRate());
                extras.putFloat("stars", location.getStarRate());

                itemActivity.putExtras(extras);

                startActivity(itemActivity);
            }
        });

        return rootView;
    }
}
