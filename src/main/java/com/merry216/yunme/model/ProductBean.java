package com.merry216.yunme.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class ProductBean {
    private String id;
    private String name;
    private String price;
    private String href;

    @Autowired
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n");
        buffer.append("名称：").append(name);
        buffer.append("价格：").append(price);
        buffer.append("链接：").append(href);
        buffer.append("\n");
        return buffer.toString();
    }

    public static String toDisplayString(String key, List<ProductBean> products) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("【").append(key).append("】\n");
        if (Objects.isNull(products) || products.isEmpty()) {
            return "相应商品信息为空";
        } else {
            products.forEach(productBean -> {
                buffer.append(productBean.toString());
            });
            buffer.append("\n");
            return buffer.toString();
        }
    }
}
