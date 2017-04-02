package impacta.ead.jp.estacionamento.utilitario;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class EstacionamentoUtil {

	public static String get(String chave) {
		Properties prop = new Properties();
		try {
			prop.load(EstacionamentoUtil.class.getResourceAsStream("/resources/configuration.txt"));
			String valor = prop.getProperty(chave);
			return valor;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static String getDataAsString(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}

	public static LocalDateTime getDate(String dataAsString) {
			return LocalDateTime.parse(dataAsString,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));	
	}
}
