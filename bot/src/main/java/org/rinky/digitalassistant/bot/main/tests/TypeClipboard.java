package org.rinky.digitalassistant.bot.main.tests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.rinky.digitalassistant.bot.MouseAndKeyboard;

public class TypeClipboard {
	public static void main(String[] args)throws Exception {
		Thread.sleep(10000);
		String s = getClipboardContents();
		MouseAndKeyboard.sendText(s, 20);
	}
	public static String getClipboardContents() {
		String result = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				result = (String) contents.getTransferData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			} catch (IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		} else if (contents.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			try {
				List<File> toRet = (List<File>) contents.getTransferData(DataFlavor.javaFileListFlavor);
				List<String> fnames = new ArrayList<String>();
				for (File f : toRet) {
					fnames.add(f.getAbsolutePath());
				}
				result = Arrays.toString(fnames.toArray(new String[0]));
				System.out.println(result);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return result;
	}
}
