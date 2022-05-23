package FirstGamePackage;

import java.util.Scanner;

public class PutMessage extends Setting implements GameMessageInterface, UserSpellThief{
	
	Scanner sc = new Scanner(System.in);

	public int putTribePick() {
		putConsoleClear();
		
		System.out.println("종족을 선택해주세요.");
		System.out.println("1.인간 / 2.오크 / 3.엘프");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0) {
			return putTribePick();
		}
		
		return input;
	}

	public int putJobPick() {
		putConsoleClear();
		
		System.out.println("직업을 선택해주세요.");
		System.out.println("1.전사 / 2.법사 / 3.도적");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0) {
			putJobPick();
		} 
		
		return input;
	}
	
	public void putStartMessage() {
		putConsoleClear();
		
		System.out.println("당신이 사는 세계에서 카레는 매우 비싼 음식입니다.");
		System.out.println("던전 클리어 보상으로 카레 시식권을 준다는 이야기를 듣고");
		System.out.println("당신은 카레를 먹기 위해서 던전에 입장하였습니다.");
		System.out.println("던전을 탈출할 때까지 살아남으면 카레를 먹을 수 있습니다.");
		System.out.println("지금부터 게임을 시작하겠습니다.");
		System.out.println();
	}
	
	public int putMainMessage() {
		System.out.println();
		System.out.println("수행할 행동을 선택해주세요.");
		System.out.println("1.이동화면 / 2.상태창 / 0.게임종료");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 3 || input < 0 ) {
			putMainMessage();
		}
		
		return input;
	}
	
	public int putMovePageMessage() {
		putConsoleClear();
		
		System.out.printf("현재 %3d/%d만큼 진행하였습니다.", getTotalWalk(), getMaxWalk());
		System.out.println();
		System.out.println("이동을 하시겠습니까?");
		System.out.println("1.이동 / 0.메인메뉴");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 1 || input < 0) {
			putMovePageMessage();
		}
		
		return input;
	}
	
	public void putTickMessage() {
		System.out.printf("이동을 하며 체력이 %2d만큼 마나가 %2d만큼 회복되었습니다.", getTickuphp(), getTickupmp());
		System.out.println();
		System.out.printf("현재 체력은 %3d/%3d이며, 마나는 %3d/%3d입니다.", getUserNowHp(), getUserMaxHp(), getUserNowMp(), getUserMaxMp());
		System.out.println();
	}
	
	public int putMovingMessage(int action) {
		if(action == 1) {
			System.out.println("몬스터와 조우하였습니다.");
			return 1;
		}
		
		if(action == 0){
			System.out.println("다행히 몬스터와 조우하지 않았습니다.");
			return 0;
		}
		
		return putErrorMessage(0003);
	}
	
	public void putCriticalMessage() {
		System.out.println("크리티컬이 터졌습니다.");
		System.out.println("데미지가 2배 증가하였습니다.");
	}
	
	public void putGameEdingMessage(int action) {
		switch (action) {
		case 0:
			putConsoleClear();
			
			System.out.println("당신은 사망하였습니다.");
			System.exit(0);
		case 1:
			putConsoleClear();
			
			System.out.println("당신은 맛있는 카레를 먹을 수 있게 되었습니다.");
			System.exit(0);
		case 2:
			putConsoleClear();
			
			System.out.println("게임을 종료합니다.");
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
		System.out.println("당신의 턴이 시작되었습니다.");
		System.out.println("수행할 명령을 입력해주세요.");
		System.out.println("1.공격 / 2.방어 / 3.스펠 / 4.포션");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 4 || input < 0) {
			putBattleMessage();
		}
		
		return input;
	}
	
	public void putUserAttackMessage() {
		System.out.println("당신이 몬스터를 공격합니다.");
		System.out.printf("당신은 몬스터에게 %3d의 데미지를 입혔습니다.", getDamage());
		System.out.println();
		
		if(getMonsterHp() > 0) {
			System.out.printf("몬스터의 체력이 %3d만큼 남았습니다.", getMonsterHp());
		
		} else {
			System.out.println("몬스터가 사망하였습니다.");
		}
		
		System.out.println();
	}
	
	public void putConsoleClear() {
		for(int i = 0; i < 3; i++) {System.out.println();}
	}
	
	public int putUserDefenceMessage() {
		putConsoleClear();

		System.out.println("당신은 몬스터의 공격을 방어하였습니다.");
		System.out.println("적이 가한 피해가 절반으로 줄어들었습니다.");
		System.out.printf("당신은 몬스터에게 %3d의 데미지를 입었습니다.", (int)(getDamage()*0.5));
		System.out.println();
		
		if (getUserNowHp() <= 0) {
			return 0;
		}
		
		System.out.printf("현재 남은 체력은 %3d/%d입니다.", getUserNowHp(), getUserMaxHp());
		System.out.println();
		
		return 1;
	}
	
	public int putMonsterAttackPage() {
		System.out.println("몬스터가 당신을 공격합니다.");
		System.out.printf("당신은 몬스터에게 %3d의 데미지를 입었습니다.", getDamage());
		System.out.println();
		
		if (getUserNowHp() <= 0) {
			return 0;
		}
		
		System.out.printf("현재 남은 체력은 %3d/%d입니다.", getUserNowHp(), getUserMaxHp());
		System.out.println();
	
		return 1;
	}
	
	public void putLevelUpMessage() {
		if(getUserNowLevel() < getUserMaxLevel()) {
			System.out.println("레벨이 상승하였습니다.");
			
			if(getUserNowLevel() % 2 != 0) {
				System.out.println("새로운 스킬을 습득하였습니다.");
			}
		} else {
			System.out.println("레벨이 최대치에 도달하였습니다.");
		}
		
	}

	public void putBattleWinMessage() {
		System.out.println("전투에서 승리하였습니다.");
		System.out.println("경험치가 상승하였습니다.");
		
	}
	
	public int putErrorMessage(int action) {
		System.out.printf("%d 에러가 떳습니다. \n 개발자에게 문의하세요.", action);
		System.exit(0);
		
		return 0;
	}

	public int putPotionUseMessage(int action) {
		if(action == 100) {
			System.out.println("사용할 포션을 선택해주세요.");
			System.out.println("각 포션은 최대량의 50%를 회복시켜줍니다.");
			System.out.println("1.HP 포션 / 2.MP포션 / 0.이전단계");
			System.out.print("입력 : ");
			
			int input = sc.nextInt();
			
			if(input < 0 || input > 2) {
				putPotionUseMessage(100);
			}
			
			return input;
		}
		
		if (action == 10) {
			System.out.println("HP 포션을 사용하였습니다.");
			System.out.printf("체력이 %d만큼 회복되었습니다.", (getUserMaxHp()/2));
			System.out.println();
			System.out.printf("현재 포션이 %d개 남았습니다.", getHpPotion());
			System.out.println();
			
			return 0;
		} 
		
		if (action == 20) {
			System.out.println("MP 포션을 사용하였습니다.");
			System.out.printf("마나가 %d만큼 회복되었습니다.", (getUserMaxMp()/2));
			System.out.println();
			System.out.printf("현재 포션이 %d개 남았습니다.", getMpPotion());
			System.out.println();
			
			return 0;
		} 
		
		if (action == 25) {
			System.out.println("소지하고 있는 포션이 부족하여서 사용하지 못하였습니다.");
			
			return 0;
		}
		
		return putErrorMessage(0004);
	}

	public void putPotionGetMessage(int action) {
		switch (action) {
		case 0:
			System.out.println("HP 포션을 획득하였습니다.");
			break;
		case 1:
			System.out.println("MP 포션을 획득하였습니다.");
			break;
		}
	}
	
	public int putGameQuestionMessage() {
		System.out.println("정말로 게임을 종료하시겠습니까?");
		System.out.println("1.되돌아가기 / 0.종료");
		System.out.print("입력 : ");
		
		int input = sc.nextInt();
		
		if(input > 1 || input < 0) {
			putGameQuestionMessage();
		}
		
		return input;
	}
	
	public void putDotDamageMessage() {
		System.out.printf("몬스터가 화상으로 인하여 %d만큼의 피해를 받았습니다.", getDotdamage());
		System.out.println();
		System.out.printf("몬스터의 체력이 %d만큼 남았습니다.", getMonsterHp());
		System.out.println();
	}
	
	public int putUserSpellMessage() {
		int input;
		
		switch (getUserJob()) {
		case "전사":
			System.out.println("사용할 스킬을 입력해주세요.");
			System.out.println("1.패링(lv1) / 2.배쉬(lv3) / 3.오라블레이드(lv5) / 0.돌아가기");
			System.out.print("입력 : ");
			
			input = sc.nextInt();
			
			if(input > 3 || input < 0) {
				putUserSpellMessage();
			}
			
			return input;
		case "법사":
			System.out.println("사용할 스킬을 입력해주세요.");
			System.out.println("1.힐링(lv0) / 2.파이어볼트(lv1) / 3.타임스탑(lv3) / 4.파워워드킬(lv5) / 0.돌아가기");
			System.out.print("입력 : ");
			
			input = sc.nextInt();
			
			if(input > 4 || input < 0) {
				putUserSpellMessage();
			} 
			
			return input;
		case "도둑":
			System.out.println("사용할 스킬을 입력해주세요.");
			System.out.println("1.단검던지기(lv1) / 2.회피(lv3) / 3.훔치기(lv5) / 0.돌아가기");
			System.out.print("입력 : ");
			
			input = sc.nextInt();
			
			if(input > 3 || input < 0) {
				putUserSpellMessage();
			} 
			
			return input;
		}
		
		return putErrorMessage(1111);
	}
	
	public void putEventMessage() {
		System.out.println("함정에 걸렸습니다.");
		System.out.println("체력이 10% 감소합니다.");
	}
}