package com.merry216.grandis.api.impl;

import com.merry216.grandis.api.IGrandisPrivateRouterService;
import com.merry216.yunme.api.ITempShopApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("grandisPrivateRouterService")
public class GrandisPrivateRouterServiceImpl implements IGrandisPrivateRouterService {

    @Autowired
    private ITempShopApi tempShopApi;

    @Override
    public String distributePrivateMsg(long qq, String msg) {
        String trimedMsg = msg.trim();
        if (trimedMsg.startsWith("$")) {
            List<String> items = Arrays.asList(trimedMsg.split("\\$"));
            String item = items.get(1);
            return tempShopApi.queryItem(item);
        }
        return null;
    }
}
