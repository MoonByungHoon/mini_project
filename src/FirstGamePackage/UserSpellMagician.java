package FirstGamePackage;

public interface UserSpellMagician extends UserSpellWarrior {
	//0.Healling (���� �ִ� ü���� 30% ȸ��)
	//1.FireBolt (1���� ������ ���� ������ ��Ʈ ������)
	//2.TimeStop (���� �ð��� 4�ϰ� ����)
	//3.PowerWardKill (���Ǿ��� ���)
	public default void MagicianHealling() {
		System.out.println("ġ�� ������ �����մϴ�.");
		System.out.println("ü���� 30% ȸ���մϴ�.");
	}
	
	public default void MagicianFireBolt() {
		System.out.println("���̾Ʈ�� �����մϴ�.");
		System.out.println("���Ͱ� �ҿ�Ÿ�� ���ο��մϴ�.");
	}
	
	public default void MagicianTimeStop() {
		System.out.println("Ÿ�ӽ�ž�� �����մϴ�.");
		System.out.println("������ �ð��� ����ϴ�.");
	}
	
	public default void MagicianPowerWardKill() {
		System.out.println("�ñ��� ������ �����մϴ�.");
		System.out.println("���� ������ ���¿� ���ο��ϸ� ����մϴ�.");
	}
}
