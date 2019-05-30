package com.fds.repository.dataprovider.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import com.fds.repository.dataprovider.model.TieuChuan;

@Transactional
@Repository
public interface TieuChuanRepository extends CrudRepository<TieuChuan, Integer> {
	@Query("SELECT tc FROM TieuChuan tc Where tc.thoiGianBatDau >= :start AND tc.thoiGianKetThuc <= :end")
	public List<TieuChuan> findByStartEnd(@Param("start") Date start, @Param("end") Date end);
}