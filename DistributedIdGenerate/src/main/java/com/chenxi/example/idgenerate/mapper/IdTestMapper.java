package com.chenxi.example.idgenerate.mapper;


import com.chenxi.example.idgenerate.entity.IdTest;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by tukun on 2019/12/26.
 */
@Mapper
public interface IdTestMapper {
    int deleteByPrimaryKey(String id);

    int insert(IdTest record);

    int insertSelective(IdTest record);

    IdTest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IdTest record);

    int updateByPrimaryKey(IdTest record);
}
