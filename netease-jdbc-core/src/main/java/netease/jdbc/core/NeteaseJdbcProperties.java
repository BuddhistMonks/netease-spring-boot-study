package netease.jdbc.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangyb
 * @date 2019-10-15 13:45:57
 */

@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class NeteaseJdbcProperties {
    private String url;
    private String username;
    private String password;
    private String DriverClassName;

}
