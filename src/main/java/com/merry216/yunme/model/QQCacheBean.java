package com.merry216.yunme.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class QQCacheBean {
    private String qqId;
    private String key;
    private List<String> sentIds;
}
