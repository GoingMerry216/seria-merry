package com.merry216.yunme.service;

import com.merry216.yunme.model.ProductBean;
import com.merry216.yunme.model.SmzdsReqBean;

import java.io.IOException;
import java.util.List;

public interface ISmzdmProcessService {
    List<ProductBean> queryProducts(SmzdsReqBean reqBean) throws IOException;
}
