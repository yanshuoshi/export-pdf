package com.example.exportpdf.PDFUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yss
 * @date 2021/11/12
 */
@RestController
public class TestController {

    @GetMapping("test")
    public void PDFTest(HttpServletResponse response){
        Map<String, Object> variables = new HashMap<>();
        variables.put("title", new String[]{"操作", "创建时间", "操作结果"});
        variables.put("signName", "列表名称");
        List<List<String>> signList = new ArrayList<>();
        for(int i = 0 ;i < 5 ;i ++){
            List<String> list = new ArrayList<>();
            list.add("操作" + i);
            list.add("操作时间" + i);
            list.add("操作结果" + i);
            signList.add(list);
        }
        variables.put("signList", signList);
        try {
            PDFUtil.buildPdf(response,"测试pdf","example",variables);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
