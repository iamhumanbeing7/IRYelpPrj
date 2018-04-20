package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Yelpprj.ConstantSet;
import Yelpprj.SearchUtility;
import org.apache.lucene.search.ScoreDoc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "searchResultBean")
@SessionScoped

public class searchResultBean implements Serializable {

    private List<searchResultDoc> searchResultDocList = new ArrayList<>();
    private String sField, sKeywords;
    private int intHits;

    public String getsField() {
        return sField;
    }

    public void setsField(String sField) {
        this.sField = sField;
    }

    public String getsKeywords() {
        return sKeywords;
    }

    public void setsKeywords(String sKeywords) {
        this.sKeywords = sKeywords;
    }

    public int getIntHits() {
        return intHits;
    }

    public void setIntHits(int intHits) {
        this.intHits = intHits;
    }

    public void search (){
        SearchUtility suVar = new SearchUtility();
        this.searchResultDocList = suVar.search(sField, sKeywords, intHits);
    }

    public List<searchResultDoc> getSearchResultDocList() {
        return searchResultDocList;
    }

    public void setSearchResultDocList(List<searchResultDoc> lstSearchResultDocList) {
        this.searchResultDocList = lstSearchResultDocList;
    }
}
