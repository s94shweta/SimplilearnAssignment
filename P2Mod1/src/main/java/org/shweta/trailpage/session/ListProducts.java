package org.shweta.trailpage.session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
//import javax.xml.bind.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import org.shweta.trailpage.bean.MyIntro;
import org.shweta.trailpage.session.HibernateUtil;

/**
* Servlet implementation class ListProducts
*/
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
        
        
    /**
* @see HttpServlet#HttpServlet()
*/
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                 try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        
                        Session session = factory.openSession();
                        // using HQL
                        List<MyIntro> list = session.createQuery("from MyIntro").list();
                        
                        session.close();
                        
                         PrintWriter out = response.getWriter();
                         out.println("<html><body>");
                         out.println("<b>Product Listing</b><br>");
                         for(MyIntro p: list) {
                                 out.println("ID: " + String.valueOf(p.getId()) + ", Name: " + p.getName() +
                                                 ", Email: " + p.getEmail() + ", Place: " + p.getPlace() + "<br>");
                         }
                         
                     out.println("</body></html>");
                     
                     
                 } catch (Exception ex) {
                         return;
                 }
                    
        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}