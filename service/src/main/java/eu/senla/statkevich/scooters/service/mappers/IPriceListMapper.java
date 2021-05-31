package eu.senla.statkevich.scooters.service.mappers;

import eu.senla.statkevich.scooters.dto.PriceListDTO;
import eu.senla.statkevich.scooters.entity.entities.PriceList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPriceListMapper {

    //IPriceListMapper INSTANCE = Mappers.getMapper(IPriceListMapper.class);

    @Mapping(target = "scooter", source = "scooter.model")
    @Mapping(target = "scooter_number", source = "scooter.number")
    @Mapping(target = "termOfRent", source = "termOfRent.title")
    PriceListDTO PriceListToPriceListDto(final PriceList priceList);

    //PriceList PriceListDTOToPriceList(final PriceListDTO priceListDTO);

    List<PriceListDTO> listPriceListToListPriceListDto(List<PriceList> priceLists);

}

