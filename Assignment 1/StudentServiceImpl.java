// Import required RMI classes
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

// Import collections for returning structured data
import java.util.HashMap;
import java.util.Map;

// Implementation class for the remote interface StudentService
public class StudentServiceImpl extends UnicastRemoteObject
        implements StudentService {

    // Constructor required for exporting remote object
    protected StudentServiceImpl() throws RemoteException {
        super();
    }

    // Remote method implementation for evaluating student performance
    @Override
    public Map<String, Object> evaluateStudent(String name, int[] marks)
            throws RemoteException {

        // Calculate total marks
        int total = 0;
        for (int m : marks) {
            total += m;
        }

        // Calculate percentage
        double percentage = total / (double) marks.length;

        // Determine grade based on percentage
        String grade;
        if (percenta
