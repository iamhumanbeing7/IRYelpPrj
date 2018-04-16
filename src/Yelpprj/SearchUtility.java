package Yelpprj;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import beans.searchResultDoc;
import Yelpprj.ConstantSet;

public class SearchUtility {

    private IndexSearcher idxSearcher;
    private IndexReader idxReader;

    public SearchUtility() {
        try {
            //create an index reader and index searcher
            idxReader = DirectoryReader.open(FSDirectory.open(Paths.get(ConstantSet.INDEX_Directory)));
            idxSearcher = new IndexSearcher(idxReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //report the number of documents indexed
    public int getCollectionSize() {
        return this.idxReader.numDocs();
    }

    //search for keywords in specified field, with the number of top results
    public List<searchResultDoc> search(String field, String keywords, int numHits) {

        //the query has to be analyzed the same way as the documents being index
        //using the same Analyzer
        QueryBuilder builder = new QueryBuilder(new StandardAnalyzer());
        Query query = builder.createBooleanQuery(field, keywords);
        ScoreDoc[] hits = null;
        List<searchResultDoc> lsrdReturn = new ArrayList<>();
        try {
            //Create a TopScoreDocCollector
            TopScoreDocCollector collector = TopScoreDocCollector.create(numHits);

            //search index
            idxSearcher.search(query, collector);

            //collect results
            hits = collector.topDocs().scoreDocs;
            int i =0;
            for (ScoreDoc hit : hits) {
//                System.out.println("\r\nResult " + i + "\tDocID: " + hit.doc + "\t Score: " + hit.score);
                try {

                    String  sReview_id 		= idxReader.document(hit.doc).get("review_id");
                    String  sUser_id 		= idxReader.document(hit.doc).get("user_id");
                    String  sBusiness_id 	= idxReader.document(hit.doc).get("business_id");
                    String  sDate 			= idxReader.document(hit.doc).get("date");
                    String  sReview_Text 	= idxReader.document(hit.doc).get("text");
                    int intUseful 			= Integer.parseInt(idxReader.document(hit.doc).get("useful").trim()) ;
                    int intFunny 			= Integer.parseInt(idxReader.document(hit.doc).get("funny").trim());
                    int intCool 			= Integer.parseInt(idxReader.document(hit.doc).get("cool").trim());
                    int intStars 			= Integer.parseInt(idxReader.document(hit.doc).get("stars").trim());
                    searchResultDoc srdVar = new searchResultDoc(hit.doc, sReview_id, sUser_id, sBusiness_id, sDate, sReview_Text, intUseful, intFunny, intCool, intStars, hit.score);
                    lsrdReturn.add(srdVar);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return lsrdReturn;
    }

    public void close() {
        try {
            if (idxReader != null) {
                idxReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
