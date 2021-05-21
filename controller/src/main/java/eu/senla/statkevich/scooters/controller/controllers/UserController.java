package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.service.ServiceException;
import eu.senla.statkevich.scooters.service.IServices.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;

import javax.validation.Valid;


@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    public UsersService userService;

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected UserDTO getUser(@PathVariable("id") Long id) {
        return userService.read(id);
    }

    //public User getUserFromDB(@RequestParam(required = false) int id, @RequestParam String name) {
    @RequestMapping(value = "/user/registration",
            method = {RequestMethod.POST, RequestMethod.GET},
            consumes = {"application/json"},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String saveUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {

            String allErrors = "Wrong data in the fields:";
            for (FieldError err : result.getFieldErrors()) {
                allErrors += err.getField() + ",";
            }
            logger.info(allErrors);
            throw new ServiceException(allErrors);
        }
        return userService.create(userDTO);
    }

    @RequestMapping(value = "/user/ByName/{name}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected UserDTO getUserByName(@PathVariable("name") String name) {

        logger.info("Get user: " + name);

        return userService.readByName(name);
    }

    //TEST
    @RequestMapping("/helloUser")
    public String helloWorld() {
        return "helloUser";
    }


//	@GetMapping("/userAuth")
//	public String user(Authentication authentication) {
//		return authentication.getPrincipal().toString();
//	}

//	@RequestMapping ( "/login" )
//	@ResponseBody
//	public ModelAndView loginPage () {
//		return new ModelAndView("Login page");
//	}

}
