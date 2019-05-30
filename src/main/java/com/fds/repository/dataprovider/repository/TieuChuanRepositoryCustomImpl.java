package com.fds.repository.dataprovider.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fds.repository.dataprovider.model.TieuChuan;

@Repository
public class TieuChuanRepositoryCustomImpl implements TieuChuanRepositoryCustom {
	@Autowired
	EntityManager entityManager;

	@Override
	public List<TieuChuan> findByStartEnd(Date start, Date end) {
		String sql = "SELECT * FROM TieuChuan tc";
		Query query = entityManager.createQuery(sql);

		return query.getResultList();

	}
}