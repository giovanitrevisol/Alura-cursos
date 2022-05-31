package br.com.gt.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gt.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);

}
