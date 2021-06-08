package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.service.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    public RolesService roleService;

    @RequestMapping(value = "/roles/id/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RoleDTO getRoleById(@PathVariable("id") Long id) {
        return roleService.read(id);
    }

    @RequestMapping(value = "/roles/title/{title}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RoleDTO getRoleByTitle(@PathVariable("title") String title) {
        return roleService.readByTitle(title);
    }

}
