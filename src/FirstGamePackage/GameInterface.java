package FirstGamePackage;

public interface GameInterface extends GameMessageInterface {
	public int gameEndingPage(int action); // ���� ���� ������(���, ���� ����, Ŭ����)
	public void userLevelUpPage(); // ������ ������
	public int gameMainPage(int action); // ���� ������ (1. �̵� 2. ����â 3.��������(�ѹ� �� �ǹ���� �� gameQuestionPage�� ����)
	public int gameMovePage(int action); // �̵��� ��� ������
	public int gameQuestionPage(int action); // ���� ����� �ǹ���� ������ �� �ٽ� �ϱ� ����������.
	public void battleWinPage(); // ���� �¸��� ����
	public int battleMainPage(int action); //��Ʋ ���� ������ (1.���� 2. ��� 3.����)
	public int JobSpellPage(int action); //��ų ���
	public void eventPage(int action); //�̺�Ʈ ���
	public int putTribePick();//��������
	public int putJobPick();//��������
	public void putUserStateOpenPage();//����â
	public void putConsoleClear();//�ܼ�Ŭ����
	public int putMonsterAttackPage();//���Ͱ���
	public int userSetting(int action1, int action2);
	public void settingUserStamina();
	public void settingMonsterStamina();
	public void settingUserSubMonsterStamina();
	public void settingHpOver();
	public void settingMpOver();
}