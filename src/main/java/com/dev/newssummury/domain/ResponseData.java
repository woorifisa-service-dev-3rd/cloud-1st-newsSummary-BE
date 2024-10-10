package com.dev.newssummury.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseData {
    @SerializedName("lastBuildDate")
    private String lastBuildDate;

    @SerializedName("total")
    private int total;

    @SerializedName("start")
    private int start;

    @SerializedName("display")
    private int display;

    @SerializedName("items")
    private List<Item> items;

    @Getter
    @Setter
    public static class Item {
        @SerializedName("title")
        private String title;

        @SerializedName("originallink")
        private String originallink;

        @SerializedName("link")
        private String link;

        @SerializedName("description")
        private String description;

        @SerializedName("pubDate")
        private String pubDate;
    }

}

