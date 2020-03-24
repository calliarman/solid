package i.refactored.taxes;

import i.refactored.personnel.Employee;
import i.refactored.personnel.FullTimeEmployee;
import i.refactored.personnel.Intern;
import i.refactored.personnel.PartTimeEmployee;


public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}
