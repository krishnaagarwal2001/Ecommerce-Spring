package com.example.EcommerceSpring.configurations;

import com.example.EcommerceSpring.gateway.api.FakeStoreCategoryApi;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration //just semantics purpose for @Component for Configuration classes
public class RetrofitConfig {
    /*
        Whenever we need the object for Retrofit, Spring boot will call this function
    */
    @Bean
    public Retrofit retrofit(FakeStoreConfig fakeStoreConfig){
        return new Retrofit.Builder()
                .baseUrl(fakeStoreConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /*
        Whenever we need the object for FakeStoreCategoryApi, Spring boot will call this function
        Basically, this method is not responsible for providing an object of FakeStoreCategoryApi
    */
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryApi.class);
    }

    @Bean
    public FakeStoreProductAPI fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductAPI.class);
    }
}
