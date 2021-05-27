package eu.senla.statkevich.scooters.service.mappers;


import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    Roles roleDtoToRole(final RoleDTO roleDTO);

    RoleDTO roleToRoleDto(final Roles role);

    Roles roleTitleToRole(final String title);

}

