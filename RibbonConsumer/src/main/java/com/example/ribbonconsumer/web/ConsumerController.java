package com.example.ribbonconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "testhello",method = RequestMethod.POST)
    public List<Map> helloConsumer(String sql){
        List<Map> list = new ArrayList<>();
//        list = restTemplate.postForObject("http://DATAOPERT-SERVICE/querySql?sql={1}",String.class,List.class,sql);
        try {
            String strUrl = "http://DATAOPERT-SERVICE/querySql?sql="+sql+"";
            URL url = new URL(strUrl);
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            list = restTemplate.postForObject(uri,String.class,List.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.toString());
        return list;

//        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }



}
