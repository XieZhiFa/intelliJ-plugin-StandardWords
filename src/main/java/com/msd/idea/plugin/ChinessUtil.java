package com.msd.idea.plugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChinessUtil {
    public static boolean checkcountname(String countname) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(countname);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
