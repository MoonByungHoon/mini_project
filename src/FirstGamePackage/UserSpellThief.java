package FirstGamePackage;

public interface UserSpellThief extends UserSpellMagician {
	//1.KnifeThrow (최소 데미지를 주며 행동력이 감소되지 않음.)
	//2.evasion (다음 상대의 공격을 회피한다. 행동력 50% 회복)
	//3.Steal (몬스터에게서 물약을 1개 훔쳐온다.)
	public default void ThiefKnifeThrow() {
		System.out.println("몬스터와 거리를 벌려 신속하게 단검을 던집니다.");
		System.out.println("몬스터가 다가오는 동안 당신의 턴이 되었습니다.");
	}
	
	public default void Thiefevasion() {
		System.out.println("몬스터의 공격을 회피합니다.");
		System.out.println("행동력이 50% 회복합니다.");
	}
	
	public default int ThiefSteal() {		
		int getpotion = (int)(Math.random());
		
		System.out.println("몬스터를 대상으로 스틸을 시도합니다.");

		return getpotion;
	}
}