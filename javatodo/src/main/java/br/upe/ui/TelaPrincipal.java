package br.upe.ui;

import br.upe.controller.TarefaControlador;
import br.upe.model.Tarefa;
import br.upe.model.TransferRowHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal implements KeyListener {

    private JPanel pnlMain;
    private JTextField txtDescricaoTarefa;
    private JButton btnAdicionarTarefa;
    private JPanel pnlAdicionar;
    private JTable tblTarefas;
    private JCheckBox chkExibirFinalizadas;
    private List<Tarefa> tarefas;

    private DefaultTableModel model;
    private TarefaControlador controlador;

    public TelaPrincipal() {
        super();

        tblTarefas.setDragEnabled(true);
        tblTarefas.setDropMode(DropMode.INSERT_ROWS);
        tblTarefas.setTransferHandler(new TransferRowHandler(tblTarefas));

        tblTarefas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        txtDescricaoTarefa.addKeyListener(this);


        tarefas = new ArrayList<>();
        btnAdicionarTarefa.addActionListener(e -> {
            adicionarTarefa(txtDescricaoTarefa.getText());
            txtDescricaoTarefa.setText("");
        });
        chkExibirFinalizadas.addActionListener(e -> {
            boolean selecionado = ((JCheckBox) e.getSource()).isSelected();
            controlador.exibirFinalizadas(selecionado);
        });
    }

    private void adicionarTarefa(String texto) {
        Tarefa tarefa = new Tarefa(texto, tarefas.size());
        controlador.adicionarTarefaAtiva(tarefa);
        tblTarefas.revalidate();
        tblTarefas.repaint();
    }

    public JPanel getPnlMain() {
        return this.pnlMain;
    }

    private void createUIComponents() {
        controlador = new TarefaControlador();
        tblTarefas = new JTable(controlador.getTarefaTableModel());
        tblTarefas.getColumnModel().getColumn(0).setMaxWidth(20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarTarefa(txtDescricaoTarefa.getText());
            txtDescricaoTarefa.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
