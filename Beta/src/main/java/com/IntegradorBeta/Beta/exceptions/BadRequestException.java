package com.IntegradorBeta.Beta.exceptions;

import lombok.Getter;

@Getter
public class BadRequestException extends Exception {
        private String code;

        public BadRequestException(String code, String mensaje) {
            super(mensaje);
            this.code = code;
        }
}
