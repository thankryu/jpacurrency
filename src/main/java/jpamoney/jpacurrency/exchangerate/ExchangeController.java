package jpamoney.jpacurrency.exchangerate;


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
    @GetMapping("/rate")
    public ExchangeRateDto getExchangeRate(@Valid @RequestBody ExchangeRequestDto dto, Errors errors) throws Exception{

        ExchangeRateDto exchangeRateDto = exchangeService.getExchangeRate(dto);

        return exchangeRateDto;
    }
}