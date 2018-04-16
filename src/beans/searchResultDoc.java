package beans;

public class searchResultDoc {
    private int intDocID;
    private String  sReview_id;
    private String  sUser_id;
    private String  sBusiness_id;
    private String  sDate;
    private String  sReview_Text;
    private int intUseful;
    private int intFunny;
    private int intCool;
    private int intStars;

    private float fltDocSearchScore;

    public searchResultDoc(){}

    public searchResultDoc(int intIArgDocID, String  sArgReview_id, String  sArgUser_id, String  sArgBusiness_id, String  sArgDate, String  sArgReview_Text, int intArgUseful, int intArgFunny, int intArgCool, int intArgStars, float fltIArgDocSearchScore) {

        this.intDocID = intIArgDocID;
        this.sReview_id = sArgReview_id;
        this.sUser_id = sArgUser_id;
        this.sBusiness_id = sArgBusiness_id;
        this.sDate = sArgDate;
        this.sReview_Text = sArgReview_Text;
        this.intUseful = intArgUseful;
        this.intFunny = intArgFunny;
        this.intCool = intArgCool;
        this.intStars = intArgStars;
        this.fltDocSearchScore = fltIArgDocSearchScore;

    }

    public int getIntDocID() {
        return intDocID;
    }

    public void setIntDocID(int intDocID) {
        this.intDocID = intDocID;
    }

    public String getsReview_id() {
        return sReview_id;
    }

    public void setsReview_id(String sReview_id) {
        this.sReview_id = sReview_id;
    }

    public String getsUser_id() {
        return sUser_id;
    }

    public void setsUser_id(String sUser_id) {
        this.sUser_id = sUser_id;
    }

    public String getsBusiness_id() {
        return sBusiness_id;
    }

    public void setsBusiness_id(String sBusiness_id) {
        this.sBusiness_id = sBusiness_id;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsReview_Text() {
        return sReview_Text;
    }

    public void setsReview_Text(String sReview_Text) {
        this.sReview_Text = sReview_Text;
    }

    public int getIntUseful() {
        return intUseful;
    }

    public void setIntUseful(int intUseful) {
        this.intUseful = intUseful;
    }

    public int getIntFunny() {
        return intFunny;
    }

    public void setIntFunny(int intFunny) {
        this.intFunny = intFunny;
    }

    public int getIntCool() {
        return intCool;
    }

    public void setIntCool(int intCool) {
        this.intCool = intCool;
    }

    public int getIntStars() {
        return intStars;
    }

    public void setIntStars(int intStars) {
        this.intStars = intStars;
    }

    public float getFltDocSearchScore() {
        return fltDocSearchScore;
    }

    public void setFltDocSearchScore(float fltDocSearchScore) {
        this.fltDocSearchScore = fltDocSearchScore;
    }
}
