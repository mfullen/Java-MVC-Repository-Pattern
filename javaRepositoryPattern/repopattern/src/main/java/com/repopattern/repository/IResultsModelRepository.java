/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.repository;

import com.repopattern.models.ResultModel;

/**
 *
 * @author ifull
 */
public interface IResultsModelRepository extends IRepository<ResultModel>
{
    /* this method could go In IRepository but you can extend specific repoistories like this
     */
    void removeAll();
}
