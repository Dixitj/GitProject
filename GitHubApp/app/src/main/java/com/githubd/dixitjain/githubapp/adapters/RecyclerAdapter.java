package com.githubd.dixitjain.githubapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.githubd.dixitjain.githubapp.R;
import com.githubd.dixitjain.githubapp.model.Item;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<Item> data;


    public RecyclerAdapter(List<Item> data){

        this.data = data;

    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View cardView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_content,viewGroup,false);

        return new RecyclerAdapter.RecyclerViewHolder(cardView);
    }

    //Adapter Dataholding method
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {


        recyclerViewHolder.titleText.setText(data.get(i).getName().trim());
        recyclerViewHolder.dateText.setText(String.valueOf(data.get(i).getStargazersCount()));
        recyclerViewHolder.descpText.setText(data.get(i).getDescription());
        recyclerViewHolder.clickClip.setText(String.valueOf(data.get(i).getId()));

        Picasso.get()
                .load(data.get(i).getOwner().getAvatarUrl())
                .resize(200,200)
                .into(recyclerViewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //ViewHolder Class
    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, dateText, descpText, clickClip;
        ImageView imageView;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.idProductImage);
            titleText = itemView.findViewById(R.id.idProductName);
            dateText = itemView.findViewById(R.id.dateText);
            descpText = itemView.findViewById(R.id.descptext);
            clickClip = itemView.findViewById(R.id.clip);


        }
    }
}
