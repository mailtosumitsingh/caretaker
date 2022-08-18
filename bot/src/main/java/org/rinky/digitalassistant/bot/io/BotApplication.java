package org.rinky.digitalassistant.bot.io;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.rinky.digitalassistant.bot.ai.impl.ButtonProbe;
import org.rinky.digitalassistant.bot.ai.impl.KeyboardProbe;
import org.rinky.digitalassistant.bot.ai.impl.MouseProbe;
import org.rinky.digitalassistant.bot.ai.impl.ScreenShotProbe;
import org.rinky.digitalassistant.bot.ai.impl.WordProbe;
import org.rinky.digitalassistant.bot.ai.spi.Context;
import org.rinky.digitalassistant.bot.io.Event.EventType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages= {"org.rinky.digitalassistant.bot.io","org.rinky.digitalassistant.bot.ai.impl"})
@SpringBootApplication
public class BotApplication {
	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventBus eb) {
		return (args) -> {
			Event ev = new Event();
			ev.setData("test", "some data");
			ev.setEventType(EventType.ButtonClick);
			eb.send(ev);
			Event ev2 = new Event();
			ev2.setData("test", "some other data");
			ev2.setEventType(EventType.ButtonClick);
			eb.send(ev2);

		};
	}

	@Bean Context getContext() {
		Context ctx = new Context();
		ctx.setWorkingDir("c:\\temp\\");
		return ctx;
	}
	@Bean
	public CommandLineRunner post(KeyboardProbe kp,MouseProbe mp, ButtonProbe bp, ScreenShotProbe sp, WordProbe wp) {
		return (args) -> {
			try {
				GlobalScreen.registerNativeHook();
				GlobalScreen.addNativeKeyListener(kp);
				GlobalScreen.addNativeMouseListener(mp);
				GlobalScreen.addNativeMouseListener(bp);
				GlobalScreen.addNativeMouseListener(sp);
				GlobalScreen.addNativeKeyListener(wp);
			} catch (NativeHookException e) {
				e.printStackTrace();
			}
		};
	}

}
