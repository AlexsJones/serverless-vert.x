package com.serverless.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> startFuture) throws Exception {

    String name = System.getenv("NAME");

    Integer port = 8080;

    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello " + name);
    }).listen(port, http -> {
      if (http.succeeded()) {
        startFuture.complete();
        System.out.println("HTTP server started on port " + port);
      } else {
        startFuture.fail(http.cause());
      }
    });
  }
}
