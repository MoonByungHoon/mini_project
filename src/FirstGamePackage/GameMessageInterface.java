package FirstGamePackage;

public interface GameMessageInterface{
	public void putStartMessage();//���۹���
	public int putMainMessage();//����
	public int putMovePageMessage();//�̵� ����
	public int putMovingMessage(int action); //�̵� ���
	public void putGameEdingMessage(int action);//����
	public int putBattleMessage();//����
	public void putUserAttackMessage();//��������
	public int putUserDefenceMessage();//������
	public void putLevelUpMessage();//������
	public void putBattleWinMessage();//�¸��� ���
	public int putErrorMessage(int action);//���� ��ġ �ľ�
	public void putTickMessage();//ƽ�� ȸ��
	public void putCriticalMessage();//ũ��Ƽ��
	public int putPotionUseMessage(int action);//���� ���
	public void putPotionGetMessage(int action);//���� ����
	public int putGameQuestionMessage();//���� �����뵵
	public void putDotDamageMessage();//��Ʈ������
	public int putUserSpellMessage();//���� �޼���
	public void putEventMessage();
}
