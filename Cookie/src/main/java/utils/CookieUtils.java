package utils;

import javax.servlet.http.Cookie;

/**
 * @author QFY
 * @Description
 * @create 2021-05-21 15:02
 */
public  class CookieUtils {
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
