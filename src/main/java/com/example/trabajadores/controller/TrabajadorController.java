/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.trabajadores.controller;

import com.example.trabajadores.model.Trabajador;
import com.example.trabajadores.service.TrabajadorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("trabajadores", trabajadorService.listarTrabajadores());
        return "trabajadores/listar"; // Nombre del archivo Thymeleaf
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        return "trabajadores/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute Trabajador trabajador) {
        trabajadorService.guardar(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Trabajador> trabajador = trabajadorService.buscarPorId(id);
        if (trabajador.isPresent()) {
            model.addAttribute("trabajador", trabajador.get());
            return "trabajadores/formulario";
        }
        return "redirect:/trabajadores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        trabajadorService.eliminar(id);
        return "redirect:/trabajadores";
    }
}

