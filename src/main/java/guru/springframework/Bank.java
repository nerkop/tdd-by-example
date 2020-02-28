package guru.springframework;

public class Bank {

    MoneyCurrency reduced(Expression source, String toCurrency){
        return source.reduce(toCurrency);
    }
}
