package FirstGamePackage;

public interface UserSpellWarrior extends GameMessageInterface{
	//1.Parrying (상대 다음 공격 회피 및 10% 체력회복)
	//2.Bash (최대 대미지 + 1턴 스턴)
	//3.AuraBlade (최대 대미지 * 3)
	
	public default void WarirrorParrying() {
		System.out.println("패링을 시도합니다.");
		System.out.println("몬스터의 공격을 막아내었습니다.");
		System.out.println("체력이 10% 회복합니다.");
	}
	
	public default void WarirrorBash() {
		System.out.println("상대에게 강력한 일격을 선사합니다.");
		System.out.println("몬스터가 스턴에 걸려 1턴간 행동을 하지 못합니다.");
	}
	
	public default void WarirrorAureBlade() {
		System.out.println("검에 마나를 불어넣습니다.");
		System.out.println("강력한 일격을 선사합니다.");
	}
}
