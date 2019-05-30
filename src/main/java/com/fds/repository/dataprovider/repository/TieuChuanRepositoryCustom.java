package com.fds.repository.dataprovider.repository;

import java.util.Date;
import java.util.List;

import com.fds.repository.dataprovider.model.TieuChuan;

public interface TieuChuanRepositoryCustom {
	public List<TieuChuan> findByStartEnd(Date start, Date end);
}