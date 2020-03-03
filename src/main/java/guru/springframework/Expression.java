package guru.springframework;

public interface Expression {
    MoneyCurrency reduce(Bank bank, String to);
    Expression plus (Expression addend);
}
