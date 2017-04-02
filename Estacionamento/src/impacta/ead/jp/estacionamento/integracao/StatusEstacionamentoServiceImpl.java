package impacta.ead.jp.estacionamento.integracao;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import impacta.ead.jp.estacionamento.controle.EstacionamentoController;

@WebService(endpointInterface = "impacta.ead.jp.estacionamento.integracao.StatusEstacionamentoService")
public class StatusEstacionamentoServiceImpl implements StatusEstacionamentoService {

	@Override
	public StatusBean getStatus() {
		StatusBean bean = new EstacionamentoController().getStatusDia();
		return bean;
	}
	
	public static void main(String[] args) {
		
		// o segundo argumento é uma implementação do serviço. Isto é o que devolve o WSDL, com as definições do seu serviço.
		Endpoint.publish("http://127.0.0.1:8888/status?WSDL", new StatusEstacionamentoServiceImpl());
	}

}
