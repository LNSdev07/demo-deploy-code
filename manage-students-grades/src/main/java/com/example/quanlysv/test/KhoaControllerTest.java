package com.example.quanlysv.test;

import com.example.quanlysv.servlet.controller.khoa.DisplayKhoaController;
import com.example.quanlysv.servlet.dto.request.khoa.KhoaDTO;
import com.example.quanlysv.servlet.service.IKhoaService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class KhoaControllerTest {
    @Mock
    private IKhoaService khoaMock;

    @InjectMocks
    private DisplayKhoaController controller;

    @BeforeClass
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindKhoa(){

        List<KhoaDTO> actualKhoa=controller.findKhoa();

        actualKhoa.stream().forEach(x->{
            System.out.println(x.toString());
        });

    }

}
