package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
@Mapper(componentModel = "spring")
public interface IUserMapper{

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

//    @Mapping(target = "role", source = "roleToRoleDto")
//    UserDTO userToUserDto(final Users  user);

    // defaultExpression = "java()")
    //@Mapping(target = "role", source = "roleDtoToRole")
    Users userDtoToUser(final UserDTO userDTO);

    //@Mapping(target="title", source="role.title")
    //Roles roleDtoToRole(final RoleDTO roleDTO);

    Roles roleDtoToRole(final String title);
}
