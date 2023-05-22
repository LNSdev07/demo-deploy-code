package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.IHocKyDao;
import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.entity.HocKyEntity;
import com.example.quanlysv.servlet.mapper.HocKyMapper;

import java.util.List;

public class HocKyDaoImpl extends AbstractDao<HocKyEntity> implements IHocKyDao {
    @Override
    public List<HocKyEntity> findSemester(BaseRequest request) {

        try{
            String sql = "select hk.id_hk as idHk, hk.ten_hoc_ky " +
                    "as tenHocKy, hk.ngay_tao as ngayTao, hk.ngay_sua as ngaySua " +
                    "from hocky as hk ORDER BY " +
                    request.getSortField() + " "+  request.getSortOrder() + " OFFSET ? LIMIT ?";

            List<HocKyEntity> list = findByProperties(sql, new HocKyMapper(),
                    (request.getPageIndex()-1) * request.getPageSize(), request.getPageSize());


            return list.isEmpty()? null: list;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer countTotalRecords(BaseRequest request) {
        String countSql = "SELECT COUNT(*) FROM hocky";
        Integer totalRecords = countTotalRecords(countSql);
        return totalRecords;
    }

    @Override
    public HocKyEntity findById(String id) {
        try {
            String sql = "select hk.id_hk as idHk, hk.ten_hoc_ky " +
                    "as tenHocKy, hk.ngay_tao as ngayTao, hk.ngay_sua as ngaySua " +
                    "from hocky as hk where hk.id_hk = ?";
            HocKyEntity hocKyEntity = findOne(sql, new HocKyMapper(), id);
            return hocKyEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean existByIdAndName(String id, String name) {
        try {
            String sql = "select hk.id_hk as idHk, hk.ten_hoc_ky " +
                    "as tenHocKy, hk.ngay_tao as ngayTao, hk.ngay_sua as ngaySua " +
                    "from hocky as hk where hk.id_hk = ? or hk.ten_hoc_ky = ?";
            HocKyEntity hocKyEntity = findOne(sql, new HocKyMapper(), id, name);
            return hocKyEntity==null? false:true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteHocKy(String id) {
        try {
            String sqlQuery = "select hk.id_hk as idHk, hk.ten_hoc_ky as tenHocKy " +
                    "from hocky as hk where hk.id_hk =?";
            List<HocKyEntity> list = findByProperties(sqlQuery, new HocKyMapper(), id.trim());
            if(list != null){
                String sql = "delete from hocky where id_hk = ?";
                insertOrUpdateOrDelete(sql, id.trim());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createOrEditHocKy(HocKyEntity hocKyEntity) {
          try{
              if(hocKyEntity != null){
                  HocKyEntity hocKyEntity1 = findById(hocKyEntity.getIdHk());
                  StringBuilder sql = new StringBuilder("");

                  if(hocKyEntity1 == null ){
                      sql.append("insert into hocky(id_hk, ten_hoc_ky, ngay_tao, ngay_sua) values(?, ?, ?, ?)");
                      insertOrUpdateOrDelete(sql.toString(), hocKyEntity.getIdHk(), hocKyEntity.getTenHocKy(),
                              hocKyEntity.getNgayTao(), hocKyEntity.getNgaySua());
                  }
                  else{
                      sql.append("update hocky set ten_hoc_ky = ?, ngay_sua =? where id_hk = ?");
                      insertOrUpdateOrDelete(sql.toString(), hocKyEntity.getTenHocKy(),
                              hocKyEntity.getNgaySua(), hocKyEntity.getIdHk());
                  }
              }
          }catch (Exception e){
              throw new RuntimeException("failed: "+ e.getMessage());
          }
    }
}
