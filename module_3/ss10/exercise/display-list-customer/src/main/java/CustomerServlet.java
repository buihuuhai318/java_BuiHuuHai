import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/index")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String IMG = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkJHckFE8JX5RK_2odaG-ZPubLRl8sXMKqXa1SzwINmQ--TM3T_BVlX7Zwrma-cQUUxMU&usqp=CAU";

        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("hai", "1997-02-03", "da nang", IMG));
        customerList.add(new Customer("thien", "1997-02-03", "da nang", IMG));
        customerList.add(new Customer("tri", "1997-02-03", "da nang", IMG));
        customerList.add(new Customer("nghia", "1997-02-03", "da nang", IMG));

        request.setAttribute("customerList", customerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}