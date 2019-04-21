package com.example.pritamsankadiya.androiddagger2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pritamsankadiya.androiddagger2.R;
import com.example.pritamsankadiya.androiddagger2.model.ImageShow;
import com.wingjay.blurimageviewlib.BlurImageView;

import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.ViewHolder> {

    private Context context;
    private View view;
    private ViewHolder viewHolder;
    private List<ImageShow> imageShowList;
    private FragmentActivity activity;

    public ShowImageAdapter(Context context, FragmentActivity activity, List<ImageShow> faqResultsList) {
        this.context = context;
        this.imageShowList = faqResultsList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.image_show_layout, viewGroup, false);

        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.blurImageView.setProgressBarBgColor(Color.parseColor("#789262"));
        viewHolder.blurImageView.setProgressBarColor(Color.parseColor("#519A73"));
        viewHolder.blurImageView.setFullImageByUrl(imageShowList.get(i).getBlurImage(), imageShowList.get(i).getClrImage());

        viewHolder.blurImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(activity, R.id.my_nav_host_fragment);
                navController.navigate(R.id.action_blureFragment_to_imageFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageShowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private BlurImageView blurImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            findid();
        }

        private void findid() {
            blurImageView = view.findViewById(R.id.full_blur_image_view);
        }
    }
}
