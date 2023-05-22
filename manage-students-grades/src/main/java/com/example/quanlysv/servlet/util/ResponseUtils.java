package com.example.quanlysv.servlet.util;

import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {
    public static void responseApi(HttpServletRequest req, HttpServletResponse resp, BaseResponse<?> baseResponse ) throws IOException {
        String json = new ObjectMapper().writeValueAsString(baseResponse);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        writer.flush();
    }
}
