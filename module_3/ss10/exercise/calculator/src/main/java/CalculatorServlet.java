import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/result")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
        char operator = request.getParameter("operator").charAt(0);

        Calculator calculator = new Calculator(firstOperand, operator, secondOperand);

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h1>RESULT");
        try {
            writer.println("<h4>Discount Price: " + calculator.getFirstOperand() + " " + calculator.getOperator() + " " + calculator.getSecondOperand() + " = " + calculator.getResult() + "</h4>");
        } catch (Exception e) {
            writer.println("Error: " + e.getMessage());
        }
        writer.println("</html>");
    }
}