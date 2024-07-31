import javax.swing.*;

public class MainFrame extends JFrame {
    private DatabaseManager dbManager;

    public MainFrame() {
        // Inicializa o gerenciador de banco de dados
        dbManager = new DatabaseManager();

        // Configuração do frame
        setTitle("Exemplo de Menu Modularizado com Banco de Dados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Centraliza o frame na tela

        // Criação e adição do painel de botões
        MenuButtonPanel buttonPanel = new MenuButtonPanel(dbManager);
        add(buttonPanel);

        // Torna o frame visível
        setVisible(true);

        // Adiciona um hook para fechar a conexão com o banco de dados ao fechar o programa
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dbManager.close();
            }
        });
    }

    public static void main(String[] args) {
        // Criação e inicialização do frame principal
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
