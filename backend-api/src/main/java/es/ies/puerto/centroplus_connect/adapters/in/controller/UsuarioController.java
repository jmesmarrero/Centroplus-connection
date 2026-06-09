package es.ies.puerto.centroplus_connect.adapters.in.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.centroplus_connect.business.IUsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name ="Usuario API")
@CrossOrigin
public class UsuarioController {

    private final IUsuarioService service;

    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }
    


}
