package com.example.blog_le_vu_nguyen.repository;

import com.example.blog_le_vu_nguyen.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
     AppUser findAppUserByUserNameContaining(String userName);
}
