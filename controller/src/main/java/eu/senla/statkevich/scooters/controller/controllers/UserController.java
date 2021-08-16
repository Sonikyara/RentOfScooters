package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.controller.security.JwtProvider;
import eu.senla.statkevich.scooters.service.ServiceException;
import eu.senla.statkevich.scooters.service.services.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import eu.senla.statkevich.scooters.dto.UserDTO;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    public UsersService userService;

    @Value("${my.mess}")
    private String myMess;

    @RequestMapping(value = "/login/{phone}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected Object login(@PathVariable("phone") String phone) {
        String token = jwtProvider.generateToken(phone);
        return Collections.singletonMap("token", token);
    }

    @RequestMapping(value = "/users/registration",
            method = {RequestMethod.POST, RequestMethod.GET},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserDTO saveUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {

            String allErrors = "Wrong data in the fields:";
            for (FieldError err : result.getFieldErrors()) {
                allErrors += err.getField() + ",";
            }
            logger.info(allErrors);
            throw new ServiceException(allErrors);
        }
        String token= login(userDTO.getPhoneNumber()).toString();
        logger.info(token);

        return userService.create(userDTO);
    }

    @RequestMapping(value = "/users/id/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected UserDTO getUser(@PathVariable("id") Long id) {
        return userService.read(id);
    }

    @RequestMapping(value = "/users/name/{name}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected UserDTO getUserByName(@PathVariable("name") String name) {

        logger.info("Get user: " + name);
        logger.info(myMess);
        return userService.readByName(name);
    }
}
