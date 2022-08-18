package org.rinky.digitalassistant.bot.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.win32.W32APIOptions;

	public interface MyGDI32 extends GDI32 {
		public static final DWORD SRCCOPY = new DWORD(0x00CC0020);
		MyGDI32 INSTANCE = (MyGDI32) Native.loadLibrary("gdi32", MyGDI32.class, W32APIOptions.DEFAULT_OPTIONS);

	    public boolean BitBlt(HDC hObject, int nXDest, int nYDest, int nWidth, int nHeight, HDC hObjectSource, int nXSrc, int nYSrc, DWORD dwRop);

	}
