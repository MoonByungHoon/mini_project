package FirstGamePackage;

import java.util.Scanner;

public class GameAction extends PutMessage{
	Scanner sc = new Scanner(System.in);
	
	public int gameStartPage(int action) {
		int input1 = 0; //���� ����
		int input2 = 0; //���� ����
		
		putStartMessage();
		
		input1 = putTribePick(); //���� ����
		input2 = putJobPick(); //���� ����
		
		userSetting(input1, input2); //���� �Ϸ� ������ ����
		
		return gameMainPage(1);
	}		
	
	public int gameMainPage(int action) { // ������ ���� ȭ��
		action = putMainMessage(); // ���� ��ŸƮ �޼���
		//(1.�̵�ȭ�� / 2.����â / 0.��������)	
		switch (action) {
			case 0:
				return gameQuestionPage(); //���� ��Ȯ�� ������
			case 1:
				return gameMovePage(action);//�̵� �޴�
			case 2:
				putUserStateOpenPage(); //����â
				gameMainPage(action); 
		}
		return putErrorMessage(0007);
	}
	
	public int gameMovePage(int action) { //�̵� ��� ���� ������
		action = putMovePageMessage(); // �̵� ����
		//(1.�̵� / 0.���θ޴�)
		switch (action) {
			case 0:
				return gameMainPage(action); // ���� �޴�
			case 1:
				return gameMovingPage(action);// �̵� ���
		}
		return putErrorMessage(0010);
	}
	
	public int gameMovingPage(int action) {
		while(true) {//(1.��Ʋ������ 2.����������)
			int walk = (int)(Math.random()*3 + 1); //�̵��� ���� ���� ����
			
			setTotalWalk(+walk); //�̵��� ����
			putConsoleClear();
			setUserNowHp(+(getTickuphp() * walk)); //ƽ�� ȸ��
			setUserNowMp(+(getTickupmp() * walk));
			
			if(getUserNowHp() > getUserMaxHp()) {
				settingHpOver();
			}//hp mp ƽ�� ȸ���� �ִ�ġ �ѱ� �ÿ� �ִ�ġ�� ������.
			
			if(getUserNowMp() > getUserMaxMp()) {
				settingMpOver();
			}
			
			putTickMessage(); //ƽ ȸ�� �޼��� ���

			if((int)(Math.random() * 100 + 1) < (walk * 20)) {
				action = putMovingMessage(1);//���� ���� Ȯ�� �׸��� �����ٴ� �޼��� ���
			} else if((int)(Math.random()* 100 + 1) < 5) {
				putEventMessage();
				eventPage();
			} else {
				//������ �ʾ��� ��� ��� ���
				action = putMovingMessage(0);
			}
			
			switch (action) {
				case 0:
					return gameMovePage(action);// ����������
				case 1:
					return battleMainPage(100); //��Ʋ������
			}
		}
	}

	public int gameQuestionPage() { //�ݺ� ������û�� �ʿ��� �͵� ���� ������
		putConsoleClear();
		int action = putGameQuestionMessage();
		//���ῡ ���� ���� ����			
		if(action == 0) {
			putGameEdingMessage(2);
		}
		
		if(action == 1) {
			gameMainPage(50);
		}
		
		return putErrorMessage(0011);
	}

	public int battleMainPage(int action) {
		//���� ������ �ൿ�� ��� �� ���� ���� Ÿ�� ���� ������
		if(action == 100) {
			setMonsterDamage(getUserNowLevel() * getUserMaxLevel());
			setMonsterHp((int)((Math.random() * 100 + 100) + (getUserNowLevel() * 20)));
			putConsoleClear();
			
			action = putMovingMessage(1);
		}
			
		while(true) { //�ൿ�� ��� 0.���� ���� 1.���� ����
			if(action == 25) {
				userTurnPage(action);
			}
			
			if(getUserNowStamina() >= getUserMaxStamina()){
				userTurnPage(action);
			}
			
			if(getMonsterStamina() >= 50) {
				monsterTurnPage(action);
			}
				setUserNowStamina(+10);
				setMonsterStamina(+10);
		}
	}

	public void userTurnPage(int action) {
		action = putBattleMessage();//(1.���� / 2.��� / 3.���� / 4.����)
		
		switch (action) {
		case 1://���� ���ݽÿ� ������ ���� min max �������߿� ���� ����
			setDamage((int)(Math.random()*getUserMaxDamage() + getUserMinDamage()));
			settingUserStamina();
			
			if((int)(Math.random()*100 + 1) < 10) {
				setDamage((getDamage()*2)); //ũ��Ƽ�� ��Ʈ
				putCriticalMessage();
			}
			
			setMonsterHp(-getDamage()); //������ ����
			putUserAttackMessage(); //���ݿ� ���� ��� ���
			
			if(getMonsterHp() <= 0) { //���� ����� ���۵�
				battleWinPage(); //��� ������
			}
			
			if(getMonsterHp() > 0) {
				battleMainPage(50); //���Ͱ� ���� ���� ��� ������
			}
		case 2:
			setDamage((int)(Math.random()*getMonsterDamage() + 1));
			//���� ������ ������ ����
			if((int)(Math.random()*100 + 1) < 10) {
				
				setDamage((getDamage()*2));
				putCriticalMessage();
			}
			
			settingUserSubMonsterStamina();
			setUserNowHp(-(int)(getDamage()*0.5));
			
			action = putUserDefenceMessage();
			
			if(getDotturn() > 0) {
				setMonsterHp(-getDotdamage());
				setDotturn(-1);
				putDotDamageMessage();
				
				if(getMonsterHp() <= 0) {
					action = 0;
				}
			}
			
			if(action == 0) {
				putGameEdingMessage(0); //����÷���
			}
			
			if(action == 1) {
				battleMainPage(50); //���� ����
			}
		case 3: //��ų
			action = putUserSpellMessage();
			
			JobSpellPage(action);
		case 4: 
			setUserNowStamina(-getUserNowStamina());
			
			action = putPotionUseMessage(100);
			//���� ���� ������
			switch (action) {
			case 0:
				userTurnPage(action); //��� ���ҽÿ� �缱��
			case 1:
				if(getHpPotion() <= 0) {
					putPotionUseMessage(25); //���� ���� �� �޼���
					battleMainPage(25);
				}
				setHpPotion(-1);
				setUserNowHp(+(int)(getUserMaxHp() * 0.5));
				//���� ��뿡 ���� ����
				if(getUserNowHp() > getUserMaxHp()) {
					settingHpOver();
				}//ȸ������ ������ ��� ������.
				
				putPotionUseMessage(10);
				battleMainPage(50);
			case 2:
				if(getMpPotion() <= 0) {
					putPotionUseMessage(25);
					battleMainPage(25);
				}
				setMpPotion(-1);
				setUserNowMp(+(int)(getUserMaxMp() * 0.5));
				
				if(getUserNowMp() > getUserMaxMp()) {
					settingMpOver();
				}
				
				putPotionUseMessage(20);
				battleMainPage(50);
			}
		}
	}
	
	public void monsterTurnPage(int action) {
		settingMonsterStamina();
		setDamage((int)(Math.random()*getMonsterDamage() + 1)); 
		
		if((int)(Math.random()*100 + 1) < 10) {
			
			setDamage((getDamage()*2));
			putCriticalMessage();
		}
		
		setUserNowHp(-getDamage());
		//���� ������ ����
		if(getDotturn() > 0) {
			
			setMonsterHp(-getDotdamage());
			setDotturn(-1);
			putDotDamageMessage();
		
			action = 0;
		}
		
		if(getMonsterHp() > 0) {
			action = putMonsterAttackPage();
		}
		//���� ���ݿ� ���� ��� ���
		if(action == 0) {
			battleWinPage(); //��� �÷���
		}
		
		if(action == 1) {
			battleMainPage(50);
		}
	}

	public void userLevelUpPage() { //������ ������
		setUserNowLevel(+1);
		setUserNowExp(-getUserNowExp()); //���������� ���� ����ġ �ʱ�ȭ
		setUserMaxExp(getUserNowLevel()); // ���� ���� ����ġ ����
		
		if(getUserNowLevel() % 2 != 0) {
			setUserSpellLevel(+1); //�ڵ��Ұ�	
		}
		
		putLevelUpMessage(); //������ ��� ������
		
		gameMovePage(50);// ����������
	}

	public void battleWinPage() {
		battleReset(); //���� �¸� �� ���Ϳ� ���� ���� �ʱ�ȭ �� ���� ���׹̳� �ʱ�ȭ
		putBattleWinMessage(); //�¸� �޼��� ���
		
		if((int)(Math.random()*100 + 1) < 15) {
			//���� ��� ���� �� hp �� mp �� 50% Ȯ���� ����
			if((int)Math.random() == 0) {
				setHpPotion(+1);
				putPotionGetMessage(0);
			} else if((int)Math.random() == 1) {
				setMpPotion(+1);
				putPotionGetMessage(1);
			} else {
				putErrorMessage(0006); //������ ���� ��� ����
			}
		}
		
		if(getUserNowExp() < getUserMaxExp()) {
			setUserNowExp(+1); //������ ���ǾƴҶ��� ����ġ ����
		} 
		
		if(getUserNowExp() >= getUserMaxExp() && 
				getUserNowLevel() < getUserMaxLevel()) {
			//������ ���� �޼��ÿ� ������
			userLevelUpPage();
		}
		
		gameMovePage(1);
	}
	
	public int JobSpellPage(int input) {
		switch (getUserJob()) {
		case "����":
			switch (input) {
			case 1:
				if(getUserNowLevel() < 1) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}

				settingUserSubMonsterStamina();
				setUserNowHp(+(int)(getUserMaxHp() * 0.1));
				setUserNowMp(-10);
				
				if(getUserNowHp() > getUserMaxHp()) {
					settingHpOver();
				}
				
				WarirrorParrying();
				
				battleMainPage(1);
			case 2:
				if(getUserNowLevel() < 3) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserSubMonsterStamina();
				setMonsterHp(-getUserMaxDamage());
				setUserNowMp(-15);
				
				WarirrorBash();
				
				System.out.printf("���Ͱ� %d��ŭ�� �������� �Ծ����ϴ�.", getUserMaxDamage());
				System.out.println();
				System.out.printf("������ ü���� %3d��ŭ ���ҽ��ϴ�.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 3:
				if(getUserNowLevel() < 5) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 25) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterHp(-(getUserMaxDamage() * 3));
				setUserNowMp(-25);
				
				WarirrorAureBlade();
				
				System.out.printf("���Ͱ� %d��ŭ�� �������� �Ծ����ϴ�.", (getUserMaxDamage() * 3));
				System.out.println();
				System.out.printf("������ ü���� %3d��ŭ ���ҽ��ϴ�.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 0:
				userTurnPage(input);
			}
		case "����":
			switch (input) {
			case 1:
				if(getUserNowMp() < 5) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setUserNowHp(+(int)(getUserMaxHp()*0.3));
				setUserNowMp(-5);
				
				if(getUserNowHp() > getUserMaxHp()) {
					settingHpOver();
				}
				
				MagicianHealling();
				
				battleMainPage(1);
			case 2:
				if(getUserNowLevel() < 1) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterHp(-(getUserMaxDamage() * 2));
				setDotdamage((int)(Math.random()*getUserMaxDamage() + getUserMinDamage()));
				setDotturn(2);
				setUserNowMp(-10);
				
				MagicianFireBolt();
				
				System.out.printf("���Ͱ� %d��ŭ�� �������� �Ծ����ϴ�.", (getUserMaxDamage() * 2));
				System.out.println();
				System.out.printf("������ ü���� %3d��ŭ ���ҽ��ϴ�.", getMonsterHp());
				System.out.println();
				
				
				if(getMonsterHp() < 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 3:
				if(getUserNowLevel() < 3) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterStamina(-200);
				setUserNowMp(-15);
				MagicianTimeStop();
				
				battleMainPage(1);
			case 4:
				if(getUserNowLevel() < 5) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 40) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				setMonsterHp(-getMonsterHp());
				setUserNowMp(-40);
				MagicianPowerWardKill();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				putErrorMessage(1234);
			case 0:
				userTurnPage(input);
			}
		case "����":
			switch (input) {
			case 1:
				if(getUserNowLevel() < 1) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				setMonsterHp(-getUserMinDamage());
				setUserNowMp(-10);
				
				ThiefKnifeThrow();
				
				System.out.printf("���Ͱ� %d��ŭ�� �������� �Ծ����ϴ�.", getUserMinDamage());
				System.out.println();
				System.out.printf("������ ü���� %3d��ŭ ���ҽ��ϴ�.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				userTurnPage(1);
			case 2:
				if(getUserNowLevel() < 3) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterStamina(-50);
				setUserNowStamina(+(int)(getUserMaxStamina() * 0.5));
				setUserNowMp(-15);
				Thiefevasion();
				
				battleMainPage(1);
			case 3:
				if(getUserNowLevel() < 5) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 20) {
					System.out.println("����ϱ⿡ ������ �����մϴ�.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setUserNowMp(-20);
				
				int getpotion = ThiefSteal();
				
				if(getpotion == 0) {
					System.out.println("���ͷκ��� HP ������ ȹ���Ͽ����ϴ�.");
					setHpPotion(+1);
				}
				
				if(getpotion == 1) {
					System.out.println("���ͷκ��� MP ������ ȹ���Ͽ����ϴ�.");
					setMpPotion(+1);
				}
				
				battleMainPage(1);
			case 0:
				userTurnPage(input);
			}
		}
		return putErrorMessage(0012);
	}
	
	public void eventPage() {
		setUserNowHp(-(int)(getUserMaxHp() * 0.1));
		
		if(getUserNowHp() < 0) {
			putGameEdingMessage(0);
		}
		
		gameMovePage(1);
	}
}