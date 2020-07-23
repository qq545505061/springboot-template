package com.li.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class ControllerUtils {
	
	public static void send(String message) {
		send(ResultCode.Success, message, null, null);
	}
	
	public static void send(ResultCode S, String message) {
		send(S, message, null, null);
	}
	
	public static void send(ResultCode S, Object value) {
		send(S, null, value, null);
	}
	
	public static void send(ResultCode S, String message, Object value) {
		send(S, message, value, null);
	}
	
	// 发送响应数据
	public static void send(ResultCode S, String message, Object value, SerializeFilter filter) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("S", S.toString());
		if(StringUtils.isBlank(message)) {
			result.put("MSG", message);
		} 
		if(value != null) {
			result.put("V", value);
		}
		// 格式化日期时间
		SerializeConfig config = new SerializeConfig();
		config.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
		config.put(Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
		// 将数据过滤输出
		String outStr = JSON.toJSONString(result, config, filter);
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.print(outStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
