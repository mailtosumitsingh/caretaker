package org.rinky.digitalassistant.bot.win32;

import java.awt.image.BufferedImage;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Kernel32Util;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HBITMAP;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinGDI.BITMAPINFO;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;

public class NativeWindowUtils {
	final static Kernel32 kern = Kernel32.INSTANCE;
	
    public static void main(String[] args) {
        MyUser32 user32 = MyUser32.INSTANCE;
        String s = getProcessByWindowName("Generic");


        System.out.println(s);
    }

    public static HWND getWindowMatching(final String str) {
        HWND p = MyUser32.INSTANCE.FindWindowA(null, str);
        MyUser32WNDENUMPROC temp = new MyUser32WNDENUMPROC(str);
        if (p == null) {
            MyUser32.INSTANCE.EnumWindows(temp, null);
        }
        return temp.getP();
    }

    public static void enumWindows(User32.WNDENUMPROC enumerator) {
        MyUser32.INSTANCE.EnumWindows(enumerator, null);
    }

    public static String getWindowText(HWND hwnd) {
        byte bytes[] = new byte[1024];
        int size = MyUser32.INSTANCE.GetWindowTextA(hwnd, bytes, 1024);
        String s = new String(bytes, 0, size);
        return s;
    }

    public static void restoreWindow(HWND hwnd) {
        MyUser32.INSTANCE.ShowWindow(hwnd, 9);
    }

    public static void makeForground(HWND hwnd) {
        MyUser32.INSTANCE.BringWindowToTop(hwnd);
    }

    public static void maxmizeWindow(HWND hwnd) {
        MyUser32.INSTANCE.ShowWindow(hwnd, 2);
    }

    public static void minimizeWindow(HWND hwnd) {
        MyUser32.INSTANCE.ShowWindow(hwnd, 0);
    }

    public static void showWindow(HWND hwnd) {
        MyUser32.INSTANCE.ShowWindow(hwnd, 5);
    }

    public static int getProcessIdForWindow(HWND hwnd) {
        IntByReference ref = new IntByReference();
        MyUser32.INSTANCE.GetWindowThreadProcessId(hwnd, ref);
        return ref.getValue();
    }

    public static HANDLE getProcessHandle(int id) {
        IntByReference ref = new IntByReference();
        return MyKernel32.INSTANCE.OpenProcess(new DWORD(0x400 | 0x0001), false, id);
    }

    public static String getProcessName(HANDLE hndl) {
        IntByReference ref = new IntByReference();
        byte[] bytes = new byte[1024];
        int size = 1;
        MyPSAPI.INSTANCE.GetProcessImageFileNameA(hndl, bytes, new DWORD(1024));
        while (size < 1024) {
            ++size;
            if (bytes[size] == '\0')
                break;
        }
        return new String(bytes, 0, size);
    }

    public static String getProcessByWindowName(String name) {
        String str = null;
        HWND p = getWindowMatching(name);
        int id = 0;
        HANDLE hndl = null;
        if (p != null) {
            id = getProcessIdForWindow(p);
            if (id != 0) {
                hndl = getProcessHandle(id);
                if (hndl != null) {
                    str = getProcessName(hndl);
                }
            }
        }
        return str;
    }

    public static String getProcessByWindowHandle(HWND p) {
        String str = null;
        int id = 0;
        HANDLE hndl = null;
        if (p != null) {
            id = getProcessIdForWindow(p);
            if (id != 0) {
                hndl = getProcessHandle(id);
                if (hndl != null) {
                    str = getProcessName(hndl);
                }
            }
        }
        return str;
    }

    public static void TerminateProcess(HWND p) {
        int id = 0;
        HANDLE hndl = null;
        if (p != null) {
            id = getProcessIdForWindow(p);
            if (id != 0) {
                hndl = getProcessHandle(id);
                if (hndl != null) {
                    MyKernel32.INSTANCE.TerminateProcess(hndl, 0);

                }
            }
        }
    }

    public static HWND getForgroundWindow() {
        return MyUser32.INSTANCE.GetForegroundWindow();

    }

    public static HWND getActiveWindow() {
        return MyUser32.INSTANCE.GetActiveWindow();
    }

    public static boolean IsWindowVisible(HWND hWnd) {
        return MyUser32.INSTANCE.IsWindowVisible(hWnd);
    }

    public static HANDLE getProcessHandleByWindowHandle(HWND p) {
        String str = null;
        int id = 0;
        HANDLE hndl = null;
        if (p != null) {
            id = getProcessIdForWindow(p);
            if (id != 0) {
                hndl = getProcessHandle(id);
            }
        }
        return hndl;
    }
    public static String getLastError(){
    	int error = kern.GetLastError();
    	String errorStr = Kernel32Util.formatMessageFromLastErrorCode(error);
    	System.out.println("Error while installing hook: "+errorStr);
    	return errorStr;
    }
    public static BufferedImage captureWindow(HWND hWnd) {

        HDC hdcWindow = MyUser32.INSTANCE.GetDC(hWnd);
        HDC hdcMemDC = GDI32.INSTANCE.CreateCompatibleDC(hdcWindow);

        RECT bounds = new RECT();
        MyUser32.INSTANCE.GetClientRect(hWnd, bounds);

        int width = bounds.right - bounds.left;
        int height = bounds.bottom - bounds.top;

        HBITMAP hBitmap = GDI32.INSTANCE.CreateCompatibleBitmap(hdcWindow, width, height);

        HANDLE hOld = GDI32.INSTANCE.SelectObject(hdcMemDC, hBitmap);
        MyGDI32.INSTANCE.BitBlt(hdcMemDC, 0, 0, width, height, hdcWindow, 0, 0, MyGDI32.SRCCOPY);

        GDI32.INSTANCE.SelectObject(hdcMemDC, hOld);
        GDI32.INSTANCE.DeleteDC(hdcMemDC);

        BITMAPINFO bmi = new BITMAPINFO();
        bmi.bmiHeader.biWidth = width;
        bmi.bmiHeader.biHeight = -height;
        bmi.bmiHeader.biPlanes = 1;
        bmi.bmiHeader.biBitCount = 32;
        bmi.bmiHeader.biCompression = WinGDI.BI_RGB;

        Memory buffer = new Memory(width * height * 4);
        GDI32.INSTANCE.GetDIBits(hdcWindow, hBitmap, 0, height, buffer, bmi, WinGDI.DIB_RGB_COLORS);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0, 0, width, height, buffer.getIntArray(0, width * height), 0, width);

        GDI32.INSTANCE.DeleteObject(hBitmap);
        User32.INSTANCE.ReleaseDC(hWnd, hdcWindow);

        return image;

    }
}
