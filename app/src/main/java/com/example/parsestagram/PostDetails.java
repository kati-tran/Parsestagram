package com.example.parsestagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

public class PostDetails extends AppCompatActivity {
    private TextView tvUsername;
    private TextView tvDescription;
    private TextView tvCreationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        tvUsername = findViewById(R.id.tvUsername);
        tvDescription = findViewById(R.id.tvDescription);
        tvCreationDate = findViewById(R.id.tvCreationDate);

        String username = getIntent().getStringExtra("username");
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");
        String creation = getIntent().getStringExtra("creation");

        tvDescription.setText(description);
        tvUsername.setText(username);
        tvCreationDate.setText(creation);

    }
}