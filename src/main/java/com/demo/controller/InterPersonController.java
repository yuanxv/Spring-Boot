package com.demo.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.InterPerson;
import com.demo.util.FileUtils;
import com.demo.util.PropertiesUtil;

/**
 * 
 * @author Administrator
 * 
 */
@RestController
public class InterPersonController {
	// @Value("${isupClient.interPerson.lastSyncTime}")
	private String lastSyncTime;

	Log log = LogFactory.getLog(InterPersonController.class);

	@RequestMapping("/getInterPersonInfo")
	public List<InterPerson> getInterPersonInfo(Long startTime, Long endTime) {
		log.info("getInterPersonInfo start");
		this.lastSyncTime = PropertiesUtil
				.getProperty("isupClient.interPerson.lastSyncTime");
		log.info("lastSyncTime is " + this.lastSyncTime);
		
		// 若上次同步时间为0 则全量，否则比较endTime和上次同步时间的差，若大于5分钟，则增量同步
		List<String> allW3List = new ArrayList<String>(1);
		List<String> notSyncW3List = new ArrayList<String>(1);
		if (this.lastSyncTime == "0") {
//			全量查
			this.syncInterPersonInfoByCount(allW3List);
		} else if (endTime - Long.valueOf(lastSyncTime) > 5 * 60 * 1000||notSyncW3List.size()>0) {
//			增量查
			if(notSyncW3List.size()>0){
				this.syncInterPersonInfoByCount(notSyncW3List);
			}
			if(endTime - Long.valueOf(lastSyncTime) > 5 * 60 * 1000){
				this.syncInterPersonInfoByTimeDiff(allW3List,Long.valueOf(this.lastSyncTime));
			}
		}
		
		PropertiesUtil.setProperty("isupClient.interPerson.lastSyncTime",
				new Date().getTime() + "");
		this.lastSyncTime = PropertiesUtil
				.getProperty("isupClient.interPerson.lastSyncTime");
		log.info("lastSyncTime is " + this.lastSyncTime);
//		根据startTime查本地库，和头像文件流，返回请求数据

		return null;
	}

	public List<InterPerson> syncInterPersonInfoByTimeDiff(List<String> w3List,Long lastSyncTime) {
//		查所有账号中 上次同步时间以来变化的数据
		return null;
	}

	public List<InterPerson> syncInterPersonInfoByCount(List<String> w3List) {

		for(int i=0;i<w3List.size();i++){
//			查每一个账号的全名     (w3账号是ywx512243，更新时间为>startTime)
//			查每一个账号的头像信息（写入目录）
//			给对象赋值 存到数据库
		}
		return null;
	}
	
	public void getImgDataByCount(File file){
		
//		读取file名  拼接path 创建文件    写入流 关闭流  
	}
	@RequestMapping("/copyImg")
	public void copyD1imgToD2img(){
//		E:\\test.png   G:\MyProject\pictureSrc
		FileUtils.saveImageToDisk("G:\\MyProject\\pictureSrc\\a.jpg","G:\\MyProject\\pictureSrc2\\a.jpg");
	}
//	需要工具类 来根据文件流存储文件   并根据路径读取文件
}
