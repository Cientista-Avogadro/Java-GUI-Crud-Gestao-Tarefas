
package Dao;

import Controllers.AutenticacaoController;
import Controllers.TarefaController;
import Dtos.TarefaDto;
import Models.Tarefa;
import Models.Usuario;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

public class GlobalDao {

    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Tarefa> tarefas = new ArrayList<>();
    private final TarefaController tarefaController = new TarefaController(this);
    private final AutenticacaoController loginController = new AutenticacaoController();

    public Usuario usuarioLogado;

    Integer tarefaId = 1;

    /* ===================== Gestão de Tarefas ====================== */
    public void CriarTarefa(TarefaDto tarefa) {
        try {
            Tarefa novaTarefa = new Tarefa();

            novaTarefa.setId(tarefaId);
            novaTarefa.setTitle(tarefa.getTitle());
            novaTarefa.setDescription(tarefa.getDescription());
            novaTarefa.setStatus(tarefa.getStatus());

            if (isAuthenticated()) {
                novaTarefa.setCreatedBy(usuarioLogado);
                novaTarefa.setUpdatedBy(usuarioLogado);
            }

            novaTarefa.setCreatedAt(LocalDate.now());
            novaTarefa.setUpdatedAt(LocalDate.now());

            tarefas.add(novaTarefa);
            ShowAlert("Criação de Tarefa", "tarefa cadastrada com sucesso", JOptionPane.INFORMATION_MESSAGE);
            tarefaId++;
        } catch (Exception e) {
            ShowAlert("Erro ao criar Tarefa", e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Tarefa> PegarTarefas() {
        return tarefas;
    }

    public ArrayList<Tarefa> PegarTarefasPorFiltros(String Titulo) {
        var founds = new ArrayList<Tarefa>();

        PegarTarefas().forEach((t) -> {
            if (t.getTitle().contains(Titulo)) {
                founds.add(t);
            }
        });

        return founds;
    }

    public Tarefa PegarTarefa(Integer id) {

        try {
            Tarefa encontrado = null;

            for (Tarefa tarefa : PegarTarefas()) {
                if (Objects.equals(tarefa.getId(), id)) {
                    encontrado = tarefa;
                }
            }
            if (encontrado != null) {
                return encontrado;
            } else {
                ShowAlert("Buscar Tarefa",
                        "Tarefa não encontrada!!!",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            ShowAlert("Erro ao Buscar Tarefa",
                    ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public void ExcluirTarefa(Integer id) {
        try {
            Tarefa encontrado = PegarTarefa(id);

            if (encontrado != null) {
                tarefas.remove(encontrado);
                ShowAlert("Exclusão de tarefa", "Tarefa excluída com sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ShowAlert("Buscar tarefa",
                        "Tarefa não encontrada!!!",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            ShowAlert("Erro ao Buscar tarefa",
                    ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EditarTarefa(Tarefa tarefa) {
        try {
            Tarefa encontrado = PegarTarefa(tarefa.getId());
            Integer posicao = PegarTarefas().indexOf(encontrado);
            if (encontrado != null) {

                tarefas.set(posicao, tarefa);

                ShowAlert("Edição de Tarefa", "Tarefa Editada com sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ShowAlert("Buscar tarefa",
                        "Tarefa não encontrado!!!",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            ShowAlert("Erro ao Editar tarefa",
                    ex.getMessage(),
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /* ===================== Autenticação e Autorização ====================== */
    public void Login(String userOrEmail, String password) {
        Usuario founded = null;
        if (!userOrEmail.isEmpty() || !password.isEmpty()) {
            if (!usuarios.isEmpty()) {
                for (var user : usuarios) {
                    if (user.getUserOrEmail().equals(userOrEmail)) {
                        founded = user;
                    }
                }
            }
        }

        if (founded != null) {
            if (founded.getPassword().equals(password)) {
                usuarioLogado = founded;
                tarefaController.IndexAction();
            } else {
                ShowAlert("Alerta Login", "Senha errada, tenta novamente!!!!!!!", JOptionPane.WARNING_MESSAGE);
                loginController.LoginAction();
            }
        } else {
            ShowAlert("Alerta Login", "Usuário não encontrado!!!!!!!", JOptionPane.WARNING_MESSAGE);
            loginController.LoginAction();
        }
    }

    public Boolean isAuthenticated() {
        return usuarioLogado != null;
    }

    public void LogOut() {
        usuarioLogado = null;
        loginController.LoginAction();
    }

    public void loadUsers() {
        usuarios.add(new Usuario(
                1,
                "user",
                "user"));

        usuarios.add(new Usuario(
                2,
                "admin",
                "admin"));
    }

    public void ShowAlert(String title, String message, int type) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, message, title, type);
    }
}
