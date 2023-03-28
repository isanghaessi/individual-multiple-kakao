package com.isanghaessi.individualmultiplekakao.service;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.isanghaessi.individualmultiplekakao.mapper.HelloMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloService {
  private final Environment environment;
  private final HelloMapper helloMapper;

  public HelloService(
      Environment environment,
      HelloMapper helloMapper) {
    this.environment = environment;
    this.helloMapper = helloMapper;
  }

  public String hello() {
    List<String> profiles = List.of(environment.getActiveProfiles());

    return String.format("hello-spring -> profiles: %s dbResult: [%s]", profiles, helloDb());
  }

  private boolean helloDb() {
    try {
      return helloMapper.selectOne();
    } catch (Exception exception) {
      log.error("db 연결에 실패했습니다.", exception);

      return false;
    }
  }
}
