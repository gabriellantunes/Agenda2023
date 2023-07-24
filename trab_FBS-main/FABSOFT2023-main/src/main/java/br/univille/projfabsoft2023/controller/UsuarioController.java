package br.univille.projfabsoft2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import br.univille.projfabsoft2023.entity.Usuario;
import br.univille.projfabsoft2023.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ModelAndView index(){
        var listaUsuarios = usuarioService.getAll();
        return new ModelAndView("usuario/index",
                "listaUsuarios",listaUsuarios);
    }

    @GetMapping("/novo")
    public ModelAndView novo(HttpServletResponse response, HttpSession session) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies

        String username = (String) session.getAttribute("username");

        if (username != null) {
            return new ModelAndView("redirect:/dashboard");
        }

        var usuario = new Usuario();
        return new ModelAndView("usuario/form",
                "usuario",usuario);
    }

    @PostMapping(params = "form")
    public String save(Usuario usuario, HttpSession session){
        usuarioService.save(usuario);
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView("usuario/form", "usuario", new Usuario());
        return "redirect:/login";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id")
                                Usuario usuario){

        return new ModelAndView("usuario/form",
                "usuario",usuario);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover (@PathVariable("id") long id){

        usuarioService.delete(id);
        return new ModelAndView("redirect:/usuario");
    }
}
