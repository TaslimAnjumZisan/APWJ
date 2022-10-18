package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private DataSource dataSource;

    public HomeController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1>Hello Java<h1>");
    }

    @RequestMapping("/greet")
    public String greet() {
        return "home";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("name", "Mir Md Kawsur");
        return "welcome";
    }

    @RequestMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @RequestMapping("/calculate")
    public String result(@ModelAttribute("firstnumber") String firstnum,@ModelAttribute("operator") String operation, @ModelAttribute("lastnumber") String lastnum, Model model) throws SQLException {
        int i=Integer.parseInt(firstnum);

        int j=Integer.parseInt(lastnum);
        int sum=i+j;
        model.addAttribute("firstnum", firstnum);
        model.addAttribute("operation", operation);
        model.addAttribute("lastnum", lastnum);
        model.addAttribute("sum", sum);
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into calculator (firstnum, lastnum, operator, sum) values (?, ?, ?, ?)");

            statement.setString(1, firstnum);
            statement.setString(2, lastnum);
            statement.setString(3, operation);
            statement.setString(4, String.valueOf(sum));

            statement.execute();

        return "calculator";
    }

    @RequestMapping("/register-form")
    public String registrationForm() {
        return "registration";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Registration Page: " + request.getParameter("username"));
        return "registration";
    }

    @RequestMapping("/register/v2")
    public String registerTwo(@ModelAttribute("firstname") String firstname, @ModelAttribute("lastname") String lastname, Model model) {
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        return "welcome";
    }

    @RequestMapping("/data")
    public void getData() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()) {
            System.out.println(resultSet.getLong(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }

    }

    @RequestMapping("/data/create")
    public void createData() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into users (email, password) values (?, ?)");
        statement.setString(1, "test2@aiub.edu");
        statement.setString(2, "789");
        statement.execute();
    }

    @RequestMapping("/data/update")
    public void createUpdate() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update users set email = ?, password = ? where id = ?");
        statement.setString(1, "test3@aiub.edu");
        statement.setString(2, "111555");
        statement.setLong(3, 5);
        statement.executeUpdate();
    }
}
