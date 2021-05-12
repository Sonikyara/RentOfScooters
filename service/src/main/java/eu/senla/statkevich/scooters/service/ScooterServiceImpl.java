package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IScooterDao;
import eu.senla.statkevich.scooters.dao.ScootersDAO;
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
    public ScooterDTO read(Long id) {
        //return scooterMapper.scooterToScooterDto(scootersDAO.readAll());
        return  null;
    }

    @Override
    public List<ScooterDTO> readAll() {
        return scooterMapper.listScooterToListScooterDto(scootersDAO.readAll());
    }

    @Override
    public ScooterDTO readByModel(String model) {
        Scooters scooter=scootersDAO.readByModel(model);
        logger.info("AAAAAAA");
        logger.info(scooter.toString());
        return scooterMapper.scooterToScooterDto(scootersDAO.readByModel(model));
    }

}
