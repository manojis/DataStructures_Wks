package com.Java_Experimentation.javaSixteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamToList {
    public static void main(String[] arrays){
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("Mr A", 56));
        patientList.add(new Patient("Mrs B", 37));
        patientList.add(new Patient("Mr C", 78));
        // java 8 Lambda functions
        List<Patient> filteredPatientUsingCollectors =
                patientList.stream().filter(p -> p.getAge() > 45).collect(Collectors.toList());
        Patient patientnew = new Patient("Mr D",89);
        filteredPatientUsingCollectors.set(1, patientnew);
        System.out.println(filteredPatientUsingCollectors);

        // Java 16 Stream.toList()
        List<Patient> filteredPatientsUsingStreamToList = patientList.stream().filter(p -> p.getAge() > 45).toList();
        Patient patientnew1  = new Patient("Mr E",89);
        filteredPatientsUsingStreamToList.set(1, patientnew1);
        System.out.println(filteredPatientsUsingStreamToList);
    }
}

