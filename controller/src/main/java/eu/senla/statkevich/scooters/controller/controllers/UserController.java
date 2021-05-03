package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Users;
import eu.senla.statkevich.scooters.service.RolesService;
import eu.senla.statkevich.scooters.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;

@RestController
public class UserController {

	@Autowired
	public UsersService userService;

	@RequestMapping(value = "/user/{id}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected UserDTO getUser(@PathVariable("id")Long id){
		return userService.read(id);
	}

//public User getUserFromDB(@RequestParam(required = false) int id, @RequestParam String name) {

	@RequestMapping(value = "/saveUser",
			method = {RequestMethod.POST,RequestMethod.GET},
	        consumes = { "application/json" },
			produces = {MediaType.APPLICATION_JSON_VALUE})
 	@ResponseBody
	public String saveUser(@RequestBody UserDTO userDTO) {
		return userService.create(userDTO);
		//return ResponseEntity.ok(userDTO.toString());
	}

	@RequestMapping(value = "/userByName/{name}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected UserDTO getRoleByTitle(@PathVariable("name")String name){
		return userService.readByName(name);
	}

	//TEST
	@RequestMapping ( "/helloUser" )
	@ResponseBody
	public String helloWorld () {
		return "helloUser";
	}

}
