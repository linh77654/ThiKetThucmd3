package com.example.thi_module3.service;

import com.example.thi_module3.model.PhongTro;
import com.example.thi_module3.repository.IPhongTroRepository;
import com.example.thi_module3.repository.PhongTroRepository;

import java.util.List;
import java.util.Optional;

public class PhongTroService implements IPhongTroService{
    public IPhongTroRepository phongTroRepository = new PhongTroRepository();
    @Override
    public List<PhongTro> findByIdOrTenPhongTroContainingOrSoDienThoaiContaining(Integer id, String tenPhongTro, String soDienThoai) {
        return phongTroRepository.findByIdOrTenPhongTroContainingOrSoDienThoaiContaining(id, tenPhongTro, soDienThoai);
    }

    @Override
    public List<PhongTro> findByTenPhongTroContaining(String tenPhongTro) {
        return phongTroRepository.findByTenPhongTroContaining(tenPhongTro);
    }

    @Override
    public List<PhongTro> findBySoDienThoaiContaining(String soDienThoai) {
        return phongTroRepository.findBySoDienThoaiContaining(soDienThoai);
    }

    @Override
    public Optional<PhongTro> findById(Integer id) {
        return phongTroRepository.findById(id);
    }

    @Override
    public void deleteByIdIn(List<Integer> ids) {
        phongTroRepository.deleteByIdIn(ids);
    }

    @Override
    public void add(PhongTro phongTro) {
        phongTroRepository.add(phongTro);
    }
}