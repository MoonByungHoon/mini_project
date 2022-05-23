package FirstGamePackage;

public class Setting extends MonsterStates{
	public void userSetting(int action1, int action2){
		setMaxWalk(500); //최대 플레이 진행도
		setUserMaxLevel(5); //최대 레벨
		setUserNowLevel(0); //시작 레벨
		setUserMaxExp(getUserNowLevel() + 1); //시작 경험치
		
		switch (action1) { // 종족 및 직업 스텟 정의
		case 1:
			setUserTribe("인간");
			setUserMaxHp(+80);
			setUserNowHp(+80);
			setUserNowMp(+80);
			setUserMaxMp(+80);
			setUserMinDamage(+15);
			setUserMaxDamage(+20);
			setUserMaxStamina(+50);
			setTickuphp(2);
			setTickupmp(2);
			
			break;
		case 2:
			setUserTribe("오크");
			setUserMaxHp(+100);
			setUserNowHp(+100);
			setUserNowMp(+60);
			setUserMaxMp(+60);
			setUserMinDamage(+20);
			setUserMaxDamage(+30);
			setUserMaxStamina(+60);
			setTickuphp(3);
			setTickupmp(1);
			break;
		case 3:
			setUserTribe("엘프");
			setUserMaxHp(+60);
			setUserNowHp(+60);
			setUserNowMp(+100);
			setUserMaxMp(+100);
			setUserMinDamage(+10);
			setUserMaxDamage(+15);
			setUserMaxStamina(+40);
			setTickuphp(1);
			setTickupmp(3);
			
			break;
		}
		
		switch (action2) {
		case 1:
			setUserJob("전사");
			setUserMaxHp(+50);
			setUserNowHp(+50);
			setUserNowMp(+20);
			setUserMaxMp(+20);
			setUserMinDamage(+10);
			setUserMaxDamage(+15);
			setTickuphp(3);
			
			break;
		case 2:
			setUserJob("법사");
			setUserMaxHp(+20);
			setUserNowHp(+20);
			setUserNowMp(+50);
			setUserMaxMp(+50);
			setUserMaxStamina(+10);
			setTickupmp(3);
			
			break;
		case 3:
			setUserJob("도둑");
			setUserMaxHp(+35);
			setUserNowHp(+35);
			setUserNowMp(+30);
			setUserMaxMp(+30);
			setUserMinDamage(+5);
			setUserMaxDamage(+10);
			setUserMaxStamina(-10);
			setTickuphp(1);
			setTickupmp(1);
			
			break;
		}
	}
	
	public void battleReset() {
		setMonsterStamina(-getMonsterStamina()); //몬스터 초기화
		setMonsterDamage(-getMonsterDamage()); //몬스터 초기화
		setMonsterHp(-getMonsterHp()); //몬스터 초기화
		setUserNowStamina(-getUserNowStamina()); //유저 행동력 초기화
		setDotturn(-getDotturn());
		setDotdamage(0);
	}
	
	public void settingUserStamina() {
		setUserNowStamina(-getUserNowStamina());
	}	
	
	public void settingMonsterStamina() {
		setMonsterStamina(-getMonsterStamina());
	}
	
	public void settingUserSubMonsterStamina() {
		setUserNowStamina(-getUserNowStamina());
		setUserNowStamina(+(50-getMonsterStamina()));
		setMonsterStamina(-getMonsterStamina());
	}
	
	public void settingHpOver() {
		setUserNowHp(-getUserNowHp() + getUserMaxHp());
	}
	
	public void settingMpOver() {
		setUserNowMp(-getUserNowMp() + getUserMaxMp());
	}
}