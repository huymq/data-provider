package com.fds.repository.dataprovider.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qli_tccn")
public class TCCN {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String tentiengviet;
    private String tentienganh;
    private Date ngaycongnhan;
    private String sogiaychungnhan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTentiengviet() {
		return tentiengviet;
	}

	public void setTentiengviet(String tentiengviet) {
		this.tentiengviet = tentiengviet;
	}

	public String getTentienganh() {
		return tentienganh;
	}

	public void setTentienganh(String tentienganh) {
		this.tentienganh = tentienganh;
	}

    public Date getNgaycongnhan() {
        return this.ngaycongnhan;
    }

    public void setNgaycongnhan(Date ngaycongnhan) {
        this.ngaycongnhan = ngaycongnhan;
    }

    public String getSogiaychungnhan() {
        return this.sogiaychungnhan;
    }

    public void setSogiaychungnhan(String sogiaychungnhan) {
        this.sogiaychungnhan = sogiaychungnhan;
    }
}