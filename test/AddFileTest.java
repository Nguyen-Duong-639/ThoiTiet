package sqa.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import sqa.control.Proceduce;
import sqa.model.DoiTuongBaoHiem;
import sqa.model.HopDong;
import sqa.model.KhachHang;


public class AddFileTest {

	Proceduce proceduce = new Proceduce();
	@Test
	@After
	public void truncateData1() {
		//String sql = "delete from nguoibaohiem\r\n" + "order by id desc limit 10";
		String sql = "truncate nguoibaohiem";
		proceduce.truncateData(sql);
	}
	@Test	
	@After
	public void truncateData2() {
		String sql = "delete from hopdong order by id desc limit 1";
		proceduce.truncateData(sql);
	}
	@Test
	@After
	public void truncateData3() {
		String sql = "delete from khachhang\r\n" + 
				"order by id desc limit 1";
		proceduce.truncateData(sql);
	}
	@Test
	public void testSuccess() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn Độ", "125822322", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Việt Đoàn", "125822323", "17/08/1999", "0982502416", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
	
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = 0;
	
		Assert.assertEquals(result, output);
	}
	@Test
	//ten Nguyen Văn @
	public void testFormatName1() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn @", "125822322", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = 1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	//name 1234 Nguyễn
	public void testFormatName2() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("1234 Nguyễn", "125822322", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = 1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	//name !/$##
	public void testFormatName3() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("!/$##", "125822322", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = 1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	public void testBirthYears() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn Độ", "125822322", "17/08/2030", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = 1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	public void testFormatPhone() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn Độ", "125822322", "17/08/1999", "0123", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = -1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	public void testFormatCMND1() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn Độ", "abcd", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = -1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	public void testFormatCMND2() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		//DoiTuongBaoHiem(ten, cmnd, ngaySinh, soDienThoai, gioiTinh, loaiDoiTuong, chietKhau, soTienBaoHiem, trangThaiBaoHiem, diaChiThuongTru, tenLoaiDoiTuong)
		danhSachBaoHiem.add(new DoiTuongBaoHiem("Nguyễn Văn Độ", "123", "17/08/1999", "0982502415", 1, 1, 0, 1, "1", "Nam Định/Giao Thủy", ""));
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = -1;
	
		Assert.assertEquals(result, output);
	}
	@Test
	public void testArray() {
		ArrayList<DoiTuongBaoHiem> danhSachBaoHiem = new ArrayList<>();
		
		KhachHang khachHang = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099005333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		HopDong hopDongResult = new HopDong(khachHang, "", danhSachBaoHiem);
		final int result = proceduce.addHopDong(hopDongResult);
		final int output = -1;
	
		Assert.assertEquals(result, output);
	}
}
