package edu.hzuapps.androidlabs.homeworks.net1414080903104;

/*
 * ʵ�֡��鿨����ť��������飺
 * ��10��id���루0-9�������ѡȡһ�����룬���������id��������ݿ�����ȡ�ÿ��Ƶ���������
 */
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import java.util.*;


public class Net1414080903104extractActivity extends ActionBarActivity {
    int num;//���ڴ������õ������֣������ִ����ſ��Ƶ�id
    Accessdata U=new Accessdata();//����һ��Accessdata�����Ա����ڴ�Ŵ����ݿ��ȡ�õ���ĳ��������
	Visitdatabases Visit=new Visitdatabases();//����һ��Visitdatabases�����Ա������ݿ⴫�����ݻ��ߴ����ݿ��ڻ�ȡ����
    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extractactivity_net1414080903104);
        
        num=randomnum();
        
        try {
			U=Visit.findonecard(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//��num����Visitdatabases�ࣨ�����������Ķ���  V ����װ�����������ʵ����ݿ�����Ӧ�����ݣ�
        //������Visit���ص����͸�ֵ������U��
        //��ʱ�����U��������getXXX������ȡ�����ݿ��ڵ����ݣ�
        //����õ�������ʾ����(����д����)
    }
	
	public int randomnum(){//����һ����0-9֮��������������ķ���
		Random random= new Random();
		int result=random.nextInt(10);
		return result;
	}
    
}
