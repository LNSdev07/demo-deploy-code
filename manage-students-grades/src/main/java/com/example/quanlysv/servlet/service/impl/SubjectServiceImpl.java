package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IKhoaDao;
import com.example.quanlysv.servlet.dao.ISubjectDao;
import com.example.quanlysv.servlet.dao.impl.KhoaDaoImpl;
import com.example.quanlysv.servlet.dao.impl.SubjectDaoImpl;
import com.example.quanlysv.servlet.dto.request.student.StudentDTO;
import com.example.quanlysv.servlet.dto.request.subject.CreateOrEditSubjectDTO;
import com.example.quanlysv.servlet.dto.request.subject.SubjectDTO;
import com.example.quanlysv.servlet.dto.request.subject.SubjectFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.SubjectEntity;
import com.example.quanlysv.servlet.service.ISubjectService;
import com.example.quanlysv.servlet.util.Convert;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubjectServiceImpl implements ISubjectService {
    private final ISubjectDao subjectDao;

    private final IKhoaDao khoaDao;

    public SubjectServiceImpl(){
        this.subjectDao = new SubjectDaoImpl();
        this.khoaDao = new KhoaDaoImpl();
    }


    @Override
    public BaseResponse<?> findSubject(SubjectFilter request) {
        List<SubjectDTO> list = new ArrayList<>();
        try{
            if(request.getTenMonHoc() == null ||request.getTenMonHoc().isEmpty()){
                request.setTenMonHoc("");
            }

            if (request.getBaseRequest().getSortOrder().isEmpty()) {
                request.getBaseRequest().setSortOrder("desc");
            }
            if(request.getBaseRequest().getSortField().isEmpty()){
                request.getBaseRequest().setSortField("ngaySua");
            }

            Integer totalRecords = subjectDao.countTotalRecords(request);
            int totalPages = totalRecords!= null?(int) Math.ceil((double)
                    totalRecords / request.getBaseRequest().getPageSize()): 0;


            List<SubjectEntity> list1 = subjectDao.findSubject(request);

            list = list1.stream().map(x ->{
                try {
                    return Convert.convertEntityToDTO(x, SubjectDTO.class);
                } catch (IllegalAccessException | InstantiationException e) {
                    return null;
                } catch (InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }).filter(Objects::nonNull).collect(Collectors.toList());
            return new BaseResponse.Builder<>().setTotalPages(totalPages)
                    .setData(list).setMessage("success").setStatus(200).build();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return new BaseResponse.Builder<List<StudentDTO>>().setMessage("failed => "+e.getMessage())
                    .setStatus(500).build();
        }
    }

    @Override
    public BaseResponse<?> createOrUpdateSubject(CreateOrEditSubjectDTO subjectDTO) {
         try{
             if(subjectDTO.getFlag()==1 && subjectDao.exitsByIdOrName(subjectDTO.getIdMh(), subjectDTO.getTenMonHoc())){
                 return new BaseResponse.Builder<>()
                         .setStatus(500)
                         .setMessage("idMh or subjectName existed!")
                         .build();
             }

             if(khoaDao.existById(subjectDTO.getIdKhoa())){
                 return new BaseResponse.Builder<>()
                         .setStatus(500)
                         .setMessage("khoa not found!")
                         .build();
             }

             SubjectEntity subjectEntity = Convert.convertDTOToEntity(subjectDTO, SubjectEntity.class);
             subjectEntity.setNgayTao(new Date().getTime());
             subjectEntity.setNgaySua(new Date().getTime());

             subjectDao.createOrUpdateSubject(subjectEntity);
             return new BaseResponse.Builder<>()
                     .setStatus(200)
                     .setMessage("success")
                     .build();

         }catch (Exception e){
             System.out.println(e.getMessage());
             return new BaseResponse.Builder<>()
                     .setStatus(500)
                     .setMessage("failed")
                     .build();

         }
    }

    @Override
    public BaseResponse<?> deleteSubject(String id) {
        try {
            if(subjectDao.existById(id)){
                subjectDao.deleteSubject(id.trim());
                return new BaseResponse.Builder<>()
                        .setStatus(200)
                        .setMessage("success")
                        .build();
            }
            return new BaseResponse.Builder<>()
                    .setStatus(200)
                    .setMessage("subject not found!")
                    .build();

        }catch (Exception e){
            return new BaseResponse.Builder<>()
                    .setStatus(500)
                    .setMessage("failed")
                    .build();

        }
    }
}
