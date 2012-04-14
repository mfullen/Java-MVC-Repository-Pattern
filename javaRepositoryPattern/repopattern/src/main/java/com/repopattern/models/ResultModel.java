/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repopattern.models;

/**
 *
 * @author ifull
 */
public class ResultModel extends AbstractModel
{
    private int id;
    private Object mycomplexObject;
    private String name;

    public int getId()
    {
        return id;
    }

    public Object getMycomplexObject()
    {
        return mycomplexObject;
    }

    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setMycomplexObject(Object mycomplexObject)
    {
        this.mycomplexObject = mycomplexObject;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
