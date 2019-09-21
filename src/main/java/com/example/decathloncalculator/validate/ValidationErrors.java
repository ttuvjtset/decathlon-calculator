package com.example.decathloncalculator.validate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrors {

    @Getter
    private List<ValidationError> errors = new ArrayList<>();

    void addError(FieldError fieldError) {
        List<String> args = Stream.of(fieldError.getArguments())
                .filter(arg -> !(arg instanceof DefaultMessageSourceResolvable))
                .map(String::valueOf)
                .collect(Collectors.toList());

        errors.add(new ValidationError(fieldError.getCodes()[0], args, fieldError.getDefaultMessage()));
    }
}