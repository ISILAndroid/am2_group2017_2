package com.isil.am2template.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isil.am2template.R;
import com.isil.am2template.adapters.PlaceAdapter;
import com.isil.am2template.listeners.OnNavListener;
import com.isil.am2template.model.Place;
import com.isil.am2template.storage.db.MyDatabase;
import com.isil.am2template.storage.db.PlaceCrudOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritePlaceFragment extends Fragment {

    private OnNavListener mListener;
    private PlaceCrudOperations placeCrudOperations;
    private List<Place> places = new ArrayList<>();

    private RecyclerView recyclerViewPlace;
    private RecyclerView.LayoutManager mLayoutManager;

    public FavoritePlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewContainer = inflater.inflate(R.layout.fragment_favorite_place, container, false);
        recyclerViewPlace = (RecyclerView) viewContainer.findViewById(R.id.recyclerViewPlace);
        return viewContainer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ui();
        placeCrudOperations = new PlaceCrudOperations(new MyDatabase(getActivity()));
        if (placeCrudOperations.getPlaceCount() <= 0) {
            populate();
        }
        loadFavoritePlaces();

    }

    private void ui() {
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewPlace.setLayoutManager(mLayoutManager);
    }

    private void loadFavoritePlaces() {
        places = placeCrudOperations.getAllFavoritePlaces();
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places);
        recyclerViewPlace.setAdapter(placeAdapter);
    }

    private void populate() {
        placeCrudOperations.addPlace(new Place("admin@gmail.com",
                "Casa", "Las Artes 1040, San Borja", 0.8));
        placeCrudOperations.addPlace(new Place("admin@gmail.com",
                "Trabajo", "Avenida Carriquiry, San Isidro", 1.2));
        placeCrudOperations.addPlace(new Place("admin@gmail.com",
                "Universidad", "Avenida Salaverry, 2255, San Isidro", 1.8));
        placeCrudOperations.addPlace(new Place("admin@gmail.com",
                "Familia", "Calle Esmeralda, 276, Los Olivos", 4.5));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNavListener) {
            mListener = (OnNavListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
