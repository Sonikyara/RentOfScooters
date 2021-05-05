package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.service.ServiceException;
import eu.senla.statkevich.scooters.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;

import javax.validation.Valid;


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
	@RequestMapping(value = "/user/registration",
			method = {RequestMethod.POST,RequestMethod.GET},
	        consumes = { "application/json" },
			produces = {MediaType.APPLICATION_JSON_VALUE})
 	@ResponseBody
	public String saveUser(@Valid @RequestBody  UserDTO userDTO, BindingResult result) {
		if (result.hasErrors()){
			String allErrors = "Wrong fields:";
			for (FieldError err:result.getFieldErrors()) {
				allErrors+=err.getField()+",";
			}
			throw new ServiceException(allErrors);
		}
		return userService.create(userDTO);

		//return ResponseEntity.ok(userDTO.toString());
	}

	@RequestMapping(value = "/user/ByName/{name}",
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
