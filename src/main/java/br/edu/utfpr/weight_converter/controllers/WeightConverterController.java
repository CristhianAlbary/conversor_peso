package br.edu.utfpr.weight_converter.controllers;

import br.edu.utfpr.weight_converter.models.domain.User;
import br.edu.utfpr.weight_converter.services.ConverterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "weightConverterController", value = "/converter")
public class WeightConverterController extends HttpServlet {

    public static String identity;
    private ConverterService converterService;
    List<String> convertions = new ArrayList<String>();

    public WeightConverterController() {
        this.converterService = new ConverterService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.convertions = converterService.getLastConvertions();
        request.setAttribute("convertions", this.convertions);
        request.getRequestDispatcher("WEB-INF/view/weightConverter.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, String> weightForm  = new HashMap<String, String>();
        weightForm.put("identity", WeightConverterController.identity);
        weightForm.put("for", request.getParameter("for"));
        weightForm.put("to", request.getParameter("to"));
        weightForm.put("value", request.getParameter("convertValue"));

        String result = this.converterService.convertValue(weightForm);

        response.sendRedirect(request.getContextPath() + "/converter");
    }

    public void destroy() {
    }
}