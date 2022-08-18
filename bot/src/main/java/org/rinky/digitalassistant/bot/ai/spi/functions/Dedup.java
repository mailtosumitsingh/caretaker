package org.rinky.digitalassistant.bot.ai.spi.functions;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.python.google.common.collect.Lists;
import org.rinky.digitalassistant.bot.ai.impl.JapyterCommon;
import org.rinky.digitalassistant.bot.ai.spi.Context;

import com.google.common.util.concurrent.Uninterruptibles;

public class Dedup {
  JapyterCommon jc ;
	
	public void init(Context ctx) throws Exception{
	this.jc = (JapyterCommon) ctx.getData().get("japyterCommon");
	}
	
	public  void doWork(String path,String whereTo) throws Exception {
		File[] files = new File(path).listFiles();
		Arrays.sort(files, Comparator.comparingLong(File::lastModified));
		File last = null;
		List<File> ar = Lists.newArrayList();
		int samplingRate = 1;
		int i = 0;
		for(File f : files) {
			if(i%samplingRate==0)
				ar.add(f);
			i++;
		}
		for(File f : ar) {
			if(last==null) {
				last = f;
			}else {
			String fpath = f.getAbsolutePath();
			fpath  = StringUtils.replace(fpath, "\\","\\\\");
			String lpath = last.getAbsolutePath();
			lpath = StringUtils.replace(lpath, "\\","\\\\");
			String str = "diff(\""+fpath+"\",\""+lpath+"\",\""+whereTo+f.getName()+"\")";
			System.out.println(str);
			jc.execute(str);
			Uninterruptibles.sleepUninterruptibly(1,TimeUnit.MILLISECONDS);
			last = f;
			}
		}
	}
}
