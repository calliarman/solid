package d.refactored.main;

import d.refactored.notifications.EmailSender;
import d.refactored.notifications.EmployeeNotifier;
import d.refactored.payment.PaymentProcessor;
import d.refactored.persistence.EmployeeFileRepository;
import d.refactored.persistence.EmployeeFileSerializer;
import d.refactored.persistence.EmployeeRepository;

public class PayEmployeesMain {

    /*
    Will take a couple of seconds to execute due to the
    sending of mails.
     */
    public static void main(String[] args) {

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        EmployeeRepository employeeRepository = new EmployeeFileRepository(serializer);
        EmployeeNotifier employeeNotifier = new EmailSender();

        PaymentProcessor paymentProcessor = new PaymentProcessor(employeeRepository, employeeNotifier);

        int totalPayments = paymentProcessor.sendPayments();
        System.out.println("Total payments " + totalPayments);
    }
}
