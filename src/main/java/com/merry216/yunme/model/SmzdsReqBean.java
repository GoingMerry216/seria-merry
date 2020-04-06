package com.merry216.yunme.model;

import com.merry216.yunme.util.HttpClientUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 什么值得买请求bean
 */
@Getter
@Setter
@ToString
public class SmzdsReqBean {
    // 目前为止这个的作用
    private String c = "home";
    /**
     * 查询关键词
     */
    private String s;
    /**
     * 排列顺序
     * time 时间
     * score 综合
     */
    private String order = "score";
    /**
     * 分类（目前无映射表，这个可以先不填）
     * 75 母婴
     * 113 个护化妆
     * 等
     */
    private String cateId;
    /**
     * 商城（目前无映射表，这个可以先不填）
     * 183 天猫
     * 等
     */
    private String mallId;
    /**
     * 最低价格
     */
    private String minPrice;
    /**
     * 最高价格
     */
    private String maxPrice;
    /**
     * 品牌id
     * 1049 李施德林
     */
    private String brandId;

    /**
     * 将自身拼接成queryString
     * @return
     */
    public String toQueryString() {
        StringBuffer buffer = new StringBuffer("?");
        HttpClientUtil.buildAQueryParam(buffer, "c", c);
        HttpClientUtil.buildAQueryParam(buffer, "&s", s);
        HttpClientUtil.buildAQueryParam(buffer, "&order", order);
        HttpClientUtil.buildAQueryParam(buffer, "&cate_id", cateId);
        HttpClientUtil.buildAQueryParam(buffer, "&mall_id", mallId);
        HttpClientUtil.buildAQueryParam(buffer, "&min_price", minPrice);
        HttpClientUtil.buildAQueryParam(buffer, "&max_price", maxPrice);
        HttpClientUtil.buildAQueryParam(buffer, "&brand_id", brandId);
        return buffer.toString();
    }
}
