package game;

public class User implements UserOption{
	
	
	private String nickname;
	private String job;
	private String skill;
	private String type;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	//�ϴ� �������´�� ��
	@Override
	public void selectedJob(int selectedNumber) {
		// TODO Auto-generated method stub
		// ���⼭ �Է��� ���ڿ� ���� �ټ��ְ��� ����
		if(selectedNumber == 1) {
			this.job = "thief";
		}else {
			this.job = "Worrior"; 
		}
	}
	
	@Override
	public void selectedType(int selectedType) {
		// TODO Auto-generated method stub
		if(selectedType == 1) {
			this.type = "human"; 
		}else {
			this.type = "elf"; 			
		}
	}
	
}
