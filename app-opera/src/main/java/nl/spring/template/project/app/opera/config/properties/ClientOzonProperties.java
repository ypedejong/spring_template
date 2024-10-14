package nl.spring.template.project.app.opera.config.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties(prefix = "application.client.ozon")
public class ClientOzonProperties {

    @NotBlank
    private String baseUrl;
}

