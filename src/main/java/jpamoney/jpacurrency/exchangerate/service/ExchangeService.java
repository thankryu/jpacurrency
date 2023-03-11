package jpamoney.jpacurrency.exchangerate.service;

import jpamoney.jpacurrency.exchangerate.dto.ExchangeRateDto;
import jpamoney.jpacurrency.exchangerate.dto.ExchangeRequestDto;

public interface ExchangeService {

    ExchangeRateDto getExchangeRate(ExchangeRequestDto dto);
}
