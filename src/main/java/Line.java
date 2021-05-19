public class Line {

    private String type;
    private String number;
    private String value;
    private String date;
    private String reference;
    private String description;
    private double income;
    private double expense;

    public Line(String type, String number, String value, String date,
                String reference, String description, String income, String expense) {
        this.type = type;
        this.number = number;
        this.value = value;
        this.date = date;
        this.reference = reference;
        this.description = description;
        this.income = Double.parseDouble(income);
        this.expense = Double.parseDouble(expense);
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganization() {
        String[] descriptionArr = description.split("\\s{3,5}");
        return descriptionArr[1].trim();
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }

    public String getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }
}
