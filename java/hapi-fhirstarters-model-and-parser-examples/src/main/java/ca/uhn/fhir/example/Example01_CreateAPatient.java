package ca.uhn.fhir.example;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.r4.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class Example01_CreateAPatient {
   public static void main(String[] theArgs) {

      // Create a resource instance
      Patient pat = new Patient(); //creating a new resource
      pat.setId("theId"); // assigning the resource an id

      FhirContext fhirContext = FhirContext.forR4();
//      System.out.println(fhirContext.newJsonParser().setPrettyPrint(true).encodeResourceToString(pat));

      // -----Method 1 | adding identifiers------
//      pat.addIdentifier();
//      List<Identifier> ids = new ArrayList<>();
//      Identifier id  = new Identifier();
//      id.setSystem("http/example-system");
//      id.setValue("AA2Test");
//
//      Identifier id2 = new Identifier();
//      id2.setSystem("MOHTest");
//      id2.setValue("MOHTest");
//      ids.add(id);
//      ids.add(id2);
//      pat.setIdentifier(ids);
//      pat.setIde();
      // ---------------------------------

      // -----Method 2 | adding identifiers------
      // checkout https://www.hl7.org/fhir/patient.html for more

      pat.addIdentifier().setValue("AA2Test").setSystem("AA2Test");
      pat.addIdentifier().setValue("MOHTest").setSystem("MOHTest");
      pat.addName().addGiven("first given name").addGiven("second given name").setFamily("your surname");
      // ----------------------------------------
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      System.out.println(fhirContext.newJsonParser().setPrettyPrint(true).encodeResourceToString(pat));
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      // // Add a "name" element
      // HumanName name = pat.addName();
      // name.setFamily("Simpson").addGiven("Homer").addGiven("J");

      // // Add an "identifier" element
      // Identifier identifier = pat.addIdentifier();
      // identifier.setSystem("http://acme.org/MRNs").setValue("7000135");

      // // Model is designed to be chained
      // pat.addIdentifier().setSystem("http://acme.org/MRNs").setValue("12345");

   }
}
