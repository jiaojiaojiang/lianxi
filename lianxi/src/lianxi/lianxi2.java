package lianxi;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class lianxi2 {

	/*
	 * ����1��ע��
	 * ����2����¼����
	 *
	 * Properties
	 * Properties ���ʾ��һ���־õ����Լ���Properties �ɱ��������л�����м��ء������б���ÿ���������Ӧֵ����һ���ַ�����
	 */

	 static Scanner sc = new Scanner(System.in);
	 static Map<String, String> map = new HashMap<String, String>();
	    /*
		 * ��װ�û���Ϣ
		 */
	 static{
		//1����һ����Ĭ��ֵ�Ŀ������б�
			Properties p = new Properties();
			//2: ͨ����������properties�ļ��е����Լ�����ȡ��������
			//���򵥵������еĸ�ʽ�������ַ����ж�ȡ�����б�����Ԫ�ضԣ���
			try {
				p.load(new BufferedReader(new FileReader("user.properties")));
				//3:ͨ������ȡֵ
				 String userName = p.getProperty("userName");
				 String password = p.getProperty("password");
				 String realName = p.getProperty("realName");
				 //4:�����Լ�������map����

				 map.put("userName", userName);
				 map.put("password", password);
				 map.put("realName", realName);
			} catch (IOException e) {
				e.printStackTrace();
			}


	 }
	public static void register() throws IOException{
		//1:ע����Ϣ
		System.out.println("�������û���");
		String userName = sc.nextLine();
		System.out.println("����������");
		String password = sc.nextLine();
		System.out.println("��������ʵ����");
		String realName = sc.nextLine();
		//2�����û���Ϣ������User.txt�ļ���
		BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
		bw.write("userName="+userName);
		bw.newLine();
		bw.write("password="+password);
		bw.newLine();
		bw.write("realName="+realName);
		bw.newLine();
		//3:�ر����ļ�
		bw.close();

		System.out.println("ע��ɹ�");
	}

	/*public static void login() throws IOException{
		System.out.println("---------��¼--------");
		//1:��д��¼��Ϣ
		System.out.println("�������û���");
		String userName  = sc.nextLine();
		System.out.println("����������");
		String password  = sc.nextLine();

		//2��ȡuser.txt���û���Ϣ
		BufferedReader br = new BufferedReader(new FileReader("user.txt"));
		String name = br.readLine();
		System.out.println(name);
		int index = name.indexOf("=");
		if(index!=-1){
			System.out.println(name.substring(index+1));
		}

		String pwd = br.readLine();
		String rname = br.readLine();


	}*/



	public static void login() throws  IOException{

		//1:��д��¼��Ϣ
		System.out.println("�������û���");
		String userName  = sc.nextLine();
		System.out.println("����������");
		String password  = sc.nextLine();

		if(userName.equals(map.get("userName"))&&password.equals(map.get("password"))){
		  System.out.println("��ӭ"+map.get("realName")+"��½");
		}else{
		   System.out.println("�û�������������");
		}
	}

	public static void main(String[] args) {
		//register();
		try {
			login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

