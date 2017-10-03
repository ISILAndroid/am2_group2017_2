package com.isil.am2template.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isil.am2template.R;
import com.isil.am2template.model.Place;

import java.util.List;

/**
 * Created by emedinaa on 15/09/15.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>  {

    private Context context;
    private List<Place> places;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_place_favorite, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Place entry = places.get(position);
        if(entry!=null){
            holder.textViewTitle.setText(entry.getName());
            holder.textViewAddress.setText(entry.getAddress());
            holder.textViewDistance.setText(entry.getDistance()+"Km");
        }

    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView textViewTitle;
        TextView textViewAddress;
        TextView textViewDistance;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            textViewTitle= (TextView) v.findViewById(R.id.textViewTitle);
            textViewAddress= (TextView) v.findViewById(R.id.textViewAddress);
            textViewDistance= (TextView) v.findViewById(R.id.textViewDistance);
        }
    }
}
