package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IPriceListDao;
import eu.senla.statkevich.scooters.dto.PriceListDTO;
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
    private IPriceListMapper priceListMapper;

    @Override
    public PriceListDTO readByUser(Users user) {
        return null;
    }

    @Override
    public List<PriceListDTO> readAll() {
        return priceListMapper.listPriceListToListPriceListDto(priceListDao.readAll());

    }
}
