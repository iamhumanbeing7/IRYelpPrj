package Yelpprj;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.lucene.*;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;
import org.json.JSONObject;

public class IndexUtility {
    /** Define the paths for the data file and the lucene index */

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main (String[] arg) throws Exception{

        Directory indexDir = FSDirectory.open(Paths.get(ConstantSet.INDEX_Directory));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
        cfg.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        IndexWriter writer = new IndexWriter(indexDir, cfg);
        Scanner in = new Scanner(new File(ConstantSet.DATA_FILE));
        int intLineNumber = 1;
        String sDataFileLine = "";
        while (in.hasNextLine()) {
            try {
                sDataFileLine = in.nextLine().trim();

                JSONObject jObj = new JSONObject(sDataFileLine);
                String sReview_id = jObj.getString("review_id");
                String sUser_id = jObj.getString("user_id");
                String sBusiness_id = jObj.getString("business_id");
                int intStars = jObj.getInt("stars");
                String sDate = jObj.getString("date");
                String sReview_Text = jObj.getString("text");
                int intUseful = jObj.getInt("useful");
                int intFunny = jObj.getInt("funny");
                int intCool = jObj.getInt("cool");

                //create a document for each JSON record
                Document doc = new Document();
                doc.add(new StringField("review_id", sReview_id, Field.Store.YES));
                doc.add(new StringField("user_id", sUser_id, Field.Store.YES));
                doc.add(new StringField("business_id", sBusiness_id, Field.Store.YES));

                doc.add(new IntPoint("stars", intStars));
                doc.add(new StoredField("stars",intStars));

                doc.add(new StringField("date", sDate, Field.Store.YES));
                doc.add(new TextField("text", sReview_Text, Field.Store.YES));

                doc.add(new IntPoint("useful", intUseful));
                doc.add(new StoredField("useful",intUseful));

                doc.add(new IntPoint("funny", intFunny));
                doc.add(new StoredField("funny",intFunny));

                doc.add(new IntPoint("cool", intCool));
                doc.add(new StoredField("cool",intCool));

                writer.addDocument(doc);

                intLineNumber++;
            } catch (Exception e) {
                System.out.println("Error at: " + intLineNumber + "\t" + sDataFileLine);
                e.printStackTrace();
            }
        }
        //close the file reader
        in.close();
        System.out.println("Index completed at " + sdf.format(new Date()));
        System.out.println("Total number of documents indexed: " + writer.maxDoc());

        //close the index writer.
        writer.close();

    }
}
