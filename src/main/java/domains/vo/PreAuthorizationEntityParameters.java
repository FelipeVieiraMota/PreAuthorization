package domains.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PreAuthorizationEntityParameters {

  private String entityId;
  private String amount;
  private String currency;
  private String paymentBrand;
  private String paymentType;
  private String cardNumber;
  private String cardHolder;
  private String cardExpiryMonth;
  private String cardExpiryYear;
  private String cardCvv;

  public String parseToString(){
      StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("entityId="+this.entityId);
        stringBuilder.append("&amount="+this.amount);
        stringBuilder.append("&currency="+this.currency);
        stringBuilder.append("&paymentBrand="+this.paymentBrand);
        stringBuilder.append("&paymentType="+this.paymentType);
        stringBuilder.append("&card.number="+this.cardNumber);
        stringBuilder.append("&card.holder="+this.cardHolder);
        stringBuilder.append("&card.expiryMonth="+this.cardExpiryMonth);
        stringBuilder.append("&card.expiryYear="+this.cardExpiryYear);
        stringBuilder.append("&card.cvv="+this.cardCvv);
      return stringBuilder.toString();
  }
}
