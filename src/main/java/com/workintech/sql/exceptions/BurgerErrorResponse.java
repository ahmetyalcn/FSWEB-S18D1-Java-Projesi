package com.workintech.sql.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}
