package com.miguel.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.miguel.Spring.repository.EventoRepository;
import org.springframework.ui.Model;
import com.miguel.Spring.models.Evento;
import jakarta.servlet.http.HttpSession;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    // ===================================
    // Rotas relacionadas ao login
    // ===================================

    @RequestMapping(value = "/logar", method = RequestMethod.GET)
    public String loginForm() {
        return "evento/login"; // Retorna a página de login
    }

    @RequestMapping(value = "/logar", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Evento evento = er.findByEmailAndPassword(email, password);

        if (evento != null) {
            session.setAttribute("usuarioLogado", evento);
            return "redirect:/testeRede";
        } else {
            return "redirect:/logar?error"; // Redireciona com erro
        }
    }

    // ===================================
    // Rotas relacionadas ao cadastro
    // ===================================

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String form(HttpSession session, Model model) {
        return "evento/cadastro"; // Retorna a página de cadastro
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String form(Evento evento, HttpSession session) {
        // Salva o evento
        er.save(evento);

        // Armazena o evento na sessão
        session.setAttribute("usuarioCadastrado", evento);

        // Redireciona para a página de testeRede
        return "redirect:/testeRede";
    }

    // ===================================
    // Rotas relacionadas ao perfil
    // ===================================

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String form4(HttpSession session, Model model) {
        Evento usuarioLogado = (Evento) session.getAttribute("usuarioLogado");
        Evento usuarioCadastrado = (Evento) session.getAttribute("usuarioCadastrado");

        if (usuarioLogado != null) {
            model.addAttribute("usuario", usuarioLogado);
            return "evento/perfil"; // Retorna a página de perfil
        } else if (usuarioCadastrado != null) {
            model.addAttribute("usuario", usuarioCadastrado);
            return "evento/perfil"; // Retorna a página de perfil
        }
        return "redirect:/logar"; // Redireciona para a página de login
    }

    // ===================================
    // Rotas diversas
    // ===================================

    @RequestMapping(value = "/testeRede", method = RequestMethod.GET)
    public String form3() {
        return "evento/testeRede";
    }
}
