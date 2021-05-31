package eu.senla.statkevich.scooters.service.serviceImpl;

import eu.senla.statkevich.scooters.dao.IDao.IRoleDao;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.entity.entities.Roles;
import eu.senla.statkevich.scooters.service.ServicesI.RolesService;
import eu.senla.statkevich.scooters.service.mappers.IRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RolesService {

    @Autowired
    private IRoleDao roleDAO;
    //private IGenericDao<Roles> roleDAO;

    @Autowired
    private IRoleMapper roleMapper;

    @Override
    public RoleDTO read(final Long id) {
        return roleMapper.roleToRoleDto(roleDAO.read(id));
    }


    @Override
    public RoleDTO readByTitle(String title) {
        return roleMapper.roleToRoleDto(roleDAO.readByTitle(title));
    }

    public Roles create(String title) {
        //return roleDAO.create(roleMapper.roleTitleToRole(title));
        return null;
    }


}
