package impacta.ead.jp.estacionamento.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import impacta.ead.jp.estacionamento.utilitario.EstacionamentoUtil;

/**
 * Classe que realiza o mapeamento objeto-relacional e consultas relacionadas
 * aos dados persistidos do estacionamento.
 *
 */
public class DAOEstacionamento {

	public int getVagasOcupadas() {
		Connection conexao = getConnection();
		String cmd = EstacionamentoUtil.get("selectOcupadas");

		try (PreparedStatement pStmt = conexao.prepareStatement(cmd)) {
			ResultSet result = pStmt.executeQuery();

			if (result.next()) {
				int ocupadas = result.getInt(1);
				return ocupadas;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(conexao);
		}

		return 0;
	}

	private static Connection getConnection() {
		String url = EstacionamentoUtil.get("urlConexao");
		String usuario = EstacionamentoUtil.get("usuarioBanco");
		String senha = EstacionamentoUtil.get("senhaBanco");
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
