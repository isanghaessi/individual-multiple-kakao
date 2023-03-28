package com.isanghaessi.individualmultiplekakao.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {
  boolean selectOne();
}
