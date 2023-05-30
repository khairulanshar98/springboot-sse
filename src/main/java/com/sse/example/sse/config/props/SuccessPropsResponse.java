package com.sse.example.sse.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class SuccessPropsResponse {
    private final boolean success = true;
    private String message;
    private Object body;
    private Object statusCode;
}
