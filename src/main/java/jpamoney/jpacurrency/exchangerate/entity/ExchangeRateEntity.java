package jpamoney.jpacurrency.exchangerate.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class ExchangeRateEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String curUnit;

    private String curNm;

    private String ttb;

    private String tts;

    private String dealBasR;

    private String bkpr;

    private String yyEfeeR;

    private String tenDdEfeeR;

    private String kftcDealBasR;

    private String kftcBkpr;

    public ExchangeRateEntity() {
    }

    @Builder
    public ExchangeRateEntity(String curUnit, String curNm, String ttb, String tts, String dealBasR, String bkpr, String yyEfeeR, String tenDdEfeeR, String kftcDealBasR, String kftcBkpr) {
        this.curUnit = curUnit;
        this.curNm = curNm;
        this.ttb = ttb;
        this.tts = tts;
        this.dealBasR = dealBasR;
        this.bkpr = bkpr;
        this.yyEfeeR = yyEfeeR;
        this.tenDdEfeeR = tenDdEfeeR;
        this.kftcDealBasR = kftcDealBasR;
        this.kftcBkpr = kftcBkpr;
    }

    @Override
    public String toString() {
        return "ExchangeRateEntity{" +
                "id=" + id +
                ", curUnit='" + curUnit + '\'' +
                ", curNm='" + curNm + '\'' +
                ", ttb='" + ttb + '\'' +
                ", tts='" + tts + '\'' +
                ", dealBasR='" + dealBasR + '\'' +
                ", bkpr='" + bkpr + '\'' +
                ", yyEfeeR='" + yyEfeeR + '\'' +
                ", tenDdEfeeR='" + tenDdEfeeR + '\'' +
                ", kftcDealBasR='" + kftcDealBasR + '\'' +
                ", kftcBkpr='" + kftcBkpr + '\'' +
                '}';
    }
}
