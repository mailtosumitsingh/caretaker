package org.rinky.digitalassistant.bot.win32;

import org.apache.commons.lang3.StringUtils;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;


public class MyUser32WNDENUMPROC implements MyUser32.WNDENUMPROC {

    public MyUser32WNDENUMPROC(String str) {
        this.str = str;
    }

    String str;
    private HWND p;

    public HWND getP() {
        return p;
    }

    public boolean callback(HWND hwnd, Pointer p2) {
        String s = NativeWindowUtils.getWindowText(hwnd);
        if (StringUtils.contains(s, str)) {
            p = hwnd;
            return false;
        } else {
            return true;
        }
    }
}