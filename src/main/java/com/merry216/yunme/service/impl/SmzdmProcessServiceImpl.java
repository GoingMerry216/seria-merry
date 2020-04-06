package com.merry216.yunme.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merry216.yunme.model.ProductBean;
import com.merry216.yunme.model.SmzdsReqBean;
import com.merry216.yunme.service.ISmzdmProcessService;
import com.merry216.yunme.util.HttpClientUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 什么值得买获取并处理爬虫结果
 */
@Service("smzdmProcessService")
public class SmzdmProcessServiceImpl implements ISmzdmProcessService {
    /* okhttpclient */
    private OkHttpClient client = new OkHttpClient();
    /* 什么值得买信息获取接口 */
    @Value("${app.yunme.smzdm}")
    private String smzdmUrl;

    @Override
    public List<ProductBean> queryProducts(SmzdsReqBean reqBean) throws IOException {
        Request request = new Request.Builder()
                .url(smzdmUrl + reqBean.toQueryString())
                .build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = HttpClientUtil.getCollectionType(mapper, ArrayList.class, ProductBean.class);
        return mapper.readValue(json, javaType);
    }
}
