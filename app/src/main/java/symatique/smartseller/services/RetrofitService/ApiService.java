package symatique.smartseller.services.RetrofitService;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import symatique.smartseller.bases.RetrofitBases;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Stocks.BonDeSortie;
import symatique.smartseller.data.Stocks.BonDeSortiesResponse;
import symatique.smartseller.data.Utilisateurs.AuthenticationResponse;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Articles.Domaine;
import symatique.smartseller.data.Articles.Entreprise;
import symatique.smartseller.data.Commandes.EtatCommande;
import symatique.smartseller.data.Ventes.NatureVente;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Factures.PrefixFacture;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;

public class ApiService implements ApiRegister {

    private static ApiRegister apiService = null;
    private Callback<AuthenticationResponse> authenticatedCallback;
    private Callback<BonDeSortiesResponse> bonSortieCallback;
    private Callback<String> updatePrixArticleCallback;
    private Callback<PrefixFacture> prefixsFactureCallback;
    private Callback<PrefixBL> prefixsBLCallback;
    private Callback<Client> clientsCallback;
    private Callback<Domaine> synchDomaineCallback;
    private Callback<Article> articlesCallback;
    private Callback<CategorieArticle> allCategoryCallback;
    private Callback<EtatCommande> etatCommandeCallback;
    private Callback<NatureVente> synchroniserNatureVentesCallback;
    private Callback<TypeEncaissementVente> synchroniserTypeEncaissementVenteCallback;
    private Callback<Banque> synchroniserBanqueCallback;
    private Callback<Commande> synchroniserVendeurCommandeCallback;
    private Callback<Object> synchroniserPaquetSupprimerCallback;

    /*
    private Call<AuthenticationResponse> authenticationResponseCall;
    private Call<BonDeSortiesResponse> bonDeSortieCall;
    private Call<List<String>> listCall;
    private Call<List<PrefixFacture>> listPrefixFactureCall;
    private Call<List<PrefixBL>> listPrefixBLCall;
    private Call<List<Client>> listClientCall;
    private Call<List<Entreprise>> listEntrepriseCall;
    private Call<List<Article>> listArticleCall;
    private Call<List<CategorieArticle>> listCategorieArticeCall;
    private Call<List<EtatCommande>> listEtatCommandeCall;
    private Call<List<NatureVente>> listNatureVenteCall;
    private Call<List<TypeEncaissementVente>> listTypeEncaissementVenteCall;
    private Call<List<Banque>> listBanqueCall;
    private Call<List<Commande>> listCommandeCall;
    private Call<List<BonDeSortiesResponse>> listBonDeSortieCall;
    */

    public static ApiRegister getApiService() {
        if(apiService == null)
            apiService = new Retrofit.Builder().baseUrl(RetrofitBases.BASE_URL).addConverterFactory(JacksonConverterFactory.create()).build().create(ApiRegister.class);
        return apiService;
    }

    @Override// s
    public Call<AuthenticationResponse> getAuthentificated(String code, String pwd, String imei, String appVersion) {
         return  getApiService().getAuthentificated(code,pwd,imei,appVersion);
    }

    @Override
    public Call<BonDeSortiesResponse> getBonSortie(String idLivreur, long idEntreprise, boolean premier_utilisation) {
        return getApiService().getBonSortie(idLivreur,idEntreprise,premier_utilisation);
    }

    @Override
    public Call<List<String>> updatePrixArticle(long idLivreur, long dateSynchro) {
        return getApiService().updatePrixArticle(idLivreur,dateSynchro);
    }

    @Override//S
    public Call<List<PrefixFacture>> getPrefixsFacture(long idLivreur, long idEntreprise) {
        return getApiService().getPrefixsFacture(idLivreur,idEntreprise);
    }

    @Override//S
    public Call<List<PrefixBL>> getPrefixsBL(long idLivreur, long idEntreprise) {
        return getApiService().getPrefixsBL(idLivreur,idEntreprise);
    }

    @Override//S
    public Call<List<Client>> getClients(long date, long idEntreprise) {
        return getApiService().getClients(date,idEntreprise);
    }

    @Override
    public Call<List<Entreprise>> synchDomaine(long date, long idEntreprise) {
        return getApiService().synchDomaine(date,idEntreprise);
    }

    @Override//S
    public Call<List<Article>> getArticles(long date, long idEntreprise) {
        return getApiService().getArticles(date,idEntreprise);
    }

    @Override//S
    public Call<List<CategorieArticle>> getAllCategory(long date, long idEntreprise) {
        return getApiService().getAllCategory(date,idEntreprise);
    }

    @Override
    public Call<List<EtatCommande>> getEtatCommande(long date, long idEntreprise) {
        return getApiService().getEtatCommande(date,idEntreprise);
    }

    @Override//S
    public Call<List<NatureVente>> synchroniserNatureVentes(long date, long idEntreprise) {
        return getApiService().synchroniserNatureVentes(date,idEntreprise);
    }

    @Override//S
    public Call<List<TypeEncaissementVente>> synchroniserTypeEncaissementVente(long date, long idEntreprise) {
        return getApiService().synchroniserTypeEncaissementVente(date,idEntreprise);
    }

    @Override//S
    public Call<List<Banque>> synchroniserBanque(long date, long idEntreprise) {
        return getApiService().synchroniserBanque(date,idEntreprise);
    }

    @Override//S
    public Call<List<Commande>> synchroniserVendeurCommande(long id, long date) {
        return getApiService().synchroniserVendeurCommande(id,date);
    }

    @Override
    public Call<List<BonDeSortiesResponse>> synchroniserPaquetSupprimer(long id_Livreur) {
        return getApiService().synchroniserPaquetSupprimer(id_Livreur);
    }

    @Override
    public Call<BonDeSortie> exportBonDeSorties(BonDeSortie bonDeSortie) {
        return getApiService().exportBonDeSorties(bonDeSortie);
    }

    public static void standartNotifyFailerResponse(Throwable t){
        Log.v("RETROFT RESPONSE FAILER","Throwable->" + t.getMessage());
    }
}