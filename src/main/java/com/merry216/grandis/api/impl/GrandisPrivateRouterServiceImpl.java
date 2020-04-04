package com.merry216.grandis.api.impl;

import com.alibaba.fastjson.JSON;
import com.merry216.grandis.api.IGrandisPrivateRouterService;
import com.merry216.yunme.api.ITempShopApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service("grandisPrivateRouterService")
public class GrandisPrivateRouterServiceImpl implements IGrandisPrivateRouterService {

    @Autowired
    private ITempShopApi tempShopApi;

    @Override
    public String distributePrivateMsg(long qq, String msg) {
        String trimedMsg = msg.trim();
        if (trimedMsg.startsWith("$")) {
            List<String> items = Arrays.asList(trimedMsg.split("\\$"));
            String key = items.get(1);
            String rst = tempShopApi.queryItem(key);
            return parseData(rst, key);
        }
        return null;
    }

    public String parseData(String jsonRst, String key) {
        List<Map> listMap = (List<Map>) JSON.parse(jsonRst);
        StringBuffer sb = new StringBuffer("【" + key + "】\n");
        AtomicInteger i = new AtomicInteger(0);
        listMap.forEach(item -> {
            String index = String.valueOf(i.incrementAndGet());
            sb.append(index + ".").append(item.get("name")).append("\n");
            sb.append(item.get("href")).append("\n");
            sb.append(item.get("price")).append("\n");
            sb.append("\n\n");
        });
        return sb.toString();
    }
}
