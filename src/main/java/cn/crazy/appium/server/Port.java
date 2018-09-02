package cn.crazy.appium.server;

import java.util.ArrayList;
import java.util.List;

import cn.crazy.appium.util.DosCmd;
import cn.crazy.appium.util.Log;




/**
 * 此类封装appium server所有需要的端口分配的诸多方法
* <p>Title: Port</p>  
* <p>Description: </p>  
* @author duanhao 
* @date 2018年8月18日
 */
public class Port {
	private DosCmd execDos;
	private Log logger=Log.getLogger(Port.class);
	public Port(DosCmd execDos){
		this.execDos=execDos;
	}

	
	/**
	 * 
	* @Title: isPortUsed  
	* @Description: TODO(验证端口是否被占用)  
	* @param @param portNum
	* @param @return    参数  
	* @return Boolean    返回类型  端口被占用了返回true，端口未被占用返回false
	* @throws  
	* @author duanhao
	 */
	public  Boolean isPortUsed(int portNum) {
		List<String> portRes = new ArrayList<String>();
		String osName=System.getProperty("os.name");
		System.out.println(osName);
		boolean flag=true;
		try {
			String command="";
			if(osName.toLowerCase().contains("mac")){
				command="netstat -an|grep " + portNum;
			}else if(osName.toLowerCase().contains("win")){
				command="netstat -ano|findstr " + portNum;
			}
			portRes = execDos.execCmdConsole(command);
			System.out.println(portRes.size());
			if (portRes.size() > 0) {
				logger.debug(String.valueOf(portNum)+"   端口已经被占用");
			}else{
				logger.debug(String.valueOf(portNum)+"   端口未被占用");
				flag=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(String.valueOf(portNum)+"    获取端口占用失败"+e);
		}
		return flag;
	}
	/**
	 * 基于当前连接的设备数量生成可用端口
	 * @param portStart,Starting ports
	 * @param deviceTotal,Total number of devices
	 * @return List<Integer>
	 */
	public  List<Integer> GeneratPortList(int portStart, int deviceTotal) {
		List<Integer> portList = new ArrayList<Integer>();
		while (portList.size() != deviceTotal) {
			if (portStart >= 0 && portStart <= 60000+portList.size()) {
				if (!isPortUsed(portStart)) {
					portList.add(portStart);
				}
				portStart++;
			}
			
		}
		return portList;
	}
	public static void main(String[] args){
		Port p=new Port(new DosCmd());
		//System.out.println(p.isPortUsed(4490));
		
		Servers server=new Servers(p, new DosCmd());
		List<String> udidList=server.getDevices();
		int count=udidList.size();
		List<Integer> portList=p.GeneratPortList(4491, count);
		for(Integer i:portList){
			System.out.println(i);
		}
		List<Integer> bpList=p.GeneratPortList(3678, count);
		for(Integer i:bpList){
			System.out.println(i);
		}
//		List<Integer> portList2=p.GeneratPortList(2251, count);
//		for(Integer i:portList2){
//			System.out.println(i);
//		}
//		for(int i=0;i<udidList.size();i++){
//			String appium_commad="appium -p "+portList.get(i)+" -bp "+portList2.get(i)+" -U "
//					+ udidList.get(i)+" > "+"logs/"+udidList.get(i).split(":")[0]+".log";
//			System.out.println(appium_commad);
//		}
		
//		DosCmd cmd=new DosCmd();
//		int i=10;
//		while(cmd.execCmdConsole("netstat -ano|findstr 4723").size()==0&&i>0){
//			Runtime.getRuntime().exec("cmd /c appium");
//			Thread.sleep(10000);
//			System.out.println(i--);
//		}
//		Runtime.getRuntime().exec("cmd /c appium >D://log.txt");
//		Thread.sleep(10000);
		//System.out.println(p.isPortUsed(4493));
	}
}
