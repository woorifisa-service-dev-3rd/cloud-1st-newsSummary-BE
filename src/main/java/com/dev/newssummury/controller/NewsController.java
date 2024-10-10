package com.dev.newssummury.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;
import java.net.*;
import java.nio.charset.Charset;
import java.util.List;

import com.dev.newssummury.domain.*;

@Log4j2
@RequestMapping("/news")
@RestController
public class NewsController {

    @GetMapping("/list/{text}")
    public ResponseEntity<String> list(@PathVariable String text, Model model) {
        // 네이버 검색 API 요청
        String clientId = "_BaFHBBYKCmUh4WzdStY";
        String clientSecret = "nBnhj1wXbc";

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/news.json")
                .queryParam("query", text)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("sort", "sim")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        // Spring 요청 제공 클래스
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .header("Content-Type", "application/json; charset=UTF-8")
                .build();


                // Spring 제공 restTemplate
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> resp = restTemplate.exchange(req, String.class);
                // JSON 데이터 파싱

                return resp;
            }
        }
