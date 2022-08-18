package org.rinky.digitalassistant.bot.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.win32.StdCallLibrary;


public interface MyPSAPI extends  StdCallLibrary {
    MyPSAPI INSTANCE = (MyPSAPI) Native.loadLibrary(("psapi"), MyPSAPI.class);

    DWORD GetProcessImageFileNameA(HANDLE hProcess, byte[] lpImageFileName, DWORD nSize);

}
