package edu.hzuapps.androidlabs.homeworks.net1414080903104;
/*
 * ʵ�֡��鿴���¿��Ƴء���ť���¼���
 * ����һ��List������ݿ������п��Ƶ�id��name��level������ʾ����
 */
import edu.hzuapps.androidlabs.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.*;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Visitdatabases;
import edu.hzuapps.androidlabs.homeworks.net1414080903104.Accessdata;

public class Net1414080903104lookActivity extends ActionBarActivity {
	List<Accessdata> U=new ArrayList<Accessdata>();//���ڴ�Ŵ����ݿ��ȡ�õ��Ŀ�������
	Visitdatabases Visit=new Visitdatabases();//����һ��Visitdatabases�����Ա������ݿ⴫�����ݻ��ߴ����ݿ��ڻ�ȡ����
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lookactivity_net1414080903104);
        
        try {
			U=Visit.Querycard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e("android", "fail to connect!"+"  "+e.getMessage());
		}//����Visit����ִ�з����������ݿ������п��Ƶ�id��name��level���ݣ�
        //���ö���U���������ʵõ�������ȫ������getXXX����ȡ����
        //����õ�������ʾ������(����д����)
    }
    
}
