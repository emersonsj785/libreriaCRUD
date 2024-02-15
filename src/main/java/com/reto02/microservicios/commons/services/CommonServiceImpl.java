package com.reto02.microservicios.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

public class CommonServiceImpl<E, R extends CrudRepository<E,Long>> implements CommonService<E> {
	
	@Autowired protected R repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll()
	{
		return repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id)
	{
		return repositorio.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity)
	{
		return repositorio.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id)
	{
		repositorio.deleteById(id);
	}

}
