package org.rinky.digitalassistant.bot.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;


public interface MyKernel32 extends Kernel32 {
    MyKernel32 INSTANCE = (MyKernel32) Native.loadLibrary(("kernel32"), MyKernel32.class);

    HANDLE OpenProcess(DWORD dwDesiredAccess, boolean bInheritHandle, long dwProcessId);

    boolean TerminateProcess(HANDLE hProcess, int uExitCode);

}
