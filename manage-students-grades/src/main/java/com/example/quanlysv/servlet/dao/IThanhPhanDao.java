package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.entity.ThanhPhanEntity;

public interface IThanhPhanDao extends IGenericDao<ThanhPhanEntity> {
    void createOrEditThanhPhan(ThanhPhanEntity thanhPhanEntity);

    ThanhPhanEntity getByIdDiem(String idDIem);
}
