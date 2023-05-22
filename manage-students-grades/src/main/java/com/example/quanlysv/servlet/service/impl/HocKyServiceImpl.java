package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.common.Constant;
import com.example.quanlysv.servlet.dao.IHocKyDao;
import com.example.quanlysv.servlet.dao.impl.HocKyDaoImpl;
import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.kyhoc.CreateOrEditSemesterDTO;
import com.example.quanlysv.servlet.dto.request.kyhoc.SemesterDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.HocKyEntity;
import com.example.quanlysv.servlet.service.IHocKyService;
import com.example.quanlysv.servlet.util.Convert;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HocKyServiceImpl implements IHocKyService {
    private static final org.apache.log4j.Logger log =
            Logger.getLogger(HocKyServiceImpl.class.getName());

    private IHocKyDao hocKyDao;

    public HocKyServiceImpl(){
        this.hocKyDao = new HocKyDaoImpl();
    }

    private final Date date = new Date();

    @Override
    public BaseResponse<?> findSemester(BaseRequest request) {
        try{
            if ((request.getSortOrder() == null || request.getSortOrder().isEmpty())) {
                request.setSortOrder("desc");
            }
            if(request.getSortField() == null || request.getSortField().isEmpty()){
                request.setSortField("idHk");
            }

            List<SemesterDTO> dtoList = new ArrayList<>();
            List<HocKyEntity> list = hocKyDao.findSemester(request);
            Integer totalRecords = hocKyDao.countTotalRecords(request);
            int totalPages = totalRecords!= null?(int) Math.ceil((double)
                    totalRecords / request.getPageSize()): null;

            dtoList = list.stream().map(x ->{
                try {
                    return Convert.convertEntityToDTO(x, SemesterDTO.class);
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

            return new BaseResponse.Builder<List<SemesterDTO>>()
                    .setData(dtoList).setMessage(Constant.messageSuccess)
                    .setStatus(Constant.httpStatusOk).setTotalPages(totalPages).build();

        }catch (Exception e){
            log.error(e.getCause());
            return new BaseResponse.Builder<List<SemesterDTO>>()
                    .setMessage("failed"+ e.getMessage())
                    .setStatus(Constant.httpStatusErrorServer).build();
        }

    }

    @Override
    public BaseResponse<?> findSemesterById(String id) {
        try {
            HocKyEntity hocKyEntity = hocKyDao.findById(id);
            if(hocKyEntity == null){
                return new BaseResponse.Builder<>()
                        .setMessage(Constant.messageStudentNotFound)
                        .setStatus(Constant.httpStatusErrorServer).build();
            }
            SemesterDTO semesterDTO = Convert.convertEntityToDTO(hocKyEntity, SemesterDTO.class);
            return new BaseResponse.Builder<>()
                    .setMessage(Constant.messageSuccess)
                    .setData(semesterDTO)
                    .setStatus(Constant.httpStatusOk).build();

        }catch (Exception e){
            log.error(e.getCause());
            return new BaseResponse.Builder<>()
                    .setMessage("failed"+ e.getMessage())
                    .setStatus(Constant.httpStatusErrorServer).build();
        }
    }

    @Override
    public BaseResponse<?> deleteSemester(String id) {
        try{
            hocKyDao.deleteHocKy(id);
            return new BaseResponse.Builder<List<SemesterDTO>>()
                    .setMessage("success").setStatus(200).build();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new BaseResponse.Builder<List<SemesterDTO>>()
                    .setMessage("failed"+ e.getMessage()).setStatus(500).build();
        }
    }


    @Override
    public BaseResponse<?> createOrEdit(CreateOrEditSemesterDTO semesterDTO) {
        try {
            if(semesterDTO.getStatus() != 0 && semesterDTO.getStatus() != 1){
                return new BaseResponse.Builder<>().setMessage(Constant.messageBadRequest)
                        .setStatus(Constant.httpStatusErrorServer)
                        .build();
            }

            if(semesterDTO.getStatus() ==0 && hocKyDao.existByIdAndName(semesterDTO.getIdHk(), semesterDTO.getTenHocKy())){
                return new BaseResponse.Builder<>().setMessage(Constant.messageSemesterExist)
                        .setStatus(Constant.httpStatusErrorServer)
                        .build();
            }
            HocKyEntity hocKyEntity = Convert.convertDTOToEntity(semesterDTO, HocKyEntity.class);
            hocKyEntity.setNgayTao(date.getTime());
            hocKyEntity.setNgaySua(date.getTime());

            hocKyDao.createOrEditHocKy(hocKyEntity);
            BaseResponse<HocKyEntity> baseResponse =
                    new BaseResponse.Builder<HocKyEntity>()
                            .setMessage(Constant.messageSuccess)
                            .setStatus(Constant.httpStatusOk).build();
            return baseResponse;
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
            return new BaseResponse.Builder<>().setMessage(Constant.messageBadRequest)
                    .setStatus(Constant.httpStatusErrorServer)
                    .build();
//            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            log.error(e.getMessage());
            return new BaseResponse.Builder<>().setMessage(Constant.messageBadRequest)
                    .setStatus(Constant.httpStatusErrorServer)
                    .build();
//            throw new RuntimeException(e);
        }
    }

}
