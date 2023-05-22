package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.common.Constant;
import com.example.quanlysv.servlet.dao.IKhoaDao;
import com.example.quanlysv.servlet.dao.ITeacherDao;
import com.example.quanlysv.servlet.dao.impl.KhoaDaoImpl;
import com.example.quanlysv.servlet.dao.impl.TeacherDaoImpl;
import com.example.quanlysv.servlet.dto.request.teacher.CreateOrEditTeacherDTO;
import com.example.quanlysv.servlet.dto.request.teacher.TeacherDTO;
import com.example.quanlysv.servlet.dto.request.teacher.TeacherFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.KhoaEntity;
import com.example.quanlysv.servlet.entity.TeacherEntity;
import com.example.quanlysv.servlet.service.ITeacherService;
import com.example.quanlysv.servlet.util.Convert;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements ITeacherService {
    private static final org.apache.log4j.Logger log = Logger.getLogger(StudentServiceImpl.class.getName());

    private ITeacherDao teacherDao;
    private IKhoaDao iKhoaDao;

    private final Date date = new Date();
    public TeacherServiceImpl(){
        teacherDao=new TeacherDaoImpl();
        iKhoaDao =  new KhoaDaoImpl();
    }

    @Override
    public BaseResponse<?> getTeacherById(String id) {
        try{
            TeacherEntity teacherEntity = teacherDao.getById(id);
            if(teacherEntity==null){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageTeacherNotFound).build();
            }

            TeacherDTO teacherDTO = Convert.convertEntityToDTO(teacherEntity, TeacherDTO.class);
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusOk)
                    .setData(teacherDTO)
                    .setMessage(Constant.messageSuccess).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageTeacherNotFound).build();
        }
    }

    @Override
    public BaseResponse<?> createOrEditTeacher(CreateOrEditTeacherDTO teacherDTO) {
        try {
            if(teacherDTO.getStatus() != 0 && teacherDTO.getStatus() != 1){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageBadRequest)
                        .build();
            }

            // status =0 ==> create; status =1 ==> update (tao flag)
            if(teacherDTO.getStatus() == 0){
                if(teacherDao.existedByIdOrEmailOrPhone(teacherDTO.getIdGv(), teacherDTO.getEmailGv(), teacherDTO.getSdtGv())){
                    return new BaseResponse.Builder<>()
                            .setStatus(Constant.httpStatusErrorServer)
                            .setMessage(Constant.messageTeacherExist)
                            .build();
                };
            }

            TeacherEntity teacherEntity = Convert.convertDTOToEntity(teacherDTO, TeacherEntity.class);
            if(teacherEntity != null){
                teacherEntity.setNgayTao(Instant.now());
                teacherEntity.setNgaySua(Instant.now());
                teacherDao.createOrEditTeacher(teacherEntity);
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusOk)
                        .setMessage(Constant.messageSuccess).build();
            }
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageFailed).build();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseResponse<?> findTeacher(TeacherFilter request) {
        List<TeacherDTO> dtoList;
        try{
            if ((request.getBaseRequest().getSortOrder() == null || request.getBaseRequest().getSortOrder().isEmpty())) {
                request.getBaseRequest().setSortOrder("desc");
            }
            if(request.getBaseRequest().getSortField() == null || request.getBaseRequest().getSortField().isEmpty()){
                request.getBaseRequest().setSortField("ngaySua");
            }
            List<TeacherEntity> list=teacherDao.findTeacher(request);
            Integer totalRecords = teacherDao.countTotalRecords(request);
            int totalPages = totalRecords!= null?(int) Math.ceil((double)
                    totalRecords / request.getBaseRequest().getPageSize()): null;
            for(TeacherEntity tmp:list){
                KhoaEntity khoaEntity = iKhoaDao.getById( tmp.getIdKhoa() );
                tmp.setTenKhoa(khoaEntity.getTenKhoa());
            }
            dtoList=list.stream().map(x->{
                try{
                    return Convert.convertEntityToDTO(x,TeacherDTO.class);
                } catch (IllegalAccessException e) {
                    System.out.println(e.getCause());
                    return null;
                } catch (InstantiationException e) {
                    System.out.println(e.getCause());
                    return null;
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }).filter(Objects::nonNull).collect(Collectors.toList());

            return new BaseResponse.Builder<List<TeacherDTO>>()
                    .setData(dtoList).setMessage("success").setStatus(200).setTotalPages(totalPages).build();
        } catch (Exception e) {
            return new BaseResponse.Builder<List<TeacherDTO>>()
                    .setMessage("failed"+ e.getMessage()).setStatus(500).build();
        }
    }

    @Override
    public BaseResponse<?> deleteTeacher(String id) {
        try{
            teacherDao.deleteTeacher(id);
            return new BaseResponse.Builder<List<TeacherDTO>>()
                    .setMessage("success")
                    .setStatus(200)
                    .build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new BaseResponse.Builder<List<TeacherDTO>>()
                    .setMessage("failed"+e.getMessage()).setStatus(500).build();
        }    }
}
