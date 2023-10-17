package api.victorxie.blog;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("vblog")
public record AppConfigProperties (
        String rdsURL,
        String iamUser,
        String iamPass,
        String oAuthClientId,
        String oAuthClientSecret,
        String schemaName){
}
