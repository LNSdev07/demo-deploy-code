package com.example.quanlysv.servlet.controller.grade.api;


import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.GradeEntity;
import com.example.quanlysv.servlet.service.IGradeService;
import com.example.quanlysv.servlet.service.impl.GradeServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.example.quanlysv.servlet.util.ReadExcelExample.getDataFromExcel;

@WebServlet("/api/admin/home/grade")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class GradeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public IGradeService service ;
    public GradeController(){
        this.service=new GradeServiceImpl();
    }
//    private String realPath="";
//    private String extractFileName(Part part) {
//        String contentDisp = part.getHeader("content-disposition");
//        String[] items = contentDisp.split(";");
//        for (String s : items) {
//            if (s.trim().startsWith("filename")) {
//                return s.substring(s.indexOf("=") + 2, s.length() - 1);
//            }
//        }
//        return "";
//    }
//    public File getFolderUpload() {
//        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
//        if (!folderUpload.exists()) {
//            folderUpload.mkdirs();
//        }
//        return folderUpload;
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");
//        for (Part part : req.getParts()) {
//            String fileName = extractFileName(part);
//            // refines the fileName in case it is an absolute path
//            fileName = new File(fileName).getName();
//            realPath=this.getFolderUpload().getAbsolutePath() + File.separator + fileName;
//            part.write(realPath);
//        }
//        System.out.println(realPath); //test file path
////        String idDiem = req.getParameter("idDiem");
////        String idGv = req.getParameter("idGv");
////        String idMh = req.getParameter("idMh");
////        String idHk = req.getParameter("idHk");
////        BaseRequest baseRequest = HttpUtil.of(req.getReader()).toModel(BaseRequest.class);
////        List<GradeEntity> gradeList= getDataFromExcel(filePath);
////
////        for(GradeEntity grade : gradeList){
////            grade.setIdDiem(idDiem);
////            grade.setIdGv(idGv);
////            grade.setIdMh(idMh);
////            grade.setIdHk(idHk);
////            BaseResponse<?> baseResponse = service.nhapDiem(grade);
////        }
////        ResponseUtils.responseApi(req, resp, null);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BaseRequest baseRequest = HttpUtil.of(req.getReader()).toModel(BaseRequest.class);
        String idLop = req.getParameter("idLop");
        BaseResponse<?> baseResponse = service.getGrade(baseRequest,idLop);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}