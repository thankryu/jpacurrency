package jpamoney.jpacurrency.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .version("v1.0.0")
                .title("통화 알림 api 명세")
                .description("통화 알림 api 명세입니다.");

        return new OpenAPI()
                .info(info);
    }
}