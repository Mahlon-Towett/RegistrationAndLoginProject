/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mvc.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
import java.util.logging.Logger;

/**
 *
 * @author mahlo
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
 public RegisterServlet() {
     }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            try {
                //Copying all the input parameters in to local variables
                LOG.info("Incomming request>>>>>>>>>>>>>>>>>>");
                response.setContentType("text/html;charset=UTF-8");
               //Copying all the input parameters in to local 
               String userName = request.getParameter("username");
               String password = request.getParameter("password");
                 String fullName = request.getParameter("fullname");
                 String email = request.getParameter("email");



                 RegisterBean registerBean;
             registerBean = new RegisterBean();
                
                 registerBean.setFullName(fullName);
                 registerBean.setEmail(email);
                 registerBean.setUserName(userName);
                 registerBean.setPassword(password); 

                 RegisterDao registerDao = new RegisterDao();

              
                 String userRegistered = registerDao.registerUser(registerBean);

                 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
                 {
                     LOG.info("Loging successfull!!!!");
                     LOG.info("Redirecting to home page");
                     request.getRequestDispatcher("/RegHome.jsp").forward(request, response);
                 }
                 else            {
                     LOG.severe("Error occurred while trying to register!!!!!!!!");
                     request.setAttribute("errMessage", userRegistered); //On Failure, display a meaningful message to the User.
                     request.getRequestDispatcher("/Register.jsp").forward(request, response);
                 } 
            } catch(Exception e){
                e.printStackTrace(System.out);
                request.setAttribute("errMessage", e.getMessage()); //On Failure, display a meaningful message to the User.
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            }         
    }
    private static final Logger LOG = Logger.getLogger(RegisterServlet.class.getName());
}
   