package com.jvgroup.jvchatapp.dao;

import com.jvgroup.jvchatapp.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
