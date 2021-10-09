package bb.api.com.bankapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("bank-api-properties")
@Getter
@Setter
public class OpenBankApiProperties {

	private String bankserviceurl;
}
