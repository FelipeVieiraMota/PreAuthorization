package com.preauthorization.PreAuthorization;

import domains.vo.PreAuthorizationEntityParameters;
import domains.vo.PreAuthorizationResponse;
import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import services.PreAuthorizationServices;
import util.http.HandleHttp;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(VertxExtension.class)
public class TestMainVerticle {

  @Test
  public void createPreAuthorizationRequestTest(){
    PreAuthorizationResponse test = PreAuthorizationServices.createPreAuthorizationRequest();
    String id = test.getId();
    System.out.println("ID "+id);
  }
}
