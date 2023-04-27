package br.upe.model;

import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragSource;

public class TransferRowHandler extends TransferHandler  { //Classe criada para realizar o drag and drop

    private final DataFlavor localObjectFlavor = new ActivationDataFlavor(Integer.class, "Indice da linha em Integer");
    private JTable table = null;

    private Integer index;

    private Integer maxRows;

    private Integer rowFrom;

    private boolean b;

    public TransferRowHandler(JTable table) {
        this.table = table;
    }

    //Cria o transferable para realizar a ação de drag and drop, mas, como o transferable é uma interface,
    //usa-se uma classe que o implementa
    @Override
    protected Transferable createTransferable(JComponent c) {
        assert (c == table);
        return new DataHandler(index.valueOf(table.getSelectedRow()), localObjectFlavor.getMimeType());
    }

    //Valida a mudança da linha, ou seja, verifica se pode ou não importar o dado
    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
        b = info.getComponent() == table && info.isDrop() && info.isDataFlavorSupported(localObjectFlavor)
                && (dl.getRow() < table.getRowCount());
        table.setCursor(b ? DragSource.DefaultMoveDrop : DragSource.DefaultMoveNoDrop);
        return b;
    }

    //Pega o tipo da ação
    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY_OR_MOVE;
    }

    //Realiza a importação do dado
    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        JTable target = (JTable) info.getComponent();
        JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
        index = dl.getRow();
        maxRows = table.getRowCount();
        if (index < 0 || index > maxRows)
            index = maxRows;
        target.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        try {
            rowFrom = (Integer) info.getTransferable().getTransferData(localObjectFlavor);
            if (rowFrom != -1 && rowFrom != index) {
                ((Reorderable)table.getModel()).reorder(rowFrom, index);
                /*if (index > rowFrom) {
                    index--;
                }*/
                //target.getSelectionModel().addSelectionInterval(index, index);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    //Faz validação após a exportação
    @Override
    protected void exportDone(JComponent c, Transferable t, int act) {
        if ((act == TransferHandler.MOVE) || (act == TransferHandler.NONE)) {
            table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

}