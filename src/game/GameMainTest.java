package game;

import java.util.Scanner;

public class GameMainTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("job select");
		int job = sc.nextInt();
		User u = new User();
		u.selectedJob(job);
		
		System.out.println(u.getJob());
		
	
		int type = sc.nextInt();
		u.selectedType(type);
		
		System.out.println(u.getType());
		
			//���⼭ ���� ���� ���Ƿ� �Z����
		// �Է��ϰ� ����� �Ҽ����ְ��Ҥ�?
		// main������ ���α׷� �帧�� ����ϰ�
		// �������� �����Ͻ������� �����ϸ�ȵȴ��ϸ�
		// �����ߴ������
		// ���� ����� �̷����̳׿�
		//���� �ñ��ߴ� �κа��� �ٸ�����
		//���� ¥�ô°� ���鼭 ��ü�� ���ؼ� ���� �� �����ѰŰ��ƿ�
		// �̰� ���� �������̽��� �����Ѱǵ�
		// ���� �����Ͻ� ���� ������ �����ϸ� �����������̽��� ������
		// �̰� ���� ���� ���� �����Ѱ�? ������ ������ ������
		// �����Ѱ�? ���ٴ� �� �׷��� �ؾߴ볪?
		// ���� ������ ������� �����̾ƴѰ�?
		// �̷�?
		// �׷� �����������̽��� ����� ������ �Է��� ���� ���� ������ ����������ϴ°žƴѰ�?
		//���� ���� ����� �������� �Ϸ��ߴµ� �ʹ� ���������� ����̰�
		
		//�׷���
	}
}
