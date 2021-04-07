package br.edu.utfpr.weight_converter.controllers;

import br.edu.utfpr.weight_converter.services.UserService;

import java.io.*;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeController", value = "/")
public class HomeController extends HttpServlet {

    private UserService userService;

    public HomeController() {
        this.userService = new UserService();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("weight-converter-pu");
        EntityManager manager = factory.createEntityManager();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap<String, String> identity  = new HashMap<String, String>();
        identity.put("identity", request.getParameter("identity"));
        WeightConverterController.identity = request.getParameter("identity");

        boolean res = this.userService.saveUser(identity);
        if(res) {
            request.setAttribute("identity", identity.get("identity"));
            response.sendRedirect(request.getContextPath() + "/converter");
        } else {
            request.setAttribute("message", "A identificação é obrigatória.");
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        }
    }

    public void destroy() { }
}