package com.merry216.yunme.api.impl;

import com.merry216.yunme.api.ITempShopApi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TempShopApiImpl implements ITempShopApi {
    /**
     * okhttpclient
     */
    private OkHttpClient client = new OkHttpClient();
//    final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public String queryItem(String key) {
        String baseUrl = "http://localhost:8091/";
        StringBuffer buffer = new StringBuffer("?s=" + key);
        Request request = new Request.Builder()
                .url(baseUrl + buffer.toString())
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            System.out.println(1);
            return "连一下，哎没通呢";
        }
    }
}
