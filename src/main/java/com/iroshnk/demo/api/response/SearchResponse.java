package com.iroshnk.demo.api.response;

import java.util.List;

public class SearchResponse {
    public int offset;
    public int limit;
    public long recordCount;
    public int status = -1;
    public String errorCode;

    public List data;
}
