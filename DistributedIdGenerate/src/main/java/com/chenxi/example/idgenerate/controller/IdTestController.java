package com.chenxi.example.idgenerate.controller;

import com.chenxi.example.idgenerate.entity.IdTest;
import com.chenxi.example.idgenerate.mapper.IdTestMapper;
import com.chenxi.example.idgenerate.util.IdGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tukun on 2019/12/26.
 */
@RestController
@RequestMapping("/test")
public class IdTestController {
@Autowired
private IdTestMapper idTestMapper;

    @GetMapping("/idAdd/{num}")
    public void  idAdd(@PathVariable("num") Integer num) {
        for(int i=0;i<num;i++) {
            IdTest idTest=new IdTest();
             idTest.setId(IdGenerateUtil.getUniqueId());
            idTestMapper.insertSelective(idTest);
        }

    }
}
