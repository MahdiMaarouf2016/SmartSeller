package symatique.smartseller.services.SQLiteService;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import symatique.smartseller.data.Article;
import symatique.smartseller.data.Banque;
import symatique.smartseller.data.BonDeSortie;
import symatique.smartseller.data.CategorieArticle;
import symatique.smartseller.data.Client;
import symatique.smartseller.data.DetailBL;
import symatique.smartseller.data.DetailBonDeSortie;
import symatique.smartseller.data.Commande;
import symatique.smartseller.data.DetailFacture;
import symatique.smartseller.data.DetailStock;
import symatique.smartseller.data.DetailVente;
import symatique.smartseller.data.Domaine;
import symatique.smartseller.data.Encaissement;
import symatique.smartseller.data.Entreprise;
import symatique.smartseller.data.EtatCommande;
import symatique.smartseller.data.PrefixFacture;
import symatique.smartseller.data.DetailCommande;
import symatique.smartseller.data.Livreur;
import symatique.smartseller.data.MotifRapportVisite;
import symatique.smartseller.data.NatureVente;
import symatique.smartseller.data.PrefixBL;
import symatique.smartseller.data.RapportVisite;
import symatique.smartseller.data.TypeEncaissementVente;
import symatique.smartseller.data.Vente;
import symatique.smartseller.modules.Panier.PanierAdapter;

import static symatique.smartseller.bases.SQLiteBases.DATABASE_NAME;
import static symatique.smartseller.bases.SQLiteBases.DATABASE_VERSION;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private Dao<Article,Integer> articles;
	private Dao<Banque,Integer> banques;
	private Dao<BonDeSortie,Integer> bonDeSortieDao;
	private Dao<DetailBonDeSortie,Integer> bonSorties;
	private Dao<CategorieArticle,Integer> categorieArtices;
	private Dao<Client,Integer> clients;
	private Dao<Commande,Integer> commandes;
	private Dao<Domaine,Integer> domaines;
	private Dao<EtatCommande,Integer> etatCommandes;
	private Dao<PrefixFacture,Integer> factures;
	private Dao<DetailCommande,Integer> detailCommandes;
	private Dao<DetailBL,Integer> detailBLS;
    private Dao<DetailFacture,Integer> detailFactures;
    private Dao<DetailStock,Integer> detailStocks;
    private Dao<DetailVente,Integer> detailVentes;
    private Dao<DetailBonDeSortie,Integer> detailBonDeSorties;
	private Dao<Livreur,Integer> livreurs;
	private Dao<NatureVente,Integer> natureVentes;
	private Dao<PanierAdapter.PanierItem.PanierPacket,Integer> panierPackets;
	private Dao<PrefixBL,Integer> prefixBLS;
	private Dao<PrefixFacture,Integer> prefixFactures;
	private Dao<RapportVisite,Integer> rapportVisites;
	private Dao<TypeEncaissementVente,Integer> typeEncaissementVentes;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
		try {

			TableUtils.createTable(connectionSource, Article.class);
			TableUtils.createTable(connectionSource, Banque.class);
			TableUtils.createTable(connectionSource, BonDeSortie.class);
			TableUtils.createTable(connectionSource, CategorieArticle.class);
			TableUtils.createTable(connectionSource, Client.class);
			TableUtils.createTable(connectionSource, Commande.class);
			TableUtils.createTable(connectionSource, DetailCommande.class);
			TableUtils.createTable(connectionSource, DetailBL.class);
			TableUtils.createTable(connectionSource, DetailBonDeSortie.class);
			TableUtils.createTable(connectionSource, DetailFacture.class);
			TableUtils.createTable(connectionSource, DetailStock.class);
			TableUtils.createTable(connectionSource, DetailVente.class);
			TableUtils.createTable(connectionSource, Domaine.class);
			TableUtils.createTable(connectionSource, Encaissement.class);
			TableUtils.createTable(connectionSource, Entreprise.class);
			TableUtils.createTable(connectionSource, EtatCommande.class);
			TableUtils.createTable(connectionSource, PrefixFacture.class);
			TableUtils.createTable(connectionSource, Livreur.class);
			TableUtils.createTable(connectionSource, MotifRapportVisite.class);
			TableUtils.createTable(connectionSource, NatureVente.class);
            TableUtils.createTable(connectionSource, PanierAdapter.PanierItem.PanierPacket.class);
			TableUtils.createTable(connectionSource, PrefixBL.class);
			TableUtils.createTable(connectionSource, PrefixFacture.class);
			TableUtils.createTable(connectionSource, RapportVisite.class);
			TableUtils.createTable(connectionSource, TypeEncaissementVente.class);
			TableUtils.createTable(connectionSource, Vente.class);
			Log.v("DATA BASE","TABLES WAS SETTED");
			Log.v("SQL 1",TableUtils.getCreateTableStatements(connectionSource, Article.class).toString());
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to create datbases", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
		try {

			TableUtils.dropTable(connectionSource, Article.class,true);
			TableUtils.dropTable(connectionSource, Banque.class,true);
			TableUtils.dropTable(connectionSource, BonDeSortie.class,true);
			TableUtils.dropTable(connectionSource, CategorieArticle.class,true);
			TableUtils.dropTable(connectionSource, Client.class,true);
			TableUtils.dropTable(connectionSource, Commande.class,true);
			TableUtils.dropTable(connectionSource, DetailBL.class,true);
			TableUtils.dropTable(connectionSource, DetailBonDeSortie.class,true);
			TableUtils.dropTable(connectionSource, DetailCommande.class,true);
			TableUtils.dropTable(connectionSource, DetailFacture.class,true);
			TableUtils.dropTable(connectionSource, DetailStock.class,true);
			TableUtils.dropTable(connectionSource, DetailVente.class,true);
			TableUtils.dropTable(connectionSource, Domaine.class,true);
			TableUtils.dropTable(connectionSource, Encaissement.class,true);
			TableUtils.dropTable(connectionSource, Entreprise.class,true);
			TableUtils.dropTable(connectionSource, EtatCommande.class,true);
			TableUtils.dropTable(connectionSource, PrefixFacture.class,true);
			TableUtils.dropTable(connectionSource, Livreur.class,true);
			TableUtils.dropTable(connectionSource, MotifRapportVisite.class,true);
			TableUtils.dropTable(connectionSource, NatureVente.class,true);
            TableUtils.dropTable(connectionSource, PanierAdapter.PanierItem.PanierPacket.class,true);
			TableUtils.dropTable(connectionSource, PrefixBL.class,true);
			TableUtils.dropTable(connectionSource, PrefixFacture.class,true);
			TableUtils.dropTable(connectionSource, RapportVisite.class,true);
			TableUtils.dropTable(connectionSource, TypeEncaissementVente.class,true);
			TableUtils.dropTable(connectionSource, Vente.class,true);
			onCreate(sqliteDatabase, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + oldVer + " to new "
					+ newVer, e);
		}

	}

	public Dao<Article, Integer> getArticles() throws SQLException {
		if(articles == null)
			articles = getDao(Article.class);
		return articles;
	}

	public Dao<Banque, Integer> getBanques() throws SQLException {
		if(banques == null)
			banques = getDao(Banque.class);
		return banques;
	}

	public Dao<BonDeSortie, Integer> getBonDeSortieDao() throws SQLException {
		if(bonDeSortieDao == null)
			bonDeSortieDao = getDao(BonDeSortie.class);
		return bonDeSortieDao;
	}

	public Dao<DetailBonDeSortie, Integer> getBonSorties() throws SQLException {
		if(bonSorties == null)
			bonSorties = getDao(DetailBonDeSortie.class);
		return bonSorties;
	}

	public Dao<CategorieArticle, Integer> getCategorieArtices() throws SQLException {
		if(categorieArtices == null)
			categorieArtices = getDao(CategorieArticle.class);
		return categorieArtices;
	}

	public Dao<Client, Integer> getClients() throws SQLException {
		if(clients == null)
			clients = getDao(Client.class);
		return clients;
	}

	public Dao<Commande, Integer> getCommandes() throws SQLException {
		if(commandes == null)
			commandes = getDao(Commande.class);
		return commandes;
	}

	public Dao<Domaine, Integer> getDomaines() throws SQLException {
		if(domaines == null)
			domaines = getDao(Domaine.class);
		return domaines;
	}

	public Dao<EtatCommande, Integer> getEtatCommandes() throws SQLException {
		if(etatCommandes == null)
			etatCommandes = getDao(EtatCommande.class);
		return etatCommandes;
	}

	public Dao<PrefixFacture, Integer> getFactures() throws SQLException {
		if(factures == null)
			factures = getDao(PrefixFacture.class);
		return factures;
	}

	public Dao<Livreur, Integer> getLivreurs() throws SQLException {
		if(livreurs == null)
			livreurs = getDao(Livreur.class);
		return livreurs;
	}

	public Dao<NatureVente, Integer> getNatureVentes() throws SQLException {
		if(natureVentes == null)
			natureVentes = getDao(NatureVente.class);
		return natureVentes;
	}

	public Dao<PanierAdapter.PanierItem.PanierPacket,Integer> getPanierPackets() throws SQLException {
	    if(panierPackets == null)
	        panierPackets = getDao(PanierAdapter.PanierItem.PanierPacket.class);
	    return panierPackets;
    }

	public Dao<PrefixBL, Integer> getPrefixBLS() throws SQLException {
		if(prefixBLS == null)
			prefixBLS = getDao(PrefixBL.class);
		return prefixBLS;
	}

	public Dao<PrefixFacture, Integer> getPrefixFactures() throws SQLException {
		if(prefixFactures == null)
			prefixFactures = getDao(PrefixFacture.class);
		return prefixFactures;
	}

	public Dao<RapportVisite, Integer> getRapportVisites() throws SQLException {
		if(rapportVisites == null)
			rapportVisites = getDao(RapportVisite.class);
		return rapportVisites;
	}

	public Dao<TypeEncaissementVente, Integer> getTypeEncaissementVentes() throws SQLException {
		if(typeEncaissementVentes == null)
			typeEncaissementVentes = getDao(TypeEncaissementVente.class);
		return typeEncaissementVentes;
	}

    public Dao<DetailCommande, Integer> getDetailCommandes() {
        return detailCommandes;
    }

    public Dao<DetailBL, Integer> getDetailBLS() throws SQLException {
	    if(detailBLS == null)
	        detailBLS = getDao(DetailBL.class);
        return detailBLS;
    }

    public Dao<DetailFacture, Integer> getDetailFactures() throws SQLException {
	    if(detailFactures == null)
	        detailFactures = getDao(DetailFacture.class);
        return detailFactures;
    }

    public Dao<DetailStock, Integer> getDetailStocks() throws SQLException {
        if(detailStocks == null)
            detailStocks = getDao(DetailStock.class);
        return detailStocks;
    }

    public Dao<DetailVente, Integer> getDetailVentes() throws SQLException {
        if(detailVentes == null)
            detailVentes = getDao(DetailVente.class);
        return detailVentes;
    }

    public Dao<DetailBonDeSortie, Integer> getDetailBonDeSorties() throws SQLException {
        if(detailBonDeSorties == null)
            detailBonDeSorties = getDao(DetailBonDeSortie.class);
        return detailBonDeSorties;
    }
}
