package org.rinky.digitalassistant.bot.win32;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public interface MyUser32 extends User32 {
	
    MyUser32 INSTANCE = (MyUser32) Native.load(("user32"), MyUser32.class);

    HWND GetForegroundWindow();

    int GetWindowTextA(HWND hwnd, byte[] bytes, int i);

    HWND FindWindowA(java.lang.String string, java.lang.String string1);

    boolean ShowWindow(HWND hWnd, int nCmdShow);

    boolean BringWindowToTop(HWND hWnd);

    HWND GetActiveWindow();

    boolean IsWindowVisible(HWND hWnd);
    void keybd_event(int key,            int b,            int state,            int d);
    void mouse_event(int dwFlags, int dx, int dy, int dwData,int dwExtraInfo);
    BOOL LockWorkStation();
    void PostQuitMessage(int paramInt);
    int GetSystemMetrics(int paramInt);
    int SetWindowRgn(WinDef.HWND paramHWND, WinDef.HRGN paramHRGN, boolean paramBoolean);
    boolean GetKeyboardState(byte[] paramArrayOfByte);
    short GetAsyncKeyState(int paramInt);
    public HDC GetWindowDC(HWND hWnd);
    public boolean GetClientRect(HWND hWnd, RECT rect);
}