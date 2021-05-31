package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.controller.securityConfiguration.JwtProvider;
import eu.senla.statkevich.scooters.entity.entities.Users;
import eu.senla.statkevich.scooters.service.ServiceException;
import eu.senla.statkevich.scooters.service.ServicesI.UsersService;
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
    private JwtProvider jwtProvider;

    @Autowired
    public UsersService userService;

    @RequestMapping(value = "/user/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected UserDTO getUser(@PathVariable("id") Long id) {
        return userService.read(id);
    }

    @RequestMapping(value = "/user/registration",
            method = {RequestMethod.POST, RequestMethod.GET},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
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
        Users newUser = userService.create(userDTO);

        String token = jwtProvider.generateToken(newUser.getName());
        logger.info(newUser.toString());
        logger.info("token :  " + token);

        return newUser.toString() + " , token: " + token;
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
