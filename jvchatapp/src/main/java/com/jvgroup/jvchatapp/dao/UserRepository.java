package com.jvgroup.jvchatapp.dao;

import com.jvgroup.jvchatapp.entity.User;
import com.jvgroup.jvchatapp.projection.UserProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    public User getUserByPhoneNumber(String phoneNumber);

    List<UserProjection> findProjectedBy();

    @Query("SELECT u FROM User u WHERE u.accessGiven = :accessGiven")
    List<UserProjection> findByAccessGiven(@Param("accessGiven") boolean accessGiven);

//    @Query("SELECT ug.user FROM UserGroup ug WHERE ug.id.group_id = :groupId")
//    List<UserProjection> findUserByGroupId(@Param("groupId") Long groupId);
}
