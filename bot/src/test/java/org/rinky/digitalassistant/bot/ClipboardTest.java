package org.rinky.digitalassistant.bot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClipboardTest {

	@Test
	void test() {
		ClipboardUtils textTransfer = new ClipboardUtils();
		System.out.println("Clipboard contains:" + textTransfer.getClipboardContents());
		String actual = "blah, blah, blah";
		textTransfer.setClipboardContents(actual);
		System.out.println("Clipboard contains:" + textTransfer.getClipboardContents());
		assertEquals(textTransfer.getClipboardContents(), "[\""+actual+"\"]");
	}

}
