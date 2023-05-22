package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.IThanhPhanDao;
import com.example.quanlysv.servlet.entity.ThanhPhanEntity;
import com.example.quanlysv.servlet.mapper.ThanhPhanMapper;

public class ThanhPhanDaoImpl extends AbstractDao<ThanhPhanEntity> implements IThanhPhanDao {
    @Override
    public void createOrEditThanhPhan(ThanhPhanEntity thanhPhanEntity) {
        try{
            String sql="INSERT INTO public.thanhphan(" +
                    " id_tp, id_diem, chuyen_can, bai_tap, thi, kiem_tra, ngay_tao, ngay_sua)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            insertOrUpdateOrDelete(sql,thanhPhanEntity.getIdDiem(),
                    thanhPhanEntity.getIdDiem(),thanhPhanEntity.getDiemCc(),
                    thanhPhanEntity.getDiemBt(),thanhPhanEntity.getDiemThi(),
                    thanhPhanEntity.getDiemKt(),thanhPhanEntity.getNgayTao(),
                    thanhPhanEntity.getNgaySua());
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("failed: "+ e.getMessage());
        }
    }

    @Override
    public ThanhPhanEntity getByIdDiem(String idDIem) {
        try{
            String sqlQuery="SELECT tp.id_tp as idTp, tp.id_diem as idDiem, tp.chuyen_can as diemCc," +
                    " tp.bai_tap as diemBt, tp.thi as diemThi, tp.kiem_tra as diemKt," +
                    " tp.ngay_tao as ngayTao, tp.ngay_sua as ngaySua" +
                    " FROM thanhphan as tp where tp.id_diem=?";
            ThanhPhanEntity thanhPhanEntity = findOne(sqlQuery,new ThanhPhanMapper(),idDIem);
            if(thanhPhanEntity != null) return thanhPhanEntity;
            return null;
        }catch (Exception e){
            throw new RuntimeException("error: "+ e.getMessage());
        }
    }
}
