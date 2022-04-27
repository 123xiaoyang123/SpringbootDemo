package com.example.pojo.redis;

public class redisTest {

    public static void main(String[] args) {

        CacheService service = new CacheService();

        service.add("test", 123);

    }

}
