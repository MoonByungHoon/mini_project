package FirstGamePackage;

public interface UserSpellThief extends UserSpellMagician {
	//1.KnifeThrow (�ּ� �������� �ָ� �ൿ���� ���ҵ��� ����.)
	//2.evasion (���� ����� ������ ȸ���Ѵ�. �ൿ�� 50% ȸ��)
	//3.Steal (���Ϳ��Լ� ������ 1�� ���Ŀ´�.)
	public default void ThiefKnifeThrow() {
		System.out.println("���Ϳ� �Ÿ��� ���� �ż��ϰ� �ܰ��� �����ϴ�.");
		System.out.println("���Ͱ� �ٰ����� ���� ����� ���� �Ǿ����ϴ�.");
	}
	
	public default void Thiefevasion() {
		System.out.println("������ ������ ȸ���մϴ�.");
		System.out.println("�ൿ���� 50% ȸ���մϴ�.");
	}
	
	public default int ThiefSteal() {		
		int getpotion = (int)(Math.random());
		
		System.out.println("���͸� ������� ��ƿ�� �õ��մϴ�.");

		return getpotion;
	}
}