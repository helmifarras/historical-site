package com.example.histiricalsite;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>  {

    // Member variables.
    private ArrayList<List> mListData;
    private Context mContext;

    ListAdapter(Context context, ArrayList<List> listData) {
        this.mListData = listData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        // Get current sport.
        List currentList = mListData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentList);
    }

    @Override
    public int getItemCount() {

        return mListData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private ImageView mSiteImage;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mSiteImage = itemView.findViewById(R.id.siteImage);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(List currentList){
            // Populate the textviews with data.
            mTitleText.setText(currentList.getTitle());

            // Load the images into the ImageView using the Glide library.
            Glide.with(mContext).load(
                    currentList.getImageResource()).into(mSiteImage);
        }

        @Override
        public void onClick(View view) {
            List currentList = mListData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentList.getTitle());
            detailIntent.putExtra("location", currentList.getLocation());
            detailIntent.putExtra("subdetail", currentList.getSubdetail());
            detailIntent.putExtra("image_resource", currentList.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}

