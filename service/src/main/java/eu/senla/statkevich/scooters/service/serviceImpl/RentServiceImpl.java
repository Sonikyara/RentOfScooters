package eu.senla.statkevich.scooters.service.serviceImpl;

import eu.senla.statkevich.scooters.dao.IDao.*;
import eu.senla.statkevich.scooters.dto.RentDTO;
import eu.senla.statkevich.scooters.entity.entities.*;
import eu.senla.statkevich.scooters.service.ServicesI.RentService;
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
    private ITermOfRentDao termOfRentDao;
    @Autowired
    private IPaymentDao paymentDao;

    @Autowired
    private IRentMapper rentMapper;

    private static final Logger logger = Logger.getLogger(RentServiceImpl.class);


    @Override
    public List<RentDTO> readAll() {
        return rentMapper.ListRentToListRentDTO(rentDao.readAll());
    }

    @Override
    public List<RentDTO> getByUserName(String name) {
        Users user = userDAO.readByName(name);
        List<Rent> rent = rentDao.readByUserId(user.getId());
        return rentMapper.ListRentToListRentDTO(rent);
    }

    @Override
    public RentDTO create(RentDTO rentDTO) {

        Rent rent = rentMapper.RentDTOToRent(rentDTO);

        Users user = userDAO.readByName(rentDTO.getUser_name());
        rent.setUser(user);

        Scooters scooter = scooterDao.readByModel(rentDTO.getScooter_model());
        rent.setScooter(scooter);

        TermOfRent termOfRent = termOfRentDao.readByTitle(rentDTO.getTermOfRent());
        PriceList priceList = priceListDao.readByTermAndScooter(termOfRent.getId(), scooter.getNumber());
        rent.setPrice(priceList);

        //проверим, есть ли оплата
        List<Payment> paymentList = paymentDao.getFreePayment(user, priceList.getPrice());
        if (paymentList.size()>0) {
            //тут оплату привязать
            Rent resultRent=rentDao.create(rent);

            paymentList.get(0).setRent(resultRent);
            paymentDao.updateRentId(paymentList.get(0));

            return rentMapper.RentToRentDto(resultRent);
        }else{
            return null;
        }

    }

    @Override
    public RentDTO returnTheScooter(String scooterName, String userName) {

        Users user = userDAO.readByName(userName);
        Scooters scooter = scooterDao.readByModel(scooterName);

        Rent rent = rentDao.readByUserScooter(user.getId(), scooter.getNumber());
        rent.setDateEnd(new Date());

        return rentMapper.RentToRentDto(rentDao.updateDateEnd(rent));
    }
}
