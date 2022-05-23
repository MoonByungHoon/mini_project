package FirstGamePackage;

import java.util.Scanner;

public class GameAction extends PutMessage{
	Scanner sc = new Scanner(System.in);
	
	public int gameStartPage(int action) {
		int input1 = 0; //종족 변수
		int input2 = 0; //직업 변수
		
		putStartMessage();
		
		input1 = putTribePick(); //종족 결정
		input2 = putJobPick(); //직업 결정
		
		userSetting(input1, input2); //정의 하러 데이터 전송
		
		return gameMainPage(1);
	}		
	
	public int gameMainPage(int action) { // 게임의 메인 화면
		action = putMainMessage(); // 게임 스타트 메세지
		//(1.이동화면 / 2.상태창 / 0.게임종료)	
		switch (action) {
			case 0:
				return gameQuestionPage(); //종료 재확인 페이지
			case 1:
				return gameMovePage(action);//이동 메뉴
			case 2:
				putUserStateOpenPage(); //정보창
				gameMainPage(action); 
		}
		return putErrorMessage(0007);
	}
	
	public int gameMovePage(int action) { //이동 명령 수행 페이지
		action = putMovePageMessage(); // 이동 메인
		//(1.이동 / 0.메인메뉴)
		switch (action) {
			case 0:
				return gameMainPage(action); // 메인 메뉴
			case 1:
				return gameMovingPage(action);// 이동 결과
		}
		return putErrorMessage(0010);
	}
	
	public int gameMovingPage(int action) {
		while(true) {//(1.배틀페이지 2.무브페이지)
			int walk = (int)(Math.random()*3 + 1); //이동값 범위 랜덤 결정
			
			setTotalWalk(+walk); //이동값 적용
			putConsoleClear();
			setUserNowHp(+(getTickuphp() * walk)); //틱당 회복
			setUserNowMp(+(getTickupmp() * walk));
			
			if(getUserNowHp() > getUserMaxHp()) {
				settingHpOver();
			}//hp mp 틱당 회복이 최대치 넘길 시에 최대치로 재정립.
			
			if(getUserNowMp() > getUserMaxMp()) {
				settingMpOver();
			}
			
			putTickMessage(); //틱 회복 메세지 출력

			if((int)(Math.random() * 100 + 1) < (walk * 20)) {
				action = putMovingMessage(1);//적과 만날 확률 그리고 만났다는 메세지 출력
			} else if((int)(Math.random()* 100 + 1) < 5) {
				putEventMessage();
				eventPage();
			} else {
				//만나지 않았을 경우 결과 출력
				action = putMovingMessage(0);
			}
			
			switch (action) {
				case 0:
					return gameMovePage(action);// 무브페이지
				case 1:
					return battleMainPage(100); //배틀페이지
			}
		}
	}

	public int gameQuestionPage() { //반복 질문요청이 필요할 것들 모은 페이지
		putConsoleClear();
		int action = putGameQuestionMessage();
		//종료에 대한 재차 질문			
		if(action == 0) {
			putGameEdingMessage(2);
		}
		
		if(action == 1) {
			gameMainPage(50);
		}
		
		return putErrorMessage(0011);
	}

	public int battleMainPage(int action) {
		//몬스터 설정과 행동력 계산 및 전투 수행 타입 결정 페이지
		if(action == 100) {
			setMonsterDamage(getUserNowLevel() * getUserMaxLevel());
			setMonsterHp((int)((Math.random() * 100 + 100) + (getUserNowLevel() * 20)));
			putConsoleClear();
			
			action = putMovingMessage(1);
		}
			
		while(true) { //행동력 계산 0.유저 만땅 1.몬스터 만땅
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
		action = putBattleMessage();//(1.공격 / 2.방어 / 3.스펠 / 4.포션)
		
		switch (action) {
		case 1://매턴 공격시에 유저가 가진 min max 데미지중에 랜덤 결정
			setDamage((int)(Math.random()*getUserMaxDamage() + getUserMinDamage()));
			settingUserStamina();
			
			if((int)(Math.random()*100 + 1) < 10) {
				setDamage((getDamage()*2)); //크리티컬 히트
				putCriticalMessage();
			}
			
			setMonsterHp(-getDamage()); //데미지 적용
			putUserAttackMessage(); //공격에 대한 결과 출력
			
			if(getMonsterHp() <= 0) { //몬스터 사망시 동작들
				battleWinPage(); //결과 페이지
			}
			
			if(getMonsterHp() > 0) {
				battleMainPage(50); //몬스터가 죽지 않을 경우 재전투
			}
		case 2:
			setDamage((int)(Math.random()*getMonsterDamage() + 1));
			//몬스터 데미지 랜덤값 적용
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
				putGameEdingMessage(0); //사망플레그
			}
			
			if(action == 1) {
				battleMainPage(50); //지속 전투
			}
		case 3: //스킬
			action = putUserSpellMessage();
			
			JobSpellPage(action);
		case 4: 
			setUserNowStamina(-getUserNowStamina());
			
			action = putPotionUseMessage(100);
			//포션 선택 페이지
			switch (action) {
			case 0:
				userTurnPage(action); //사용 안할시에 재선택
			case 1:
				if(getHpPotion() <= 0) {
					putPotionUseMessage(25); //포션 없을 시 메세지
					battleMainPage(25);
				}
				setHpPotion(-1);
				setUserNowHp(+(int)(getUserMaxHp() * 0.5));
				//포션 사용에 대한 연산
				if(getUserNowHp() > getUserMaxHp()) {
					settingHpOver();
				}//회복량이 과다할 경우 재정립.
				
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
		//받은 데미지 연산
		if(getDotturn() > 0) {
			
			setMonsterHp(-getDotdamage());
			setDotturn(-1);
			putDotDamageMessage();
		
			action = 0;
		}
		
		if(getMonsterHp() > 0) {
			action = putMonsterAttackPage();
		}
		//몬스터 공격에 대한 결과 출력
		if(action == 0) {
			battleWinPage(); //사망 플레그
		}
		
		if(action == 1) {
			battleMainPage(50);
		}
	}

	public void userLevelUpPage() { //레벨업 페이지
		setUserNowLevel(+1);
		setUserNowExp(-getUserNowExp()); //레벨업으로 인한 경험치 초기화
		setUserMaxExp(getUserNowLevel()); // 다음 레벨 경험치 정의
		
		if(getUserNowLevel() % 2 != 0) {
			setUserSpellLevel(+1); //코딩할곳	
		}
		
		putLevelUpMessage(); //레벨업 결과 페이지
		
		gameMovePage(50);// 무브페이지
	}

	public void battleWinPage() {
		battleReset(); //게임 승리 후 몬스터에 대한 정보 초기화 및 유저 스테미나 초기화
		putBattleWinMessage(); //승리 메세지 출력
		
		if((int)(Math.random()*100 + 1) < 15) {
			//포션 드랍 조건 및 hp 와 mp 중 50% 확률로 결정
			if((int)Math.random() == 0) {
				setHpPotion(+1);
				putPotionGetMessage(0);
			} else if((int)Math.random() == 1) {
				setMpPotion(+1);
				putPotionGetMessage(1);
			} else {
				putErrorMessage(0006); //에러가 뜰경우 잡기 위함
			}
		}
		
		if(getUserNowExp() < getUserMaxExp()) {
			setUserNowExp(+1); //레벨업 조건아닐때에 경험치 증가
		} 
		
		if(getUserNowExp() >= getUserMaxExp() && 
				getUserNowLevel() < getUserMaxLevel()) {
			//레벨업 조건 달성시에 레벨업
			userLevelUpPage();
		}
		
		gameMovePage(1);
	}
	
	public int JobSpellPage(int input) {
		switch (getUserJob()) {
		case "전사":
			switch (input) {
			case 1:
				if(getUserNowLevel() < 1) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("사용하기에 마나가 부족합니다.");
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
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				settingUserSubMonsterStamina();
				setMonsterHp(-getUserMaxDamage());
				setUserNowMp(-15);
				
				WarirrorBash();
				
				System.out.printf("몬스터가 %d만큼의 데미지를 입었습니다.", getUserMaxDamage());
				System.out.println();
				System.out.printf("몬스터의 체력이 %3d만큼 남았습니다.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 3:
				if(getUserNowLevel() < 5) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 25) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterHp(-(getUserMaxDamage() * 3));
				setUserNowMp(-25);
				
				WarirrorAureBlade();
				
				System.out.printf("몬스터가 %d만큼의 데미지를 입었습니다.", (getUserMaxDamage() * 3));
				System.out.println();
				System.out.printf("몬스터의 체력이 %3d만큼 남았습니다.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 0:
				userTurnPage(input);
			}
		case "법사":
			switch (input) {
			case 1:
				if(getUserNowMp() < 5) {
					System.out.println("사용하기에 마나가 부족합니다.");
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
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterHp(-(getUserMaxDamage() * 2));
				setDotdamage((int)(Math.random()*getUserMaxDamage() + getUserMinDamage()));
				setDotturn(2);
				setUserNowMp(-10);
				
				MagicianFireBolt();
				
				System.out.printf("몬스터가 %d만큼의 데미지를 입었습니다.", (getUserMaxDamage() * 2));
				System.out.println();
				System.out.printf("몬스터의 체력이 %3d만큼 남았습니다.", getMonsterHp());
				System.out.println();
				
				
				if(getMonsterHp() < 0) {
					battleWinPage();
				}
				
				battleMainPage(1);
			case 3:
				if(getUserNowLevel() < 3) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setMonsterStamina(-200);
				setUserNowMp(-15);
				MagicianTimeStop();
				
				battleMainPage(1);
			case 4:
				if(getUserNowLevel() < 5) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 40) {
					System.out.println("사용하기에 마나가 부족합니다.");
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
		case "도둑":
			switch (input) {
			case 1:
				if(getUserNowLevel() < 1) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 10) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				setMonsterHp(-getUserMinDamage());
				setUserNowMp(-10);
				
				ThiefKnifeThrow();
				
				System.out.printf("몬스터가 %d만큼의 데미지를 입었습니다.", getUserMinDamage());
				System.out.println();
				System.out.printf("몬스터의 체력이 %3d만큼 남았습니다.", getMonsterHp());
				System.out.println();
				
				if(getMonsterHp() <= 0) {
					battleWinPage();
				}
				
				userTurnPage(1);
			case 2:
				if(getUserNowLevel() < 3) {
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 15) {
					System.out.println("사용하기에 마나가 부족합니다.");
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
					System.out.println("사용하기에 레벨이 부족합니다.");
					userTurnPage(input);
				}
				
				if(getUserNowMp() < 20) {
					System.out.println("사용하기에 마나가 부족합니다.");
					userTurnPage(input);
				}
				
				settingUserStamina();
				setUserNowMp(-20);
				
				int getpotion = ThiefSteal();
				
				if(getpotion == 0) {
					System.out.println("몬스터로부터 HP 포션을 획득하였습니다.");
					setHpPotion(+1);
				}
				
				if(getpotion == 1) {
					System.out.println("몬스터로부터 MP 포션을 획득하였습니다.");
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