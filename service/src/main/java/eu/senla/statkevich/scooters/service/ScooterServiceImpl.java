package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IDao.IScooterDao;
import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.entity.Scooters;
import eu.senla.statkevich.scooters.service.IServices.ScootersService;
import eu.senla.statkevich.scooters.service.mappers.IScooterMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScooterServiceImpl implements ScootersService {

    private static final Logger logger = Logger.getLogger(ScooterServiceImpl.class);

    @Autowired
    private IScooterDao scootersDAO;

    @Autowired
    private IScooterMapper scooterMapper;


    @Override
    public ScooterDTO read(Long number) {
        return scooterMapper.scooterToScooterDto(scootersDAO.read(number));
        //return  null;
    }

    @Override
    public List<ScooterDTO> readAll() {
        return scooterMapper.listScooterToListScooterDto(scootersDAO.readAll());
    }

    @Override
    public ScooterDTO readByModel(String model) {
        Scooters scooter=scootersDAO.readByModel(model);
        return scooterMapper.scooterToScooterDto(scootersDAO.readByModel(model));
    }

}
