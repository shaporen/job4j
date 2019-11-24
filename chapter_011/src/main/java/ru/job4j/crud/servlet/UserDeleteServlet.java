package ru.job4j.crud.servlet;

import ru.job4j.crud.datamodel.User;
import ru.job4j.crud.logic.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 19.11.2019
 */
public class UserDeleteServlet extends HttpServlet {

    /**
     * Logic layout - слой содержит выполнение бизнес логики.
     */
    private final ValidateService service = ValidateService.getInstance();

    /**
     * Удаляет пользователя.
     * После удаления отправляет GET сервлету UsersServlet.
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findById(id);

        if (service.delete(user)) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            writer.append(String.format("error delete for id=%d", id));
        }
    }

}