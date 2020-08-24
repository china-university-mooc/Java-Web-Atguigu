package com.itutry.util;

import javax.servlet.http.Cookie;

public class CookieUtil {

    // 查找指定名称的Cookie对象
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if (cookies == null || cookies.length == 0 || name == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
