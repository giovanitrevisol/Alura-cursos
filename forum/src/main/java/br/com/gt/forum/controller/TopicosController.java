package br.com.gt.forum.controller;

import br.com.gt.forum.controller.dto.TopicoDto;
import br.com.gt.forum.modelo.Curso;
import br.com.gt.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        Topico topico = new Topico("Dúvida Gio", "Duvida 1", new Curso("Java", "Programação"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }
}
