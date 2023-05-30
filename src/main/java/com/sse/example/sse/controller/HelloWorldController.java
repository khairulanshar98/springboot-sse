package com.sse.example.sse.controller;

import com.sse.example.sse.config.exception.RecordNotCreatedException;
import com.sse.example.sse.config.exception.RecordNotFoundException;
import com.sse.example.sse.config.exception.RecordNotUpdatedException;
import com.sse.example.sse.config.props.ErrorPropsResponse;
import com.sse.example.sse.config.props.SuccessPropsResponse;
import com.sse.example.sse.entity.Dummy;
import com.sse.example.sse.service.DummyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@Tag(name = "hello", description = "API hello")
public class HelloWorldController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/world/{name}")
    public ResponseEntity<?> world(@PathVariable String name) {
        try {
            SuccessPropsResponse response = new SuccessPropsResponse();
            response.setMessage("Record found");
            response.setBody(this.dummyService.getByHello(name));
            response.setStatusCode(HttpStatus.FOUND);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RecordNotFoundException exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/worlds")
    public ResponseEntity<?> world() {
        try {
            SuccessPropsResponse response = new SuccessPropsResponse();
            response.setMessage("All Records");
            response.setBody(this.dummyService.getAll());
            response.setStatusCode(HttpStatus.FOUND);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RecordNotFoundException exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Dummy dummy) {
        try {
            SuccessPropsResponse response = new SuccessPropsResponse();
            response.setMessage("Record Created");
            dummy = this.dummyService.create(dummy);
            response.setBody(dummy);
            response.setStatusCode(HttpStatus.CREATED);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RecordNotCreatedException exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody Dummy dummy) {
        try {
            SuccessPropsResponse response = new SuccessPropsResponse();
            response.setMessage("Record Created");
            dummy = this.dummyService.update(dummy);
            response.setBody(dummy);
            response.setStatusCode(HttpStatus.ACCEPTED);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RecordNotUpdatedException e) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            error.setMessage(e.getMessage());
            if (e.getCause() != null) {
                error.setCause(e.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception exception) {
            ErrorPropsResponse error = new ErrorPropsResponse();
            error.setStatusCode(HttpStatus.BAD_REQUEST);
            error.setMessage(exception.getMessage());
            if (exception.getCause() != null) {
                error.setCause(exception.getCause());
            } else {
                error.setCause("unknown");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
