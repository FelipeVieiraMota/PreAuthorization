package services;

import com.google.gson.Gson;
import domains.vo.PreAuthorizationResponse;
import domains.vo.PreAuthorizationResponseEntity;
import domains.vo.ResultEntity;

public class PreAuthorizationServices {

    public String applyJson(String json){
      Gson gson = new Gson();
      PreAuthorizationResponseEntity entity = gson.fromJson(json, PreAuthorizationResponseEntity.class);
      ResultEntity rs = entity.getResult();
      String id = entity.getId();
      String code = rs.getCode();
      String description = rs.getDescription();
      PreAuthorizationResponse response = new PreAuthorizationResponse(id,code,description);
      return gson.toJson(response);
    }
}
