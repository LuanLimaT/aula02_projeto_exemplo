package br.edu.ifto.aula02.controller;

import br.edu.ifto.aula02.model.dao.VeiculoDAO;
import br.edu.ifto.aula02.model.entity.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller //classe que irá receber requisições web
@RequestMapping("veiculos") // mapeia URLs para métodos de controladores no Spring, lidando com requisições HTTP.


public class VeiculoController {

    private VeiculoDAO dao;

    public VeiculoController() {
        this.dao = new VeiculoDAO();
    }

    // Exibir o formulário de cadastro
    @GetMapping("/form")
    public String form(Veiculo veiculo) {
        return "/veiculos/form";
    }

    // Listar todos os veículos
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("veiculos", dao.buscarVeiculos());
        return new ModelAndView("/veiculos/list", model);
    }

    // Salvar novo veículo
    @PostMapping("/save")
    public ModelAndView save(Veiculo veiculo) {
        dao.save(veiculo);
        return new ModelAndView("redirect:/veiculos/list");
    }

    // Remover veículo pelo ID
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        dao.remove(id);
        return new ModelAndView("redirect:/veiculos/list");
    }

    // Editar veículo pelo ID
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("veiculo", dao.buscarVeiculo(id));
        return new ModelAndView("/veiculos/form", model);
    }

    // Atualizar veículo
    @PostMapping("/update")
    public ModelAndView update(Veiculo veiculo) {
        dao.update(veiculo);
        return new ModelAndView("redirect:/veiculos/list");
    }



}
