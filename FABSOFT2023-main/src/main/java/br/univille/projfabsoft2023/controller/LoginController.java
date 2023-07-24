package br.univille.projfabsoft2023.controller;

import br.univille.projfabsoft2023.entity.Usuario;
import br.univille.projfabsoft2023.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;  // Import HttpSession
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, RedirectAttributes redirectAttributes, HttpSession session) {
        Usuario usuario = usuarioRepo.findByEmailAndSenha(email, senha);
        if (usuario != null) {
            // login successful

            // Store the username in the HTTP session
            session.setAttribute("username", usuario.getNome());

            return "redirect:/dashboard";
        } else {
            // login failed
            redirectAttributes.addFlashAttribute("loginError", true);
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(HttpServletResponse response, HttpSession session) {
        // Instrui o navegador a não armazenar em cache a página
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies

        String username = (String) session.getAttribute("username");

        // Se o usuário já estiver logado, redirecione para o dashboard
        if (username != null) {
            return "redirect:/dashboard";
        }

        return "login";
    }
}
