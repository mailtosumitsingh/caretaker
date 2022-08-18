package org.rinky.digitalassistant.bot;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClipboardUtils implements ClipboardOwner {


	public void lostOwnership(Clipboard aClipboard, Transferable aContents) {
	}

	public void setClipboardContents(String aString) {
		StringSelection stringSelection = new StringSelection(aString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, this);
	}

	public String getClipboardContents() {
		String result = "";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		boolean hasTransferableText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
		if (hasTransferableText) {
			try {
				result = (String) contents.getTransferData(DataFlavor.stringFlavor);
				List<String> fnames = new ArrayList<String>();
				fnames.add(result);
				result = StaticUtil.toJson(fnames);
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
				result = StaticUtil.toJson(fnames);
				System.out.println(result);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return result;
	}
	
}
