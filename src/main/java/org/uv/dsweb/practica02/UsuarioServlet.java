package org.uv.dsweb.practica02;

/**
 *
 * @author 15-dy2xxLapDeLuis
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "listar";
        }

        switch (action) {
            case "nuevo":
                request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
                break;
            case "editar":
                long clave = Long.parseLong(request.getParameter("clave"));
                Usuario usuario = usuarioDAO.obtenerUsuario(clave);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
                break;
            case "eliminar":
                eliminarUsuario(request, response);
                break;
            case "listar":
            default:
                listarUsuarios(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setDireccion(direccion);
        usuario.setTelefono(telefono);

        if (clave == null || clave.isEmpty()) {
            usuarioDAO.crearUsuario(usuario);
        } else {
            usuario.setClave(Long.parseLong(clave));
            usuarioDAO.actualizarUsuario(usuario);
        }
        response.sendRedirect("usuario?action=listar");
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long clave = Long.parseLong(request.getParameter("clave"));
        usuarioDAO.eliminarUsuario(clave);
        response.sendRedirect("usuario?action=listar");
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("usuario-list.jsp").forward(request, response);
    }
}