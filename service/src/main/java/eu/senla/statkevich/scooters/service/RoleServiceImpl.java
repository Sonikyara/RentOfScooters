package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IRoleDao;
import eu.senla.statkevich.scooters.dao.RoleDAO;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dao.repository.RolesRepository;
import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RolesService{

    @Autowired
    private IRoleDao roleDAO;
    //private RoleDAO roleDAO;

//    @Autowired
//    private IUserMapper userMapper;

    @Autowired
    private IRoleMapper roleMapper;

    @Override
    public RoleDTO read(final Long id){
        return roleMapper.roleToRoleDto(roleDAO.read(id));
    };

    @Override
    public RoleDTO readByTitle(String title) {
        return roleMapper.roleToRoleDto(roleDAO.readByTitle(title));
    }

    @Override
    public Roles create(String title) {
        return roleDAO.create(roleMapper.roleTitleToRole(title));
    }


}
