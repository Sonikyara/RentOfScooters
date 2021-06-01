package eu.senla.statkevich.scooters.controller.controllers;

import eu.senla.statkevich.scooters.dto.PaymentDTO;
import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.service.ServicesI.PaymentService;
import eu.senla.statkevich.scooters.service.ServicesI.PriceListService;
import eu.senla.statkevich.scooters.service.ServicesI.RentService;
import eu.senla.statkevich.scooters.service.ServicesI.ScootersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
public class RentController {

    private static final Logger logger = Logger.getLogger(RentController.class);

    @Autowired
    public ScootersService scooterService;

    @Autowired
    public PriceListService priceListService;

    @Autowired
    public RentService rentService;

    @Autowired
    public PaymentService paymentService;

    //payment
    @Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/payment/pay",
            method = {RequestMethod.POST, RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PaymentDTO addPayment(@RequestParam(name = "sum", required = true) BigDecimal sum, Principal principal) {
        return paymentService.create(sum, principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/payment/all",
            method = {RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PaymentDTO> allPayments() {

        return paymentService.readAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @RequestMapping(value = "/payment/my",
            method = {RequestMethod.GET},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PaymentDTO> allPaymentsForUser(Principal principal) {
        return paymentService.getByUserName(principal.getName());
    }

    //rent a scooter
    @RequestMapping(value = "/rent/scooter",
            method = {RequestMethod.POST, RequestMethod.GET},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String rentTheScooter(@RequestBody RentDTO rentDTO, Principal principal) {
        rentDTO.setUser_name(principal.getName());
        RentDTO resultRentDTO = rentService.create(rentDTO);
        logger.info(resultRentDTO);
        if (resultRentDTO == null) {
            return "нет подходящей оплаты";
        } else {
            return resultRentDTO.toString();
        }
    }

    @RequestMapping(value = "/rent/returnScooter",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RentDTO returnTheScooter(@RequestParam(name = "scooter", required = true) String scooter, Principal principal) {

        return rentService.returnTheScooter(scooter, principal.getName());
    }

    @RequestMapping(value = "/rent/all",
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

    //http://localhost:8081/controller-1.0-SNAPSHOT/scooters/free?dateStr=2020-07-01
    @RequestMapping(value = "/scooters/all",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ScooterDTO> getAllScooters() {
        return scooterService.readAll();
    }

    //ожидается, что в эту дату будут свободны
    @RequestMapping(value = "/scooters/free",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ScooterDTO> getFreeScooters(@RequestParam(name = "dateStr") String dateStr) {
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
