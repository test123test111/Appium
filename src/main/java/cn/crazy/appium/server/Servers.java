package cn.crazy.appium.server;

import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.util.DosCmd;
import cn.crazy.appium.util.Log;
import cn.crazy.appium.util.XmlUtil;
import cn.crazy.appium.util.fengzhuang;

public class Servers {
	private Log logger=Log.getLogger(DosCmd.class);
	String osName=System.getProperty("os.name");
	private List<Integer> appiumPortList;
	private List<Integer> bootstrapPortList;
	private List<String> deviceList;
	private Port port;
	private DosCmd dos;
	private String path=System.getProperty("user.dir");
	public Servers(Port port,DosCmd dos){
		this.port=port;
		this.dos=dos;
	}
	
	


	/**
	 * 根据设备数量生成可用端口列表
	 * @param start 端口起始号
	 * @return 返回值是一个List<Integer>
	 * @throws Exception
	 */
	private List<Integer> getPortList(int start){
		List<String> deviceList=getDevices();
		List<Integer> portList=port.GeneratPortList(start, deviceList.size());
		return portList;	
	}

	/**
	 * 
	* @Title: getDevices  
	* @Description: TODO(获取当前可用设备{"xxx1","xx2","xx3"})  
	* @param @return
	* @param @throws Exception    参数  
	* @return List<String>   返回设备的UDID 返回类型  
	* @throws  
	* @author duanhao
	 */
	public  List<String> getDevices(){
		
		List<String> devList = dos.execCmdConsole("adb devices");
		List<String> deviceRes = new ArrayList<String>();
		if (devList.size() > 2) {
			for(int i = 1; i < devList.size() - 1; i++) {
				//获取打印后的list，从索引1开始取数据，用split进行拆分，devices为设备连接的状态，同时返回设备的UDID
				String deviceInfo[] = devList.get(i).split("\t");
				if (deviceInfo[1].trim().equals("device")) {
					deviceRes.add(deviceInfo[0].trim());
					int sum = devList.size()-2;
					System.out.println("当前连接设备数量为"+sum+"台");
				}
			}
		} else {
			System.out.println("当前没有设备或设备连接状态不正确");
		}
		return deviceRes;
	}
	/**
	 * 生成服务端启动命令字符串存入List
	 * @return
	 * @throws Exception
	 */
	public List<String> GeneratServerCommand(){
		appiumPortList=getPortList(4490);
		bootstrapPortList=getPortList(3456);
		deviceList=getDevices();
		List<String> commandList=new ArrayList<String>();
		//127.0.0.1:62001   xxxxxxxxx
		for(int i=0;i<deviceList.size();i++){
			if(deviceList.get(i).contains(":")) {
				String command="appium -p "+appiumPortList.get(i)+" -bp "+bootstrapPortList.get(i)
				+" -U "+deviceList.get(i)+">"+path+"\\logs\\"+fengzhuang.getdate()+"："+deviceList.get(i).split(":")[0]+"："+deviceList.get(i).split(":")[1]+".log";
				
				System.out.println(command);
				commandList.add(command);
			}else {
				String command="appium -p "+appiumPortList.get(i)+" -bp "+bootstrapPortList.get(i)
				+" -U "+deviceList.get(i)+">"+path+"\\logs\\"+fengzhuang.getdate()+"+"+deviceList.get(i)+".log";
				
				System.out.println(command);
				commandList.add(command);
			}

		}
		try {
			XmlUtil.createDeviceXml(deviceList,appiumPortList);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("创建devices  xml文件失败------------"+e);
		}

		return commandList;
	}
	/**
	 * 启动多个所有appium服务端
	 * @return
	 * @throws Exception
	 */
	public boolean startServers(){
		List<String> startCommand=GeneratServerCommand();
		boolean flag=false;
		
		if(startCommand.size()>0){
			for(String s:startCommand){
				dos.execCmd(s);
			}
			flag=true;
		}else{
			flag=false;	
		}
		return flag;
	}
	
	
	/**
	 * kill server with appium servers
	 * 杀掉appium的server服务，为了下次的启动做准备
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean killServer() throws Exception{
		String command="taskkill -F -PID node.exe";
		if(osName.toLowerCase().contains("mac")){
			command="killall node";
		}else if(osName.toLowerCase().contains("win")){
			command="taskkill -F -PID node.exe";
		}else{
			command="taskkill -F -PID node.exe";
		}
		if(new DosCmd().execCmd(command)){
			logger.debug("kill server node  Succeed");
			return true;
		}else{
			logger.error("kill server node Failure");
			return false;
		}
	}
	
	public static void main(String[] args){
		DosCmd dc=new DosCmd();
//		List<String> deviceList=dc.execCmdConsole("adb devices");
//		for(int i=1;i<deviceList.size()-1;i++){
//			String[] deviceInfo=deviceList.get(i).split("\t");
//			//System.out.println(deviceList.get(i));
//			if(deviceInfo[1].equals("device")){
//				System.out.println(deviceInfo[0]);
//			}
//		}
		Servers server=new Servers(new Port(new DosCmd()), new DosCmd());
		List<String>  devices=server.getDevices();
		for(String s:devices){
			System.out.println(s);
		}
		//server.startServers();
//		List<String> serverCommands=server.GeneratServerCommand();
//		for(String s:serverCommands){
//			System.out.println(s);
//		}
//		if(dc.killServer()){
//			server.startServers();
//		}
		//server.startServers();
		
	}

}
