package util.http;

import domains.vo.PreAuthorizationEntityParameters;
import domains.vo.PreAuthorizationResponse;
import services.PreAuthorizationServices;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class HandleHttp {

  public PreAuthorizationResponse doPostRequest(PreAuthorizationEntityParameters preAuthorizationEntityParameters)  {
    PreAuthorizationResponse result = null;
    try{
      String data = preAuthorizationEntityParameters.parseToString();
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
      result = service.filterParameters(response.toString());
    }catch (IOException io){
      io.printStackTrace();
    }
    return result;
  }

}
