package com.merry216.yunme.api.impl;

import com.merry216.yunme.api.ITempShopApi;
import com.merry216.yunme.model.ProductBean;
import com.merry216.yunme.model.SmzdsReqBean;
import com.merry216.yunme.service.ISmzdmProcessService;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 订阅商品信息
 */
@Service("tempShopApi")
public class TempShopApiImpl implements ITempShopApi {
    @Autowired
    private ISmzdmProcessService smzdmProcessService;

    /**
     * 查询商品信息
     *
     * @param key
     * @return rst
     */
    @Override
    public String queryProducts(String key) {
        List<ProductBean> products = new ArrayList<>();
        try {
            SmzdsReqBean reqBean = new SmzdsReqBean();
            reqBean.setS(key);
            products = smzdmProcessService.queryProducts(reqBean);
        } catch (Exception e) {
            products = null;
            e.printStackTrace();
        }
        return ProductBean.toDisplayString(key, products);
    }
}
