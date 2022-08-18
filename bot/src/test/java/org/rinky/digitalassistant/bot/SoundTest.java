package org.rinky.digitalassistant.bot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.rinky.digitalassistant.bot.ai.AIHelper;
import org.rinky.digitalassistant.bot.io.SoundCapture;

class SoundTest {

	@Test
	void test() throws Exception {
		String fname = AIHelper.captureSound(5);
		AIHelper.playSound(fname);
		
	}

}
