package jpamoney.jpacurrency.exchangerate.service;

import jpamoney.jpacurrency.exchangerate.dto.ExchangeRateDto;
import jpamoney.jpacurrency.exchangerate.dto.ExchangeRequestDto;
import jpamoney.jpacurrency.exchangerate.entity.ExchangeRateEntity;
import jpamoney.jpacurrency.exchangerate.repository.ExchangeRateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExchangeServiceImpl implements ExchangeService{

    // 한국수출입은행 auth key
    @Value("${bank.exchange.authkey}")
    String authkey;

    private final ExchangeRateRepository exchangeRateRepository;

    // 한국수출입은행 API URL
    private String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

    public ExchangeServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

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
        params.add("data", dto.getData());

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        WebClient webClient = WebClient
                .builder()
                .uriBuilderFactory(factory)
                .baseUrl(url)
                .build();

        // 환율 API
        Flux<ExchangeRateDto> exchangeRateDtoList = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParams(params).build())
                .retrieve()
                .bodyToFlux(ExchangeRateDto.class);

        List<ExchangeRateDto> exchangeRateDtos = exchangeRateDtoList
                .collect(Collectors.toList())
                .share().block();

        // TODO entity 키 작성 필요
        
        // 조회한 내용 entity에 담기
        List<ExchangeRateEntity> rateList = exchangeRateDtos.stream()
                .map(rateDto -> {
                    ExchangeRateEntity entity = ExchangeRateEntity.builder()
                            .curNm(rateDto.getCur_nm())
                            .curUnit(rateDto.getCur_unit())
                            .ttb(rateDto.getTtb())
                            .tts(rateDto.getTts())
                            .dealBasR(rateDto.getDeal_bas_r())
                            .bkpr(rateDto.getBkpr())
                            .yyEfeeR(rateDto.getYy_efee_r())
                            .tenDdEfeeR(rateDto.getTen_dd_efee_r())
                            .kftcDealBasR(rateDto.getKftc_deal_bas_r())
                            .kftcBkpr(rateDto.getKftc_bkpr())
                            .build();
                    return entity;
                })
                .collect(Collectors.toList());


        // 데이터 저장
        exchangeRateRepository.saveAll(rateList);


        List<ExchangeRateEntity> list = exchangeRateRepository.findAll();
        Optional<ExchangeRateEntity> test = exchangeRateRepository.findByCurUnit(dto.getCurType());

        System.out.println(test.get().toString());
        return null;
    }
}