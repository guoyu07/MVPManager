package io.xujiaji.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import io.xujiaji.plugin.dialog.EditorMVPDialog;
import io.xujiaji.plugin.model.EditEntity;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jiana on 05/12/16.
 */
public class MVPCreatorAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {

        // TODO: insert action logic here
        EditorMVPDialog mEditorMVPDialog = new EditorMVPDialog();
        mEditorMVPDialog.setEditorListener(new EditorListener() {
            @Override
            public void editOver(EditEntity editEntity) {
                print(editEntity.getView());
                print(editEntity.getPresenter());
                print(editEntity.getModel());
                try {
                    ClassCreateHelper.create(e, editEntity);
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });
        mEditorMVPDialog.pack();
        mEditorMVPDialog.setVisible(true);

    }

    private void print(List<String> datas) {
        for (String s : datas) {
            System.out.println(s);
        }
    }
}
