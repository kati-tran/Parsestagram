package com.example.parsestagram;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.w3c.dom.Text;

import java.lang.reflect.Constructor;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvUsername;
        private TextView tvDescription;
        private ImageView ivImage;
        private TextView tvCreationDate;
        private ImageView ivReadMore;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvCreationDate = itemView.findViewById(R.id.tvCreationDate);
            ivReadMore = itemView.findViewById(R.id.ivReadMore);
        }

        public void bind(Post post) {
            // Bind the post data to the view element
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            tvCreationDate.setText(post.getCreation());
            ParseFile image = post.getImage();
            if(image != null){
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }
            ivReadMore.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, PostDetails.class);
                    i.putExtra("username", post.getUser().getUsername());
                    i.putExtra("image", post.getImage().getUrl());
                    i.putExtra("description", post.getDescription());
                    i.putExtra("creation", post.getCreation());
                    context.startActivity(i);
                }
            });

        }

        public void clear() {
            posts.clear();
            notifyDataSetChanged();
        }

        // Add a list of items -- change to type used
        public void addAll(List<Post> list) {
            posts.addAll(list);
            notifyDataSetChanged();
        }
    }
}
