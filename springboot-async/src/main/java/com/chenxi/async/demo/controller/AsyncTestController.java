package com.chenxi.async.demo.controller;

import com.chenxi.async.demo.AsyncExecutUtil;
import com.chenxi.async.demo.BadAsyncExecutUtil;
import com.chenxi.async.demo.task.CallableTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/async")
public class AsyncTestController {

    @GetMapping("test")
    public void testAsync() {
         List<CallableTask> callableTaskList=new ArrayList<>();
        for(int i=0;i<3;i++) {
            callableTaskList.add(new CallableTask(String.valueOf(i)));

        }
        AsyncExecutUtil.execute(callableTaskList);
        //BadAsyncExecutUtil.execute(callableTaskList);

    }
}
