package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

	@Autowired
	public RolesService roleService;

	@RequestMapping(value = "/roleById/{id}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected RoleDTO getRoleById(@PathVariable("id")Long id){
		return roleService.read(id);
	}

	@RequestMapping(value = "/role/{title}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected RoleDTO getRoleByTitle(@PathVariable("title")String title){
		return roleService.readByTitle(title);
	}

	@RequestMapping(value = "/saveRole",
			method = {RequestMethod.POST,RequestMethod.GET},
			consumes = { "application/json" },
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Roles saveRole(@RequestBody RoleDTO roleDTO) {

		return roleService.create(roleDTO.getTitle());

	}

	//TEST
	@RequestMapping ( "/helloRole" )
	@ResponseBody
	public String helloWorld () {
		return "helloRole";
	}

}
