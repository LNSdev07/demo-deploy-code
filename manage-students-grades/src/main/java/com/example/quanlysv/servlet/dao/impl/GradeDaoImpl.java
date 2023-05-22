package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.IGradeDao;
import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.diem.GradeFilter;
import com.example.quanlysv.servlet.entity.GradeEntity;
import com.example.quanlysv.servlet.entity.SubjectEntity;
import com.example.quanlysv.servlet.mapper.GradeMapper;
import com.example.quanlysv.servlet.mapper.SubjectMapper;

import java.time.Instant;
import java.util.List;
/*


                "SELECT id_diem as idDiem," +
                "diem_cc as diemCc, diem_bt as diemBt, diem_thi as diemThi, diem_kt as diemKt," +
                "id_gv as idGv, id_mh as idMh, id_sv as idSv, id_hk as idHk," +
                "ngay_tao as ngayTao, ngay_sua as ngaySua ";
*/

public class GradeDaoImpl extends AbstractDao<GradeEntity> implements IGradeDao {

    @Override
    public void createOrUpdateGrade(GradeEntity gradeEntity) {
//        String sqlQuery="SELECT diem.id_diem as idDiem, " +
//                "diem.diem_cc as diemCc, diem.diem_bt as diemBt, diem.diem_thi as diemThi, diem.diem_kt as diemKt, " +
//                "diem.id_gv as idGv, diem.id_mh as idMh, diem.id_sv as idSv, diem.id_hk as idHk, " +
//                "diem.ngay_tao as ngayTao, diem.ngay_sua as ngaySua FROM diem WHERE diem.id_diem =? ";
//        List<GradeEntity> list = findByProperties(sqlQuery, new GradeMapper(), gradeEntity.getIdDiem());

        try{
            String sql = "INSERT INTO public.diem(" +
                    "id_diem," +
                    " diem_cc, diem_bt, diem_thi, diem_kt," +
                    " id_gv, id_mh, id_sv, id_hk,id_lop," +
                    " ngay_tao, ngay_sua)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            insertOrUpdateOrDelete(sql,gradeEntity.getIdDiem(),
                    gradeEntity.getDiemCc(),gradeEntity.getDiemBt(),
                    gradeEntity.getDiemThi(),gradeEntity.getDiemKt(),
                    gradeEntity.getIdGv(),gradeEntity.getIdMh(),gradeEntity.getIdSv(),gradeEntity.getIdHk(),gradeEntity.getIdLop(),
                    gradeEntity.getNgayTao(),gradeEntity.getNgaySua()
            );
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("failed: "+ e.getMessage());
        }
    }

    @Override
    public void nhapDiem(GradeEntity gradeEntity) {
        String sqlQuery="INSERT INTO public.diem(id_diem," +
                "diem_cc, diem_bt, diem_thi, diem_kt," +
                "id_gv, id_mh, id_sv, id_hk," +
                "ngay_tao, ngay_sua)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Instant instant = Instant.now();
            gradeEntity.setNgayTao(instant);

//
//            System.out.println(gradeEntity.getIdDiem()+" "+
//                    gradeEntity.getDiemCc()+" "+gradeEntity.getDiemBt()+" "+
//                    gradeEntity.getDiemThi()+" "+gradeEntity.getDiemKt()+" "+
//                    gradeEntity.getIdGv()+" "+gradeEntity.getIdMh()+" "+gradeEntity.getIdSv()+" "+gradeEntity.getIdHk()+" "+
//                    gradeEntity.getNgayTao()+" "+gradeEntity.getNgaySua());
            System.out.println(gradeEntity.getDiemCc()+" "+gradeEntity.getDiemCc().getClass());
            insertOrUpdateOrDelete(sqlQuery,gradeEntity.getIdDiem(),
                    gradeEntity.getDiemCc(),gradeEntity.getDiemBt(),
                    gradeEntity.getDiemThi(),gradeEntity.getDiemKt(),
                    gradeEntity.getIdGv(),gradeEntity.getIdMh(),gradeEntity.getIdSv(),gradeEntity.getIdHk(),
                    gradeEntity.getNgayTao(),gradeEntity.getNgaySua()
            );
        }catch (Exception e){
            throw new RuntimeException("insert grade failed: "+ e.getMessage());
        }
    }

    @Override
    public List<GradeEntity> findDiem(BaseRequest request,String idLop) {
        try {
            String sql="SELECT diem.id_diem as idDiem, " +
                    "diem.diem_cc as diemCc, diem.diem_bt as diemBt, diem.diem_thi as diemThi, diem.diem_kt as diemKt, " +
                    "diem.id_gv as idGv, diem.id_mh as idMh, diem.id_sv as idSv, diem.id_hk as idHk, " +
                    "diem.ngay_tao as ngayTao, diem.ngay_sua as ngaySua FROM diem WHERE id_lop=? ORDER BY "+
                    request.getSortField() + " "+  request.getSortOrder() + " OFFSET ? LIMIT ?";

            List<GradeEntity> list = findByProperties(sql, new GradeMapper(),idLop,
                    request.getPageIndex() * request.getPageSize(), request.getPageSize());
            System.out.println(list);
            return list.isEmpty()?null:list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<GradeEntity> viewGradeByIdLop(GradeFilter request) {
    String sql="SELECT diem.id_diem as idDiem, " +
                    "diem.diem_cc as diemCc, diem.diem_bt as diemBt, diem.diem_thi as diemThi, diem.diem_kt as diemKt, " +
                    "diem.id_gv as idGv, diem.id_mh as idMh, diem.id_sv as idSv, diem.id_hk as idHk,diem.id_lop as idLop," +
                    "diem.ngay_tao as ngayTao, diem.ngay_sua as ngaySua FROM diem WHERE diem.id_lop= ?  ORDER BY "+
            request.getBaseRequest().getSortField() + " "+  request.getBaseRequest().getSortOrder()  + " OFFSET ? LIMIT ?";

        List<GradeEntity> gradeEntities = findByProperties(sql,new GradeMapper(),
                request.getIdLop(),
                (request.getBaseRequest().getPageIndex()-1) * request.getBaseRequest().getPageSize(),
                request.getBaseRequest().getPageSize());
        return gradeEntities.isEmpty() ? null : gradeEntities;
    }


    @Override
    public Integer countTotalRecords(GradeFilter request) {
        String countSql= "SELECT COUNT(*) FROM diem where diem.id_lop=?";
        Integer totalRecords=countTotalRecords(countSql,request.getIdLop());
        return totalRecords;
    }
}