package com.itutry.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

    @Test
    public void testLocale() {
        // 获取系统默认的语言国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);

//        for (Locale availableLocale : Locale.getAvailableLocales()) {
//            System.out.println(availableLocale);
//        }

        // 获取中文，中国的常量对象
        System.out.println(Locale.CHINA);
        // 获取英文，美国的常量对象
        System.out.println(Locale.US);
    }

    @Test
    public void test2() {
        // 1. 指定locale对象
        Locale locale = Locale.CHINA;

        // 2. 通过basename和locale对象，读取相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        // 3. 获取语言信息
        String username = bundle.getString("username");
        System.out.println(username);
    }
}
