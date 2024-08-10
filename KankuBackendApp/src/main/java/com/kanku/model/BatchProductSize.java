package com.kanku.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BatchProductSize {
    private Product product;
    private List<Size> sizes;
}
