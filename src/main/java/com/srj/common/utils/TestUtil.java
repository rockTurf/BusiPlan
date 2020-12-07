package com.srj.common.utils;


import com.srj.web.util.StringUtil;
import org.junit.Test;

import java.util.LinkedList;

public class TestUtil {

	@Test
	public void test(){
		LinkedList<String> list = FileUtil.readFileByLines("C:\\Users\\Dell\\Desktop\\work\\ZGZYZZB.sql");
		StringBuffer buffer = new StringBuffer();
		String str = "";
		String temp = "";
		String s = "";
		//总条数
		int SIZE = 7000;//条数
		int TOTAL = list.size();
		int COUNT = (TOTAL  +  SIZE  - 1) / SIZE;
		for(int i=1;i<=COUNT;i++){
			for(int j=(i-1)*SIZE+1;j<i*SIZE;j++){
				if(j>=TOTAL){
					break;
				}else{
					str = list.get(j);

					if(str.indexOf("INSERT")!=-1&&str.indexOf("CF_AUDIT")==-1){
						s = str.substring(str.length()-1,str.length());
						if(s.equals(";")){
							buffer.append(str+"\n");
						}
					}
				}
			}
			temp = buffer.toString();
			FileUtil.writeFileByLine("C:\\Users\\Dell\\Desktop\\work\\copy\\SQL_DATA"+i+".sql",temp);
			buffer.setLength(0);
		}

	}

	@Test
	public void test1(){
		String s = "cf0000";
		if("CF0000".equals(s.toUpperCase())){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}


}
