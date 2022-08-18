package org.rinky.digitalassistant.bot;

import org.rinky.digitalassistant.bot.ai.impl.JapyterCommon;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.ai.spi.functions.Iconify;

public class IconifyTest {
public static void main(String[] args) throws Exception{
	JapyterCommon jc = new JapyterCommon();
	jc.connect();
	Iconify ic = new Iconify();
	Context ctx = new Context();
	ctx.getData().put("japyterCommon",jc);
	ic.init(ctx);
	String path = "C:\\projects\\data\\videos\\b";
	String toPath="C:\\\\projects\\\\data\\\\videos\\\\b_icon\\\\";
	ic.doWork(path,toPath,100,100);
	
}
}
