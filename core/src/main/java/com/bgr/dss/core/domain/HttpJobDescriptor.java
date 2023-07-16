package com.bgr.dss.core.domain;

import java.util.List;
import java.util.Map;

public class HttpJobDescriptor {
    private String url;
    private String method;
    private String body;
    private Map<String, List<String>> headers;
    private Long timeout;
    private List<Integer> successStatusCodes;
}
