public class MySQLColumnCreator {

    private String columnName;
    private String columnType;
    private boolean notNull;
    private boolean autoIncrement;

    public MySQLColumnCreator(String columnName, String columnType, boolean notNull, boolean autoIncrement) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.notNull = notNull;
        this.autoIncrement = autoIncrement;
    }

    public String generateScript() {
        StringBuilder script = new StringBuilder();
        script.append("'" + columnName + "' " + columnType);
        if (notNull) {
            script.append(" NOT NULL");
        }
        if (autoIncrement) {
            script.append(" AUTO_INCREMENT");
        }
        return script.toString();
    }

    public static void main(String[] args) {
        MySQLColumnCreator column1 = new MySQLColumnCreator("codigo", "INT", true, true);
        MySQLColumnCreator column2 = new MySQLColumnCreator("codigo", "INT", false, true);
        MySQLColumnCreator column3 = new MySQLColumnCreator("codigo", "INT", true, false);
        MySQLColumnCreator column4 = new MySQLColumnCreator("codigo", "INT", false, false);
        System.out.println(column1.generateScript());
        System.out.println(column2.generateScript());
        System.out.println(column3.generateScript());
        System.out.println(column4.generateScript());
    }
}
