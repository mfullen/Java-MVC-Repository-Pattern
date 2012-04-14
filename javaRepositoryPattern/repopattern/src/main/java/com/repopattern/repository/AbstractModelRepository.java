/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.repository;

import com.repopattern.models.AbstractModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Basic implementation of what an AbstractModel Repository should do, can
 * simply just use implements IRepository<T> 
 * @author ifull
 */
public abstract class AbstractModelRepository<T extends AbstractModel> implements IRepository<T>
{
    private List<T> items = null;

    public AbstractModelRepository()
    {
        this(new ArrayList<T>());
    }

    public AbstractModelRepository(List<T> itemsList)
    {
        this.items = itemsList;
    }

    public void add(T item)
    {
        items.add(item);
    }

    public void remove(T item)
    {
        items.remove(item);
    }

    public Collection<T> getAll()
    {
        return items;
    }

    public T findById(int id)
    {
        return items.get(id);
    }
    
    public void removeAll()
    {
        items.clear();
    }
}
