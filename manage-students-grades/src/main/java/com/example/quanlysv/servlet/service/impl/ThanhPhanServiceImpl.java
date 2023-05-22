package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.common.Constant;
import com.example.quanlysv.servlet.dao.IThanhPhanDao;
import com.example.quanlysv.servlet.dao.impl.ThanhPhanDaoImpl;
import com.example.quanlysv.servlet.dto.request.thanhphan.CreateThanhPhanDTO;
import com.example.quanlysv.servlet.dto.request.thanhphan.ThanhPhanDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.ThanhPhanEntity;
import com.example.quanlysv.servlet.service.ThanhPhanService;
import com.example.quanlysv.servlet.util.Convert;
import org.apache.log4j.Logger;

import java.time.Instant;

public class ThanhPhanServiceImpl implements ThanhPhanService {
    private static final org.apache.log4j.Logger log = Logger.getLogger(GradeServiceImpl.class.getName());
    private IThanhPhanDao iThanhPhanDao;
    public ThanhPhanServiceImpl(){iThanhPhanDao=new ThanhPhanDaoImpl();
    }

    @Override
    public void createThanhPhan(CreateThanhPhanDTO createThanhPhanDTO) {
        Instant currentTime = Instant.now();

        try{
            ThanhPhanEntity thanhPhanEntity = Convert.convertDTOToEntity(createThanhPhanDTO,ThanhPhanEntity.class);
            if(thanhPhanEntity != null){
                thanhPhanEntity.setNgayTao(currentTime);
                thanhPhanEntity.setNgaySua(currentTime);
                iThanhPhanDao.createOrEditThanhPhan(thanhPhanEntity);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BaseResponse<?> getThanhPhanByIdDiem(String idDiem) {
        try{
            ThanhPhanEntity thanhPhanEntity = iThanhPhanDao.getByIdDiem(idDiem);
            if(thanhPhanEntity == null){
                return new BaseResponse.Builder<>()
                        .setStatus(Constant.httpStatusErrorServer)
                        .setMessage(Constant.messageStudentNotFound).build();
            }
            ThanhPhanDTO thanhPhanDTO = Convert.convertEntityToDTO(thanhPhanEntity, ThanhPhanDTO.class);
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusOk)
                    .setData(thanhPhanDTO)
                    .setMessage(Constant.messageSuccess).build();
        }catch (Exception e){
            log.error(e.getMessage());
            return new BaseResponse.Builder<>()
                    .setStatus(Constant.httpStatusErrorServer)
                    .setMessage(Constant.messageStudentNotFound).build();
        }
    }


}
