package eu.senla.statkevich.scooters.service.mappers;


import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    //@Mapping(target="title", source="role.title")
    Roles roleDtoToRole(final RoleDTO roleDTO);

    //    @Mapping(target="title", source="title")
    RoleDTO roleToRoleDto(final Roles role);

    Roles roleTitleToRole(final String title);

}

