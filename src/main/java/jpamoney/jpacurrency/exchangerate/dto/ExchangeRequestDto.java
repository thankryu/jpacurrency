package jpamoney.jpacurrency.exchangerate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRequestDto {
    String searchdate; // 검색요청날짜 : ex) 2015-01-01, 20150101, (DEFAULT)현재일
    String data; // 검색요청API타입 : AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리
}
