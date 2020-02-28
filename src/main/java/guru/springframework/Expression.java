package guru.springframework;

public interface Expression {
    MoneyCurrency reduce(Bank bank, String to);
}
