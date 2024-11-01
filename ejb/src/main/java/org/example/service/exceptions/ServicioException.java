package org.example.service.exceptions;

public class ServicioException extends Exception {
    private String codigoError;

    public ServicioException(String codigoError, String mensaje) {
        super(mensaje);
        this.codigoError = codigoError;
    }

    public String getCodigoError() {
        return codigoError;
    }
}