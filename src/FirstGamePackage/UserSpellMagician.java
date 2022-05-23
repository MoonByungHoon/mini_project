package FirstGamePackage;

public interface UserSpellMagician extends UserSpellWarrior {
	//0.Healling (본인 최대 체력의 30% 회복)
	//1.FireBolt (1방의 데미지 이후 다음턴 도트 데미지)
	//2.TimeStop (적의 시간을 4턴간 멈춤)
	//3.PowerWardKill (조건없이 즉사)
	public default void MagicianHealling() {
		System.out.println("치유 마법을 시전합니다.");
		System.out.println("체력이 30% 회복합니다.");
	}
	
	public default void MagicianFireBolt() {
		System.out.println("파이어볼트를 시전합니다.");
		System.out.println("몬스터가 불에타서 괴로워합니다.");
	}
	
	public default void MagicianTimeStop() {
		System.out.println("타임스탑을 시전합니다.");
		System.out.println("몬스터의 시간이 멈춥니다.");
	}
	
	public default void MagicianPowerWardKill() {
		System.out.println("궁극의 마법을 시전합니다.");
		System.out.println("상대는 강력한 마력에 괴로워하며 사망합니다.");
	}
}
