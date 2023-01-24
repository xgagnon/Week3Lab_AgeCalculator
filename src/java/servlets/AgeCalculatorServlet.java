/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xavier
 */
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("result","---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String age = request.getParameter("age");
        
        request.setAttribute("age", age);
        
        if (age == null || age.equals("")) {
            request.setAttribute("submitMsg","You must give your current age");
            
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request,response);
            
            return;
        }
        
        try{
            int parsedAge = Integer.parseInt(age);
            request.setAttribute("submitMsg","Your age next birthday wil be " + (parsedAge+1));
        } catch (NumberFormatException e) {
            request.setAttribute("submitMsg","You must enter a number");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request,response);
    }

}
