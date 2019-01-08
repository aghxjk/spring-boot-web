package com.zym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GetArgumentsBean {

    private static String[] arguments;

    public GetArgumentsBean(){
    }

    @Autowired
    public GetArgumentsBean(ApplicationArguments args) {
        arguments = args.getSourceArgs();
        System.err.println(Arrays.asList(args.getSourceArgs()));
    }

    public String getArgs() {
        if (arguments != null) {
            return Arrays.asList(arguments).toString();
        } else {
            return "null";
        }
    }
}
