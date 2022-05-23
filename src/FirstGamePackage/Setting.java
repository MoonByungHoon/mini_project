package FirstGamePackage;

public class Setting extends MonsterStates{
	public void userSetting(int action1, int action2){
		setMaxWalk(500); //�ִ� �÷��� ���൵
		setUserMaxLevel(5); //�ִ� ����
		setUserNowLevel(0); //���� ����
		setUserMaxExp(getUserNowLevel() + 1); //���� ����ġ
		
		switch (action1) { // ���� �� ���� ���� ����
		case 1:
			setUserTribe("�ΰ�");
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
			setUserTribe("��ũ");
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
			setUserTribe("����");
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
			setUserJob("����");
			setUserMaxHp(+50);
			setUserNowHp(+50);
			setUserNowMp(+20);
			setUserMaxMp(+20);
			setUserMinDamage(+10);
			setUserMaxDamage(+15);
			setTickuphp(3);
			
			break;
		case 2:
			setUserJob("����");
			setUserMaxHp(+20);
			setUserNowHp(+20);
			setUserNowMp(+50);
			setUserMaxMp(+50);
			setUserMaxStamina(+10);
			setTickupmp(3);
			
			break;
		case 3:
			setUserJob("����");
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
		setMonsterStamina(-getMonsterStamina()); //���� �ʱ�ȭ
		setMonsterDamage(-getMonsterDamage()); //���� �ʱ�ȭ
		setMonsterHp(-getMonsterHp()); //���� �ʱ�ȭ
		setUserNowStamina(-getUserNowStamina()); //���� �ൿ�� �ʱ�ȭ
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