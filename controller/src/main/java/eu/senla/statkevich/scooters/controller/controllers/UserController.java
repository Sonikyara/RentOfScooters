package eu.senla.statkevich.scooters.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.service.UserService;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/user/{id}", 	//getUser/id
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected UserDTO getUser(@PathVariable("id")long id){
		//output???
		return userService.read(id);
	}

//public User getUserFromDB(@RequestParam(required = false) int id, @RequestParam String name) {

//	@RequestMapping(value = "/saveUser",
//			method = RequestMethod.POST,
//			produces = { MediaType.APPLICATION_JSON_VALUE})
//	public String saveNewUserToDB(@RequestBody Users user) {
//		//userService.saveUserById(user);
//		return "save";
//	}

	//TEST
	@RequestMapping ( "/helloWorld" )
	@ResponseBody
	public String helloWorld () {
		return "helloWorld";
	}

}
