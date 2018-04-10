package pageObjects;

public class NguoiDung {
	
	String btnNguoidung;
	String btnTaikhoancuatoi;
	String btnDangxuat;
	
	public String getBtnNguoiDung() {
		return btnNguoidung="//*[@id='tab' and ./parent::*[./parent::*[@id='tab_user']]]";
	}
	
	public String getBtnTaikhoancuatoi() {
		return btnTaikhoancuatoi="//*[@id='btn_my_account']";
	}
	
	public String getBtnDangxuat() {
		return btnDangxuat="//*[@id='btn_log_out']";
		
	}
}
