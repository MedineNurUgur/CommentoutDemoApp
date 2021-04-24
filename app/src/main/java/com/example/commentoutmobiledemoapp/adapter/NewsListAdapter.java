package com.example.commentoutmobiledemoapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.commentoutmobiledemoapp.R;
import com.example.commentoutmobiledemoapp.model.ImageModel;
import com.example.commentoutmobiledemoapp.model.NewsModel;
import com.example.commentoutmobiledemoapp.view.NewsDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private Context context;
    private List<NewsModel> newsList;

    public NewsListAdapter(Context context, List<NewsModel> newsList){
        this.context= context;
        this.newsList = newsList;
    }

    public void setNewsList(List<NewsModel> newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.news_card_design, parent, false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        holder.newsTitle.setText(this.newsList.get(position).getTitle().toString());
        ImageModel main_image = this.newsList
                .get(position)
                .getMain_image();

        Picasso.get()
                .load(main_image.getUrl())
                .resize(main_image.getWidth(),main_image.getHeight())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(holder.newsImage);

        holder.newsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsDetailActivity.class);
                intent.putExtra("news",newsList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(this.newsList != null){
            return this.newsList.size();
        }
        return 0;
    }

    public class NewsViewHolder extends  RecyclerView.ViewHolder{

        TextView newsTitle;
        ImageView newsImage;
        CardView newsCard;

        public  NewsViewHolder(View itemView){
            super(itemView);
            newsTitle = itemView.findViewById(R.id.textViewNewsTitle);
            newsImage = itemView.findViewById(R.id.imageViewNews);
            newsCard = itemView.findViewById(R.id.news_card);
        }

    }
}
