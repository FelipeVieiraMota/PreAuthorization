package com.preauthorization.PreAuthorization;

import domains.vo.PreAuthorizationEntityParameters;
import domains.vo.PreAuthorizationResponse;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import services.PreAuthorizationServices;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    vertx.createHttpServer()
      .requestHandler(req -> {
        String result = doPostRequest();
        req
          .response()
          .putHeader("content-type", "application/json;charset=UTF-8")
          .end(result);
      })
      .listen(8888, http -> {
        if (http.succeeded()) {
          startPromise.complete();
        } else
            startPromise.fail(http.cause());
      });

  }

  private String doPostRequest()  {
    String result = "";
    try{
      PreAuthorizationEntityParameters preAuthorizationEntityParameters = new PreAuthorizationEntityParameters(
        System.getenv("entity_id"),
        "1225.69",
        "EUR",
        "VISA",
        "PA",
        "4200000000000000",
        "393.236.588-71",
        "11",
        "2030",
        "753"
      );

      String data = preAuthorizationEntityParameters.parseToString();
      System.out.println("data " + data);
      URL url = new URL(System.getenv("url_end_point"));

      HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Authorization", System.getenv("authentication"));
      conn.setDoInput(true);
      conn.setDoOutput(true);

      DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
      wr.writeBytes(data);
      wr.flush();
      wr.close();
      int responseCode = conn.getResponseCode();
      InputStream is;

      if (responseCode >= 400)
        is = conn.getErrorStream();
      else
        is = conn.getInputStream();

      BufferedReader in = new BufferedReader(new InputStreamReader(is));

      StringBuilder response = new StringBuilder();
      String currentLine;

      while ((currentLine = in.readLine()) != null)
        response.append(currentLine);

      in.close();

      PreAuthorizationServices service = new PreAuthorizationServices();
      result = service.applyJson(response.toString());
      //result = response.toString();
      System.out.println("result " + result);
    }catch (IOException io){
      io.printStackTrace();
    }
    return result;
  }
}
