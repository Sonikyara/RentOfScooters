package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.*;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.entity.*;
import eu.senla.statkevich.scooters.service.IServices.RentService;
import eu.senla.statkevich.scooters.service.mappers.IRentMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private IRentDao rentDao;
    @Autowired
    private IPriceListDao priceListDao;
    @Autowired
    private IUserDao userDAO;
    @Autowired
    private IScooterDao scooterDao;
    @Autowired
    private ITermOfRentDAO termOfRentDao;

    @Autowired
    private IRentMapper rentMapper;

    private static final Logger logger = Logger.getLogger(RentServiceImpl.class);

    @Override
    public RentDTO readByUser(Users user) {
        return null;
    }

    @Override
    public List<RentDTO> readAll() {
        return rentMapper.ListRentToListRentDTO(rentDao.readAll());
    }

    @Override
    public List<RentDTO> getByUserName(String name) {
        Users user =userDAO.readByName(name);
        logger.info(user.toString());
        List<Rent> rentDAO=rentDao.readByUserId(user.getId());
        logger.info(rentDAO.stream().toArray());
        return rentMapper.ListRentToListRentDTO(rentDAO);
    }

    @Override
    public String create(RentDTO rentDTO) {

        Rent rent=rentMapper.RentDTOToRent(rentDTO);

        Users user =userDAO.readByName(rentDTO.getUser_name());
        rent.setUser(user);

        Scooters scooter = scooterDao.readByModel(rentDTO.getScooter_model());
        rent.setScooter(scooter);

        TermOfRent termOfRent=termOfRentDao.readByTitle(rentDTO.getTermOfRent());
        PriceList priceList= priceListDao.readByTermAndScooter(termOfRent.getId(),scooter.getNumber());
        rent.setPrice(priceList);

        //logger.info(rent.toString());

        return String.valueOf(rentDao.create(rent));
    }

    @Override
    public RentDTO returnTheScooter(String scooterName, String name) {

        Users user =userDAO.readByName(name);
        Scooters scooter = scooterDao.readByModel(scooterName);

        Rent rent=rentDao.readByUserScooter(user.getId(),scooter.getNumber());
        rent.setDateEnd(new Date());

        return rentMapper.RentToRentDto(rentDao.updateDateEnd(rent));
    }
}
