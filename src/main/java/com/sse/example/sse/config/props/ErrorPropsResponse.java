package com.sse.example.sse.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ErrorPropsResponse {
    private final boolean success = false;
    private String message;
    private Object cause;
    private Object statusCode;
}
