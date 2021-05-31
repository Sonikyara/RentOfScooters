package eu.senla.statkevich.scooters.service.mappers;

import eu.senla.statkevich.scooters.dto.ScooterDTO;
import eu.senla.statkevich.scooters.entity.entities.Scooters;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IScooterMapper {

    IScooterMapper INSTANCE = Mappers.getMapper(IScooterMapper.class);

    //пока запись из браузера не нужна
    //Scooters scooterDtoToScooter(final ScooterDTO scooterDTO);

    @Mapping(target = "seller", source = "seller.name")
    //@Mapping(target = "typeProducer", source = "typeProducer.id")
    @Mapping(target = "producer", source = "typeProducer.producer.name")
    @Mapping(target = "type", source = "typeProducer.scootersType.title")
    ScooterDTO scooterToScooterDto(final Scooters scooter);

    List<ScooterDTO> listScooterToListScooterDto(List<Scooters> scooter);

}

