package com.kass.lang.util;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

/**
 * Created by kass on 2017-10-19.
 */
public class Utils {

    public static void setHttpHeader(@Context HttpServletResponse resposne) {
        resposne.setHeader("Access-Control-Allow-Origin", "*");
        resposne.setHeader("Access-Control-Allow-Method", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
        resposne.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");

    }
}
