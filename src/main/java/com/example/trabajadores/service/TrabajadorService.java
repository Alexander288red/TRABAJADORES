/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.trabajadores.service;

import com.example.trabajadores.model.Trabajador;
import com.example.trabajadores.repository.TrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    private final TrabajadorRepository repository;

    public TrabajadorService(TrabajadorRepository repository) {
        this.repository = repository;
    }

    public List<Trabajador> listarTrabajadores() {
        return repository.findAll();
    }

    public Optional<Trabajador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Trabajador guardar(Trabajador trabajador) {
        return repository.save(trabajador);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
