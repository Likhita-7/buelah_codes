package Assessment;

import java.util.List;

public interface FacultyDAO {
    void addFaculty(Faculty faculty);
    void deleteFaculty(int id);
    void updateFaculty(Faculty faculty);
    Faculty getFacultyById(int id);
    List<Faculty> getAllFaculties();
}

