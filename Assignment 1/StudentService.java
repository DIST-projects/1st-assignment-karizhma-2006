import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface StudentService extends Remote {

    // Remote method for evaluating student performance
    Map<String, Object> evaluateStudent(
            String name,
            int[] marks
    ) throws RemoteException;
}
