/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.views;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ifull
 */
public interface IView<T extends DefaultTableModel>
{
    public void setModel(T model);

   // public void updateView();
}
