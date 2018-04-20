package Yelpprj;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "InstantSet")
@SessionScoped
public class ConstantSet {

    public static final String DATA_FILE="D:/IRResources/data/yelp_dataset/IRPrj/review.json";
    public static final String INDEX_Directory="D:/IRResources/data/yelp_dataset/IRPrj/Index";
    public static final int numHits=20;
}
