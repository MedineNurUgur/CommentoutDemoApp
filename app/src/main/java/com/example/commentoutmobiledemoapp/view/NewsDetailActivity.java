package com.example.commentoutmobiledemoapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.commentoutmobiledemoapp.R;
import com.example.commentoutmobiledemoapp.model.ImageModel;
import com.example.commentoutmobiledemoapp.model.NewsModel;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    private ImageView newsImage;
    private TextView newsTitle;
    private WebView content;
    private Button btnShare;

    NewsModel news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        news = (NewsModel) getIntent().getSerializableExtra("news");

        newsImage = findViewById(R.id.imageNews);
        newsTitle = findViewById(R.id.textNewsTitle);
        content = findViewById(R.id.content);
        btnShare = findViewById(R.id.btnShare);

        loadImage(news.getMain_image());
        newsTitle.setText(news.getTitle());
        content.loadDataWithBaseURL(null, news.getContent(), "text/html", "utf-8", null);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createSendIntent(news.getShare_url()));
            }
        });

    }
    private void loadImage(ImageModel image){
        Picasso.get()
                .load(image.getUrl())
                .resize(image.getWidth(),image.getHeight())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_image)
                .into(newsImage);
    }

    private Intent createSendIntent(String message){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);

        return shareIntent;
    }
}