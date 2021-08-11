package com.xxl.job.executor.mvc.controller;

import com.xxl.job.core.executor.XxlJobExecutor;
import com.xxl.job.core.handler.impl.MethodJobHandler;
import com.xxl.job.executor.service.jobhandler.TestAddJob;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.jvm.hotspot.debugger.win32.coff.TestDebugInfo;

import java.lang.reflect.Method;

@Controller
@EnableAutoConfiguration
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        TestAddJob testAddJob = new TestAddJob();
        Method[] methods = testAddJob.getClass().getDeclaredMethods();
        methods[0].setAccessible(true);
        MethodJobHandler methodJobHandler = new MethodJobHandler(testAddJob,methods[0],null,null);
        XxlJobExecutor.registJobHandler("test111",methodJobHandler);
        return "xxl job executor running.";
    }

}
