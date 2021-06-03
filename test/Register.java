/**
 * 
 */
package sqa.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sqa.control.Proceduce;
import sqa.model.KhachHang;

/**
 * @author doanv
 *
 */

public class Register {

	Proceduce proceduce = new Proceduce();
	String username;
	@Test
	@After
	public void truncateData() {
		String sql = "delete from khachhang\r\n" + 
				"order by id desc limit 1";
		proceduce.truncateData(sql);
	}
	@Test
	public void testSuccess() {
		this.username = "duong404";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099006333", "24/5/2000", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678"));
		final KhachHang khachHangOutput = new KhachHang("Nguyen Duong zzz","036099006333", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "duong404", "12345678");
		Assert.assertEquals(khachHangOutput.getCmnd(), khachHangResult.getCmnd());
	}
	@Test
	@After
	public void testUsernameDuplicate() {
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003234", "24/5/2000", "0354718186", 1, "Nam Định/Giao Thủy", this.username, "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testName() {
		this.username = "duong2";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Dương @","036099003233", "24/5/2000", "0354718186", 1, "Nam Định/Giao Thủy", "duong2", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testBirthday() {
		this.username = "duong3";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003235", "1/6/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong3", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testYears() {
		this.username = "duong4";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003236", "24/5/2010", "0354718186", 1, "Nam Định/Giao Thủy", "duong4", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testAddress() {
		this.username = "duong5";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003237", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong5", "12345678"));
		final KhachHang khachHangOutput = new KhachHang("Nguyen Duong zzz","036099003233", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong21", "12345678");;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testDuplicateCMND() {
		this.username = "duong6";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003238", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong6", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testShortCMND() {
		this.username = "duong7";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003239", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong7", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testCodeArea() {
		this.username = "duong8";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","033099003230", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong8", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testCodeGender() {
		this.username = "duong9";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036199003243", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong9", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testCodeBirth() {
		this.username = "duong10";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036098003253", "24/5/2021", "0354718186", 1, "Nam Định/Giao Thủy", "duong10", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testFomatPhone() {
		this.username = "duong11";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003263", "24/5/2021", "0354718186234", 1, "Nam Định/Giao Thủy", "duong11", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	//user co chu in hoa
	public void testUsername1() {
		this.username = "Duong20";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003273", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "Duong20", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	//user co dau space
	public void testUsername2() {
		this.username = "Duong nguyen";
		final KhachHang khachHangResult = proceduce.checkRegister(
				new KhachHang("Nguyen Duong zzz","036099003283", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "Duong nguyen", "12345678"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testShortPassword() {
		this.username = "duong12";
		final KhachHang khachHangResult = proceduce.checkRegister(new KhachHang("Nguyen Duong zzz","036099003293", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "duong12", "1234"));
		final KhachHang khachHangOutput = null;
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	@Test
	public void testFormatPassword() {
		this.username = "duong13";
		final KhachHang khachHangResult = proceduce.checkRegister(new KhachHang("Nguyen Duong zzz","36099003213", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "duong13", "duong1234"));
		final KhachHang khachHangOutput = new KhachHang("Nguyen Duong zzz","36099003213", "24/5/2021", "354718186", 1, "Nam Định/Giao Thủy", "duong13", "duong1234");
		Assert.assertEquals(khachHangOutput, khachHangResult);
	}
	
}
