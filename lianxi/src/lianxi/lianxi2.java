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
	 * 需求1：注册
	 * 需求2：登录案例
	 *
	 * Properties
	 * Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
	 */

	 static Scanner sc = new Scanner(System.in);
	 static Map<String, String> map = new HashMap<String, String>();
	    /*
		 * 封装用户信息
		 */
	 static{
		//1创建一个无默认值的空属性列表。
			Properties p = new Properties();
			//2: 通过输入流把properties文件中的属性集，读取到集合中
			//按简单的面向行的格式从输入字符流中读取属性列表（键和元素对）。
			try {
				p.load(new BufferedReader(new FileReader("user.properties")));
				//3:通过键获取值
				 String userName = p.getProperty("userName");
				 String password = p.getProperty("password");
				 String realName = p.getProperty("realName");
				 //4:将属性集保存在map集合

				 map.put("userName", userName);
				 map.put("password", password);
				 map.put("realName", realName);
			} catch (IOException e) {
				e.printStackTrace();
			}


	 }
	public static void register() throws IOException{
		//1:注册信息
		System.out.println("请输入用户名");
		String userName = sc.nextLine();
		System.out.println("请输入密码");
		String password = sc.nextLine();
		System.out.println("请输入真实姓名");
		String realName = sc.nextLine();
		//2：将用户信息保存在User.txt文件中
		BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
		bw.write("userName="+userName);
		bw.newLine();
		bw.write("password="+password);
		bw.newLine();
		bw.write("realName="+realName);
		bw.newLine();
		//3:关闭流文件
		bw.close();

		System.out.println("注册成功");
	}

	/*public static void login() throws IOException{
		System.out.println("---------登录--------");
		//1:填写登录信息
		System.out.println("请输入用户名");
		String userName  = sc.nextLine();
		System.out.println("请输入密码");
		String password  = sc.nextLine();

		//2读取user.txt中用户信息
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

		//1:填写登录信息
		System.out.println("请输入用户名");
		String userName  = sc.nextLine();
		System.out.println("请输入密码");
		String password  = sc.nextLine();

		if(userName.equals(map.get("userName"))&&password.equals(map.get("password"))){
		  System.out.println("欢迎"+map.get("realName")+"登陆");
		}else{
		   System.out.println("用户名或密码有误");
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

