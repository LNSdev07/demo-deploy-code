package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.IStudentDao;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.entity.StudentEntity;
import com.example.quanlysv.servlet.mapper.StudentMapper;

import java.util.List;

public class StudentDaoImpl extends AbstractDao<StudentEntity> implements IStudentDao {

    @Override
    public List<StudentEntity> findListStudentByIdLop(String idLop) {
        String sql="SELECT sv.id_sv as idSv, sv.ten_sv as tenSv, sv.email_sv as emailSv," +
                "sv.dob_sv as dobSv, sv.gender_sv as genderSv, sv.ngay_tao as ngayTao, " +
                "sv.ngay_sua as ngaySua,sv.phone_sv as phoneSv, sv.lop_hanh_chinh_sv as " +
                "lopHanhChinhSv from sinhvien as sv,hoc,lop where sv.id_sv = hoc.id_sv " +
                "and hoc.id_lop=lop.id_lop and hoc.id_lop=?";
        List<StudentEntity>studentEntities=findByProperties(sql,new StudentMapper(),idLop);
        return studentEntities.isEmpty()?null:studentEntities;
    }

    @Override
    public List<StudentEntity> findStudent(StudentFilter request) {
        String sql = "SELECT sv.id_sv as idSv, sv.ten_sv as tenSv, sv.email_sv as emailSv," +
                "sv.dob_sv as dobSv, sv.gender_sv as genderSv, sv.ngay_tao as ngayTao, sv.ngay_sua as ngaySua," +
                "sv.phone_sv as phoneSv, sv.lop_hanh_chinh_sv as lopHanhChinhSv, sv.trang_thai as trangThai" +
                " FROM sinhvien as sv where" +
                " lower(sv.ten_sv) like concat('%',lower(?), '%') and lower(sv.id_sv) like concat('%', lower(?), '%') ORDER BY " +
                request.getBaseRequest().getSortField() + " "+  request.getBaseRequest().getSortOrder() + " OFFSET ? LIMIT ?";

        List<StudentEntity> studentEntities = findByProperties(sql, new StudentMapper(),
                request.getTenSv(), request.getIdSv(),
                (request.getBaseRequest().getPageIndex()-1) * request.getBaseRequest().getPageSize(),
                request.getBaseRequest().getPageSize());
        return studentEntities.isEmpty() ? null : studentEntities;
    }

    @Override
    public Integer countTotalRecords(StudentFilter request) {
        String countSql = "SELECT COUNT(*) FROM sinhvien as sv where lower(sv.ten_sv) like concat('%',lower(?), '%') and lower(sv.id_sv) like concat('%', lower(?), '%')";
        Integer totalRecords = countTotalRecords(countSql, request.getTenSv(), request.getIdSv());
        return totalRecords;
    }

    @Override
    public void createOrUpdateStudent(StudentEntity studentEntity) {
        String sqlQuery = "select sv.id_sv as idSv, sv.ten_sv as tenSv, sv.email_sv as emailSv, " +
                "sv.dob_sv as dobSv, sv.gender_sv as genderSv, " +
                "sv.phone_sv as phoneSv, sv.lop_hanh_chinh_sv as lopHanhChinhSv," +
                " sv.ngay_tao as ngayTao, sv.ngay_sua as ngaySua from sinhvien as " +
                "sv where sv.id_sv = ?";
        List<StudentEntity> studentEntities = findByProperties(sqlQuery, new StudentMapper(), studentEntity.getIdSv());

        try {
            StringBuilder sql = new StringBuilder("");
            StringBuilder sql2 = new StringBuilder("");
            if(studentEntities == null || studentEntities.isEmpty()){
                sql.append("INSERT INTO sinhvien (id_sv, ten_sv, email_sv, dob_sv, gender_sv, phone_sv, lop_hanh_chinh_sv, ngay_tao, ngay_sua, trang_thai) " +
                        "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                insertOrUpdateOrDelete(sql.toString(), studentEntity.getIdSv(), studentEntity.getTenSv(), studentEntity.getEmailSv(),
                        studentEntity.getDobSv(), studentEntity.getGenderSv(), studentEntity.getPhoneSv(), studentEntity.getLopHanhChinhSv(),
                        studentEntity.getNgayTao(), studentEntity.getNgaySua(), 1
                        );
                sql2.append("INSERT INTO taikhoan (username, password, email, role_id, status_password_default) " +
                        "Values(?, ?, ?, ?, ?)");
                insertOrUpdateOrDelete(sql2.toString(), studentEntity.getIdSv(), studentEntity.getIdSv(),
                        studentEntity.getEmailSv(), 2, 0);
            }
            else{
                sql.append("UPDATE sinhvien SET ten_sv = ?, email_sv = ?, dob_sv =?, gender_sv =?, phone_sv =?, lop_hanh_chinh_sv =?, ngay_sua=? " +
                        "WHERE id_sv = ?");
                insertOrUpdateOrDelete(sql.toString(),studentEntity.getTenSv(), studentEntity.getEmailSv(),
                        studentEntity.getDobSv(), studentEntity.getGenderSv(), studentEntity.getPhoneSv(), studentEntity.getLopHanhChinhSv(),
                        studentEntity.getNgaySua(), studentEntity.getIdSv());
                sql2.append("UPDATE taikhoan SET email = ? WHERE username = ?");
                insertOrUpdateOrDelete(sql2.toString(), studentEntity.getEmailSv(), studentEntity.getIdSv());
            }


        } catch (Exception e) {
            throw new RuntimeException("create student failed: "+ e.getMessage());
        }
    }

    @Override
    public boolean existedByEmailAndIdSvAndPhone(String id, String email, String phone) {
        try {
            String sqlQuery = "select sv.id_sv as idSv, sv.ten_sv as tenSv, sv.email_sv as emailSv, " +
                    "sv.dob_sv as dobSv, sv.gender_sv as genderSv, " +
                    "sv.phone_sv as phoneSv, sv.lop_hanh_chinh_sv as" +
                    " lopHanhChinhSv, sv.ngay_tao as ngayTao, sv.ngay_sua" +
                    " as ngaySua from sinhvien as sv where sv.id_sv = ? or sv.email_sv =? or sv.phone_sv =?";
            StudentEntity student =  findOne(sqlQuery,new StudentMapper(), id, email, phone);
            if(student != null) return true;
            return false;
        }catch (Exception e){
            throw new RuntimeException("error: "+ e.getMessage());
        }
    }

    @Override
    public StudentEntity getById(String id) {
        try {
            String sqlQuery = "select sv.id_sv as idSv, sv.ten_sv as tenSv, sv.email_sv as emailSv, " +
                    "sv.dob_sv as dobSv, sv.gender_sv as genderSv, " +
                    "sv.phone_sv as phoneSv, sv.lop_hanh_chinh_sv as" +
                    " lopHanhChinhSv, sv.ngay_tao as ngayTao, sv.ngay_sua" +
                    " as ngaySua from sinhvien as sv where sv.id_sv = ?";
            StudentEntity student =  findOne(sqlQuery,new StudentMapper(), id);
            if(student != null) return student;
            return null;
        }catch (Exception e){
            throw new RuntimeException("error: "+ e.getMessage());
        }
    }

    @Override
    public void deleteStudentById(String id) {
        try{

            if(!id.trim().isEmpty()){
                String sql = "UPDATE sinhvien SET trang_thai = ? WHERE id_sv = ?";
                insertOrUpdateOrDelete(sql, 0, id.trim());
            }
        }catch (Exception e){
            throw new RuntimeException("create student failed: "+ e.getMessage());
        }
    }
}
