package com.aybaroud.springmvcthymleaf.security.repositories;

import com.aybaroud.springmvcthymleaf.security.entities.AppRole;
import com.aybaroud.springmvcthymleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository
        extends JpaRepository<AppRole,String> {
    AppRole findByRoleName(String roleName);
}
