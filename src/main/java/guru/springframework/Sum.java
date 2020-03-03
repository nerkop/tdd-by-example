package guru.springframework;

public class Sum implements Expression{

    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }
    @Override
    public MoneyCurrency reduce(Bank bank, String to){
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new MoneyCurrency(amount, to);

    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }
}
