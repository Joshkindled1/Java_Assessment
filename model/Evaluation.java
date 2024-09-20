package java_assessment.model;

import java.util.List;
import java_assessment.model.Student;

public interface Evaluation                 //buiness rules for any entities that requires eval methods
{
    double getAverage();                    //method signature

    List<Course> getApprovedCourses();

}
