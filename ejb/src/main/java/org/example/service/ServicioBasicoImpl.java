package org.example.service;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.NoResultException;
import org.example.model.Usuario;
import org.example.service.exceptions.ServicioException;

import java.util.List;

@Stateless
@WebService(endpointInterface = "org.example.service.ServicioBasico") // Asegúrate de que el paquete sea correcto
public class ServicioBasicoImpl implements ServicioBasico {
	

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario obtPersonaPorDoc(String organizacion, String passwordEntidad, String nroDocumento, String tipoDocumento) throws ServicioException {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM Usuario u WHERE u.nroDocumento = :nroDocumento AND u.tipoDocumento = :tipoDocumento", Usuario.class)
                    .setParameter("nroDocumento", nroDocumento)
                    .setParameter("tipoDocumento", tipoDocumento)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new ServicioException("500", "Persona inexistente");
        } catch (Exception e) {
            throw new ServicioException("1001", "No se pudo completar la consulta: " + e.getMessage());
        }
    }

    @Override
    public String productDesc() {
        return "Versión del servicio: 1.0, Modo: Producción";
    }
}