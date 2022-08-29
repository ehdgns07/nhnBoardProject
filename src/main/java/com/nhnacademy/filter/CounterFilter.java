package com.nhnacademy.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "counterFilter", urlPatterns = "/index.jsp")
public class CounterFilter implements Filter {

    Integer counter;
    @Override
    public void init(FilterConfig filterConfig){

        try (BufferedReader bufferedReader = new BufferedReader(

            new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("/counter.dat")))) {
            String count = bufferedReader.readLine();
            counter = Integer.valueOf(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        counter++;
        log.error("{}",counter);
        // NOTE : filterChain 조건에 모두 맞게 달아야 함.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        URL url = this.getClass().getClassLoader().getResource("counter.dat");
        File countFile = null;
        try {
            countFile = Paths.get(url.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(countFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(fw)) {
            bufferedWriter.write(counter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}