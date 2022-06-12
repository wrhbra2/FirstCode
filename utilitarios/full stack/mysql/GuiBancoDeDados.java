import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.Statement;  
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.Statement; 
import javax.swing.*;




public class GuiBancoDeDados extends JFrame{
	
	private JLabel Filme;
	private JLabel Genero;
	private JLabel idCadastro;
	private JTextField TFilme;
	private JTextField TGenero;
	private JTextField TidCadastro;
	private JButton Enviar;
	private String driver = "com.mysql.jdbc.Driver";  
    private String url = "jdbc:mysql://localhost/locadora";  
    private String usuario = "root";  
    private String senha = "w4nd3r0107";  
    Connection conn;  
    Statement stmt;
	
	
	public GuiBancoDeDados(){
		super("Cadastro de Filmes");
		setLayout(new FlowLayout());
		
		
		Filme = new JLabel("Nome do Filme");
		TFilme = new JTextField(20);
		add(Filme);
		add(TFilme);
		
		Genero = new JLabel("Genero do Filme");
		TGenero = new JTextField(20);
		add(Genero);
		add(TGenero);
		
		idCadastro = new JLabel("Codigo do Filme");
		TidCadastro = new JTextField(20);
		add(idCadastro);
		add(TidCadastro);
		
		
		Enviar = new JButton("Enviar");
		add(Enviar);
		Enviar.addActionListener(new ActionListener()
		{
			public void actionPerformed( ActionEvent event )
			{//******
			GuiBancoDeDados conexao = new GuiBancoDeDados();
			try {
				Class.forName(conexao.driver);
				conexao.conn = DriverManager.getConnection(conexao.url,conexao.usuario,conexao.senha);
				
				
				if(!conexao.conn.isClosed()){
					System.out.println("Conexao Ativada");
					
					
					String sql ="INSERT INTO locadora.cadastro" + "(TFilme,TGenero,TidCadastro)" +" VALUES ("+"'"+Filme+"'"+","+"'"+Genero+"'"+","+"'"+idCadastro+"'"+");";
					int flag = conexao.stmt.executeUpdate(sql);
					
					if(flag == 0){
						System.out.println("inclusão não realizada");
						}else{
							System.out.println("inclusão realizada com sucesso");
							} //final else
						conexao.conn.close();
						System.out.println("Conexao Desativada");
										}//fim conexao.conn is closed
										else{
											System.out.println("Conexao não ativada");
										}
			}catch(Exception e) {
				System.out.println("Erro AcessaDB :"+e.toString());
			}finally{
			try{
				conexao.conn.close();
				System.out.println("Conexão Desativada no finally!");
				
			}catch (Exception e) {
				System.out.println("Erro Fechamento Conexao no finally!");
			}
			}
			}// fim action performed
		}//fim action listener
			
			
			);//fim add.action listener
		
		
	}	// fim do construtor
	public static void main(String arg[]){
		GuiBancoDeDados guibanco = new GuiBancoDeDados();
		
		guibanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guibanco.setSize(275,220);
		guibanco.setVisible(true);
		
	}
}	
