package com.example.EcommerceSpring.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
    Builder to work, we need @AllArgsConstructor
*/
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
}
