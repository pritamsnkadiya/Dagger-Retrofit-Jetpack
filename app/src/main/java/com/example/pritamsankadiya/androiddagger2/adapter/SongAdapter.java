package com.example.pritamsankadiya.androiddagger2.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.pritamsankadiya.androiddagger2.R;
import com.example.pritamsankadiya.androiddagger2.model.SongsList;

import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    private Context context;
    private List<SongsList> allSongs;
    private FragmentActivity activity;

    public SongAdapter(Context context, FragmentActivity activity, List<SongsList> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
        this.activity = activity;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.songe_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        holder.songTitle.setText(allSongs.get(position).getSongTitle());
        holder.songAuthor.setText(allSongs.get(position).getSongAuthor());
        Glide.with(context)
                .load(allSongs.get(position).getSongImage())
                .into(holder.songImage);
        holder.songImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavController navController = Navigation.findNavController(activity, R.id.my_nav_host_fragment);
                navController.navigate(R.id.action_imageFragment_to_blureFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }
}