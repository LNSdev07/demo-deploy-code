package com.example.quanlysv.servlet.util;

import com.example.quanlysv.servlet.common.Constant;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convert {
    public static <E, D> D convertEntityToDTO(E entity, Class<D> dtoClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        D dto = dtoClass.getDeclaredConstructor().newInstance();
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Field[] dtoFields = dtoClass.getDeclaredFields();
        for (Field entityField : entityFields) {
            entityField.setAccessible(true);
            for (Field dtoField : dtoFields) {
                dtoField.setAccessible(true);
                if (entityField.getName().equals(dtoField.getName())) {
                    if (entityField.getType() == Long.class && dtoField.getType() == String.class
                            && (entityField.getName().equals(Constant.columnCreatedDate)
                            || entityField.getName().equals(Constant.columnUpdatedDate))) {
                        String dateString = convertDateFormDbToDto(entity, entityField);
                        dtoField.set(dto, dateString);
                    } else {
                        dtoField.set(dto, entityField.get(entity));
                    }
                    break;
                }
            }
        }
        return dto;
    }

    private static <E> String convertDateFormDbToDto(E entity, Field entityField) throws IllegalAccessException {
        long timestamp = (long) entityField.get(entity);
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.dateFormat);
        String dateString = sdf.format(date);
        return dateString;
    }

    public static <E, D> E convertDTOToEntity(D dto, Class<E> entityClass) throws IllegalAccessException, InstantiationException {
        E entity = entityClass.newInstance();
        Field[] dtoFields = dto.getClass().getDeclaredFields();
        Field[] entityFields = entityClass.getDeclaredFields();
        for (Field dtoField : dtoFields) {
            dtoField.setAccessible(true);
            for (Field entityField : entityFields) {
                entityField.setAccessible(true);
                if (dtoField.getName().equals(entityField.getName())) {
                    entityField.set(entity, dtoField.get(dto));
                    break;
                }
            }
        }
        return entity;
    }

    public static Long convertDateFromDtoToDb(String date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Constant.dateFormat);
            Date date1 = null;
            date1 = sdf.parse(date);
            return date1.getTime();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
