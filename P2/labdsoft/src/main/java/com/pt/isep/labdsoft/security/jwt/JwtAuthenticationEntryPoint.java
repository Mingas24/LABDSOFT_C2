package com.pt.isep.labdsoft.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pt.isep.labdsoft.dto.ResponseDTO;
import com.pt.isep.labdsoft.enums.StatusCode;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, AccessDeniedHandler, Serializable {

    @Serial
    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ResponseDTO resultDTO = new ResponseDTO(false, "Authentication failed", StatusCode.AUTHENTICATION_FAILED.getValue());
        this.writeException(response, resultDTO);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        ResponseDTO resultDTO = new ResponseDTO(false, "Access Denied", StatusCode.ACCESS_DENIED.getValue());
        this.writeException(response, resultDTO);
    }

    private void writeException(HttpServletResponse response, ResponseDTO responseDTO) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper objectMapper = new ObjectMapper();
        String resBody = objectMapper.writeValueAsString(responseDTO);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(resBody);
        printWriter.flush();
        printWriter.close();
    }
}
