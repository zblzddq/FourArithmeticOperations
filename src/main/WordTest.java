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
//	���������ĵ��ķ���	
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
//		����һ��Map����
		Map<String,Object> dataMap=new HashMap<String,Object>();
//		�˴������˸����е�������ݵķ���
		getData(dataMap);
//		�˴�����ģ��
		configuration.setClassForTemplateLoading(this.getClass(), "/main/template");  //FTL�ļ������ڵ�λ��
		Template t=null;
		try {
			t = configuration.getTemplate(modelName); //�ļ���
		} catch (IOException e) {
			e.printStackTrace();
		}
//		�˴������ļ�
		File outFile = new File(filePath+fileName+".doc");
		Writer out = null;
		try {
//		����һ��bufferderwriter����
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
//		 �˴�д���ļ�
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
//	�����������ģ�壬��Ҫ���滻ģ���еı���ַ���
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
