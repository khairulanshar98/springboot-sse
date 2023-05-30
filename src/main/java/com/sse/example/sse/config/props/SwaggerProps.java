package com.sse.example.sse.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.swagger")
@Getter
@Setter
public class SwaggerProps {
    private String title;
    private String description;
    private String version;
}
