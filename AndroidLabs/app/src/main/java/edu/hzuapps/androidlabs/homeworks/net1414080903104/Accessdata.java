package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * ʵ�ּ�¼��Ϣ���ݻ������ڶ�������ݿ��ϵ����в���
 * һ��javabean�࣬����ı�����Ϊ���Ƶ�����
 */
public class Accessdata {
	private int id;//����˽�б���id��
	private String name,level,background;//����˽�б�������name���ȼ�level����������background
	private String strength,defensive,hp;//����˽�б�������ֵstrength������ֵdefensive��Ѫ��ֵhp
	public int getId(){return id;}
	public void setId(int id){this.id=id;}
	public String getName(){return name;}
	public void setName(String name){this.name=name;}
	public String getLevel(){return level;}
	public void setLevel(String level){this.level=level;}
	public String getBackground(){return background;}
	public void setBackground(String background){this.background=background;}
	public String getStrength(){return strength;}
	public void setStrength(String strength){this.strength=strength;}
	public String getDefensive(){return defensive;}
	public void setDefensive(String defensive){this.defensive=defensive;}
	public String getHp(){return hp;}
	public void setHp(String hp){this.hp=hp;}
}
