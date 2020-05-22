package domains.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PreAuthorizationResponseEntity {
  private String id;
  private String paymentType;
  private String paymentBrand;
  private String amount;
  private String currency;
  private String descriptor;
  private ResultEntity result;
  private CardEntity card;
  private RiskEntity risk;
  private String buildNumber;
  private String timestamp;
  private String ndc;

}
