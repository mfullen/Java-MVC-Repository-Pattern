/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.repository;

import com.repopattern.models.ResultModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ifull
 */
public class InMemoryResultsModelRepository implements IResultsModelRepository
{
    private List<ResultModel> items = new ArrayList<ResultModel>();

    public InMemoryResultsModelRepository()
    {
        for (int i = 0; i < 50; i++)
        {
            {
                ResultModel model = new ResultModel();
                model.setId(i);
                model.setName("Test" + i);
                model.setMycomplexObject((i % 2) == 0 ? true : false);
                items.add(model);
            }
        }

    }

    public void add(ResultModel item)
    {
        items.add(item);
    }

    public void remove(ResultModel item)
    {
        items.remove(item);
    }

    public Collection<ResultModel> getAll()
    {
        return items;
    }

    public ResultModel findById(int id)
    {
        return items.get(id);
    }

    public void removeAll()
    {
        items.clear();
    }
}
