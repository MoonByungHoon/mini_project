package FirstGamePackage;

public interface UserSpellWarrior extends GameMessageInterface{
	//1.Parrying (��� ���� ���� ȸ�� �� 10% ü��ȸ��)
	//2.Bash (�ִ� ����� + 1�� ����)
	//3.AuraBlade (�ִ� ����� * 3)
	
	public default void WarirrorParrying() {
		System.out.println("�и��� �õ��մϴ�.");
		System.out.println("������ ������ ���Ƴ������ϴ�.");
		System.out.println("ü���� 10% ȸ���մϴ�.");
	}
	
	public default void WarirrorBash() {
		System.out.println("��뿡�� ������ �ϰ��� �����մϴ�.");
		System.out.println("���Ͱ� ���Ͽ� �ɷ� 1�ϰ� �ൿ�� ���� ���մϴ�.");
	}
	
	public default void WarirrorAureBlade() {
		System.out.println("�˿� ������ �Ҿ�ֽ��ϴ�.");
		System.out.println("������ �ϰ��� �����մϴ�.");
	}
}
