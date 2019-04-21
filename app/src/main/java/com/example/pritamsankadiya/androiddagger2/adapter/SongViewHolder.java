package com.example.pritamsankadiya.androiddagger2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pritamsankadiya.androiddagger2.R;

public class SongViewHolder extends RecyclerView.ViewHolder{
    public TextView songTitle;
    public TextView songAuthor;
    public ImageView songImage;
    public SongViewHolder(View itemView) {
        super(itemView);
        songTitle = (TextView)itemView.findViewById(R.id.song_name);
        songAuthor = (TextView)itemView.findViewById(R.id.song_author);
        songImage = (ImageView)itemView.findViewById(R.id.song_image);
    }
}