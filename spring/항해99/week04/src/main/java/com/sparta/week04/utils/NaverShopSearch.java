package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "MqzRjEkh9y1dtldzuTse");
        headers.add("X-Naver-Client-Secret", "39EEmbeP6d");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);
        return response;
    }

    public List<ItemDto> fromJsonToItems(String result){
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");
        List<ItemDto> list = new ArrayList<>();

        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = (JSONObject) items.get(i);
            ItemDto itemDto = new ItemDto(itemJson);
            list.add(itemDto);
        }

        return list;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("아이맥");
    }
}