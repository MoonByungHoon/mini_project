package FirstGamePackage;

public interface GameInterface extends GameMessageInterface {
	public int gameEndingPage(int action); // 게임 종료 페이지(사망, 직접 종료, 클리어)
	public void userLevelUpPage(); // 레벨업 페이지
	public int gameMainPage(int action); // 메인 페이지 (1. 이동 2. 상태창 3.게임종료(한번 더 되물어보기 즉 gameQuestionPage로 리턴)
	public int gameMovePage(int action); // 이동시 결과 페이지
	public int gameQuestionPage(int action); // 게임 종료시 되물어보는 페이지 및 다시 하기 질문페이지.
	public void battleWinPage(); // 전투 승리시 정산
	public int battleMainPage(int action); //배틀 메인 페이지 (1.공격 2. 방어 3.스펠)
	public int JobSpellPage(int action); //스킬 출력
	public void eventPage(int action); //이벤트 출력
	public int putTribePick();//종족선택
	public int putJobPick();//직업선택
	public void putUserStateOpenPage();//정보창
	public void putConsoleClear();//콘솔클리어
	public int putMonsterAttackPage();//몬스터공격
	public int userSetting(int action1, int action2);
	public void settingUserStamina();
	public void settingMonsterStamina();
	public void settingUserSubMonsterStamina();
	public void settingHpOver();
	public void settingMpOver();
}