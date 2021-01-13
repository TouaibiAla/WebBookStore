package com.example.demo.utile;

public class ModifyPassword {
	private String ancienPass;
    private String nouveauPass;
    private String confirmPass;
	public ModifyPassword(String ancienPass, String nouveauPass, String confirmPass) {
		super();
		this.ancienPass = ancienPass;
		this.nouveauPass = nouveauPass;
		this.confirmPass = confirmPass;
	}
	public String getAncienPass() {
		return ancienPass;
	}
	public void setAncienPass(String ancienPass) {
		this.ancienPass = ancienPass;
	}
	public String getNouveauPass() {
		return nouveauPass;
	}
	public void setNouveauPass(String nouveauPass) {
		this.nouveauPass = nouveauPass;
	}
	public String getConfirmPass() {
		return confirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
    
    
}
