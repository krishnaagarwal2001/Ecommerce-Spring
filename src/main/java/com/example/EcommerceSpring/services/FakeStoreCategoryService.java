package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO;
import com.example.EcommerceSpring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service //just semantics purpose for @Component for Service classes
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    /*
        Currently, there is only one implementation of ICategoryGateway only.
        So Spring can easily auto-inject the object because at runtime, there is only implementation to look for.

        But now assume, there are 2 implementations of ICategoryGateway. It will throw
        NoUniqueBeanDefinitionException. To resolve this,

        1. @Primary Annotation
            It specifies which is the default implementation that has to be used by Spring to auto-inject.
            Usage :-
                It makes sense when we are trying to deprecate one implementation.

        2.@Qualifier
            It kind of uses key based unique identifier.

            Example :-
                @Component("fakeStoreCategoryGateway)
                public class FakeStoreCategoryGateway implements ICategoryGateway {
                ...

                 public FakeStoreCategoryService(@Qualifier('fakeStoreCategoryGateway) ICategoryGateway categoryGateway) {
                ...

            Usage :-
                Now different services can use different implementation of ICategoryGateway depending upon their
                use case.

    */

    public FakeStoreCategoryService(@Qualifier("fakeStoreRestTemplateGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories() ;
    }
}
