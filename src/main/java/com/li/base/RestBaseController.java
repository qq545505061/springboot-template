package com.li.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.li.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author longxiong
 * REST风格基础controller
 * 统一返回格式
 */
@RestController
public class RestBaseController {

    // 返回状态码
    public enum State {
        //全局状态码
        Success(1), // 成功
        Fail(0), // 失败
        Error(-1), // 程序错误
        NoData(2000); // 没有获取到数据

        private int code;
        // 构造函数，枚举类型只能为私有
        private State(int _code) {
            this.code = _code;
        }
        @Override
        public String toString() {
            return String.valueOf(this.code);
        }

    }

    private ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<HttpServletResponse>();
    @ModelAttribute
    private void initResponse(HttpServletResponse response) {
        responseContainer.set(response);
    }
    protected HttpServletResponse getResponse() {
        return responseContainer.get();
    }

    public void sendData(State S, String message) {
        sendData(S, message, null, null);
    }

    public void sendData(State S, String message, Object value) {
        sendData(S, message, value, null);
    }

    // 发送响应数据
    public void sendData(State S, String message, Object value, SerializeFilter filter) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("S", S.toString());
        if(!StringUtils.stringIsEmpty(message)) {
            result.put("MSG", message);
        }
        if(value != null) {
            result.put("V", value);
        }
        // 将数据过滤输出
        writer(JSON.toJSONString(result, filter));
    }

    /*
     * 将数据输出
     */
    public void writer(String value) {
        try {
            getResponse().setCharacterEncoding("UTF-8");
            PrintWriter pw = getResponse().getWriter();
            pw.print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
