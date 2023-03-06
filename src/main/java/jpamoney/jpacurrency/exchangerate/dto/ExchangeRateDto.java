package jpamoney.jpacurrency.exchangerate.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ExchangeRateDto {
       String result;
       String cur_unit;
       String ttb;
       String tts;
       String deal_bas_r;
       String bkpr;
       String yy_efee_r;
       String ten_dd_efee_r;
       String kftc_bkpr;
       String kftc_deal_bas_r;
       String cur_nm;

    @Override
    public String toString() {
        return "ExchangeRateDto{" +
                "result='" + result + '\'' +
                ", cur_unit='" + cur_unit + '\'' +
                ", ttb='" + ttb + '\'' +
                ", tts='" + tts + '\'' +
                ", deal_bas_r='" + deal_bas_r + '\'' +
                ", bkpr='" + bkpr + '\'' +
                ", yy_efee_r='" + yy_efee_r + '\'' +
                ", ten_dd_efee_r='" + ten_dd_efee_r + '\'' +
                ", kftc_bkpr='" + kftc_bkpr + '\'' +
                ", kftc_deal_bas_r='" + kftc_deal_bas_r + '\'' +
                ", cur_nm='" + cur_nm + '\'' +
                '}';
    }
}
