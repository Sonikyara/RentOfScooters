package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.entity.Users;
import eu.senla.statkevich.scooters.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;

@RestController
public class UserController {

	@Autowired
	public UserServiceImpl userService;

	@RequestMapping(value = "/user/{id}", 	//getUser/id
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected UserDTO getUser(@PathVariable("id")long id){
		//output???
		return userService.read(id);
	}

//public User getUserFromDB(@RequestParam(required = false) int id, @RequestParam String name) {

	@RequestMapping(value = "/saveUser",
			method = {RequestMethod.POST,RequestMethod.GET},
	        consumes = { "application/json" },
			produces = {MediaType.APPLICATION_JSON_VALUE})
 	@ResponseBody
	public Users saveUser(@RequestBody UserDTO userDTO) {

		return userService.create(userDTO);

		//return ResponseEntity.ok(userDTO.toString());
	}

	//TEST
	@RequestMapping ( "/helloWorld" )
	@ResponseBody
	public String helloWorld () {
		return "helloWorld";
	}

}
