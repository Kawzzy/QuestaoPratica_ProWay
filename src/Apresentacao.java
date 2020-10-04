import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfQtdPontos;
	private Jogo novoJogo;
	private ArrayList<Jogo> listaDeJogos = new ArrayList<>();
	private JTable table;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Cadastrar novo jogo");
		
		JLabel lblQtdPontos = new JLabel("Quantidade de pontos marcados:");
		
		tfQtdPontos = new JTextField();
		tfQtdPontos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			int counter = 1;
			public void actionPerformed(ActionEvent e) {
				novoJogo = new Jogo(Integer.parseInt(tfQtdPontos.getText()), counter); //counter controls how many games has been registered
				listaDeJogos.add(novoJogo);
				JOptionPane.showMessageDialog(frame, "Jogo cadastrado!");
				counter++;
			}
		});
		
		JButton btnVisualizarLista = new JButton("Visualizar");
		btnVisualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogo pesquisaJogo;
				String msg = "";
				int maior = 0,
					menor = 1000,
					QRMax = -1,
					QRMin = -1;
				int[] verificaMaxTemp = new int[listaDeJogos.size()];
				int[] verificaMinTemp = new int[listaDeJogos.size()];
				textArea.setText("");
				for (int i = 0; i < listaDeJogos.size(); i++) {
					pesquisaJogo = listaDeJogos.get(i);
					msg = "Jogo: " + pesquisaJogo.getQtdJogos() + "\nPlacar: " + pesquisaJogo.getPlacar();
					
					verificaMaxTemp[i] = pesquisaJogo.getPlacar();
					verificaMinTemp[i] = pesquisaJogo.getPlacar();
//to verify the max and min score, and controls how many time the max and min record was broken
					if (verificaMaxTemp[i] > maior) {
						maior = verificaMaxTemp[i];
						QRMax++;
					}
					if (verificaMinTemp[i] < menor) {
						menor = verificaMinTemp[i];
						QRMin++;
					}
					msg += "\nMínimo da temporada: " + menor + "\nMáximo da temporada: " + maior
							+ "\nQuebra recorde mínimo: " + QRMin + "\nQuebra recorde máximo: " + QRMax + "\n\n";
					textArea.append(msg);
				}
			}
		});
		
		table = new JTable();
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblQtdPontos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfQtdPontos, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVisualizarLista))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfQtdPontos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrar)
						.addComponent(btnVisualizarLista)
						.addComponent(lblQtdPontos))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
	}
}
