package impacta.ead.jp.estacionamento.controle;

import impacta.ead.jp.estacionamento.integracao.StatusBean;
import impacta.ead.jp.estacionamento.negocio.Vaga;
import impacta.ead.jp.estacionamento.persistencia.DAOEstacionamento;

/**
 * Classe controladora que coordena todo o fluxo da informação 
 * e eventos do sistema.
 */
public class EstacionamentoController {


	/**
	 * Recupera o status das vagas do estacionamento  
	 * 
	 * @return status atual de vagas ocupadas no estaciomento
	 */
	public static int inicializarVagasOcupadas() {
		return new DAOEstacionamento().getVagasOcupadas();
	}

	public StatusBean getStatusDia() {
		StatusBean bean = null;
		int livres = Vaga.livres();
		int ocupadas = Vaga.getOcupadas();
		double faturamento = new DAOEstacionamento().getFaturamentoCorrente();
		
		bean = new StatusBean(livres, ocupadas, faturamento);
		
		return bean;
	}



	
}
