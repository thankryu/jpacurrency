package jpamoney.jpacurrency.exchangerate;


import io.swagger.v3.oas.annotations.Operation;
import jpamoney.jpacurrency.exchangerate.dto.ExchangeRateDto;
import jpamoney.jpacurrency.exchangerate.dto.ExchangeRequestDto;
import jpamoney.jpacurrency.exchangerate.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exchange")
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    /**
     * 환율 정보 조회
     * @param dto
     * @param errors
     * @return
     * @throws Exception
     */
    @Operation(
            summary = "통화 조회", description = "원하는 통화의 환율을 조회"
    )
    @GetMapping("/rate")
    public ExchangeRateDto getExchangeRate(@Valid @RequestBody ExchangeRequestDto dto, Errors errors) throws Exception{

        ExchangeRateDto exchangeRateDto = exchangeService.getExchangeRate(dto);

        return exchangeRateDto;
    }
}