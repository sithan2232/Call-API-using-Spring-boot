package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;


@RestController
public class Controller {
    private static final String BASEURL="http://localhost:8082/";
    @Scheduled(fixedRate = 3000)
    public void getAPI(){
        callGetAllPost();
    }

    private static void callGetAllPost(){
        RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity=restTemplate.exchange(BASEURL+"post/getAllPostInfo",
				HttpMethod.GET,
				requestEntity,
				String.class);
//		ในกรณีที่รับค่า JSON มาเเบบ Array
		JSONArray postArray=new JSONArray(responseEntity.getBody());
//		get ค่าตําเเหน่ง 0 จาก Array
		JSONObject postObject=postArray.getJSONObject(0);
//		เอาค่า topic มาเก็บ
		String topic =postObject.getString("topic_name");
		String description =postObject.getString("description");
		int color=postObject.getInt("color");
//		เอาค่า Array ที่ซ้อนอยู่ใน obj อีกทีนึง
		JSONArray likeList=postObject.getJSONArray("likes");
		JSONObject postWriter=postObject.getJSONObject("postWriter");
//		เอาค่าการ like มาเก็บในตัวเเปลอีกทีนึง
		String first_name =postWriter.getString("first_name");
		String last_name =postWriter.getString("last_name");
		int age=postWriter.getInt("age");
		System.out.println();
		System.out.println("topic :"+topic);
		System.out.println("description :"+description);
		System.out.println("color :"+color);
		System.out.println("writer(first_name) :"+first_name);
		System.out.println("writer(last_name) :"+last_name);
		System.out.println("age :"+age);
		System.out.println("likes :"+likeList);
        System.out.println();
    }
}
