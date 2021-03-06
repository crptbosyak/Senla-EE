package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Role;

public interface RoleDao extends GenericDao<Role, Long> {

    Role getRoleWithUsers(Long id);

}
