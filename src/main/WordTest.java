package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordTest {
	
	private Configuration configuration = null;
	private int testNum = 0;
	private Test t;
	
	@SuppressWarnings("deprecation")
	public WordTest(){
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		WordTest test = new WordTest();
		test.createWord("D:/","/1223","model_25.ftl");
	}
//	用来生成文档的方法	
	public void createWord(String filePath,String fileName,String modelName) throws UnsupportedEncodingException{
		if (modelName.equals("model_25.ftl")) {
			testNum = 26;
		}
		else if (modelName.equals("model_50.ftl")) {
			testNum = 51;
		}else if (modelName.equals("model_100.ftl")) {
			testNum = 101;
		}
		else {
			return;
		}
//		创建一个Map对象
		Map<String,Object> dataMap=new HashMap<String,Object>();
//		此处调用了该类中的填充内容的方法
		getData(dataMap);
//		此处载入模板
		configuration.setClassForTemplateLoading(this.getClass(), "/main/template");  //FTL文件所存在的位置
		Template t=null;
		try {
			t = configuration.getTemplate(modelName); //文件名
		} catch (IOException e) {
			e.printStackTrace();
		}
//		此处创建文件
		File outFile = new File(filePath+fileName+".doc");
		Writer out = null;
		try {
//		创建一个bufferderwriter对象
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
//		 此处写入文件
        try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        finally{
        	outFile = null;
        	out = null;
        	t = null;
        	System.gc();
        }
	}
//	这里用来填充模板，主要是替换模板中的标记字符串
	private void getData(Map<String, Object> dataMap) {
		String a = "timu";
		String b = "daan";
		t = new Test();
		for (int i = 1; i < testNum; i++) {
			String answer = t.maketest();
			dataMap.put(b+i, i+": "+answer.substring((answer.indexOf('=')+1),answer.length()));
			dataMap.put(a+i, i+": "+answer.substring(0, answer.indexOf('='))+"=");
		}
		
	}
}
