package FirstGamePackage;

public class MonsterStates extends UserStates{
	private int monsterhp, monsterstamina, monsterdamage, dotdamage, dotturn;
	//몬스터 적용 스텟
	public int getDotturn() {
		return dotturn;
	}
	public void setDotturn(int dotturn) {
		this.dotturn += dotturn;
	}
	public int getDotdamage() {
		return dotdamage;
	}
	public void setDotdamage(int dotdamage) {
		this.dotdamage = dotdamage;
	}
	public int getMonsterDamage() {
		return monsterdamage;
	}
	public void setMonsterDamage(int monsterdamage) {
		this.monsterdamage = monsterdamage;
	}
	public int getMonsterHp() {
		return monsterhp;
	}
	public void setMonsterHp(int monsterhp) {
		this.monsterhp += monsterhp;
	}
	public int getMonsterStamina() {
		return monsterstamina;
	}
	public void setMonsterStamina(int monsterstamina) {
		this.monsterstamina += monsterstamina;
	}
}
