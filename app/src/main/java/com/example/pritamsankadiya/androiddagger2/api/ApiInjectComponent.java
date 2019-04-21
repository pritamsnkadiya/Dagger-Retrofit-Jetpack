package com.example.pritamsankadiya.androiddagger2.api;

import com.example.pritamsankadiya.androiddagger2.fragment.BlureFragment;
import com.example.pritamsankadiya.androiddagger2.fragment.ImageFragment;
import com.example.pritamsankadiya.androiddagger2.fragment.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiClient.class})
public interface ApiInjectComponent {
    void inject(ImageFragment fragment);
    void inject(BlureFragment fragment);
    void inject(LoginFragment fragment);
}