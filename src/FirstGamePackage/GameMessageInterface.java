package FirstGamePackage;

public interface GameMessageInterface{
	public void putStartMessage();//시작문구
	public int putMainMessage();//메인
	public int putMovePageMessage();//이동 선택
	public int putMovingMessage(int action); //이동 출력
	public void putGameEdingMessage(int action);//엔딩
	public int putBattleMessage();//전투
	public void putUserAttackMessage();//유저공격
	public int putUserDefenceMessage();//방어출력
	public void putLevelUpMessage();//레벨업
	public void putBattleWinMessage();//승리시 출력
	public int putErrorMessage(int action);//에러 위치 파악
	public void putTickMessage();//틱당 회복
	public void putCriticalMessage();//크리티컬
	public int putPotionUseMessage(int action);//포션 사용
	public void putPotionGetMessage(int action);//포션 습득
	public int putGameQuestionMessage();//재차 질문용도
	public void putDotDamageMessage();//도트데미지
	public int putUserSpellMessage();//스펠 메세지
	public void putEventMessage();
}
