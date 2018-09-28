package com.example.android.zemuntour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {
    public PlacesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Gardos Kula", "Grobljanska bb", R.drawable.gardos));
        locations.add(new Location("Park", "Gradski park 9", R.drawable.zemun_park));
        locations.add(new Location("Lido", "Kej Oslobodjenja bb", R.drawable.lido));
        locations.add(new Location("Madlenianum", "Glavna 32", R.drawable.madlenianum));
        locations.add(new Location("Zemunski Kej", "Kej Oslobodjenja bb", R.drawable.zemunski_kej));
        locations.add(new Location("Magistarski Trg", "Magistarski Trg", R.drawable.magistarski_trg));

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

                itemActivity.putExtras(extras);

                startActivity(itemActivity);
            }
        });

        return rootView;
    }
}
