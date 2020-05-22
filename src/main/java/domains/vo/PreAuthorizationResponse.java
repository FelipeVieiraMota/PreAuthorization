package domains.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PreAuthorizationResponse {
  private String id;
  private String code;
  private String description;
}


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
class CardEntity {
  private String bin;
  private String last4Digits;
  private String holder;
  private String expiryMonth;
  private String expiryYear;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
class RiskEntity{
    private String score;
}
