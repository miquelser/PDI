package org.example.service;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import org.example.model.Usuario;
import org.example.service.exceptions.ServicioException;


@WebService
public interface ServicioBasico {
    @WebMethod
    Usuario obtPersonaPorDoc(String organizacion, String passwordEntidad, String nroDocumento, String tipoDocumento) throws ServicioException;

    @WebMethod
    String productDesc();
}