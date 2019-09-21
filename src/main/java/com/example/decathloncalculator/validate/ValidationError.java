package com.example.decathloncalculator.validate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {
    private String code;
    private List<String> arguments;
    private String message;
}