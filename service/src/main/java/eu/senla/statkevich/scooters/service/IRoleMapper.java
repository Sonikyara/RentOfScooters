package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IRoleDao;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface IRoleMapper {

    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    //@Mapping(target="title", source="role.title")
    Roles roleDtoToRole(final RoleDTO roleDTO);

//    @Mapping(target="title", source="title")
    RoleDTO roleToRoleDto(final Roles role);

    // как тут поискть из существующих
    Roles roleTitleToRole(final String title);

//    default Roles roleTitleToRole(final String title, IRoleDao iRoleDao){
//        if (title == null) {
//            return null;
//        }
//        if (iRoleDao.readByTitle(title) == null) {
//            return null;
//        }
////        final Roles role=new Role();
////        library.setTitle(title);
////        return role;
//        return null;
//    };
}

