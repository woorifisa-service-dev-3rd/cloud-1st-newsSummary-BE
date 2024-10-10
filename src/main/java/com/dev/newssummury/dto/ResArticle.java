package com.dev.newssummury.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResArticle {
    private Long id;
    private String title;
    private String content;
}
