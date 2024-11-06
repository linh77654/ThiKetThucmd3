package com.example.thi_module3.service;

import com.example.thi_module3.model.PhongTro;

import java.util.List;
import java.util.Optional;

public interface IPhongTroService {
    List<PhongTro> findByIdOrTenPhongTroContainingOrSoDienThoaiContaining(
            Integer id, String tenPhongTro, String soDienThoai);

    List<PhongTro> findByTenPhongTroContaining(String tenPhongTro);

    List<PhongTro> findBySoDienThoaiContaining(String soDienThoai);

    Optional<PhongTro> findById(Integer id);

    void deleteByIdIn(List<Integer> ids);
    void add(PhongTro phongTro);

}