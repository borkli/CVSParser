import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final String PATCH = "src/test/resources/movementList.csv";

    public static void main(String[] args) {
        System.out.println("Сумма расходов: " + new Movements(PATCH).getExpenseSum());
        System.out.println("Сумма доходов: " + new Movements(PATCH).getIncomeSum());
        System.out.println("Сумма расходов по организациям:\n" + getOrganizationExpense());
    }

    public static String getOrganizationExpense() {
        Map<String, Double> expenseOrg = Movements.getMapLine()
                .collect(Collectors
                        .groupingBy(Line::getOrganization, Collectors
                                .summingDouble(Line::getExpense)));
        StringBuilder expenseBuilder = new StringBuilder();
        for (Map.Entry<String, Double> expenseSum : expenseOrg.entrySet()) {
            expenseBuilder.append(expenseSum.getKey()).append(" - ");
            expenseBuilder.append(expenseSum.getValue()).append(" руб.").append("\n");
        }
        return expenseBuilder.toString();
    }
}
