package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Rent;
import eu.senla.statkevich.scooters.service.IServices.ScootersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class RentController {
//посмотреть список самокатов (свободных ?)
//арендовать конкретный самокат
//мои аренды
//прайс

//вернуть самокат
	@Autowired
	public ScootersService scooterService;

//	@RequestMapping(value = "/scooters/{number}",
//			method = RequestMethod.GET,
//			produces = {MediaType.APPLICATION_JSON_VALUE})
//	@ResponseBody
//	protected ScooterDTO getScooter(@PathVariable("number")Long number){
//		return scooterService.read(number);
//	}

	@RequestMapping(value = "/scoot/states",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<ScooterDTO> getScooters(Principal principal){
		//(authentication.isAuthenticated())?((UserPrincipal) authentication.getPrincipal()).getName():"Нет такого юзера"
		//return principal.getName();
		return scooterService.readAll();
	}

	@RequestMapping(value = "/scoot/{model}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	protected ScooterDTO getByModel(@PathVariable("model")String model){
		//(authentication.isAuthenticated())?((UserPrincipal) authentication.getPrincipal()).getName():"Нет такого юзера"
		//return principal.getName();
		return scooterService.readByModel(model);
	}

	@RequestMapping(value = "/rent",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<Rent> getMyRent(Principal principal){
		return null;
	}

	//TEST
	//@PermitAll
	@RequestMapping ( "/helloRent" )
	@ResponseBody
	public String helloWorld () {
		return "helloRent";
	}

}
