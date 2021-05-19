import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movements {

    public static String pathMovementsCsv;

    public Movements(String pathMovementsCsv) {
        Movements.pathMovementsCsv = pathMovementsCsv;
    }

    public double getExpenseSum() {
        Map<String, Double> expense = getMapLine()
                .collect(Collectors.groupingBy(Line::getType, Collectors.summingDouble(Line::getExpense)));
        for (Map.Entry<String, Double> expenseSum : expense.entrySet()) {
            return expenseSum.getValue();
        }
        return 0;
    }

    public double getIncomeSum() {
        Map<String, Double> expense = getMapLine()
                .collect(Collectors.groupingBy(Line::getType, Collectors.summingDouble(Line::getIncome)));
        for (Map.Entry<String, Double> incomeSum : expense.entrySet()) {
            return incomeSum.getValue();
        }
        return 0;
    }

    public static Stream<Line> getMapLine() {
        return FileList.getCorrectList().stream()
                .map(e -> e.split(","))
                .map(e -> new Line(e[0], e[1], e[2], e[3], e[4], e[5], e[6], e[7]));
    }
}
