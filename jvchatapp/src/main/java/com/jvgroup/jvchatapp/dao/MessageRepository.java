package com.jvgroup.jvchatapp.dao;

import com.jvgroup.jvchatapp.entity.Message;
import com.jvgroup.jvchatapp.projection.MessageProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<MessageProjection> findProjectedBy();
}
