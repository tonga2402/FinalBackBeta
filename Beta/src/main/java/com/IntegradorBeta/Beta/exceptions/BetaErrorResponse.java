package com.IntegradorBeta.Beta.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BetaErrorResponse {
    private String code;
    private String message;
}
