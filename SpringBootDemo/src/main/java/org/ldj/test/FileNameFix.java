/**
 * @ProjectName: SpringBootDemo
 * @Copyright: 2010 by Beijing Star Cube Technology Development Co., Ltd.
 * @address: http://www.starscube.com
 * @Description: 本内容仅限于北京星立方科技发展股份有限公司内部使用，禁止转发.
 * @author liudj
 * @date: 2018年6月6日 上午10:28:36
 * @Title: FileNameFix.java
 * @Package org.ldj.test
 */
package org.ldj.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;


/**
 * @author liudj 2018年6月6日 上午10:28:36
 * @ClassName FileNameFix
 * @Description  
 *       文件名过滤，复制一个目录下的java文件，到另一个,并按类名重命名文件名
 * @version V1.0   
 */
public class FileNameFix {
	
	
	public static void main(String[] args) throws Exception {
//		Pattern reg = Pattern.compile("[\\u4E00-\\u9FA5]+");
		Pattern reg = Pattern.compile("public.*(class|interface|enum) (\\w+|[\\u4E00-\\u9FA5]+)(\\W+|\\{)");
		String str = "public static interface FileNameFixFileNameFix extends{";
		Matcher m =reg.matcher(str);

		
		if(m.find()){
			System.out.println(m.groupCount());
			for(int i=0;i<m.groupCount()+1;i++){
				System.out.println( i+ "   "+m.group(i));
			}
		}else{
			throw new Exception("未找到类名");
		}
		
		fileFilter();
	}
	
	/**
	 * 
	 * @author liudj 2018年6月6日 下午1:15:16
	 * @Method: fileFilter 
	 * @param args
	 * @throws Exception 
	 * @throws
	 */
	public static void fileFilter() throws Exception {
		String fileRoot="D:\\ldjWorkRoot\\SVNROOT\\JC";
		String newFilePathTemp = fileRoot+File.separator+"tmp"+File.separator;
		String newFileName;
		String classContent ;
		Pattern reg = Pattern.compile(".*(class|interface|enum) (\\w+|[\\u4E00-\\u9FA5]+)(\\W+|\\{)");
		
		File f = new File(fileRoot +File.separator +"org.cncip.sdk-v2.1.3");
		Collection<File > li = FileUtils.listFiles(f,FileFilterUtils.suffixFileFilter("java"),TrueFileFilter.INSTANCE);
			System.out.println("size "+li.size());
		for (Iterator<File> iterator = li.iterator(); iterator.hasNext();) {
			File file = (File)iterator.next();
			String newFilePath = newFilePathTemp + StringUtils.substringAfter(file.getParent(), "1.3"+File.separator);
			classContent = FileUtils.readFileToString(file);
			newFileName = matcheClassName(reg, classContent,2);
			FileUtils.copyFile(file, new File(newFilePath+File.separator+newFileName+".java"), true);
		}
		
	}
	
	public static String matcheClassName(Pattern reg,String conntent,int index) throws Exception{
		Matcher m =reg.matcher(conntent);
		if(m.find()){
			return m.group(index);
		}else{
			System.out.println(conntent);
			throw new Exception("未找到类名");
		}
	}
	
}
