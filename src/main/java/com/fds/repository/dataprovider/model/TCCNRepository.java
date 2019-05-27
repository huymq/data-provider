package com.fds.repository.dataprovider.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fds.repository.dataprovider.model.TCCN;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TCCNRepository extends CrudRepository<TCCN, Integer> {
    @Query("SELECT tccn from TCCN tccn where tccn.ngaycongnhan >= :start AND tccn.ngaycongnhan <= :end")
    public List<TCCN> findBetweenPublicationDate(@Param("start") Date start, @Param("end") Date end);
}