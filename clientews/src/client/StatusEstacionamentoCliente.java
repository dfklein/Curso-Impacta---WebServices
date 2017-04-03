package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import impacta.ead.jp.estacionamento.integracao.StatusBean;
import impacta.ead.jp.estacionamento.integracao.StatusEstacionamentoService;

public class StatusEstacionamentoCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel slblFaturamento = new JLabel("Faturamento");
	private JLabel slblDisponibilidade = new JLabel("Disponibilidade");
	private JLabel slblOcupacao = new JLabel("Ocupa\u00E7\u00E3o");

	private JLabel lblFaturamento = new JLabel("---");
	private JLabel lblDisponibilidade = new JLabel("---");
	private JLabel lblOcupacao = new JLabel("---");

	private StatusEstacionamentoService statusService;

	public static void main(String args[]) throws Exception {
		StatusEstacionamentoCliente cliente = new StatusEstacionamentoCliente();
		cliente.setVisible(true);
	}

	public StatusEstacionamentoCliente() throws MalformedURLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Status do Estacionamento");
		this.setSize(new Dimension(600, 200));

		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JButton btnAtualizar = new JButton("Atualizar Status");
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statusService = carregarServico();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				StatusBean bean = statusService.getStatus(); // chamada do WebService
				carregarLabels(bean);
				// TODO atualizar o status chamando o serviço
			}

		});
		panel.add(btnAtualizar, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		slblFaturamento.setBackground(new Color(255, 255, 0));
		slblFaturamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		slblFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(slblFaturamento, BorderLayout.NORTH);
		lblFaturamento.setForeground(Color.BLUE);
		lblFaturamento.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblFaturamento, BorderLayout.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		slblOcupacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		slblOcupacao.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(slblOcupacao, BorderLayout.NORTH);
		lblOcupacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupacao.setForeground(Color.BLUE);
		lblOcupacao.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblOcupacao, BorderLayout.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		slblDisponibilidade.setHorizontalAlignment(SwingConstants.CENTER);
		slblDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_5.add(slblDisponibilidade, BorderLayout.NORTH);
		lblDisponibilidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibilidade.setForeground(Color.BLUE);
		lblDisponibilidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(lblDisponibilidade, BorderLayout.CENTER);
	}

	protected void carregarLabels(StatusBean bean) {
		this.lblDisponibilidade.setText(Integer.toString(bean.getVagasLivres()));
		this.lblOcupacao.setText(Integer.toString(bean.getVagasOcupadas()));
		this.lblFaturamento.setText(Double.toString(bean.getFaturamentoDia()));
	}

	protected StatusEstacionamentoService carregarServico() throws MalformedURLException {

		StatusEstacionamentoService service = null;
		
		// Definir a URL de acesso ao serviço
		URL url = new URL("http://127.0.0.1:8888/status?WSDL");
		
		// Qname (Qualified Name)
		// No 1o parâmetro você vai passar o nome do pacote onde está seu serviço ao contrário. No caso: impacta.ead.jp.estacionamento.integracao.
		// Já o segundo é o nome da sua implemntação da interface do servico + "Service" no final
		QName qname = new QName("http://integracao.estacionamento.jp.ead.impacta/",
				"StatusEstacionamentoServiceImplService");
		
		// Cria um proxy de comunicação com o serviço provedor
		Service srv = Service.create(url, qname);
		service = srv.getPort(StatusEstacionamentoService.class); // obtem o proxy
		
		return service;
	}
}
