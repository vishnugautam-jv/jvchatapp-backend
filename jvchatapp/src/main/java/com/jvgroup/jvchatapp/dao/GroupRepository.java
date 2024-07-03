package com.jvgroup.jvchatapp.dao;

import com.jvgroup.jvchatapp.entity.Group;
import com.jvgroup.jvchatapp.projection.GroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<GroupProjection> findProjectedBy();

    @Query("SELECT ug.group FROM UserGroup ug WHERE ug.id.userId = :userId")
    List<GroupProjection> findGroupsByUserId(@Param("userId") int userId);

}
