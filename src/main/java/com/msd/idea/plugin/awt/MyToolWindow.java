package com.msd.idea.plugin.awt;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.AncestorListenerAdapter;
import com.msd.idea.plugin.component.MyProjectComponentImpl;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyToolWindow {


    private JPanel myToolWindowContent;
    private JButton refresh;
    private JTextArea result;

    public MyToolWindow(ToolWindow toolWindow){
        result.setEditable(false);
        result.setText(MyProjectComponentImpl.getNonstandard());

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUi();
            }
        });

        myToolWindowContent.addAncestorListener(new AncestorListenerAdapter() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                super.ancestorAdded(event);
                updateUi();
            }
        });

    }


    public void updateUi(){
        result.setText(MyProjectComponentImpl.getNonstandard());
    }


    public JPanel getContent() {
        return myToolWindowContent;
    }
}
