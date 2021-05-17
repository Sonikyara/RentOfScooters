package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.PriceList;
import eu.senla.statkevich.scooters.entity.Rent;
import eu.senla.statkevich.scooters.service.IServices.PriceListService;
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

//вернуть самокат
	@Autowired
	public ScootersService scooterService;
	@Autowired
	public PriceListService priceListService;

//rent a scooter
	@RequestMapping(value = "/rent",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Rent> getAll(){ //DTO
		return null;
	}

//price
	@RequestMapping(value = "/price",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<PriceListDTO> getAllPrice(){
		return priceListService.readAll();
	}

//about scooters
	@RequestMapping(value = "/scooters/byNumber/{number}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	protected ScooterDTO getScooter(@PathVariable("number")Long number){
		return scooterService.read(number);
	}

	@RequestMapping(value = "/scooters/states",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ScooterDTO> getScooters(Principal principal){
		//(authentication.isAuthenticated())?((UserPrincipal) authentication.getPrincipal()).getName():"Нет такого юзера"
		//return principal.getName();
		return scooterService.readAll();
	}

	@RequestMapping(value = "/scooters/{model}",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	protected ScooterDTO getByModel(@PathVariable("model")String model){
		//(authentication.isAuthenticated())?((UserPrincipal) authentication.getPrincipal()).getName():"Нет такого юзера"
		//return principal.getName();
		return scooterService.readByModel(model);
	}

	//TEST
	//@PermitAll
	@RequestMapping ( "/helloRent" )
	public String helloWorld () {
		return "helloRent";
	}

}
