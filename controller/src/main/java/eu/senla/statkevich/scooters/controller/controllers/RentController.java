package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.service.IServices.PriceListService;
import eu.senla.statkevich.scooters.service.IServices.RentService;
import eu.senla.statkevich.scooters.service.IServices.ScootersService;
import eu.senla.statkevich.scooters.service.ScooterServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
public class RentController {
//вернуть самокат

    private static final Logger logger = Logger.getLogger(RentController.class);

    @Autowired
    public ScootersService scooterService;

    @Autowired
    public PriceListService priceListService;

    @Autowired
    public RentService rentService;

    //rent a scooter
    @RequestMapping(value = "/rent/scooter",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String rentTheScooter(@RequestBody RentDTO rentDTO, Principal principal) {
        rentDTO.setUser_name(principal.getName());
        return rentService.create(rentDTO);
    }

    @RequestMapping(value = "/rent/returnScooter",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RentDTO returnTheScooter(@RequestParam(name = "scooter", required = true) String scooter, Principal principal) {

        return rentService.returnTheScooter(scooter, principal.getName());
    }

    @RequestMapping(value = "/rent/All",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RentDTO> getAll() {
        return rentService.readAll();
    }

    @RequestMapping(value = "/rent/my",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RentDTO> getByUser(Principal principal) {
        return rentService.getByUserName(principal.getName());
    }

    //price
    @RequestMapping(value = "/priceList",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PriceListDTO> getAllPrice() {
        return priceListService.readAll();
    }

    @RequestMapping(value = "/price/scooterAndTerm",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PriceListDTO getPriceByTermAndScootersModel(@RequestParam(name = "term", required = true) String term,
                                                       @RequestParam(name = "scooter", required = true) String scooter) {
        return priceListService.readByTermAndScooter(term, scooter);
    }

    //about scooters
    @RequestMapping(value = "/scooters/byNumber/{number}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected ScooterDTO getScooter(@PathVariable("number") Long number) {
        return scooterService.read(number);
    }

    @RequestMapping(value = "/scooters/all",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ScooterDTO> getAllScooters(Principal principal) {
        //(authentication.isAuthenticated())?((UserPrincipal) authentication.getPrincipal()).getName():"Нет такого юзера"
        //return principal.getName();
        return scooterService.readAll();
    }

    //ожидается, что в эту дату будут свободны
    @RequestMapping(value = "/scooters/free",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ScooterDTO> getFreeScooters(@DateTimeFormat(pattern = "dd-MM-yyyy") @RequestParam(name = "date") Date date, @RequestParam(name = "dateStr") String dateStr) {
//если дата не задана, то возьмет просто текущее состояние табилц??
        logger.info(dateStr);
        return scooterService.readFreeScooters(dateStr);
    }

    @RequestMapping(value = "/scooters/{model}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    protected ScooterDTO getByModel(@PathVariable("model") String model) {
        return scooterService.readByModel(model);
    }

    //TEST
    //@PermitAll
    @RequestMapping("/helloRent")
    public String helloWorld() {
        return "helloRent";
    }

}
