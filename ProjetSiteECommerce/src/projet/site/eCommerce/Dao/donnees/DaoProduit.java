package projet.site.eCommerce.Dao.donnees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projet.site.eCommerce.Dao.exception.DAOException;
import projet.site.eCommerce.beans.Produit;

public class DaoProduit implements InterfaceProduit {
	private DAOFactory df;
	Connection connexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public DaoProduit(DAOFactory df) {
		this.df = df;
	}

	public static PreparedStatement initialisationRequetePreparee(
			Connection connexion, String sql, boolean returnGeneratedKeys,
			Object... objets) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS
						: Statement.NO_GENERATED_KEYS);
		for (int i = 0; i < objets.length; i++) {
			preparedStatement.setObject(i + 1, objets[i]);
		}
		return preparedStatement;
	}

	public Produit map(ResultSet rs) throws SQLException {
		Produit p = new Produit();
		p.setIdProduit(rs.getInt(1));
		p.setLibelle(rs.getString(2));
		p.setDescription(rs.getString(3));
		p.setPrix(rs.getDouble(4));
		p.setdProduit(rs.getDate(5));
		p.setPhoto(rs.getString(6));
		p.setCont(rs.getInt(7));
		p.setEtat(rs.getInt(8));

		return p;
	}

	@Override
	public void add(Produit p) {
		String req = "insert into produit values(null,?,?,?,?,?,?,?,?,'1')";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false, p.getLibelle(), p.getDescription(), p.getPrix(),
					p.getdProduit(), p.getPhoto(), p.getEtat(),
					p.getCategorie(), p.getCont());
			int rs = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(preparedStatement, connexion);
		}

	}

	@Override
	public ArrayList<Produit> getAll() {
		Produit p;
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		String req = "SELECT `idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `quantitee`, `etatproduit` FROM produit";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				p = map(resultSet);
				listeProduit.add(p);
			}
			return listeProduit;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifier(Produit p) {
		String req = "UPDATE  produit set`libelle`=?, `description`=?, `prix`=?, `datePro`=?, `photo`=?, `quantitee`=?, `etatproduit`=? where `idProduit`=\""+p.getIdProduit()+"\"";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false,p.getLibelle(),p.getDescription(),p.getPrix(),p.getdProduit(),"pc2.jpg",p.getCont(),p.getEtat());
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}
		

	}

	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("Échec de la fermeture du ResultSet : "
						+ e.getMessage());
			}
		}
	}

	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("Échec de la fermeture du Statement : "
						+ e.getMessage());
			}
		}
	}

	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse(Connection connexion) {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				System.out.println("Échec de la fermeture de la connexion : "
						+ e.getMessage());
			}
		}
	}

	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses(Statement statement,
			Connection connexion) {
		fermetureSilencieuse(statement);
		fermetureSilencieuse(connexion);
	}

	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses(ResultSet resultSet,
			PreparedStatement preparedStatement, Connection connexion) {
		fermetureSilencieuse(resultSet);
		fermetureSilencieuse(preparedStatement);
		fermetureSilencieuse(connexion);
	}

	@Override
	public ArrayList<Produit> GetProduitCategorie(int categorie) {

		Produit p;
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		String req = "SELECT `idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `etatproduit` FROM produit where `idCategorie`=\""
				+ categorie + "\"";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				p = map(resultSet);
				listeProduit.add(p);
			}
			return listeProduit;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

	}

	@Override
	public ArrayList<Produit> GetActualite() {

		Produit p;
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		String req = "SELECT `idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `etatproduit` FROM produit order by idProduit desc  LIMIT 0 , 4";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				p = map(resultSet);
				listeProduit.add(p);
			}
			return listeProduit;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

	}

	@Override
	public Produit getProduit(int id) {
		Produit p;
		ArrayList<Produit> listeProduit = new ArrayList<Produit>();
		String req = "SELECT `idProduit`, `libelle`, `description`, `prix`, `datePro`, `photo`, `quantitee`, `etatproduit` FROM produit where `idProduit`=\""
				+ id + "\"";
		try {
			connexion = df.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, req,
					false);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				p = map(resultSet);
				listeProduit.add(p);
			}
			return listeProduit.get(0);
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

	}

}
