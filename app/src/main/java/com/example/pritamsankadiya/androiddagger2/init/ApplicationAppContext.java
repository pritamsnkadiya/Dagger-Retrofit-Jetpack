package com.example.pritamsankadiya.androiddagger2.init;

import android.app.Application;
import com.example.pritamsankadiya.androiddagger2.api.ApiInjectComponent;
import com.example.pritamsankadiya.androiddagger2.api.ApiClient;
import com.example.pritamsankadiya.androiddagger2.api.DaggerApiInjectComponent;
import com.example.pritamsankadiya.androiddagger2.utils.AppConstants;

public class ApplicationAppContext extends Application{
    private ApiInjectComponent networkComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerApiInjectComponent.builder()
                .apiClient(new ApiClient(AppConstants.BASE_URL))
                .build();
    }
    public ApiInjectComponent getNetworkComponent(){
        return networkComponent;
    }
}