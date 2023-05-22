package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.ITeacherDao;
import com.example.quanlysv.servlet.dto.request.teacher.TeacherFilter;
import com.example.quanlysv.servlet.entity.TeacherEntity;
import com.example.quanlysv.servlet.mapper.TeacherMapper;

import java.time.Instant;
import java.util.List;

public class TeacherDaoImpl extends AbstractDao<TeacherEntity> implements ITeacherDao {

    @Override
    public TeacherEntity getById(String id) {
        try{
            String sql="select gv.id_gv as idGv,gv.ten_gv as tenGv,gv.sdt_gv as sdtGv," +
                    "gv.email_gv as emailGv, gv.gender_gv as genderGv, gv.id_khoa as idKhoa," +
                    "gv.ngay_tao as ngayTao, gv.ngay_sua as ngaySua from giangvien as gv where gv.id_gv=?";
            TeacherEntity teacher = findOne(sql,new TeacherMapper(),id);
            if(teacher != null) return teacher;
            return null;
        }catch (Exception e){
            throw new RuntimeException("error: "+ e.getMessage());
        }
    }

    @Override
    public boolean existedByIdOrEmailOrPhone(String id, String email, String phoneNum) {
        try {
            String sql = "select gv.id_gv as idGv,gv.ten_gv as tenGv,gv.sdt_gv as sdtGv," +
                    "gv.email_gv as emailGv, gv.gender_gv as genderGv, gv.id_khoa as idKhoa," +
                    "gv.ngay_tao as ngayTao, gv.ngay_sua as ngaySua from giangvien as gv where gv.id_gv=? " +
                    "or gv.email_gv=? or gv.sdt_gv=?";
            TeacherEntity teacher =  findOne(sql,new TeacherMapper(), id, email, phoneNum);
            if(teacher != null) return true;
            return false;
        }catch (Exception e){
            throw new RuntimeException("error: "+ e.getMessage());
        }
    }

    @Override
    public List<TeacherEntity> findTeacher(TeacherFilter request) {
        String sql="select gv.id_gv as idGv,gv.ten_gv as tenGv,gv.sdt_gv as sdtGv," +
                "gv.email_gv as emailGv, gv.gender_gv as genderGv, gv.id_khoa as idKhoa, gv.trang_thai as trangThai, " +
                "gv.ngay_tao as ngayTao, gv.ngay_sua as ngaySua from giangvien as gv where " +
                "lower(gv.ten_gv) like concat('%',lower(?), '%') ORDER BY " +
                request.getBaseRequest().getSortField() + " "+  request.getBaseRequest().getSortOrder() + " OFFSET ? LIMIT ?";

        List<TeacherEntity> list = findByProperties(sql, new TeacherMapper(),
                request.getTenGv(),
                (request.getBaseRequest().getPageIndex()-1) * request.getBaseRequest().getPageSize(),
                request.getBaseRequest().getPageSize());

        return list.isEmpty() ? null : list;
    }

    @Override
    public Integer countTotalRecords(TeacherFilter request) {
        String countSql = "SELECT COUNT(*) FROM giangvien as gv where lower(gv.ten_gv) like concat('%',lower(?), '%')";
        Integer totalRecords = countTotalRecords(countSql, request.getTenGv());
        return totalRecords;
    }

    @Override
    public void createOrEditTeacher(TeacherEntity teacherEntity) {
        String sqlQuery="select gv.id_gv as idGv,gv.ten_gv as tenGv,gv.sdt_gv as sdtGv," +
                " gv.email_gv as emailGv, gv.gender_gv as genderGv, gv.id_khoa as idKhoa," +
                " gv.ngay_tao as ngayTao, gv.ngay_sua as ngaySua from giangvien as gv" +
                " where gv.id_gv=?";
        List<TeacherEntity>teacherEntities=findByProperties(sqlQuery,new TeacherMapper(),teacherEntity.getIdGv());
        try{
            StringBuilder sql = new StringBuilder("");
            if(teacherEntities==null||teacherEntities.isEmpty()){
                Instant instant = Instant.now();
                teacherEntity.setNgayTao(instant);
                sql.append("insert into giangvien (id_gv, ten_gv, sdt_gv, email_gv," +
                "gender_gv, id_khoa, ngay_tao, ngay_sua, trang_thai) values(?,?,?,?,?,?,?,?,?)");
                insertOrUpdateOrDelete(sql.toString(),teacherEntity.getIdGv(),teacherEntity.getTenGv(),
                teacherEntity.getSdtGv(),teacherEntity.getEmailGv(),teacherEntity.getGenderGv(),
                teacherEntity.getIdKhoa(),teacherEntity.getNgayTao(),teacherEntity.getNgayTao(), 1
                );
            }
            else{
                Instant instant = Instant.now();
                teacherEntity.setNgaySua(instant);
                sql.append("UPDATE giangvien SET ten_gv = ?,sdt_gv = ?," +
                        "email_gv = ?,gender_gv = ?,id_khoa = ?,ngay_sua=? " +
                "WHERE id_gv=? ");
                insertOrUpdateOrDelete(sql.toString(),teacherEntity.getTenGv(),
                        teacherEntity.getSdtGv(),teacherEntity.getEmailGv(),
                        teacherEntity.getGenderGv(),teacherEntity.getIdKhoa(),
                        teacherEntity.getNgaySua(),teacherEntity.getIdGv()
                );

            }
        }catch (Exception e){
            throw new RuntimeException("update teacher failed: "+ e.getMessage());
        }
    }



    @Override
    public void deleteTeacher(String id) {
        try{
            String sqlQuery="SELECT * FROM giangvien as gv where gv.id_gv=?";
            List<TeacherEntity>teacherEntities = findByProperties(sqlQuery,new TeacherMapper(),id.trim());
            if (teacherEntities!=null){
                String sql="UPDATE giangvien SET trang_thai = ? WHERE id_gv=?";
                insertOrUpdateOrDelete(sql, 0, id.trim());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
