package com.fds.repository.dataprovider.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.repository.dataprovider.model.TieuChuan;
import com.fds.repository.dataprovider.repository.TieuChuanRepository;

@Service
public class TieuChuanService {
	@Autowired
	private TieuChuanRepository tieuChuanRepository;

	public List<TieuChuan> findAll() {

		Iterable<TieuChuan> it = tieuChuanRepository.findAll();

		List<TieuChuan> results = new ArrayList<TieuChuan>();
		it.forEach(e -> results.add(e));

		return results;
	}
	
	public List<TieuChuan> findByStartEnd(Date start, Date end) {

		Iterable<TieuChuan> it = tieuChuanRepository.findByStartEnd(start, end);

		List<TieuChuan> results = new ArrayList<TieuChuan>();
		it.forEach(e -> results.add(e));

		return results;
	}
}
