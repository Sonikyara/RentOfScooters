package eu.senla.statkevich.scooters.service.implementations;

import eu.senla.statkevich.dao.dao.IPriceListDao;
import eu.senla.statkevich.dao.dao.IScooterDao;
import eu.senla.statkevich.dao.dao.ITermOfRentDao;
import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.entities.Scooters;
import eu.senla.statkevich.scooters.entities.TermOfRent;
import eu.senla.statkevich.scooters.service.services.PriceListService;
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
    private ITermOfRentDao termOfRentDao;

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
