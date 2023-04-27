package com.ynabouzi.atelier2.controllers;

import com.ynabouzi.atelier2.models.Student;

import java.util.List;

public interface mainDAO<T> {
	public void CreateAll(List<T> Objs);
	public void ShowAll();
	public void ShowByID(long id);
	public void DeleteByID(long id);
	void UpdateByID(long id, T toChangeTo);
	public T FindByID(long id);

}
