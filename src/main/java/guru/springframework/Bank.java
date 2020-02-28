package guru.springframework;

import java.util.HashMap;

public class Bank {

    private HashMap<Pair, Integer> ratMap = new HashMap<>();

    MoneyCurrency reduced(Expression source, String toCurrency) {
        return source.reduce(this,toCurrency);
    }

    public int rate(String from, String to) {
        if (from.equals(to)){
            return 1;
        }
        return ratMap.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        ratMap.put(new Pair(from, to), rate);

    }
}
