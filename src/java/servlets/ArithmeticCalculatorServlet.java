/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xavier
 */
public class ArithmeticCalculatorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("result","---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstInt = request.getParameter("firstInt");
        String secondInt = request.getParameter("secondInt");
        
        if (firstInt == null || firstInt.equals("") ||
                secondInt == null || secondInt.equals("")) {
            request.setAttribute("result","Invalid");
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
            
            return;
        }
        
        int result = 0;
        
        try{
            int parsedFirstInt = Integer.parseInt(firstInt);
            int parsedSecondInt = Integer.parseInt(secondInt);
            
            switch(request.getParameter("submit")) {
            case "+": 
                result = parsedFirstInt+parsedSecondInt;
                break;
            case "-":
                result = parsedFirstInt-parsedSecondInt;
                break;
            case "*": 
                result = parsedFirstInt*parsedSecondInt;
                break;
            case "/": 
                result = parsedFirstInt/parsedSecondInt;
                break;
        }
        } catch (NumberFormatException e) {
            request.setAttribute("result","Invalid");
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
            
            return;
        }
        
        request.setAttribute("result",result);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request,response);
    }

}
