// Import RMI registry classes
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Server program to publish remote object
public class RMIServer {

    public static void main(String[] args) {
        try {
            // Create instance of remote object
            StudentService service = new StudentServiceImpl();

            // Start RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind remote object with a name
            registry.rebind("StudentEvaluationService", service);

            // Server status message
            System.out.println("Student RMI Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
