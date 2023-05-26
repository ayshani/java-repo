package simple;

public class TokenBucketFilter {

    private int MAX_TOKENS;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleToken =0;

    public TokenBucketFilter(int maxTokens){
        this.MAX_TOKENS = maxTokens;
    }

    /*
    Note how getToken() doesn't return any token type ! The fact a thread can return from the getToken call
    would imply that the thread has the token, which is nothing more than a permission to undertake some action.
     */
    synchronized void getToken() throws InterruptedException {
        // Divide by a 1000 to get granularity at the second level.
        possibleToken += (System.currentTimeMillis() - lastRequestTime)/1000;

        if(possibleToken>MAX_TOKENS){
            possibleToken = MAX_TOKENS;
        }

        if(possibleToken ==0){
            Thread.sleep(1000);
        } else{
            possibleToken--;
        }

        lastRequestTime = System.currentTimeMillis();

        System.out.println("Granting "+ Thread.currentThread().getName() +" token at : "+ lastRequestTime/1000);
    }
}
