package org.rinky.digitalassistant.bot.ai.impl;

import static org.rinky.digitalassistant.bot.japyter.client.Shell.InspectDetailLevel.FINE;
import static org.rinky.digitalassistant.bot.japyter.gen.HistoryRequest.HistAccessType.TAIL;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.rinky.digitalassistant.bot.japyter.Japyter;
import org.rinky.digitalassistant.bot.japyter.client.Shell;
import org.rinky.digitalassistant.bot.japyter.client.IoPub.BroadcastListener;
import org.rinky.digitalassistant.bot.japyter.client.IoPub.MessageListener;
import org.rinky.digitalassistant.bot.japyter.client.Stdin.AbstractStdinHandler;
import org.rinky.digitalassistant.bot.japyter.client.Stdin.StdinHandler;
import org.rinky.digitalassistant.bot.japyter.gen.Broadcast;
import org.rinky.digitalassistant.bot.japyter.gen.ExecuteRequest;
import org.rinky.digitalassistant.bot.japyter.gen.HistoryRequest;
import org.rinky.digitalassistant.bot.japyter.gen.Message;

public class JapyterCommon {
	StdinHandler randomStdinHandler;
	Japyter japyter;
	Shell shell;

	public void connect() {

		randomStdinHandler = new AbstractStdinHandler() {
			@Override
			public String prompt(final String text, final boolean password) {
				return RandomStringUtils.randomAlphanumeric(20);
			}
		};
		try {
			japyter = Japyter.fromConfigFile(new File("C:\\projects\\caretaker\\bot\\connect.txt"))
					.withUserName("it-test").withStdinHandler(randomStdinHandler).build();
			shell = japyter.getShell();

			japyter.getIoPub().subscribe(new BroadcastListener() {
				@Override
				public void handle(final Broadcast b) {
					System.out.println("IoPub Broadcast: " + b);
				}
			});
			japyter.getIoPub().subscribe(new MessageListener() {
				@Override
				public void handle(final Message m) {
					System.out.println("IoPub Message: " + m);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(String str) throws IOException {
		shell.execute(new ExecuteRequest().withCode(str));
	}
}
