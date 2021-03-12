package com.amaker.dao;

import com.amaker.bean.Addp;

import java.util.List;

public interface AddDao {
    public void save(Addp a);
    public List seek();
    public List list();

    public void update(Addp a);

    public void delete(String[] s);

    public Addp get(int id);
}
