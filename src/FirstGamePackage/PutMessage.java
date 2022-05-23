package FirstGamePackage;

import java.util.Scanner;

public class PutMessage extends Setting implements GameMessageInterface, UserSpellThief{
	
	Scanner sc = new Scanner(System.in);

	public int putTribePick() {
		putConsoleClear();
		
		System.out.println("������ �������ּ���.");
		System.out.println("1.�ΰ� / 2.��ũ / 3.����");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0) {
			return putTribePick();
		}
		
		return input;
	}

	public int putJobPick() {
		putConsoleClear();
		
		System.out.println("������ �������ּ���.");
		System.out.println("1.���� / 2.���� / 3.����");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0) {
			putJobPick();
		} 
		
		return input;
	}
	
	public void putStartMessage() {
		putConsoleClear();
		
		System.out.println("����� ��� ���迡�� ī���� �ſ� ��� �����Դϴ�.");
		System.out.println("���� Ŭ���� �������� ī�� �ýı��� �شٴ� �̾߱⸦ ���");
		System.out.println("����� ī���� �Ա� ���ؼ� ������ �����Ͽ����ϴ�.");
		System.out.println("������ Ż���� ������ ��Ƴ����� ī���� ���� �� �ֽ��ϴ�.");
		System.out.println("���ݺ��� ������ �����ϰڽ��ϴ�.");
		System.out.println();
	}
	
	public int putMainMessage() {
		System.out.println();
		System.out.println("������ �ൿ�� �������ּ���.");
		System.out.println("1.�̵�ȭ�� / 2.����â / 0.��������");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0 ) {
			putMainMessage();
		}
		
		return input;
	}
	
	public int putMovePageMessage() {
		putConsoleClear();
		
		System.out.printf("���� %3d/%d��ŭ �����Ͽ����ϴ�.", getTotalWalk(), getMaxWalk());
		System.out.println();
		System.out.println("�̵��� �Ͻðڽ��ϱ�?");
		System.out.println("1.�̵� / 0.���θ޴�");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 1 || input < 0) {
			putMovePageMessage();
		}
		
		return input;
	}
	
	public void putTickMessage() {
		System.out.printf("�̵��� �ϸ� ü���� %2d��ŭ ������ %2d��ŭ ȸ���Ǿ����ϴ�.", getTickuphp(), getTickupmp());
		System.out.println();
		System.out.printf("���� ü���� %3d/%3d�̸�, ������ %3d/%3d�Դϴ�.", getUserNowHp(), getUserMaxHp(), getUserNowMp(), getUserMaxMp());
		System.out.println();
	}
	
	public int putMovingMessage(int action) {
		if(action == 1) {
			System.out.println("���Ϳ� �����Ͽ����ϴ�.");
			return 1;
		}
		
		if(action == 0){
			System.out.println("������ ���Ϳ� �������� �ʾҽ��ϴ�.");
			return 0;
		}
		
		return putErrorMessage(0003);
	}
	
	public void putCriticalMessage() {
		System.out.println("ũ��Ƽ���� �������ϴ�.");
		System.out.println("�������� 2�� �����Ͽ����ϴ�.");
	}
	
	public void putGameEdingMessage(int action) {
		switch (action) {
		case 0:
			putConsoleClear();
			
			System.out.println("����� ����Ͽ����ϴ�.");
			System.exit(0);
		case 1:
			putConsoleClear();
			
			System.out.println("����� ���ִ� ī���� ���� �� �ְ� �Ǿ����ϴ�.");
			System.exit(0);
		case 2:
			putConsoleClear();
			
			System.out.println("������ �����մϴ�.");
			System.exit(0);
		}
	}

	public void putUserStateOpenPage() {
		putConsoleClear();
		
		System.out.println();
		System.out.printf("%-10s : %s", "Tribe", getUserTribe());
		System.out.println();
		System.out.printf("%-10s : %s", "Job", getUserJob());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Hp", getUserNowHp(), getUserMaxHp());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Mp", getUserNowMp(), getUserMaxMp());
		System.out.println();
		System.out.printf("%-10s : %d~%d", "Damage", getUserMinDamage(), getUserMaxDamage());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Lv", getUserNowLevel(), getUserMaxLevel());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Exp", getUserNowExp(), getUserMaxExp());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Map", getTotalWalk(), getMaxWalk());
		System.out.println();
		System.out.printf("%-10s : %d/%d", "Recovery", getTickuphp(), getTickupmp());
		System.out.println();
		System.out.printf("%-10s : %dea", "Hp Potion", getHpPotion());
		System.out.println();
		System.out.printf("%-10s : %dea", "Mp Potion", getMpPotion());
		System.out.println();
	}
	
	public int putBattleMessage() {
		System.out.println();
		System.out.println("����� ���� ���۵Ǿ����ϴ�.");
		System.out.println("������ ����� �Է����ּ���.");
		System.out.println("1.���� / 2.��� / 3.���� / 4.����");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 4 || input < 0) {
			putBattleMessage();
		}
		
		return input;
	}
	
	public void putUserAttackMessage() {
		System.out.println("����� ���͸� �����մϴ�.");
		System.out.printf("����� ���Ϳ��� %3d�� �������� �������ϴ�.", getDamage());
		System.out.println();
		
		if(getMonsterHp() > 0) {
			System.out.printf("������ ü���� %3d��ŭ ���ҽ��ϴ�.", getMonsterHp());
		
		} else {
			System.out.println("���Ͱ� ����Ͽ����ϴ�.");
		}
		
		System.out.println();
	}
	
	public void putConsoleClear() {
		for(int i = 0; i < 3; i++) {System.out.println();}
	}
	
	public int putUserDefenceMessage() {
		putConsoleClear();

		System.out.println("����� ������ ������ ����Ͽ����ϴ�.");
		System.out.println("���� ���� ���ذ� �������� �پ������ϴ�.");
		System.out.printf("����� ���Ϳ��� %3d�� �������� �Ծ����ϴ�.", (int)(getDamage()*0.5));
		System.out.println();
		
		if (getUserNowHp() <= 0) {
			return 0;
		}
		
		System.out.printf("���� ���� ü���� %3d/%d�Դϴ�.", getUserNowHp(), getUserMaxHp());
		System.out.println();
		
		return 1;
	}
	
	public int putMonsterAttackPage() {
		System.out.println("���Ͱ� ����� �����մϴ�.");
		System.out.printf("����� ���Ϳ��� %3d�� �������� �Ծ����ϴ�.", getDamage());
		System.out.println();
		
		if (getUserNowHp() <= 0) {
			return 0;
		}
		
		System.out.printf("���� ���� ü���� %3d/%d�Դϴ�.", getUserNowHp(), getUserMaxHp());
		System.out.println();
	
		return 1;
	}
	
	public void putLevelUpMessage() {
		if(getUserNowLevel() < getUserMaxLevel()) {
			System.out.println("������ ����Ͽ����ϴ�.");
			
			if(getUserNowLevel() % 2 != 0) {
				System.out.println("���ο� ��ų�� �����Ͽ����ϴ�.");
			}
		} else {
			System.out.println("������ �ִ�ġ�� �����Ͽ����ϴ�.");
		}
		
	}

	public void putBattleWinMessage() {
		System.out.println("�������� �¸��Ͽ����ϴ�.");
		System.out.println("����ġ�� ����Ͽ����ϴ�.");
		
	}
	
	public int putErrorMessage(int action) {
		System.out.printf("%d ������ �����ϴ�. \n �����ڿ��� �����ϼ���.", action);
		System.exit(0);
		
		return 0;
	}

	public int putPotionUseMessage(int action) {
		if(action == 100) {
			System.out.println("����� ������ �������ּ���.");
			System.out.println("�� ������ �ִ뷮�� 50%�� ȸ�������ݴϴ�.");
			System.out.println("1.HP ���� / 2.MP���� / 0.�����ܰ�");
			System.out.print("�Է� : ");
			
			int input = sc.nextInt();
			
			if(input < 0 || input > 2) {
				putPotionUseMessage(100);
			}
			
			return input;
		}
		
		if (action == 10) {
			System.out.println("HP ������ ����Ͽ����ϴ�.");
			System.out.printf("ü���� %d��ŭ ȸ���Ǿ����ϴ�.", (getUserMaxHp()/2));
			System.out.println();
			System.out.printf("���� ������ %d�� ���ҽ��ϴ�.", getHpPotion());
			System.out.println();
			
			return 0;
		} 
		
		if (action == 20) {
			System.out.println("MP ������ ����Ͽ����ϴ�.");
			System.out.printf("������ %d��ŭ ȸ���Ǿ����ϴ�.", (getUserMaxMp()/2));
			System.out.println();
			System.out.printf("���� ������ %d�� ���ҽ��ϴ�.", getMpPotion());
			System.out.println();
			
			return 0;
		} 
		
		if (action == 25) {
			System.out.println("�����ϰ� �ִ� ������ �����Ͽ��� ������� ���Ͽ����ϴ�.");
			
			return 0;
		}
		
		return putErrorMessage(0004);
	}

	public void putPotionGetMessage(int action) {
		switch (action) {
		case 0:
			System.out.println("HP ������ ȹ���Ͽ����ϴ�.");
			break;
		case 1:
			System.out.println("MP ������ ȹ���Ͽ����ϴ�.");
			break;
		}
	}
	
	public int putGameQuestionMessage() {
		System.out.println("������ ������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.�ǵ��ư��� / 0.����");
		System.out.print("�Է� : ");
		
		int input = sc.nextInt();
		
		if(input > 1 || input < 0) {
			putGameQuestionMessage();
		}
		
		return input;
	}
	
	public void putDotDamageMessage() {
		System.out.printf("���Ͱ� ȭ������ ���Ͽ� %d��ŭ�� ���ظ� �޾ҽ��ϴ�.", getDotdamage());
		System.out.println();
		System.out.printf("������ ü���� %d��ŭ ���ҽ��ϴ�.", getMonsterHp());
		System.out.println();
	}
	
	public int putUserSpellMessage() {
		int input;
		
		switch (getUserJob()) {
		case "����":
			System.out.println("����� ��ų�� �Է����ּ���.");
			System.out.println("1.�и�(lv1) / 2.�转(lv3) / 3.������̵�(lv5) / 0.���ư���");
			System.out.print("�Է� : ");
			
			input = sc.nextInt();
			
			if(input > 3 || input < 0) {
				putUserSpellMessage();
			}
			
			return input;
		case "����":
			System.out.println("����� ��ų�� �Է����ּ���.");
			System.out.println("1.����(lv0) / 2.���̾Ʈ(lv1) / 3.Ÿ�ӽ�ž(lv3) / 4.�Ŀ�����ų(lv5) / 0.���ư���");
			System.out.print("�Է� : ");
			
			input = sc.nextInt();
			
			if(input > 4 || input < 0) {
				putUserSpellMessage();
			} 
			
			return input;
		case "����":
			System.out.println("����� ��ų�� �Է����ּ���.");
			System.out.println("1.�ܰ˴�����(lv1) / 2.ȸ��(lv3) / 3.��ġ��(lv5) / 0.���ư���");
			System.out.print("�Է� : ");
			
			input = sc.nextInt();
			
			if(input > 3 || input < 0) {
				putUserSpellMessage();
			} 
			
			return input;
		}
		
		return putErrorMessage(1111);
	}
	
	public void putEventMessage() {
		System.out.println("������ �ɷȽ��ϴ�.");
		System.out.println("ü���� 10% �����մϴ�.");
	}
}