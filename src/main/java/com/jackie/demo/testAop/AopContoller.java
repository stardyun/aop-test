package com.jackie.demo.testAop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * @author Jackie
 * @Date 2020/6/24 23:59
 * @Description
 */
@RestController
public class AopContoller {

    @PostMapping("/test")
    public String metod(@ReqDataType(ReqData.class) BaseRequest<ReqData> baseRequest) {
        System.out.println(baseRequest);
        return "hello";
    }
}
