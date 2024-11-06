package com.example.thi_module3.controller;

import com.example.thi_module3.model.PhongTro;
import com.example.thi_module3.service.IPhongTroService;
import com.example.thi_module3.service.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/phongtro")
public class PhongTroController extends HttpServlet {

    private IPhongTroService phongTroService = new PhongTroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "list":
                listPhongTro(request, response);
                break;
            case "view":
                viewPhongTro(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/phongtro?action=list");
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/phongtro/add.jsp").forward(request, response);
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenPhongTro = request.getParameter("tenPhongTro");
        String soDienThoai = request.getParameter("soDienThoai");

        // Handle id being optional, return null if not present
        Integer id = null;
        try {
            if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                id = Integer.parseInt(request.getParameter("id"));
            }
        } catch (NumberFormatException e) {
        }

        List<PhongTro> phongTroList = phongTroService.findByIdOrTenPhongTroContainingOrSoDienThoaiContaining(id, tenPhongTro, soDienThoai);

        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("/phongtro/list.jsp").forward(request, response);
    }

    private void viewPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        phongTroService.findById(id).ifPresent(phongTro -> {
            request.setAttribute("phongTro", phongTro);
            try {
                request.getRequestDispatcher("/phongtro/view.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action != null ? action : "") {
            case "delete":
                deletePhongTro(request, response);
                break;
            case "add":
                addPhongTro(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/phongtro?action=list");
                break;
        }
    }

    private void addPhongTro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tenPhongTro = request.getParameter("tenPhongTro");
        String soDienThoai = request.getParameter("soDienThoai");
        String ngayBatDauStr = request.getParameter("ngayBatDau");
        String hinhThucThanhToan = request.getParameter("hinhThucThanhToan");
        String ghiChu = request.getParameter("ghiChu");

        if (tenPhongTro == null || soDienThoai == null || ngayBatDauStr == null || hinhThucThanhToan == null) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("/phongtro/add.jsp").forward(request, response);
            return;
        }

        PhongTro newPhongTro = new PhongTro();
        newPhongTro.setTenPhongTro(tenPhongTro);
        newPhongTro.setSoDienThoai(soDienThoai);
        newPhongTro.setNgayBatDau(java.sql.Date.valueOf(ngayBatDauStr));
        newPhongTro.setHinhThucThanhToan(hinhThucThanhToan);
        newPhongTro.setGhiChu(ghiChu);

        phongTroService.add(newPhongTro);

        response.sendRedirect(request.getContextPath() + "/phongtro?action=list");
    }

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] idsParam = request.getParameterValues("ids");
        if (idsParam != null && idsParam.length > 0) {
            List<Integer> ids = new ArrayList<>();
            for (String id : idsParam) {
                ids.add(Integer.parseInt(id));
            }
            phongTroService.deleteByIdIn(ids);
        }
        response.sendRedirect(request.getContextPath() + "/phongtro?action=list");
    }
}