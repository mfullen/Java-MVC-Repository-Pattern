/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.repository;

import java.util.Collection;

/**
 *
 * @author ifull
 */
public interface IRepository<T>
{
    void add(T item);

    void remove(T item);

    Collection<T> getAll();

    T findById(int id);
}
