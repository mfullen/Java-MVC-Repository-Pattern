/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.views;

import com.repopattern.models.ResultModel;
import com.repopattern.repository.IResultsModelRepository;
import com.repopattern.repository.ResultModelRepository;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ifull
 */
public class ResultsViewModel extends DefaultTableModel
{
    private String[] columnNames =
    {
        "id", "object", "name"
    };
    private IResultsModelRepository repository = null;

    public ResultsViewModel()
    {
        this(new ResultModelRepository());
    }

    public ResultsViewModel(IResultsModelRepository repo)
    {
        this.repository = repo;
    }

    public void setRepository(IResultsModelRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col)
    {
        return columnNames[col];
    }

    @Override
    public Class getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
    }

    @Override
    public int getRowCount()
    {
        if (repository == null)
        {
            return 0;
        }
        return repository.getAll().size();
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        ResultModel model = repository.findById(row);

        switch (column)
        {
            case 0:
                return model.getId();
            case 1:
                return model.getMycomplexObject();
            case 2:
                return model.getName();
        }
        return super.getValueAt(row, column);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
