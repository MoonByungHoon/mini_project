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
		
			//여기서 제가 값을 임의로 줫지만
		// 입력하게 만들면 할수야있겟죠ㅕ?
		// main에서는 프로그램 흐름을 담당하고
		// 유저에서 비지니스로직을 포함하면안된다하면
		// 나눠야대겟지만
		// 대충 만들면 이런식이네요
		//제가 궁금했던 부분과는 다르지만
		//지금 짜시는거 보면서 객체에 대해서 지금 더 이해한거같아여
		// 이게 잡을 인터페이스로 구현한건데
		// 님이 생각하신 내가 시프를 선택하면 시프인터페이스가 나오고
		// 이건 제가 봤을 때는 가능한가? ㄹㅏ는 생각이 좀들어요
		// 가능한가? 보다는 왜 그렇게 해야대나?
		// 시프 메지션 워리어는 직업이아닌가?
		// 이런?
		// 그럼 직업인터페이스를 만들고 유저가 입력한 값에 따라 직업을 구현해줘야하는거아닌가?
		//제가 원래 상속의 재상속으로 하려했는데 너무 난잡하지는 기분이고
		
		//그래서
	}
}
