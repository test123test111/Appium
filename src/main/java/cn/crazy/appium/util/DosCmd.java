package cn.crazy.appium.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.server.Port;


/**
 * 此类完成dos或shell命令的执行封装
 *
 */
public class DosCmd {
	private Log logger=Log.getLogger(DosCmd.class);
	String osName=System.getProperty("os.name");
	
	/**
	 * execute dos command
	 * @param dos command,String
	 * @return boolean.succeed is true,Failure is false
	 * 
	 */
	public boolean execCmd(String cmdString){
		Runtime p = Runtime.getRuntime();//获取当前执行环境
		System.out.println(p);
		
		try {
			if(osName.toLowerCase().contains("mac")){
				String[] command={"/bin/sh","-c",cmdString};
				p.exec(command);
			}else if(osName.toLowerCase().contains("win")){
				p.exec("cmd.exe /c "+cmdString);
				System.out.println(cmdString);
			}
			//Thread.sleep(10000);
			//appium -p 4490 -bp 2253 -U 127.0.0.1:62001>xxx
			//当执行启动appium命令的时候获取端口号，判断端口是否启动成功，直到appium服务启动成功
			int portNum=RandomUtil.getInt(cmdString,0);
			System.out.println(portNum);
			if(portNum>0){
				Port port=new Port(new DosCmd());
				while(!port.isPortUsed(portNum)){
					Thread.sleep(1000);
				}
			}
			System.out.println("dos命令执行完成");
			logger.debug("执行启动appium的命令：------"+cmdString+"------成功");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("执行启动appium的命令:------"+cmdString+"------失败", e);
			return false;
		}
	}
	
	
	/**
	 * 
	* @Title: execCmdConsole  
	* @Description: TODO(获取dos命令和shell命令的封装)  
	* @param @param cmdString   adb devices命令的输入
	* @param @return
	* @param @throws InterruptedException    参数  
	* @return List<String>    返回类型  
	* @throws  
	* @author duanhao
	 */
	public List<String> execCmdConsole(String cmdString) {
		List<String> dosRes = new ArrayList<String>();
		try {
			Process process=null;
			System.out.println(cmdString);
			if(osName.toLowerCase().contains("mac")){
				String[] command={"/bin/sh","-c",cmdString};
				process = Runtime.getRuntime().exec(command);
			}else if(osName.toLowerCase().contains("win")){
				process = Runtime.getRuntime().exec("cmd /c "+cmdString);
			}
			InputStream in = process.getInputStream();
			BufferedReader inr = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = inr.readLine()) != null) {
				dosRes.add(line);
			}
			try {
				process.waitFor();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("执行等待命令失败-------"+e);
			}

			process.destroy();
			System.out.println();
			logger.debug("执行dos命令：-----"+cmdString+"------成功");
		} catch (IOException e) {
			System.out.println();
			logger.error("执行dos命令：----- "+cmdString+"-----失败", e);
		}
		return dosRes;
	}
	
	
	
	
	/**
	 * kill server with appium servers
	 * 
	 * @return boolean
	 */
	public boolean killServer(){
		String command="taskkill -F -PID node.exe";
		if(osName.toLowerCase().contains("mac")){
			command="killall node";
		}else if(osName.toLowerCase().contains("win")){
			command="taskkill -F -PID node.exe";
		}else{
			command="taskkill -F -PID node.exe";
		}
		if(execCmd(command)){
			logger.debug("杀掉服务进程成功");
			return true;
		}else{
			logger.error("杀掉服务进程失败");
			return false;
		}
	}

	public static void main(String[] args) {
		//Runtime.getRuntime().exec("xxx");
		System.out.println(System.getProperty("os.name"));
		DosCmd dc=new DosCmd();
//		dc.execCmd("taskkill -F -PID node.exe");
//		//System.out.println(dc.osName);
		List<String> devicesList=dc.execCmdConsole("adb devices");
		System.out.println(devicesList.size());
		for(String s:devicesList){
			System.out.println(s);
		}
		dc.execCmd("appium -p 4490 -bp 3456 -U a64c4287d540>C:\\Users\\43776\\Desktop\\AutoUI\\CrazyAppium\\logs\\20180819124821+a64c4287d540.log");
//		String s="appium -p 4490 -bp 2253 -U 127.0.0.1:62001>xxx";
//		System.out.println(s.split("-p ")[1].split(" -bp")[0]);
		
	}
}
