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
                .setOAuthConsumerKey("R1wJ3p0He4NbjHcNEQMRBZCOy")
                .setOAuthConsumerSecret("d3YEzh7A6PaZml2DPAuAsSUMelfMMfssCC29Nvf8wyHy6jDo18")
                .setOAuthAccessToken("3063743111-zMOb1dugAFn3xP9ltPIMCLRwIhMGn0Kpu8h8RKt")
                .setOAuthAccessTokenSecret("2dD7LfICbg4VOLDPdU2x0Qk0IjulGyLV2Gk0z6mIzsGV1");
        twitter = new TwitterFactory(cb.build()).getInstance();

        Paging pagina = new Paging();

        Twitter mitwitter = new TwitterFactory().getInstance();

        Query query = new Query("#Cangas");
        QueryResult result = mitwitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }
}
