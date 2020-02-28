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

    public MoneyCurrency times(int multiplier) {
        return new MoneyCurrency(amount*multiplier, this.currency);
    }

    public Expression plus (MoneyCurrency addend){
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        MoneyCurrency moneyCurrency = (MoneyCurrency) object;
        return amount == moneyCurrency.amount && this.currency == moneyCurrency.currency;
    }

    @Override
    public MoneyCurrency reduce(Bank bank, String to){
<<<<<<< Updated upstream
        //return this;
        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
      //  return new MoneyCurrency(amount / bank.rate(this.currency, to), to);
        return new MoneyCurrency(rate,to);
=======
        int rate = (currency.equals("CHF") && currency.equals("USD")) ? 2:1;
        return new MoneyCurrency(amount/ rate, to);
>>>>>>> Stashed changes
    }



    @Override
    public String toString() {
        return "MoneyCurrency{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public MoneyCurrency reduce(String to) {
        return null;
    }
}

