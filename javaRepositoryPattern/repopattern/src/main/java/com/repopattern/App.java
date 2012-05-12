package com.repopattern;

import com.repopattern.controllers.ResultsModelController;
import com.repopattern.models.ResultModel;
import com.repopattern.repository.IResultsModelRepository;
import com.repopattern.repository.InMemoryResultsModelRepository;
import com.repopattern.views.ResultsView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
        //create a list of Result models which are suppose to mirror another
        //data structure such as protobuff
        List<ResultModel> models = new ArrayList<ResultModel>();
        {
            ResultModel model = new ResultModel();
            model.setId(1);
            model.setName("Gorilla");
            model.setMycomplexObject(new Boolean(true));
            models.add(model);
        }
        {
            ResultModel model = new ResultModel();
            model.setId(55);
            model.setName("Cats");
            model.setMycomplexObject(new Boolean(true));
            models.add(model);
        }
        {
            ResultModel model = new ResultModel();
            model.setId(33);
            model.setName("Dog");
            model.setMycomplexObject(new Boolean(true));
            models.add(model);
        }
        {
            ResultModel model = new ResultModel();
            model.setId(46);
            model.setName("Batman");
            model.setMycomplexObject(new Boolean(true));
            models.add(model);
        }

        //create the controller
        final ResultsModelController controller = new ResultsModelController();
        //handle the incoming message with data
        controller.handleIncomingMessage(models);

        //the repository implmenetation we are using
        final IResultsModelRepository defaultRepo = controller.getResultModelRepository();
        //another repository, all of this data is created inside of the repository
        //this really shows the power of the repository patter. We could create
        //a DatabaseResultsModel repo and read data from a database
        //or a repository which reads in the Results model from XML and replace
        //each implementation as a new repository
        final IResultsModelRepository inmemrepo = new InMemoryResultsModelRepository();


        //Button to add a row to the current repository
        AbstractAction addRow = new AbstractAction("add row")
        {
            public void actionPerformed(ActionEvent e)
            {
                List<ResultModel> models = new ArrayList<ResultModel>();
                {
                    ResultModel model = new ResultModel();
                    model.setId(6);
                    model.setName("Test");
                    model.setMycomplexObject(new Boolean(true));
                    models.add(model);
                }
                controller.handleIncomingMessage(models);
            }
        };

        //swaps to the Inmemory Implementation
        AbstractAction swaptoInmem = new AbstractAction("Use In Memory Model")
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.setResultModelRepository(inmemrepo);
            }
        };

        //swaps back to the original repository
        AbstractAction swaptoOrg = new AbstractAction("Use Orginial Model")
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.setResultModelRepository(defaultRepo);
            }
        };

        //Create the table, results view
        JFrame frame = new JFrame();
        ResultsView view = controller.getResultsView();

        frame.add(view);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //create the actions window
        JFrame actionsFrame = new JFrame("actions");
        JPanel actionsPanel = new JPanel();
        actionsPanel.add(new JButton(addRow));
        actionsPanel.add(new JButton(swaptoInmem));
        actionsPanel.add(new JButton(swaptoOrg));
        actionsPanel.add(new JButton(controller.getClearAction()));
        actionsFrame.add(actionsPanel);
        actionsFrame.pack();
        actionsFrame.setLocationRelativeTo(null);
        actionsFrame.setVisible(true);
    }
}
