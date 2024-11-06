package com.example.thi_module3.repository;

import com.example.thi_module3.model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhongTroRepository implements IPhongTroRepository {

    private Connection getConnection() {
        return BaseRepository.getConnectDB();
    }

    @Override
    public List<PhongTro> findByIdOrTenPhongTroContainingOrSoDienThoaiContaining(Integer id, String tenPhongTro, String soDienThoai) {
        List<PhongTro> phongTroList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM phong_tro WHERE 1=1");

        if (id != null) {
            sql.append(" AND id = ?");
        }
        if (tenPhongTro != null && !tenPhongTro.isEmpty()) {
            sql.append(" AND ten_nguoi_thue LIKE ?");
        }
        if (soDienThoai != null && !soDienThoai.isEmpty()) {
            sql.append(" AND so_dien_thoai LIKE ?");
        }

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql.toString())) {

            int parameterIndex = 1;

            if (id != null) {
                ps.setInt(parameterIndex++, id);
            }
            if (tenPhongTro != null && !tenPhongTro.isEmpty()) {
                ps.setString(parameterIndex++, "%" + tenPhongTro + "%");
            }
            if (soDienThoai != null && !soDienThoai.isEmpty()) {
                ps.setString(parameterIndex++, "%" + soDienThoai + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhongTro phongTro = new PhongTro();
                phongTro.setId(rs.getInt("id"));
                phongTro.setTenPhongTro(rs.getString("ten_nguoi_thue"));
                phongTro.setSoDienThoai(rs.getString("so_dien_thoai"));
                phongTro.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                phongTro.setHinhThucThanhToan(rs.getString("hinh_thuc_thanh_toan"));
                phongTro.setGhiChu(rs.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongTroList;
    }

    @Override
    public List<PhongTro> findByTenPhongTroContaining(String tenPhongTro) {
        List<PhongTro> phongTroList = new ArrayList<>();
        String sql = "SELECT * FROM phong_tro WHERE ten_nguoi_thue LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + tenPhongTro + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhongTro phongTro = new PhongTro();
                phongTro.setId(rs.getInt("id"));
                phongTro.setTenPhongTro(rs.getString("ten_nguoi_thue"));
                phongTro.setSoDienThoai(rs.getString("so_dien_thoai"));
                phongTro.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                phongTro.setHinhThucThanhToan(rs.getString("hinh_thuc_thanh_toan"));
                phongTro.setGhiChu(rs.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongTroList;
    }

    @Override
    public List<PhongTro> findBySoDienThoaiContaining(String soDienThoai) {
        List<PhongTro> phongTroList = new ArrayList<>();
        String sql = "SELECT * FROM phong_tro WHERE so_dien_thoai LIKE ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + soDienThoai + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhongTro phongTro = new PhongTro();
                phongTro.setId(rs.getInt("id"));
                phongTro.setTenPhongTro(rs.getString("ten_nguoi_thue"));
                phongTro.setSoDienThoai(rs.getString("so_dien_thoai"));
                phongTro.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                phongTro.setHinhThucThanhToan(rs.getString("hinh_thuc_thanh_toan"));
                phongTro.setGhiChu(rs.getString("ghi_chu"));
                phongTroList.add(phongTro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongTroList;
    }

    @Override
    public Optional<PhongTro> findById(Integer id) {
        Optional<PhongTro> phongTro = Optional.empty();
        String sql = "SELECT * FROM phong_tro WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                phongTro = Optional.of(new PhongTro());
                phongTro.get().setId(rs.getInt("id"));
                phongTro.get().setTenPhongTro(rs.getString("ten_nguoi_thue"));
                phongTro.get().setSoDienThoai(rs.getString("so_dien_thoai"));
                phongTro.get().setNgayBatDau(rs.getDate("ngay_bat_dau"));
                phongTro.get().setHinhThucThanhToan(rs.getString("hinh_thuc_thanh_toan"));
                phongTro.get().setGhiChu(rs.getString("ghi_chu"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phongTro;
    }

    @Override
    public void deleteByIdIn(List<Integer> ids) {
        String sql = "DELETE FROM phong_tro WHERE id IN (?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            String idsStr = String.join(",", ids.stream().map(String::valueOf).toArray(String[]::new));
            ps.setString(1, idsStr);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(PhongTro phongTro) {
        String sql = "INSERT INTO phong_tro (ten_nguoi_thue, so_dien_thoai, ngay_bat_dau, hinh_thuc_thanh_toan, ghi_chu) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, phongTro.getTenPhongTro());
            ps.setString(2, phongTro.getSoDienThoai());
            ps.setDate(3, new java.sql.Date(phongTro.getNgayBatDau().getTime()));
            ps.setString(4, phongTro.getHinhThucThanhToan());
            ps.setString(5, phongTro.getGhiChu());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        phongTro.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}