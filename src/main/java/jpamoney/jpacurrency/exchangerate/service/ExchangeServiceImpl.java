package jpamoney.jpacurrency.exchangerate.service;

import jpamoney.jpacurrency.exchangerate.dto.ExchangeRateDto;
import jpamoney.jpacurrency.exchangerate.dto.ExchangeRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService{

    // 한국수출입은행 auth key
    @Value("${bank.exchange.authkey}")
    String authkey;

    // 한국수출입은행 API URL
    private String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    /**
     * 환율 정보 조회
     * @param dto
     * @return
     */
    @Override
    public ExchangeRateDto getExchangeRate(ExchangeRequestDto dto) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("authkey", authkey);
        params.add("searchdate", dto.getSearchdate());
        params.add("date", dto.getData());

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        WebClient webClient = WebClient
                .builder()
                .uriBuilderFactory(factory)
                .baseUrl(url)
                .build();

        Flux<ExchangeRateDto> exchangeRateDtoList = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParams(params).build())
                .retrieve()
                .bodyToFlux(ExchangeRateDto.class);

        List<ExchangeRateDto> exchangeRateDtos = exchangeRateDtoList
                .collect(Collectors.toList())
                .share().block();

        for(ExchangeRateDto rateDto : exchangeRateDtos){
            rateDto.toString();
        }

        return null;
    }
}