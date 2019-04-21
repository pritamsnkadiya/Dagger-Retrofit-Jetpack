package com.example.pritamsankadiya.androiddagger2.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pritamsankadiya.androiddagger2.R;
import com.example.pritamsankadiya.androiddagger2.adapter.SongAdapter;
import com.example.pritamsankadiya.androiddagger2.api.ApiInterface;
import com.example.pritamsankadiya.androiddagger2.init.ApplicationAppContext;
import com.example.pritamsankadiya.androiddagger2.model.Songs;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ImageFragment extends Fragment {

    private static final String TAG = ImageFragment.class.getSimpleName();
    private RecyclerView gridRecycler;
    private RecyclerView.Adapter mAdapter;
    public GridLayoutManager mGrid;
    private Context context;
    private Activity activity;
    private View view;
    @Inject
    Retrofit retrofit;

    public ImageFragment() {
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "In onAttach");
        super.onAttach(context);
        this.context = context;
        this.activity = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ((ApplicationAppContext) activity.getApplication()).getNetworkComponent().inject(ImageFragment.this);

        gridRecycler = view.findViewById(R.id.song_list);
        mGrid = new GridLayoutManager(context, 2);
        gridRecycler.setLayoutManager(mGrid);
        gridRecycler.setHasFixedSize(true);

        callGetSongeApi();
    }

    private void callGetSongeApi() {

        ApiInterface mService = retrofit.create(ApiInterface.class);
        Call<Songs> mSong = mService.allSongs();
        mSong.enqueue(new Callback<Songs>() {
            @Override
            public void onResponse(Call<Songs> call, Response<Songs> response) {

                Log.d(TAG, "Result " + response.body());

                mAdapter = new SongAdapter(context,getActivity(), response.body().getSong());
                gridRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Songs> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });
    }
}
