package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbms.dao.*;
import dbms.model.Points;
import dbms.model.Product;
import dbms.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Phillip on 7/26/2015.
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		PrintWriter out;
		if (method.equals("getUsersGraph")) {
			Map<String, Integer> userCountCategoryWise = UserDAO
					.getUserCountCategoryWise();
			out = response.getWriter();
			JSONObject myObj = new JSONObject(userCountCategoryWise);
			JSONObject resObj = new JSONObject();
			try {
				resObj.put("userCountCategoryWiseList", myObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(resObj.toString());
			out.close();
		} else if (method.equals("getProductsGraph")) {
			Map<String, Integer> productCountCategoryWise = ProductDao
					.getProductCountCategoryWise();
			out = response.getWriter();
			JSONObject myObj = new JSONObject(productCountCategoryWise);
			JSONObject resObj = new JSONObject();
			try {
				resObj.put("productCountCategoryWiseList", myObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(resObj.toString());
			out.close();
		} else if (method.equals("getProductsSalesGraph")) {
			Map<String, Integer> orderCountCategoryWise = OrderDAO.getOrderCountCategoryWise();
			out = response.getWriter();
			JSONObject myObj = new JSONObject(orderCountCategoryWise);
			JSONObject resObj = new JSONObject();
			try {
				resObj.put("orderCountCategoryWise", myObj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println(resObj.toString());
			out.close();
		} else {

			request.setAttribute("userList", UserDAO.getAllUsers());
			request.setAttribute("categoryList",
					CategoriesDAO.getAllCategories());
			request.setAttribute("productsList", ProductDao.getAllProducts());
			request.setAttribute("pointsList", PointsDAO.getAllPoints());
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("userList", UserDAO.getAllUsers());
		request.setAttribute("categoryList", CategoriesDAO.getAllCategories());
		request.setAttribute("productsList", ProductDao.getAllProducts());
		request.setAttribute("pointsList", PointsDAO.getAllPoints());
		// request.setAttribute("productList",ProductDao.getAllProducts(0));
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);

	}

}
