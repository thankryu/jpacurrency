package jpamoney.jpacurrency;

import jpamoney.jpacurrency.exchangerate.dto.ExchangeRateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class JpacurrencyApplicationTests {

    @Value("${bank.exchange.authkey}")
    String authkey;

    /**
     * 환율 은행 통신 테스트
     */
    @Test
    void exchageRateApiTest() {

        String urlTest = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("authkey", authkey);
        params.add("searchdate", "20230306");
        params.add("data", "AP01");

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(urlTest);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        WebClient webClient = WebClient
                .builder()
                .uriBuilderFactory(factory)
                .baseUrl(urlTest)
                .build();

        Flux<ExchangeRateDto> exchangeRateDtoList = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.queryParams(params).build())
                .retrieve()
                .bodyToFlux(ExchangeRateDto.class);


        List<ExchangeRateDto> exchangeRateDtos = exchangeRateDtoList
                .collect(Collectors.toList())
                .share().block();

        System.out.println("token::"+exchangeRateDtoList);
        System.out.println("exchangeRateDtos::"+exchangeRateDtos);

    }

}
