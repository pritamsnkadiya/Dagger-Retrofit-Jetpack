package com.example.pritamsankadiya.androiddagger2.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.pritamsankadiya.androiddagger2.R;
import com.example.pritamsankadiya.androiddagger2.api.ApiInterface;
import com.example.pritamsankadiya.androiddagger2.init.ApplicationAppContext;
import com.example.pritamsankadiya.androiddagger2.model.RequestModel;
import com.example.pritamsankadiya.androiddagger2.model.ResponseModel;

import javax.inject.Inject;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = LoginFragment.class.getSimpleName();
    public EditText et_phone_number, et_password;
    public Button bt_login;
    public RequestModel requestModel;
    private Context context;
    private Activity activity;
    private View view;
    @Inject
    Retrofit retrofit;

    public LoginFragment() {
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
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ((ApplicationAppContext) activity.getApplication()).getNetworkComponent().inject(LoginFragment.this);

        et_phone_number = view.findViewById(R.id.et_phone_number);
        et_password = view.findViewById(R.id.et_password);
        bt_login = view.findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        callLoginApi();
    }


    private void callLoginApi() {
        requestModel = new RequestModel();

        requestModel.email = et_phone_number.getText().toString().trim();
        requestModel.password = et_password.getText().toString().trim();

        ApiInterface mService = retrofit.create(ApiInterface.class);
        Call<ResponseModel> responseModelCall = mService.login(requestModel);
        responseModelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Result " + response.body());
                    NavController navController = Navigation.findNavController(activity, R.id.my_nav_host_fragment);
                    navController.navigate(R.id.action_loginFragment_to_imageFragment);
                }
                NavController navController = Navigation.findNavController(activity, R.id.my_nav_host_fragment);
                navController.navigate(R.id.action_loginFragment_to_imageFragment);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });
    }
}
