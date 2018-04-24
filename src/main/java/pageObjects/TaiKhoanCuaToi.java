package pageObjects;

public class TaiKhoanCuaToi {
	
	String btnThongTinCaNhan;
	String btnThongTinLienLac;
	String btnCaiDatTaiKhoan;
	String txtHoTen;
	String txtNgaySinh;
	String txtCMND;
	String btnLuuThayDoi;
	String btnBack;
	String txtDienThoai;
	String txtQuocGia;
	String txtThanhPho;
	String txtDiaChi;
	String txtMatKhauCu;
	String txtMatKhauMoi;
	String txtXacNhanMatKhau;
	String btnCancel;
	
	public String getBtnBack() {
		return btnBack="//*[@id='btn_back']";
	}
	
	public String getBtnLuuThayDoi() {
		return btnLuuThayDoi="//*[@id='btn_save']";
	}
	
	
	//------------- Thong tin ca nhan--------------------------------
	public String getBtnThongTinCaNhan() {
		return btnThongTinCaNhan="//*[@class='android.widget.TextView' and @width>0 and ./parent::*[@id='btn_personal_info']]";
	}
	
	public String getTxtHoTen() {
		return txtHoTen="//*[@id='edtFirstName']";
	}
	
	public String getTxtNgaySinh() {
		return txtNgaySinh="//*[@id='edtDateOfBirth']";
	}
	
	public String getTxtCMND() {
		return txtCMND="//*[@id='edtPassport']";
	}
	
	//button dong y khi khong thay doi thong tin
	public String getBtnCancel() {
		return btnCancel="//*[@id='btnCancel']";
	}
	
	
	//*********************************************************************
	
	
	//---------------Thong tin lien lac-------------------------------------
	public String getBtnThongTinLienLac() {
		return btnThongTinLienLac="//*[@class='android.widget.TextView' and @width>0 and ./parent::*[@id='btn_contact_info']]";
	}
	
	public String getTxtDienThoai() {
		return txtDienThoai="//*[@id='edt_phone']";
	}
	public String getTxtQuocGia() {
		return txtQuocGia="//*[@id='edt_nation']";
	}
	public String getTxtThanhPho() {
		return txtThanhPho="//*[@id='edt_city']";
	}
	public String getTxtDiaChi() {
		return txtDiaChi="//*[@id='edt_address']";
	}
	

	
	//Cai dat tai khoan
	
	public String getBtnCaiDatTaiKhoan() {
		return btnCaiDatTaiKhoan="(//*[@class='android.webkit.WebView' and ./parent::*[@class='android.webkit.WebView' and (./preceding-sibling::* | ./following-sibling::*)[@id='imv_card']]]/*[@text and @class='android.view.View'])[2]";
	}
	

	public String getTxtMatKhauCu() {
		return txtMatKhauCu="//*[@id='edt_old_password']";
	}
	

	public String getTxtMatKhauMoi() {
		return txtMatKhauMoi="//*[@id='edt_new_password']";
	}
	

	public String getTxtXacNhanMatKhau() {
		return txtXacNhanMatKhau="//*[@id='edt_confirm_password']";
	}
}
