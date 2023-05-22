package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IKhoaDao;
import com.example.quanlysv.servlet.dao.impl.KhoaDaoImpl;
import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.khoa.KhoaDTO;
import com.example.quanlysv.servlet.entity.KhoaEntity;
import com.example.quanlysv.servlet.service.IKhoaService;
import com.example.quanlysv.servlet.util.Convert;

import java.util.ArrayList;
import java.util.List;

public class KhoaServiceImpl implements IKhoaService {

    private IKhoaDao khoaDao;

    public KhoaServiceImpl(){
        khoaDao=new KhoaDaoImpl();
    }
    @Override
    public List<KhoaDTO> findKhoa(BaseRequest request) {
        List<KhoaDTO>result=new ArrayList<>();
        try{
            List<KhoaEntity>list=khoaDao.findKhoa(request);
            for(int i=0;i< list.size();i++){
                result.add(Convert.convertEntityToDTO(list.get(i), KhoaDTO.class));
            }
            return result;
        }catch (Exception e){
            return result;
        }
    }

}
