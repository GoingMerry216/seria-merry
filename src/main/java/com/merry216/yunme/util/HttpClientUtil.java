package com.merry216.yunme.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;

public class HttpClientUtil {
    /**
     *
     * @param buffer
     * @param key
     * @param value
     */
    public static void buildAQueryParam(StringBuffer buffer, String key, String value) {
        if (Strings.isNotBlank(value)) buffer.append(key).append("=").append(value);
    }


    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
