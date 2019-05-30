package com.fds.repository.dataprovider.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qli_tieuchuan")
public class TieuChuan {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="tc_id")
    private Integer id;

    private String soHieu;
    private Date namBanHanh;
    private String tenTiengViet;
    private String tenSuaDoi;
    private String tenTiengAnh;
    private String quyetDinhBanHanh;
    private Integer soTrang;
    private String chiSoPhanLoai;
    private String maHS;
    private Integer gia;
    private Integer soLuong;
    private String tinhTrang;
    private String tieuChuanTuongDuong;
    private Integer mucDo;
    private String tieuChuanVienDan;
    private String thayTheCho;
    private String thayTheBang;
    private String phamViApDung;
    private String tuKhoa;
    private Integer idBanKyThuat;
    private String coQuanXayDung;
    private Integer hoSoTieuChuan;
    private String fileDinhKem;
    private String fileDinhKemTrichXuat;
    private Integer trangThai;
    private String lyDo;
    private Integer idKeHoach;
    private Integer tinhTrangSuaDoi;
    private String phuongThucXayDung;
    private String toKen;
    private Integer idDuAn;
    private Integer giaiDoan;
    private Integer groupDuAn;
    private String ghiChu;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private Integer type;
    
    private String anhDaiDien;
    
    @Column(name="create_time")
    private Date createTime;
    
    @Column(name="update_time")
    private Date updateTime;
    
    @Column(name="thutu_1")
    private Integer thuTu1;
    
    @Column(name="thutu_2")
    private Integer thuTu2;
	
    public String getSoHieu() {
		return soHieu;
	}
	public void setSoHieu(String soHieu) {
		this.soHieu = soHieu;
	}
	public Date getNamBanHanh() {
		return namBanHanh;
	}
	public void setNamBanHanh(Date namBanHanh) {
		this.namBanHanh = namBanHanh;
	}
	public String getTenTiengViet() {
		return tenTiengViet;
	}
	public void setTenTiengViet(String tenTiengViet) {
		this.tenTiengViet = tenTiengViet;
	}
	public String getTenSuaDoi() {
		return tenSuaDoi;
	}
	public void setTenSuaDoi(String tenSuaDoi) {
		this.tenSuaDoi = tenSuaDoi;
	}
	public String getTenTiengAnh() {
		return tenTiengAnh;
	}
	public void setTenTiengAnh(String tenTiengAnh) {
		this.tenTiengAnh = tenTiengAnh;
	}
	public String getQuyetDinhBanHanh() {
		return quyetDinhBanHanh;
	}
	public void setQuyetDinhBanHanh(String quyetDinhBanHanh) {
		this.quyetDinhBanHanh = quyetDinhBanHanh;
	}
	public Integer getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(Integer soTrang) {
		this.soTrang = soTrang;
	}
	public String getChiSoPhanLoai() {
		return chiSoPhanLoai;
	}
	public void setChiSoPhanLoai(String chiSoPhanLoai) {
		this.chiSoPhanLoai = chiSoPhanLoai;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public Integer getGia() {
		return gia;
	}
	public void setGia(Integer gia) {
		this.gia = gia;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getTieuChuanTuongDuong() {
		return tieuChuanTuongDuong;
	}
	public void setTieuChuanTuongDuong(String tieuChuanTuongDuong) {
		this.tieuChuanTuongDuong = tieuChuanTuongDuong;
	}
	public Integer getMucDo() {
		return mucDo;
	}
	public void setMucDo(Integer mucDo) {
		this.mucDo = mucDo;
	}
	public String getTieuChuanVienDan() {
		return tieuChuanVienDan;
	}
	public void setTieuChuanVienDan(String tieuChuanVienDan) {
		this.tieuChuanVienDan = tieuChuanVienDan;
	}
	public String getThayTheCho() {
		return thayTheCho;
	}
	public void setThayTheCho(String thayTheCho) {
		this.thayTheCho = thayTheCho;
	}
	public String getThayTheBang() {
		return thayTheBang;
	}
	public void setThayTheBang(String thayTheBang) {
		this.thayTheBang = thayTheBang;
	}
	public String getPhamViApDung() {
		return phamViApDung;
	}
	public void setPhamViApDung(String phamViApDung) {
		this.phamViApDung = phamViApDung;
	}
	public String getTuKhoa() {
		return tuKhoa;
	}
	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}
	public Integer getIdBanKyThuat() {
		return idBanKyThuat;
	}
	public void setIdBanKyThuat(Integer idBanKyThuat) {
		this.idBanKyThuat = idBanKyThuat;
	}
	public String getCoQuanXayDung() {
		return coQuanXayDung;
	}
	public void setCoQuanXayDung(String coQuanXayDung) {
		this.coQuanXayDung = coQuanXayDung;
	}
	public Integer getHoSoTieuChuan() {
		return hoSoTieuChuan;
	}
	public void setHoSoTieuChuan(Integer hoSoTieuChuan) {
		this.hoSoTieuChuan = hoSoTieuChuan;
	}
	public String getFileDinhKem() {
		return fileDinhKem;
	}
	public void setFileDinhKem(String fileDinhKem) {
		this.fileDinhKem = fileDinhKem;
	}
	public String getFileDinhKemTrichXuat() {
		return fileDinhKemTrichXuat;
	}
	public void setFileDinhKemTrichXuat(String fileDinhKemTrichXuat) {
		this.fileDinhKemTrichXuat = fileDinhKemTrichXuat;
	}
	public Integer getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}
	public String getLyDo() {
		return lyDo;
	}
	public void setLyDo(String lyDo) {
		this.lyDo = lyDo;
	}
	public Integer getIdKeHoach() {
		return idKeHoach;
	}
	public void setIdKeHoach(Integer idKeHoach) {
		this.idKeHoach = idKeHoach;
	}
	public Integer getTinhTrangSuaDoi() {
		return tinhTrangSuaDoi;
	}
	public void setTinhTrangSuaDoi(Integer tinhTrangSuaDoi) {
		this.tinhTrangSuaDoi = tinhTrangSuaDoi;
	}
	public String getPhuongThucXayDung() {
		return phuongThucXayDung;
	}
	public void setPhuongThucXayDung(String phuongThucXayDung) {
		this.phuongThucXayDung = phuongThucXayDung;
	}
	public String getToKen() {
		return toKen;
	}
	public void setToKen(String toKen) {
		this.toKen = toKen;
	}
	public Integer getIdDuAn() {
		return idDuAn;
	}
	public void setIdDuAn(Integer idDuAn) {
		this.idDuAn = idDuAn;
	}
	public Integer getGiaiDoan() {
		return giaiDoan;
	}
	public void setGiaiDoan(Integer giaiDoan) {
		this.giaiDoan = giaiDoan;
	}
	public Integer getGroupDuAn() {
		return groupDuAn;
	}
	public void setGroupDuAn(Integer groupDuAn) {
		this.groupDuAn = groupDuAn;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}
	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}
	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}
	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getThuTu1() {
		return thuTu1;
	}
	public void setThuTu1(Integer thuTu1) {
		this.thuTu1 = thuTu1;
	}
	public Integer getThuTu2() {
		return thuTu2;
	}
	public void setThuTu2(Integer thuTu2) {
		this.thuTu2 = thuTu2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}