package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController {

	@Autowired
	public UsersService userService;

	//@RolesAllowed(value={"ROLE_USER", "ROLE_ADMIN"})
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

	@GetMapping("/user")
	@ResponseBody
	public String user() {

		return "user";
	}

//	@GetMapping("/userAuth")
//	public String user(Authentication authentication) {
//
//		return authentication.getPrincipal().toString();
//	}

//	@RequestMapping ( "/login" )
//	@ResponseBody
//	public ModelAndView loginPage () {
//		return new ModelAndView("Login page");
//	}

}
