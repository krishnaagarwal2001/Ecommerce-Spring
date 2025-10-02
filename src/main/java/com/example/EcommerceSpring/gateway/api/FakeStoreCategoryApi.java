package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

/*
    We need to tell spring how to tell the object of this interface (as it is external library)
    The implementation is given by retrofit on runtime. But as of now Spring does not know about it

    We don't need @Component is here as we have not given the responsibility to create object to Spring
    We are creating object using @Bean in configurations

*/
public interface FakeStoreCategoryApi {

    /*
        @GET
        We are getting this from retrofit
    */
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories () throws IOException;
}
