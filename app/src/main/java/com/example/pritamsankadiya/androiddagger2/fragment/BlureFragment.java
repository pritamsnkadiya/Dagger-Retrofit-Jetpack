package com.example.pritamsankadiya.androiddagger2.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pritamsankadiya.androiddagger2.R;
import com.example.pritamsankadiya.androiddagger2.adapter.ShowImageAdapter;
import com.example.pritamsankadiya.androiddagger2.api.ApiInterface;
import com.example.pritamsankadiya.androiddagger2.init.ApplicationAppContext;
import com.example.pritamsankadiya.androiddagger2.model.Songs;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BlureFragment extends Fragment {

    private static final String TAG = BlureFragment.class.getSimpleName();
    private RecyclerView gridRecycler;
    private RecyclerView.Adapter mAdapter;
    public StaggeredGridLayoutManager mGrid;
    private Context context;
    private Activity activity;
    private View view;
    @Inject
    Retrofit retrofit;

    public BlureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "In onAttach");
        super.onAttach(context);
        this.context = context;
        this.activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_blure, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ((ApplicationAppContext) activity.getApplication()).getNetworkComponent().inject(BlureFragment.this);

        gridRecycler = view.findViewById(R.id.song_list);
      //  mGrid = new   StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        gridRecycler.setLayoutManager(new LinearLayoutManager(context));
        gridRecycler.setHasFixedSize(true);
        callGetImageApi();
    }

    private void callGetImageApi() {

        ApiInterface mService = retrofit.create(ApiInterface.class);
        Call<Songs> mSong = mService.getAllImages();
        mSong.enqueue(new Callback<Songs>() {
            @Override
            public void onResponse(Call<Songs> call, Response<Songs> response) {

                Log.d(TAG, "Result " + response.body());

                mAdapter = new ShowImageAdapter(context, getActivity(), response.body().getImageShow());
                gridRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Songs> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });
    }
}
