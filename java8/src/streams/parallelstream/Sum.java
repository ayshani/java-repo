package streams.parallelstream;

public class Sum {
    private int total;

    public void performSum(int input){
        total +=input;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
