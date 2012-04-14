/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.controllers;

import com.repopattern.models.ResultModel;
import com.repopattern.repository.IResultsModelRepository;
import com.repopattern.repository.ResultModelRepository;
import com.repopattern.views.ResultsView;
import com.repopattern.views.ResultsViewModel;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;

/**
 *
 * @author ifull
 */
public class ResultsModelController
{
    private IResultsModelRepository resultModelRepository = null;
    private ResultsView view = null;
    private ResultsViewModel viewModel = null;
    private AbstractAction clearAction = new AbstractAction("Clear All Items")
    {
        public void actionPerformed(ActionEvent e)
        {
            ResultsModelController.this.clear();
        }
    };

    //constructor, creates a new ResultModelRepository to inject
    public ResultsModelController()
    {
        this(new ResultModelRepository());
    }

    /**
     * Constructor which has a dependency on IResultsModelRepository
     * @param resultModelRepository the dependency
     */
    public ResultsModelController(IResultsModelRepository resultModelRepository)
    {
        this.resultModelRepository = resultModelRepository;

    }

    /**
     * Gets the current IResultsModelRepository
     * @return 
     */
    public IResultsModelRepository getResultModelRepository()
    {
        return resultModelRepository;
    }

    /**
     * Sets the current IResultsModelRepository impl
     * @param resultModelRepository 
     */
    public void setResultModelRepository(
            IResultsModelRepository resultModelRepository)
    {
        this.resultModelRepository = resultModelRepository;
        this.getViewModel().setRepository(resultModelRepository);
        this.getViewModel().fireTableDataChanged();
    }

    public void handleIncomingMessage(List<ResultModel> exampleProtoMessageList)
    {
        //example to mimick conversion of protobuf to our objects
        for (ResultModel resultModel : exampleProtoMessageList)
        {
            resultModelRepository.add(resultModel);
        }

        //fire event saying table data changed
        this.getViewModel().fireTableDataChanged();
    }

    public void remove(ResultModel item)
    {
        this.resultModelRepository.remove(item);
    }

    public void add(ResultModel item)
    {
        this.resultModelRepository.add(item);
    }

    public void edit(ResultModel item) throws Exception
    {
        ResultModel search = resultModelRepository.findById(item.getId());
        if (search == null)
        {
            throw new Exception("Item not found");
        }
        search = item;
    }

    public void clear()
    {
        this.resultModelRepository.removeAll();
        this.getViewModel().fireTableDataChanged();
    }

    public AbstractAction getClearAction()
    {
        return clearAction;
    }

    private ResultsViewModel getViewModel()
    {
        //lazy load the view model
        if (this.viewModel == null)
        {
            this.viewModel = new ResultsViewModel(resultModelRepository);
        }
        return this.viewModel;
    }

    public ResultsView getResultsView()
    {
        //lazy load the view and view models
        if (this.view == null)
        {
            this.view = new ResultsView();
            this.view.setModel(getViewModel());
        }
        return this.view;
    }
}
