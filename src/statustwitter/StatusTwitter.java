package statustwitter;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Clase para recobrar los twitts del morrazo
 *
 * @author damian
 */
public class StatusTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {

        Twitter twitter;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("cCwlXGbOea4tWifNEsWSYZowp")
                .setOAuthConsumerSecret("nVckoYIfas2ucRVUROQcB0s6ZDHCpjOdvw8G6i0v72ilKY0xKy")
                .setOAuthAccessToken("3055269988-3EClzoFaUspMzlM1O7tTebuGe3vyi5rCkSU3LiB")
                .setOAuthAccessTokenSecret("ibohhy5rRk0ue0SQ3zhCUpmvhfEXCooULhtKfs2PUEwL5");
        twitter = new TwitterFactory(cb.build()).getInstance();

        Paging pagina = new Paging();


        Query query = new Query("#Cangas");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }
}
