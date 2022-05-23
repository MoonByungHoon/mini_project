package FirstGamePackage;

public class UserStates{
	private int usernowhp, usermaxhp, usernowmp, usermaxmp,
	usermaxdamage, usermindamage, usernowstamina, tickupmp, 
	usermaxstamina, usernowexp, usermaxexp, tickuphp, 
	usernowlevel, usermaxlevel, totalwalk, maxwalk, damage,
	hppotion, mppotion, userspelllevel;

	private String usertribe, userjob;//필요한 유저 정보 변수들.

	public int getUserSpellLevel() {
		return userspelllevel;
	}
	public void setUserSpellLevel(int userspelllevel) {
		this.userspelllevel += userspelllevel;
	}
	public int getHpPotion() {
		return hppotion;
	}
	public void setHpPotion(int hppotion) {
		this.hppotion += hppotion;
	}
	public int getMpPotion() {
		return mppotion;
	}
	public void setMpPotion(int mppotion) {
		this.mppotion += mppotion;
	}
	public int getTickupmp() {
		return tickupmp;
	}
	public void setTickupmp(int tickupmp) {
		this.tickupmp += tickupmp;
	}
	public int getTickuphp() {
		return tickuphp;
	}
	public void setTickuphp(int tickuphp) {
		this.tickuphp += tickuphp;
	}
	public int getUserNowHp() {
		return usernowhp;
	}
	public void setUserNowHp(int usernowhp) {
		this.usernowhp += usernowhp;
	}
	public int getUserMaxHp() {
		return usermaxhp;
	}
	public void setUserMaxHp(int usermaxhp) {
		this.usermaxhp += usermaxhp;
	}
	public int getUserNowMp() {
		return usernowmp;
	}
	public void setUserNowMp(int usernowmp) {
		this.usernowmp += usernowmp;
	}
	public int getUserMaxMp() {
		return usermaxmp;
	}
	public void setUserMaxMp(int usermaxmp) {
		this.usermaxmp += usermaxmp;
	}
	public int getUserMaxDamage() {
		return usermaxdamage;
	}
	public void setUserMaxDamage(int usermaxdamage) {
		this.usermaxdamage += usermaxdamage;
	}
	public int getUserMinDamage() {
		return usermindamage;
	}
	public void setUserMinDamage(int usermindamage) {
		this.usermindamage += usermindamage;
	}
	public int getUserNowStamina() {
		return usernowstamina;
	}
	public void setUserNowStamina(int usernowstamina) {
		this.usernowstamina += usernowstamina;
	}
	public int getUserMaxStamina() {
		return usermaxstamina;
	}
	public void setUserMaxStamina(int usermaxstamina) {
		this.usermaxstamina += usermaxstamina;
	}
	public int getUserNowExp() {
		return usernowexp;
	}
	public void setUserNowExp(int usernowexp) {
		this.usernowexp += usernowexp;
	}
	public int getUserMaxExp() {
		return usermaxexp;
	}
	public void setUserMaxExp(int usermaxexp) {
		this.usermaxexp += usermaxexp;
	}
	public int getUserNowLevel() {
		return usernowlevel;
	}
	public void setUserNowLevel(int usernowlevel) {
		this.usernowlevel += usernowlevel;
	}
	public int getUserMaxLevel() {
		return usermaxlevel;
	}
	public void setUserMaxLevel(int usermaxlevel) {
		this.usermaxlevel += usermaxlevel;
	}
	public int getTotalWalk() {
		return totalwalk;
	}
	public void setTotalWalk(int totalwalk) {
		this.totalwalk += totalwalk;
	}
	public int getMaxWalk() {
		return maxwalk;
	}
	public void setMaxWalk(int maxwalk) {
		this.maxwalk = maxwalk;
	}
	public String getUserTribe() {
		return usertribe;
	}
	public void setUserTribe(String usertribe) {
		this.usertribe = usertribe;
	}
	public String getUserJob() {
		return userjob;
	}
	public void setUserJob(String userjob) {
		this.userjob = userjob;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
}