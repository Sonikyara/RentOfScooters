package work.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import work.UserDTO;
import work.UserService;
import work.Users;

@RestController
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/user/{id}", 	//getUser/id
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected UserDTO getUserFromDB(@PathVariable("id")int id){
		//output???
		return userService.getUserById(id);
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
