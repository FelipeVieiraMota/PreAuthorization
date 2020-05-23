package services;

import com.google.gson.Gson;
import domains.vo.PreAuthorizationEntityParameters;
import domains.vo.PreAuthorizationResponse;
import domains.vo.PreAuthorizationResponseEntity;
import domains.vo.ResultEntity;
import util.http.HandleHttp;

public class PreAuthorizationServices {

    public PreAuthorizationResponse filterParameters(String json){
      Gson gson = new Gson();
      PreAuthorizationResponseEntity entity = gson.fromJson(json, PreAuthorizationResponseEntity.class);
      ResultEntity rs = entity.getResult();
      String id = entity.getId();
      String code = rs.getCode();
      String description = rs.getDescription();
      PreAuthorizationResponse response = new PreAuthorizationResponse(id,code,description);
      return response;
    }

    public static PreAuthorizationResponse createPreAuthorizationRequest(){
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
      HandleHttp handle = new HandleHttp();
      return handle.doPostRequest(preAuthorizationEntityParameters);
    }
}
