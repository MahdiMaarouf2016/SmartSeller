package symatique.smartseller.services.SQLiteService;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.data.Articles.Domaine;
import symatique.smartseller.data.Articles.Entreprise;
import symatique.smartseller.data.Factures.Facture;
import symatique.smartseller.data.Factures.LigneFacture;
import symatique.smartseller.data.Stocks.BonDeSortie;
import symatique.smartseller.data.Stocks.BonDeSortiesResponse;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Commandes.EtatCommande;
import symatique.smartseller.data.Commandes.LigneCommande;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Encaissements.Encaissement;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Factures.PrefixFacture;
import symatique.smartseller.data.Stocks.Packet;
import symatique.smartseller.data.Utilisateurs.Livreur;
import symatique.smartseller.data.Ventes.*;

import static symatique.smartseller.bases.SQLiteBases.DATABASE_NAME;
import static symatique.smartseller.bases.SQLiteBases.DATABASE_VERSION;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private Dao<Article,Integer> articles;
	private Dao<Banque,Integer> banques;
	private Dao<CategorieArticle,Integer> categorieArtices;
	private Dao<Client,Integer> clients;
	private Dao<Commande,Integer> commandes;
	private Dao<Domaine,Integer> domaines;
	private Dao<EtatCommande,Integer> etatCommandes;
    private Dao<PrefixFacture, Integer> prefixfactures;
    private Dao<Facture, Integer> factures;
    private Dao<LigneFacture, Integer> ligneFacture;
    private Dao<BonDeSortie,Integer> bonDeSorties;
    private Dao<Packet,Integer> packetsStock;
    private Dao<DetailVente,Integer> detailVentes;
	private Dao<Livreur,Integer> livreurs;
	private Dao<NatureVente,Integer> natureVentes;
	private Dao<PrefixBL,Integer> prefixBLS;
	private Dao<PrefixFacture,Integer> prefixFactures;
	private Dao<RapportVisite,Integer> rapportVisites;
	private Dao<TypeEncaissementVente,Integer> typeEncaissementVentes;
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

    // + ---------------------------------------- QUERY FOR VALUE ------------------------------------------------
    public static long getDateSynchroniseClients(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getClients().queryRawValue("SELECT MAX(dateSynchro) FROM " + database.getClients().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public static long getDateSynchroniseCategorieArticles(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getCategorieArtices().queryRawValue("SELECT MAX(dateSynchro) FROM " + database.getCategorieArtices().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public Dao<Article, Integer> getArticles() throws SQLException {
        if (articles == null)
            articles = getDao(Article.class);
        return articles;
    }

    public Dao<Banque, Integer> getBanques() throws SQLException {
        if (banques == null)
            banques = getDao(Banque.class);
        return banques;
    }

    public Dao<CategorieArticle, Integer> getCategorieArtices() throws SQLException {
        if (categorieArtices == null)
            categorieArtices = getDao(CategorieArticle.class);
        return categorieArtices;
    }

    public Dao<Client, Integer> getClients() throws SQLException {
        if (clients == null)
            clients = getDao(Client.class);
        return clients;
    }

    public Dao<Commande, Integer> getCommandes() throws SQLException {
        if (commandes == null)
            commandes = getDao(Commande.class);
        return commandes;
    }

    public Dao<Domaine, Integer> getDomaines() throws SQLException {
        if (domaines == null)
            domaines = getDao(Domaine.class);
        return domaines;
    }

    public Dao<EtatCommande, Integer> getEtatCommandes() throws SQLException {
        if (etatCommandes == null)
            etatCommandes = getDao(EtatCommande.class);
        return etatCommandes;
    }

    public static long getDateSynchroniseArticles(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getArticles().queryRawValue("SELECT MAX(dateSynchro) FROM " + database.getArticles().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public static long getDateSynchroniseCommandes(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getCommandes().queryRawValue("SELECT MAX(dateSynch) FROM " + database.getCommandes().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public Dao<Livreur, Integer> getLivreurs() throws SQLException {
        if (livreurs == null)
            livreurs = getDao(Livreur.class);
        return livreurs;
    }

    public Dao<NatureVente, Integer> getNatureVentes() throws SQLException {
        if (natureVentes == null)
            natureVentes = getDao(NatureVente.class);
        return natureVentes;
    }

    public Dao<PrefixBL, Integer> getPrefixBLS() throws SQLException {
        if (prefixBLS == null)
            prefixBLS = getDao(PrefixBL.class);
        return prefixBLS;
    }

    public Dao<PrefixFacture, Integer> getPrefixFactures() throws SQLException {
        if (prefixFactures == null)
            prefixFactures = getDao(PrefixFacture.class);
        return prefixFactures;
    }

    public Dao<RapportVisite, Integer> getRapportVisites() throws SQLException {
        if (rapportVisites == null)
            rapportVisites = getDao(RapportVisite.class);
        return rapportVisites;
    }

    public Dao<TypeEncaissementVente, Integer> getTypeEncaissementVentes() throws SQLException {
        if (typeEncaissementVentes == null)
            typeEncaissementVentes = getDao(TypeEncaissementVente.class);
        return typeEncaissementVentes;
    }

    public static long getDateSynchroniseNatureVentes(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getNatureVentes().queryRawValue("SELECT MAX(dateSynch) FROM " + database.getNatureVentes().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public Dao<Packet, Integer> getPacketsStock() throws SQLException {
        if (packetsStock == null)
            packetsStock = getDao(Packet.class);
        return packetsStock;
    }

    public Dao<DetailVente, Integer> getDetailVentes() throws SQLException {
        if (detailVentes == null)
            detailVentes = getDao(DetailVente.class);
        return detailVentes;
    }

    public Dao getBonDeSorties() throws SQLException {
        if (bonDeSorties == null)
            bonDeSorties = getDao(BonDeSortie.class);
        return bonDeSorties;
    }

    public static long getDateSynchroniseTypeEncaissementVente(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getTypeEncaissementVentes().queryRawValue("SELECT MAX(dateSynchro) FROM " + database.getTypeEncaissementVentes().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public static long getDateSynchroniseBanques(Context context) {

        long maxDateSynchro = 0;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            maxDateSynchro = database.getBanques().queryRawValue("SELECT MAX(dateSynchro) FROM " + database.getBanques().getTableName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxDateSynchro;
    }

    public static EtatCommande getEtatCommandeByArgs(Context context, String argwhere1, Object argwhere2) {
        EtatCommande etatCommande = null;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            etatCommande = database.getEtatCommandes().queryBuilder().where().eq(argwhere1, argwhere2).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etatCommande;
    }

    public static TypeEncaissementVente getTypeEncaissmentByArgs(Context context, String argwhere1, Object argwhere2) {

        TypeEncaissementVente typeEncaissementVente = null;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            typeEncaissementVente = database.getTypeEncaissementVentes().queryBuilder().where().eq(argwhere1, argwhere2).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return typeEncaissementVente;
    }

	@Override
	public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
		try {
            TableUtils.dropTable(connectionSource, Article.class,true);
            TableUtils.dropTable(connectionSource, Banque.class,true);
            TableUtils.dropTable(connectionSource, CategorieArticle.class,true);
            TableUtils.dropTable(connectionSource, Client.class,true);
            TableUtils.dropTable(connectionSource, Commande.class,true);
            TableUtils.dropTable(connectionSource, LigneCommande.class,true);
            TableUtils.dropTable(connectionSource, LigneFacture.class, true);
            TableUtils.dropTable(connectionSource, Packet.class,true);
            TableUtils.dropTable(connectionSource, DetailVente.class,true);
            TableUtils.dropTable(connectionSource, Domaine.class,true);
            TableUtils.dropTable(connectionSource, Encaissement.class,true);
            TableUtils.dropTable(connectionSource, Entreprise.class,true);
            TableUtils.dropTable(connectionSource, EtatCommande.class,true);
            TableUtils.dropTable(connectionSource, Livreur.class,true);
            TableUtils.dropTable(connectionSource, NatureVente.class,true);
            TableUtils.dropTable(connectionSource, PrefixBL.class,true);
            TableUtils.dropTable(connectionSource, PrefixFacture.class,true);
            TableUtils.dropTable(connectionSource, RapportVisite.class,true);
            TableUtils.dropTable(connectionSource, TypeEncaissementVente.class,true);
            TableUtils.dropTable(connectionSource, Vente.class,true);
            TableUtils.dropTable(connectionSource, Facture.class, true);

			TableUtils.createTable(connectionSource, Article.class);
			TableUtils.createTable(connectionSource, Banque.class);
			TableUtils.createTable(connectionSource, CategorieArticle.class);
			TableUtils.createTable(connectionSource, Client.class);
			TableUtils.createTable(connectionSource, Commande.class);
			TableUtils.createTable(connectionSource, LigneCommande.class);
            TableUtils.createTable(connectionSource, LigneFacture.class);
			TableUtils.createTable(connectionSource, Packet.class);
			TableUtils.createTable(connectionSource, DetailVente.class);
			TableUtils.createTable(connectionSource, Domaine.class);
			TableUtils.createTable(connectionSource, Encaissement.class);
			TableUtils.createTable(connectionSource, Entreprise.class);
			TableUtils.createTable(connectionSource, EtatCommande.class);
			TableUtils.createTable(connectionSource, Livreur.class);
			TableUtils.createTable(connectionSource, NatureVente.class);
			TableUtils.createTable(connectionSource, PrefixBL.class);
			TableUtils.createTable(connectionSource, PrefixFacture.class);
			TableUtils.createTable(connectionSource, RapportVisite.class);
			TableUtils.createTable(connectionSource, TypeEncaissementVente.class);
			TableUtils.createTable(connectionSource, Vente.class);
            TableUtils.createTable(connectionSource, Facture.class);
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
			TableUtils.dropTable(connectionSource, BonDeSortiesResponse.class,true);
			TableUtils.dropTable(connectionSource, CategorieArticle.class,true);
			TableUtils.dropTable(connectionSource, Client.class,true);
			TableUtils.dropTable(connectionSource, Commande.class,true);
			TableUtils.dropTable(connectionSource, LigneCommande.class,true);
            TableUtils.dropTable(connectionSource, LigneFacture.class, true);
			TableUtils.dropTable(connectionSource, Packet.class,true);
			TableUtils.dropTable(connectionSource, DetailVente.class,true);
			TableUtils.dropTable(connectionSource, Domaine.class,true);
			TableUtils.dropTable(connectionSource, Encaissement.class,true);
			TableUtils.dropTable(connectionSource, Entreprise.class,true);
			TableUtils.dropTable(connectionSource, EtatCommande.class,true);
			TableUtils.dropTable(connectionSource, PrefixFacture.class,true);
			TableUtils.dropTable(connectionSource, Livreur.class,true);
			TableUtils.dropTable(connectionSource, NatureVente.class,true);
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

    public Dao<Facture, Integer> getFactures() throws SQLException {
		if(factures == null)
            factures = getDao(Facture.class);
		return factures;
	}

    public Dao<PrefixFacture, Integer> getPrefixfacturesFactures() throws SQLException {
        if (prefixfactures == null)
            prefixfactures = getDao(PrefixFacture.class);
        return prefixfactures;
    }

    public Dao<LigneFacture, Integer> getDetailFactures() throws SQLException {
        if (ligneFacture == null)
            ligneFacture = getDao(LigneFacture.class);
        return ligneFacture;
    }

    public PrefixBL getPrifixBlByArgs(Context context, String argwhere1, Object argwhere2) {
        PrefixBL prefixBL = null;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            prefixBL = database.getPrefixBLS().queryBuilder().where().eq(argwhere1, argwhere2).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prefixBL;
    }

    public PrefixFacture getPrifixFactureByArgs(Context context, String argwhere1, Object argwhere2) {
        PrefixFacture prefixFacture = null;

        try {
            DatabaseHelper database = DataBaseManager.getInstance(context).getHelper();
            prefixFacture = database.getPrefixFactures().queryBuilder().where().eq(argwhere1, argwhere2).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prefixFacture;
    }


    // - ---------------------------------------- QUERY FOR VALUE ------------------------------------------------
}
