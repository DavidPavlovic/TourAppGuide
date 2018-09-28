package com.example.android.zemuntour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        final ArrayList<Location> locations = new ArrayList<>();

        locations.add(new Location("Restoran Princip", "Gardoska 4", R.drawable.restoran_princip, 5));
        locations.add(new Location("Restoran Toro Grill", "Kej Oslobodjenja 49", R.drawable.restoran_toro_grill, 4.5f));
        locations.add(new Location("Stara Carinica", "Kej Oslobodjenja 31", R.drawable.stara_carinarnica, 4.5f));
        locations.add(new Location("Restoran Reka", "Kej Oslobodjenja 73b", R.drawable.restoran_reka, 4.5f));
        locations.add(new Location("Restoran Sac", "Rabina Alkalaja 5", R.drawable.restoran_sac, 4));
        locations.add(new Location("Restoran Cetverac", "Kej Oslobodjenja bb", R.drawable.cetverac, 4.5f));
        locations.add(new Location("Restoran Saran", "Kej Oslobodjenja bb", R.drawable.saran, 4.5f));
        locations.add(new Location("Restoran kod Naje", "Magistarski Trg 14", R.drawable.restoran_kod_naje, 4.5f));
        locations.add(new Location("Salon 5", "Avijaticarski Trg 5", R.drawable.salon_5, 5));

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
