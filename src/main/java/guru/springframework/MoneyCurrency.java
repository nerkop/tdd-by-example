package guru.springframework;

public class MoneyCurrency implements Expression {

    protected int amount;
    protected String currency;

    public MoneyCurrency(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String getCurrency(){
        return currency;
    }

    public static MoneyCurrency getDollar (int amount){
        return new MoneyCurrency(amount, "USD");
    }

    public static MoneyCurrency getFranc(int amount){
        return new MoneyCurrency(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new MoneyCurrency(amount*multiplier, this.currency);
    }

    public Expression plus (Expression addend){
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        MoneyCurrency moneyCurrency = (MoneyCurrency) object;
        return amount == moneyCurrency.amount && this.currency == moneyCurrency.currency;
    }

    @Override
    public MoneyCurrency reduce(Bank bank, String to){
        return new MoneyCurrency(amount / bank.rate(this.currency, to), to);
    }



    @Override
    public String toString() {
        return "MoneyCurrency{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

}

