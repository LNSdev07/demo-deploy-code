package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IGradeDao;
import com.example.quanlysv.servlet.dao.impl.GradeDaoImpl;
import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.diem.CreateOrEditGradeDTO;
import com.example.quanlysv.servlet.dto.request.diem.GradeDTO;
import com.example.quanlysv.servlet.dto.request.diem.GradeFilter;
import com.example.quanlysv.servlet.dto.request.student.StudentDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.GradeEntity;
import com.example.quanlysv.servlet.service.IGradeService;
import com.example.quanlysv.servlet.util.Convert;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements IGradeService {
    private static final org.apache.log4j.Logger log = Logger.getLogger(GradeServiceImpl.class.getName());

    private IGradeDao gradeDao;
    public GradeServiceImpl(){gradeDao=new GradeDaoImpl();}

    @Override
    public void createOrUpdateGrade(CreateOrEditGradeDTO createOrEditGradeDTO) {
        try{
            GradeEntity gradeEntity = Convert.convertDTOToEntity(createOrEditGradeDTO, GradeEntity.class);
            if(gradeEntity != null){
                gradeDao.createOrUpdateGrade(gradeEntity);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BaseResponse<?> nhapDiem(GradeEntity gradeEntity) {
        try{
            gradeDao.nhapDiem(gradeEntity);
            BaseResponse<GradeEntity>baseResponse=
                    new BaseResponse.Builder<GradeEntity>()
                            .setMessage("success")
                            .setStatus(200)
                            .build();
            return baseResponse;
        }catch (Exception e){
            return new BaseResponse.Builder<List<CreateOrEditGradeDTO>>()
                    .setMessage("failed"+ e.getMessage()).setStatus(500).build();
        }
    }

    @Override
    public BaseResponse<?> getGrade(BaseRequest request,String idLop) {
        try{
            if ((request.getSortOrder() == null || request.getSortOrder().isEmpty())) {
                request.setSortOrder("asc");
            }
            if(request.getSortField() == null || request.getSortField().isEmpty()){
                request.setSortField("id_diem");
            }
            List<GradeDTO> dtoList=new ArrayList<>();
            List<GradeEntity> list=gradeDao.findDiem(request,idLop);
            for(int i=0;i<list.size();i++){
                dtoList.add(Convert.convertEntityToDTO(list.get(i),GradeDTO.class));
            }

            return new BaseResponse.Builder<List<GradeDTO>>()
                    .setData(dtoList).setMessage("success").setStatus(200).build();
        } catch (Exception e) {
            return new BaseResponse.Builder<List<CreateOrEditGradeDTO>>()
                    .setMessage("failed"+ e.getMessage()).setStatus(500).build();
        }
    }

    @Override
    public BaseResponse<?> viewGradeByIdLop(GradeFilter request) {
        List<GradeDTO> dtoList = new ArrayList<>();
        try{

            if (request.getBaseRequest().getSortOrder().isEmpty()) {
                request.getBaseRequest().setSortOrder("asc");
            }
            if(request.getBaseRequest().getSortField().isEmpty()){
                request.getBaseRequest().setSortField("id_sv");
            }

            List<GradeEntity>list = gradeDao.viewGradeByIdLop(request);
            Integer totalRecords = gradeDao.countTotalRecords(request);
            int totalPages = totalRecords!= null?(int) Math.ceil((double)
                    totalRecords / request.getBaseRequest().getPageSize()): null;

            for(int i=0;i<list.size();i++){
                dtoList.add(Convert.convertEntityToDTO(list.get(i),GradeDTO.class));
            }

            return new BaseResponse.Builder<List<GradeDTO>>().setMessage("success")
                    .setStatus(200).setData(dtoList).setTotalPages(totalPages).build();
        }catch (Exception e){
            return new BaseResponse.Builder<List<StudentDTO>>().setMessage("failed => "+e.getMessage())
                    .setStatus(500).build();
        }
    }



}

    //    @Override
//    public BaseResponse<?> nhapDiem(CreateOrEditGradeDTO gradeDTO) {
//        try{
//            GradeEntity gradeEntity = Convert.convertDTOToEntity(gradeDTO,GradeEntity.class);
//            gradeDao.nhapDiem(gradeEntity);
//            BaseResponse<GradeEntity>baseResponse=
//                    new BaseResponse.Builder<GradeEntity>()
//                            .setMessage("success")
//                            .setStatus(200)
//                            .build();
//            return baseResponse;
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        }
//    }
