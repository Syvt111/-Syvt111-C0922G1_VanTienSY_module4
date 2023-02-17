package com.example.blog_le_vu_nguyen.repository;

import com.example.blog_le_vu_nguyen.model.AppRole;
import com.example.blog_le_vu_nguyen.model.AppUser;
import com.example.blog_le_vu_nguyen.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<AppRole,Integer> {

    List<UserRole> findByAppUser(AppUser appUser);

}
