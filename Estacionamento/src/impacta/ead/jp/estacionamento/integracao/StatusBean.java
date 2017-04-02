package impacta.ead.jp.estacionamento.integracao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StatusBean {

	@XmlElement
	private int vagasLivres;

	@XmlElement
	private int vagasOcupadas;
	
	@XmlElement
	private double faturamentoDia;
	
	public StatusBean() {
		
	}
	
	public StatusBean(int vagasLivres, int vagasOcupadas, double faturamentoDia) {
		super();
		this.vagasLivres = vagasLivres;
		this.vagasOcupadas = vagasOcupadas;
		this.faturamentoDia = faturamentoDia;
	}



	public int getVagasLivres() {
		return vagasLivres;
	}

	public int getVagasOcupadas() {
		return vagasOcupadas;
	}

	public double getFaturamentoDia() {
		return faturamentoDia;
	}
	
	
	
}
