package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.service.IServices.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

	@Autowired
	public RolesService roleService;

	@RequestMapping(value = "/role/{id}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected RoleDTO getRoleById(@PathVariable("id")Long id){
		return roleService.read(id);
	}

	@RequestMapping(value = "/role/ByTitle/{title}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected RoleDTO getRoleByTitle(@PathVariable("title")String title){
		return roleService.readByTitle(title);
	}

//	@RequestMapping(value = "/roleSave",
//			method = {RequestMethod.POST,RequestMethod.GET},
//			consumes = { "application/json" },
//			produces = {MediaType.APPLICATION_JSON_VALUE})
//	@ResponseBody
//	public Roles saveRole(@RequestBody RoleDTO roleDTO) {
//		return roleService.create(roleDTO.getTitle());
//	}

	//TEST
	//@PermitAll
	@RequestMapping ( "/helloRole" )
	@ResponseBody
	public String helloWorld () {
		return "helloRole";
	}

}
