// Import RMI registry classes
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;

// Client program to invoke remote RMI service
public class RMIClient {

    public static void main(String[] args) {
        try {
            // Connect to RMI registry running on the server
            Registry registry =
                LocateRegistry.getRegistry("<3.16.146.5>", 1099);

            // Lookup remote object using registered name
            StudentService service =
                (StudentService) registry.lookup(
                        "StudentEvaluationService");

            // Input marks array
            int[] marks = {78, 85, 90, 88};

            // Invoke remote method
            Map<String, Object> report =
                service.evaluateStudent("Arjun", marks);

            // Display evaluation report
            System.out.println("Student Evaluation Report");
            System.out.println("-------------------------");
            report.forEach((k, v) ->
                System.out.println(k + " : " + v));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
