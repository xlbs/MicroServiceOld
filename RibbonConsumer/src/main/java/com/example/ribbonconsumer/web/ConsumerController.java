package com.example.ribbonconsumer.web;

import com.example.ribbonconsumer.commutils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "testhello",method = {RequestMethod.POST,RequestMethod.GET})
    public void helloConsumer(){
//        list = restTemplate.postForObject("http://DATAOPERT-SERVICE/querySql?sql={1}",String.class,List.class,sql);
//        restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
        try {
//            URL url = new URL(strurl);
//            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
//            String strurl = "http://DATAOPERT-SERVICE/querySql";
//            String sql = "select * from s_user";
//            MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
//            map.add("sql",sql);
//            List<Map> list = restTemplate.postForObject(strurl,map,List.class);
//            System.out.println(list.toString());

//            URL url = new URL(strurl);
//            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            List<String> list = new ArrayList<>();
            String sql ="";
            sql = "INSERT INTO s_user (USER_NO,USER_NAME,ORG_ID,USER_PWD,IS_VALID) VALUES ('6666','fff',200,'ggg','F_YES')";
            list.add(sql);
            sql = "";
            sql = "INSERT INTO s_user (USER_NO,USER_NAME,ORG_ID,USER_PWD,IS_VALID) VALUES ('777','ddd',200,'ggg','F_YES')";
            list.add(sql);
            String sqlList = JSONUtils.serialize(list);
            String strurl = "http://DATAOPERT-SERVICE/executeTrans";
            String result = restTemplate.postForObject(strurl, sqlList, String.class);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
