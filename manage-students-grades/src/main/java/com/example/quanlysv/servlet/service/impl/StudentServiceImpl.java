package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.common.Constant;
import com.example.quanlysv.servlet.dao.IStudentDao;
import com.example.quanlysv.servlet.dao.impl.StudentDaoImpl;
import com.example.quanlysv.servlet.dto.request.student.CreateOrEditStudentDTO;
import com.example.quanlysv.servlet.dto.request.student.StudentDTO;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.StudentEntity;
import com.example.quanlysv.servlet.service.IStudentService;
import com.example.quanlysv.servlet.util.Convert;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

    private static final org.apache.log4j.Logger log = Logger.getLogger(StudentServiceImpl.class.getName());
    private IStudentDao studentDao;

    public StudentServiceImpl(){
        studentDao = new StudentDaoImpl();
    }

    private final Date date = new Date();

    @Override
    public BaseResponse<?> findStudent(StudentFilter request) {
        List<StudentDTO> result = new ArrayList<>();
        try{

            if (request.getBaseRequest().getSortOrder().isEmpty()) {
                request.getBaseRequest().setSortOrder("desc");
            }
            if(request.getBaseRequest().getSortField().isEmpty()){
                request.getBaseRequest().setSortField("ngaySua");
            }

            List<StudentEntity> list = studentDao.findStudent(request);
            Integer totalRecords = studentDao.countTotalRecords(request);
            int totalPages = totalRecords!= null?(int) Math.ceil((double)
                    totalRecords / request.getBaseRequest().getPageSize()): null;

            for(int i=0; i< list.size(); i++){
                result.add(Convert.convertEntityToDTO(list.get(i), StudentDTO.class));
            }
            return new BaseResponse.Builder<List<StudentDTO>>().setMessage("success")
                    .setStatus(200).setData(result).setTotalPages(totalPages).build();
        }catch (Exception e){
            log.error("failed by => ", e.getCause());
            return new BaseResponse.Builder<List<StudentDTO>>().setMessage("failed => "+e.getMessage())
                    .setStatus(500).build();
        }
    }

    @Override
    public BaseResponse<?> createOrUpdateStudent(CreateOrEditStudentDTO studentDTO) {
        try {
            if(studentDTO.getStatus() != 0 && studentDTO.getStatus() != 1){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageBadRequest)
                        .build();
            }
            
            // status =0 ==> create; status =1 ==> update (tao flag)
            if(studentDTO.getStatus() == 0){
                if(studentDao.existedByEmailAndIdSvAndPhone(studentDTO.getIdSv(),
                        studentDTO.getEmailSv(), studentDTO.getPhoneSv())){
                    return new BaseResponse.Builder<>()
                            .setStatus(Constant.httpStatusErrorServer)
                            .setMessage(Constant.messageStudentExist)
                            .build();
                };
            }

            StudentEntity studentEntity = Convert.convertDTOToEntity(studentDTO, StudentEntity.class);
            if(studentEntity != null){
                studentEntity.setNgayTao(date.getTime());
                studentEntity.setNgaySua(date.getTime());
                studentDao.createOrUpdateStudent(studentEntity);
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusOk)
                        .setMessage(Constant.messageSuccess).build();
            }
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageFailed).build();
        } catch (IllegalAccessException e) {
            log.error("failed by =>", e.getCause());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageFailed).build();
        } catch (InstantiationException e) {
            log.error("failed by =>", e.getCause());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageFailed).build();
        }
    }

    @Override
    public BaseResponse<?> getStudentById(String id) {
        try {
            StudentEntity studentEntity = studentDao.getById(id);
            if(studentEntity == null){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageStudentNotFound).build();
            }
            StudentDTO studentDTO = Convert.convertEntityToDTO(studentEntity, StudentDTO.class);
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusOk)
                    .setData(studentDTO)
                    .setMessage(Constant.messageSuccess).build();

        }catch (Exception e){
            log.error(e.getMessage());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageStudentNotFound).build();
        }

    }

    @Override
    public BaseResponse<?> deleteStudentById(String id) {
        try{
            StudentEntity studentEntity = studentDao.getById(id);
            if(studentEntity == null){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageStudentNotFound).build();
            }
            if(!id.trim().isEmpty()) {
                studentDao.deleteStudentById(id.trim());
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusOk)
                        .setMessage(Constant.messageSuccess).build();
            }
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageStudentNotFound).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageStudentNotFound).build();
        }
    }
}
