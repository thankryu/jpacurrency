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

    private String cur_unit;

    private String cur_nm;

    private String ttb;

    private String tts;

    private String deal_bas_r;

    private String bkpr;

    private String yy_efee_r;

    private String ten_dd_efee_r;

    private String kftc_deal_bas_r;

    private String kftc_bkpr;

    public ExchangeRateEntity() {
    }

    @Builder
    public ExchangeRateEntity(String cur_unit, String cur_nm, String ttb, String tts, String deal_bas_r, String bkpr, String yy_efee_r, String ten_dd_efee_r, String kftc_deal_bas_r, String kftc_bkpr) {
        this.cur_unit = cur_unit;
        this.cur_nm = cur_nm;
        this.ttb = ttb;
        this.tts = tts;
        this.deal_bas_r = deal_bas_r;
        this.bkpr = bkpr;
        this.yy_efee_r = yy_efee_r;
        this.ten_dd_efee_r = ten_dd_efee_r;
        this.kftc_deal_bas_r = kftc_deal_bas_r;
        this.kftc_bkpr = kftc_bkpr;
    }
}
