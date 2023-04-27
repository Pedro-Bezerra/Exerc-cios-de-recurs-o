package br.upe.model;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class TarefaTableModel extends AbstractTableModel implements Reorderable {  //Interface implementada pelo grupo

    private Tarefa aux = null;
    //private Tarefa temp = null;
    private int index;
    private List<Tarefa> tarefasFinalizadas;
    private List<Tarefa> tarefasAtivas;
    private boolean exibirFinalizadas;

    public TarefaTableModel() {
        tarefasAtivas = new ArrayList<>();
        tarefasFinalizadas = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (tarefasAtivas == null || tarefasAtivas.isEmpty()) {
            return 0;
        }
        return tarefasAtivas.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa tarefa = tarefasAtivas.get(rowIndex);
        switch (columnIndex) {
            case 0 : return tarefa.isFinalizada();
            case 1 : return tarefa.getDescricao();
        }
        return null;
    }

    public Class getColumnClass(int c) {
        switch (c) {
            case 0 : return Boolean.class;
            case 1 : return String.class;
        }
        return null;
    }

    //Editado pelo grupo
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Tarefa tarefa = tarefasAtivas.get(rowIndex);
        if (columnIndex == 0) {
            //Tarefa tarefa = tarefasAtivas.get(rowIndex);
            tarefa.setFinalizada((Boolean) aValue);
            if (this.exibirFinalizadas) {
                if ((Boolean) aValue) {
                    tarefasFinalizadas.add(tarefa);
                } else {
                    tarefasFinalizadas.remove(tarefa);
                }
            } else {
                if ((Boolean) aValue) {
                    tarefasAtivas.remove(tarefa);
                    tarefasFinalizadas.add(tarefa);
                }
            }
            this.fireTableDataChanged();
        //Editado pelo grupo
        } else if (columnIndex == 1) {
            tarefa.setDescricao((String) aValue);
        }
        this.fireTableDataChanged();

        /*if (aux == null) {
            aux = tarefasAtivas.get(rowIndex);
            index = rowIndex;
        } else {
            temp = tarefasAtivas.get(rowIndex);
            tarefasAtivas.set(rowIndex, aux);
            tarefasAtivas.set(index, temp);
            this.fireTableDataChanged();
            aux = null;
        }*/


    }


    public void setExibirFinalizadas(boolean selecionado) {
        this.exibirFinalizadas = selecionado;
        if (this.exibirFinalizadas) {
            this.tarefasAtivas.addAll(this.tarefasFinalizadas);
        } else {
            this.tarefasAtivas.removeAll(this.tarefasFinalizadas);
        }
        this.fireTableDataChanged();
    }

    public List<Tarefa> getTarefasFinalizadas() {
        return tarefasFinalizadas;
    }

    public void setTarefasFinalizadas(List<Tarefa> tarefasFinalizadas) {
        this.tarefasFinalizadas = tarefasFinalizadas;
    }

    public List<Tarefa> getTarefasAtivas() {
        return tarefasAtivas;
    }

    public void setTarefasAtivas(List<Tarefa> tarefasAtivas) {
        this.tarefasAtivas = tarefasAtivas;
    }

    public boolean isExibirFinalizadas() {
        return exibirFinalizadas;
    }

    //Editado pelo grupo
    @Override
    public void reorder(int fromIndex, int toIndex) {


        aux = tarefasAtivas.get(fromIndex);
        if (fromIndex < toIndex) {
            for (int i = fromIndex + 1; i <= toIndex; i++) {
                tarefasAtivas.set(i - 1, tarefasAtivas.get(i));
            }
            tarefasAtivas.set(toIndex, aux);
        } else if (fromIndex > toIndex) {
            for (int i = fromIndex - 1; i >= toIndex; i--) {
                tarefasAtivas.set(i + 1, tarefasAtivas.get(i));
            }
            tarefasAtivas.set(toIndex, aux);
        }
        this.fireTableDataChanged();


        /*
        temp = tarefasAtivas.get(toIndex);
        tarefasAtivas.set(toIndex, aux);
        tarefasAtivas.set(fromIndex, temp);
        this.fireTableDataChanged();*/
    }
}
