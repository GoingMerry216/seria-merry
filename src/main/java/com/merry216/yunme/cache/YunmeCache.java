package com.merry216.yunme.cache;

import com.merry216.yunme.model.ProductBean;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * yunme商品与订阅者缓存bean
 */
@Component
public class YunmeCache {
    // 存储查询的关键词
    private Set<String> keys = new HashSet<>();
    // 存储关键词与qq号订阅关系
    private Map<String, Set<Long>> subscribesMap = new ConcurrentHashMap<>();

    /**
     * 添加订阅
     * @param qq
     * @param item
     */
    public synchronized void subscribe(long qq, String item) {
        if (subscribesMap.containsKey(item)) {
            if (Objects.isNull(subscribesMap.get(item))) {
                subscribesMap.put(item, new HashSet<>());
            }
            subscribesMap.get(item).add(qq);
        }
    }

    /**
     * 取消订阅
     * @param qq
     * @param item
     */
    public synchronized void cancelSubscribe(long qq, String item) {
        if (subscribesMap.containsKey(item)) {
            if (!Objects.isNull(subscribesMap.get(item))) {
                subscribesMap.remove(qq);
            }
        }
    }
}
