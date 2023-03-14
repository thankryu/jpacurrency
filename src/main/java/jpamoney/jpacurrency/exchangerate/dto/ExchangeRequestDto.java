package jpamoney.jpacurrency.exchangerate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ExchangeRequestDto {

    @Schema(title="검색 요청 날짜", example = "2015-01-01")
    String searchdate; // 검색요청날짜 : ex) 2015-01-01, 20150101, (DEFAULT)현재일

    @Schema(title = "검색 요청 API 타입", example = "AP01")
    @Size(min = 4, max = 4)
    @NotBlank
    String data; // 검색요청API타입 : AP01 : 환율, AP02 : 대출금리, AP03 : 국제금리
}
