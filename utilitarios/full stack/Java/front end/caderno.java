 import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class caderno extends JFrame {

	// --> atributos
	private static final long serialVersionUID = 1L;
	private JLabel labelData;
        private JLabel labelMateria;
        private JLabel labelItem;
        private JLabel labelChave;
        private JLabel labelComent;

	private JTextField textFieldData;
        private JTextField textFieldMateria;
        private JTextField textFieldItem;
        private JTextField textFieldChave;
        private JTextField textFieldComent;


	private JButton buttonOk;

	// --> construtor da classe
	public caderno() {
		// --> muda o titulo e o leiaute
		setTitle("Caderno");
		setLayout(new FlowLayout());
		// --> instancia os componentes
		labelData = new JLabel("Data: ");
		textFieldData = new JTextField(15);
                labelMateria = new JLabel("Materia: ");
		textFieldMateria = new JTextField(15);
                labelItem = new JLabel("Item: ");
		textFieldItem = new JTextField(15);
                labelChave = new JLabel("Chave: ");
		textFieldChave = new JTextField(15);
                labelComent = new JLabel("Comentario: ");
		textFieldComent = new JTextField(15);

		buttonOk = new JButton("OK");
		// --> adiciona os componentes a janela
		add(labelData);
		add(textFieldData);
                add(labelMateria);
		add(textFieldMateria);
                add(labelItem);
		add(textFieldItem);
                add(labelChave);
		add(textFieldChave);
                add(labelComent);
		add(textFieldComent);
                 
		add(buttonOk);
		// --> ajusta o tamanho, a posicao e a acao ao fechar
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// --> mostra a janela
		setVisible(true);

	}

	// --> metodo main
	public static void main(String[] args) {
		// muda o LookAndFeel para parecer com uma aplicacao nativa
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// --> cria um novo objeto do tipo Swing1
		// por causa da execucao multithreading da
		// API swing,isso deve ser feito dessa forma:
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new caderno();
			}
		});
	}
}
