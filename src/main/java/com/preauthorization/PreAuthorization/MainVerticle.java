package com.preauthorization.PreAuthorization;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import services.PreAuthorizationServices;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Router router = Router.router(vertx);
    router
      .get("/")
      .handler(request ->{
        request
          .response()
          .putHeader("content-type", "application/json; charset=utf-8")
          .end(Json.encodePrettily(PreAuthorizationServices.createPreAuthorizationRequest()));
      });

    vertx.createHttpServer().requestHandler(router).listen(8888);
  }
}
