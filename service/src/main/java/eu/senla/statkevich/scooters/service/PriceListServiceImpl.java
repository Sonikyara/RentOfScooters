package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IDao.IPriceListDao;
import eu.senla.statkevich.scooters.dao.IDao.IScooterDao;
import eu.senla.statkevich.scooters.dao.IDao.ITermOfRentDAO;
import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.entity.Scooters;
import eu.senla.statkevich.scooters.entity.TermOfRent;
import eu.senla.statkevich.scooters.entity.Users;
import eu.senla.statkevich.scooters.service.IServices.PriceListService;
import eu.senla.statkevich.scooters.service.mappers.IPriceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private IPriceListDao priceListDao;
    @Autowired
    private IScooterDao scooterDao;
    @Autowired
    private ITermOfRentDAO termOfRentDao;

    @Autowired
    private IPriceListMapper priceListMapper;

    @Override
    public List<PriceListDTO> readAll() {
        return priceListMapper.listPriceListToListPriceListDto(priceListDao.readAll());
    }

    @Override
    public PriceListDTO readByTermIdAndScooter(Long term, String scootersModel) {
        Scooters scooter = scooterDao.readByModel(scootersModel);
        return priceListMapper.PriceListToPriceListDto(priceListDao.readByTermAndScooter(term, scooter.getNumber()));
    }

    @Override
    public PriceListDTO readByTermAndScooter(String term, String scootersModel) {
        TermOfRent termOfRent = termOfRentDao.readByTitle(term);
        return readByTermIdAndScooter(termOfRent.getId(), scootersModel);
        //return priceListMapper.PriceListToPriceListDto(priceListDao.readByTermAndScooter(termOfRent.getId(),scooter.getNumber()));
    }
}
