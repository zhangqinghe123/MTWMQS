package com.qianxx.qztaxi.vo;

public class AccountStatistics {
	private Integer id;
	private String staticDate;
	private double incomeFareAli;
	private double incomeFareWechat;
	private double incomeFareBalance;
	private double incomeFareCoupon;
	private double incomePasRecharge;
	private double incomeDriRecharge;
	private double incomeCut;
	private double outcomeCashin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStaticDate() {
		return staticDate;
	}

	public void setStaticDate(String staticDate) {
		this.staticDate = staticDate;
	}

	public double getIncomeFareAli() {
		return incomeFareAli;
	}

	public void setIncomeFareAli(double incomeFareAli) {
		this.incomeFareAli = incomeFareAli;
	}

	public double getIncomeFareWechat() {
		return incomeFareWechat;
	}

	public void setIncomeFareWechat(double incomeFareWechat) {
		this.incomeFareWechat = incomeFareWechat;
	}

	public double getIncomeFareBalance() {
		return incomeFareBalance;
	}

	public void setIncomeFareBalance(double incomeFareBalance) {
		this.incomeFareBalance = incomeFareBalance;
	}

	public double getIncomeFareCoupon() {
		return incomeFareCoupon;
	}

	public void setIncomeFareCoupon(double incomeFareCoupon) {
		this.incomeFareCoupon = incomeFareCoupon;
	}

	public double getIncomePasRecharge() {
		return incomePasRecharge;
	}

	public void setIncomePasRecharge(double incomePasRecharge) {
		this.incomePasRecharge = incomePasRecharge;
	}

	public double getIncomeDriRecharge() {
		return incomeDriRecharge;
	}

	public void setIncomeDriRecharge(double incomeDriRecharge) {
		this.incomeDriRecharge = incomeDriRecharge;
	}

	public double getIncomeCut() {
		return incomeCut;
	}

	public void setIncomeCut(double incomeCut) {
		this.incomeCut = incomeCut;
	}

	public double getOutcomeCashin() {
		return outcomeCashin;
	}

	public void setOutcomeCashin(double outcomeCashin) {
		this.outcomeCashin = outcomeCashin;
	}

}
